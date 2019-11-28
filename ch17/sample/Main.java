package ch17.sample;

public class Main {
    public static void main(String[] args) {
        NumberGenerator g = new RandomNumberGenerator();

        Observer o1 = new DigitObserver();
        Observer o2 = new GraphObserver();

        g.addObserver(o1);
        g.addObserver(o2);

        g.execute();
    }
}
