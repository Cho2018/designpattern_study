package ch02.sample02;

public class Main2 {
    public static void main(String[] args) {
        Print p = new PrintBannerAdapter2("aa");

        p.printWeak();
        p.printStrong();

        p.printName();
    }
}
