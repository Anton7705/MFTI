
//3.2.3
// Базовый класс для всех птиц
abstract class Bird {
    public void sing() {
        System.out.println(getSong());
    }

    public abstract String getSong();
}
