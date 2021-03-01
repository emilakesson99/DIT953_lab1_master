import java.util.Random;

public class RandomNumbers {
    int max;
    int min;

    public int Return() {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    public RandomNumbers(int max, int min) {
        this.min = min;
        this.max = max;
    }
}
