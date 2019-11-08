package ch05.sample;

public class Singleton {
    private static Singleton s = new Singleton();

    private Singleton() {
        System.out.println("Singleton 인스턴스를 생성합니다.");
    }

    public static Singleton getInstance() {
        return s;
    }
}
