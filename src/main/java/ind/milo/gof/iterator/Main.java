package ind.milo.gof.iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("西游记"));
        bookShelf.appendBook(new Book("红楼梦"));
        bookShelf.appendBook(new Book("水浒传"));
        bookShelf.appendBook(new Book("三国演绎"));
        System.out.println(bookShelf.getLength());
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }

    }
}
