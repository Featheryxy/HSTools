package ind.milo.demo.stream;

import ind.milo.demo.stream.entity.Author;
import ind.milo.demo.stream.entity.Book;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Date 2022/4/17 10:38
 * @Created by Milo
 */
public class StreamDemo {
    private List<Author> authors = getAuthors();

    // 初始化一些数据
    private static List<Author> getAuthors() {
        Author author1 = new Author(1L, "杨杰炜", "my introduction 1", 18, null);
        Author author2 = new Author(2L, "yjw", "my introduction 2", 19, null);
        Author author3 = new Author(3L, "yjw", "my introduction 3", 14, null);
        Author author4 = new Author(4L, "wdt", "my introduction 4", 29, null);
        Author author5 = new Author(5L, "wtf", "my introduction 5", 12, null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        // 上面是作者和书
        books1.add(new Book(1L, "类别,分类啊", "书名1", 45D, "这是简介哦"));
        books1.add(new Book(2L, "高效", "书名2", 84D, "这是简介哦"));
        books1.add(new Book(3L, "喜剧", "书名3", 83D, "这是简介哦"));

        books2.add(new Book(5L, "天啊", "书名4", 65D, "这是简介哦"));
        books2.add(new Book(6L, "高效", "书名5", 89D, "这是简介哦"));

        books3.add(new Book(7L, "久啊", "书名6", 45D, "这是简介哦"));
        books3.add(new Book(8L, "高效", "书名7", 44D, "这是简介哦"));
        books3.add(new Book(9L, "喜剧", "书名8", 81D, "这是简介哦"));

        author1.setBookList(books1);
        author2.setBookList(books2);
        author3.setBookList(books3);
        author4.setBookList(books3);
        author5.setBookList(books2);

        return new ArrayList<>(Arrays.asList(author1, author2, author3, author4, author5));
    }

    @Test
    public void test1() {
        authors.stream().
                distinct().
                filter(author -> author.getAge()<18).
                forEach(author -> System.out.println(author.getName()));
    }

    @Test
    public void test2(){
        // 数组：Arrays.stream(arr)
        int[] ints = {1, 2, 3};
        IntStream stream = Arrays.stream(ints);
        Stream<int[]> ints1 = Stream.of(ints);
        OptionalInt min = Arrays.stream(ints).min();
        System.out.println(min.getAsInt());

        // 单列集合: 集合对象.stream()
        List<Author> authors = getAuthors();
        Stream<Author> stream1 = authors.stream();

        // 双列集合: 先将双列对象转换成单例后再创建
        Map<String, String> map = new HashMap<>();
        map.put("Mike", "male");
        map.put("Lucy", "female");
        map.put("Lisa", "female");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Optional<String> first = entries.stream()
                .filter(entry -> "male".equals(entry.getValue()))
                .map(entry -> "小明").findFirst();
        if (first.isPresent()) {
            System.out.println(first.get());
        }

        System.out.println(first.isPresent());
        boolean present = first.isPresent();


        // Mike=male
    }
}
