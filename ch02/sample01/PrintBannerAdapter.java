package ch02.sample01;

public class PrintBannerAdapter extends Banner implements Print {
    public PrintBannerAdapter(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
