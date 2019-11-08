package ch01.hw;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(5);

        bookShelf.appendBook(new Book("자료구조론", "박우창"));
        bookShelf.appendBook(new Book("인공지능", "이승찬"));
        bookShelf.appendBook(new Book("이산수학", "이주영"));
        bookShelf.appendBook(new Book("디지털 디자인", "유견아"));
        bookShelf.appendBook(new Book("멀티미디어응용", "이경미"));

        Iterator it = bookShelf.iterator();
        while (it.hasNext()) { 
            Book book = (Book)it.next(); 
            System.out.println("(" + book.getName() + ", " + book.getAuthor() + ")");
        }
    }
}
