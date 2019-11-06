package ch01.sample;

import java.util.Vector;

public class BookShelf implements Aggregate {
    private Vector books;

    public BookShelf(int s) {
        this.books = new Vector(s);
    }

    public Book getBookAt(int index) {
        return (Book)books.get(index);
    }

    public void appendBook(Book book) {
        this.books.add(book);
    }

    public int getLength() {
        return this.books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
