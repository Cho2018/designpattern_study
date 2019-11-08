package ch05.A3_2;

public class Main extends Thread {
    public static void main(String[] args) {
        new Main("A").start();
        new Main("B").start();
        new Main("C").start();
    }

    public void run() {
        Singleton s = Singleton.getInstance();
        System.out.println(getName() + ": s = " + s);
    }

    public Main(String name) {
        super(name);
    }
}
