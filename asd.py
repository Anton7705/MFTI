import geopandas as gpd
from shapely.geometry import Point, MultiPoint
import warnings
from sqlalchemy import create_engine
from shapely.geometry import Point, MultiPoint

# username = 'postgres'
# password = '123'
# host = 'localhost'
# port = '5432'
# database = 'postgres'
# connection_string = f'postgresql+psycopg2://{username}:{password}@{host}:{port}/{database}'

# Игнорируем предупреждения
warnings.filterwarnings("ignore", category=RuntimeWarning)

path_input = 'input_data/'
name_house_enter = 'HouseEnter.shp'
name_house = 'House.shp'


try:
    gdf_house_enter = gpd.read_file(path_input + name_house_enter, encoding='cp1251')
    print("HouseEnter успешно загружен.")
    print(gdf_house_enter.head())
except Exception as e:
    print(f"Ошибка при загрузке HouseEnter: {e}")
    exit()


try:
    gdf_house = gpd.read_file(path_input + name_house, encoding='cp1251')
    print("House успешно загружен.")
    print(gdf_house.head())
except Exception as e:
    print(f"Ошибка при загрузке House: {e}")
    exit()

# Проверка столбцов
print("Столбцы HouseEnter:", gdf_house_enter.columns.tolist())
print("Столбцы House:", gdf_house.columns.tolist())

# Функция для извлечения координат
def parse_coordinates(geom):
    if geom is None:
        print("Геометрия равна None.")
        return None, None
    if isinstance(geom, MultiPoint):
        return geom.geoms[0].x, geom.geoms[0].y
    elif isinstance(geom, Point):
        return geom.x, geom.y
    else:
        print(f"Неизвестный тип геометрии: {type(geom)}")
        return None, None

# Применяем функцию к столбцу geometry
gdf_house_enter['x'], gdf_house_enter['y'] = zip(*gdf_house_enter['geometry'].apply(parse_coordinates))

if 'HouseId' not in gdf_house_enter.columns or 'HouseId' not in gdf_house.columns:
    print("Ошибка: отсутствуют необходимые столбцы для объединения.")
else:
    merged_df = gdf_house_enter.merge(gdf_house, left_on='HouseId', right_on='HouseId', how='inner')
    print("Данные успешно объединены.")
    print(merged_df.head())

    # Группируем по HouseId и оставляем не более 2 записей
    filtered_df = merged_df.groupby('HouseId').head(2)
    print("Данные успешно отфильтрованы.")
    print(filtered_df.head())

# Подключение к базе данных
# try:
#     engine = create_engine(connection_string)
#     print("Подключение к базе данных успешно установлено.")
# except Exception as e:
#     print(f"Ошибка при подключении к базе данных: {e}")
#     exit()
#
# # Сохранение результата в PostgreSQL
# table_name = 'filtered_houses'
# try:
#     filtered_df.to_postgis(table_name, engine, if_exists='replace', index=False)
#     print(f"Данные успешно записаны в таблицу '{table_name}'.")
# except Exception as e:
#     print(f"Ошибка при записи данных в базу данных: {e}")
