package ch01.hw;

public class BookShelfIteratorBackward implements Iterator { 
    private BookShelf bookShelf; 
    private int index; 

    public BookShelfIteratorBackward(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = bookShelf.getLength() - 1;
    }

    public boolean hasNext() {
        if (index >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index--;

        return book;
    }
}
