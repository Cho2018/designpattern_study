package ch02.sample02;

public class PrintBannerAdapter2 extends Print {
    private Banner b;

    public PrintBannerAdapter2(String s) {
        b = new Banner(s);
    }

    @Override
    public void printWeak() {
        b.showWithParen();
    }

    @Override
    public void printStrong() {
        b.showWithAster();
    }
}
