import java.util.Random;

//3.2.3
public class Parrot extends Bird {
    private final String text;

    public Parrot(String text) {
        this.text = text;
    }

    @Override
    public String getSong() {
        int length = new Random().nextInt(text.length()) + 1;
        return text.substring(0, length);
    }
}