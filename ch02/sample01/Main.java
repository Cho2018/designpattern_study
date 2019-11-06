package ch02.sample01;

public class Main {
    public static void main(String[] args) {
        Print a1 = new PrintBannerAdapter("aa");

        a1.printWeak();
        a1.printStrong();
    }
}
