/*
 * @author yjiewei
 * @date 2022/2/20 20:54
 */
package ind.milo.demo.stream;


import ind.milo.demo.stream.entity.Author;
import ind.milo.demo.stream.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestOptional {
    public static void main(String[] args) {
        test();

//        testOfNullable();
//
//        testFilter();
//
//        testMap();
    }

    private static void test() {
    }

    private static void testMap() {
        Optional<Author> authorOptional = getAuthorOptional();
        Optional<List<Book>> books = authorOptional.map(author -> author.getBookList());
        books.ifPresent(books1 -> books1.forEach(book -> System.out.println(book.getName())));
    }

    private static void testFilter() {

        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.filter(author -> author.getAge() > 18).ifPresent(author -> System.out.println(author.getName()));
    }

    /**
     * Optional.ofNullable()
     * Optional.ifPresent()
     * Optional.orElseGet()
     * Optional.get()
     * Optional.orElseThrow()
     */
    private static void testOfNullable() {
        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.ifPresent(author -> System.out.println(author.getName()));
        // authorOptional.get();// 这种方式不推荐使用 防止出现异常
        // Optional.orElseGet(); // 如果get获取到的值为空，就会获取默认值，这里的是 new Author()
        Author author = authorOptional.orElseGet(Author::new);
        System.out.println(author.toString());
        System.out.println(author.getName()); // 虽然这里的author是null，但是也不会出现空指针的情况

        authorOptional.orElseThrow(() -> new RuntimeException("当前获取到的数据是NULL"));
    }

    public static Optional<Author> getAuthorOptional(){
        Author author = new Author(1L, "杨杰炜", "my introduction 1", 20, null);
        return Optional.ofNullable(author);
    }
}
