package ind.milo.demo.function_base;




import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Kano on 2017/5/24.
 */
public class LambdaTest {
    /**
     * 比较器 的线程 和 调用 sort 的线程
     * 是同一个 线程
     */
    @Test
    public void _01_01_sortThread() {
        String[] strings = {"aaa", "b", "cc"};
        System.out.println(Thread.currentThread().getName());
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println(Thread.currentThread().getName());
                return Integer.compare(o1.length(), o2.length());
            }
        });
    }

    /**
     * 找出某个 文件夹下 所有子文件夹
     * Java 6 的写法
     */
    @Test
    public void _01_02_subDir_6() {
        String dir = "Y:\\";
        String[] list = new File(dir).list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
            }
        });
        Arrays.stream(list).forEach(System.out::println);
    }

    /**
     * 找出某个 文件夹下 所有子文件夹
     * lambda 的写法
     */
    @Test
    public void _01_02_subDir_lambda() {
        String dir = "Y:\\";
        String[] list = new File(dir).list((dir1, name) -> new File(dir1, name).isDirectory());
        Arrays.stream(list).forEach(System.out::println);
    }

    /**
     * 找出某个 文件夹下 所有子文件夹
     * 方法引用 的写法
     * (这个我感觉比较别扭)
     */
    @Test
    public void _01_02_subDir_method() {
        String dir = "Y:\\";
        List<String> list = Arrays.stream(new File(dir).list())
                .map(name -> new File(dir, name))
                .filter(File::isDirectory)
                .map(File::getName)
                .collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    /**
     * 返回某个目录下 指定扩展名 的文件
     * Java 6 的写法
     */
    @Test
    public void _01_03_listFiles() {
        String dir = "H:\\";
        String ext = "msi";
        File[] list = new File(dir).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(ext);
            }
        });
        Arrays.stream(list).map(file -> file.getName()).forEach(System.out::println);
    }

    /**
     * 返回某个目录下 指定扩展名 的文件
     * lambda 的写法
     * (会捕获薄荷作用域中的 ext 变量)
     */
    @Test
    public void _01_03_listFiles_lambda() {
        String dir = "H:\\";
        String ext = "msi";
        File[] list = new File(dir).listFiles((dir1, name) -> name.endsWith(ext));
        Arrays.stream(list).map(file -> file.getName()).forEach(System.out::println);
    }

    /**
     * 给定的 file 数组 进行排序,规则是
     *  首先按照目录排序,如果目录相同,则按照文件的路径排序
     *
     * lambda 实现
     */
    @Test
    public void _01_04_file_sort() {
        File[] files = new File[5];
        files[0] = new File("C:\\Windows\\addins\\FXSEXT.ecf");
        files[1] = new File("C:\\Windows\\Cnxt\\setup5776297E157xyz\\FXSEXT.ecf");
        files[2] = new File("C:\\Windows\\AppPatch\\pcamain.sdb");
        files[3] = new File("C:\\Windows\\Cnxt\\setup5776297E157xyz\\DtsHpxInit64.dll");
        files[4] = new File("C:\\Windows\\AppPatch\\frxmain.sdb");

        Arrays.sort(files, (File o1, File o2) ->
                o1.getParent().equals(o2.getParent()) ?
                        o1.getPath().compareTo(o2.getPath()) : o1.getParent().compareTo(o2.getParent())
        );
        Arrays.stream(files).map(File::getAbsolutePath).forEach(System.out::println);

    }


    /**
     * 用 lambda 实现 Runnable
     */
    @Test
    public void _01_05_thread() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }


    /**
     *  改造 Runnable 结构,让其可以抛出异常
     *  (需要定义一个 接口)
     */
    @Test
    public void _01_06_thread_uncheck() {
        new Thread(RunnableEx.uncheck(() -> {
            System.out.println("sdfsd");
            Thread.sleep(100); //不用 捕获异常
        })).start();
    }

    interface RunnableEx {
        void run() throws Exception;

        static Runnable uncheck (RunnableEx runner){
            return () -> {
                try {
                    runner.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        }
    }

    /**
     *  写一个 andThen 方法,传递两个 Runnable 实例
     *  返回一个 分别运行这两个实例的 Runnable 实例
     */
    @Test
    public void _01_07_andThen() {
        Runnable then = andThen(
                () -> System.out.println("12"),
                () -> System.out.println("34")
        );

        new Thread(then).start();
    }

    private static Runnable andThen(Runnable r1,Runnable r2){
        return ()->{
            new Thread(r1).start();
            new Thread(r2).start();
        };
    }

    /**
     *  这样写没问题
     */
    @Test
    public void _01_08_for() {
        String[] names={"zhangsan","lisi","wangwu"};
        List<Runnable> runners=new ArrayList<>();
        for (String name : names) {
            runners.add(()-> System.out.println(name));
        }
        runners.stream().map(Thread::new).forEach(Thread::start);
    }

    /**
     * 这样写  有问题
     */
    @Test
    public void _01_08_fori() {
        String[] names={"zhangsan","lisi","wangwu"};
        List<Runnable> runners=new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            // 这么写就会有问题,因为 lambda 表达式 只能捕获 不能变化的 值,而i 在变化
//            runners.add(()-> System.out.println(names[i]));
        }
        runners.stream().map(Thread::new).forEach(Thread::start);
    }



    @Test
    public void _01_09_Collection2() {
        AList2<String> strings = new AList2<>();
        strings.add("asdfg");
        strings.add("qqq");
        strings.add("rtypo12");
        // 如果 字符串的 长度 大于5 .就输出
        strings.forEachIf(System.out::println,s->s.length()>5);
    }


    /**
     * 这个 接口 并不难写,写完之后要怎么用呢?
     * 现在这个接口没有实现类,所以无法使用,需要写一个 实现类,在下面 AList2
     * @param <T>
     */
    interface Collection2<T> extends Collection<T> {
        default void forEachIf(Consumer<T> action, Predicate<T> filter){
            //多么优雅的代码 , 不用写 if else 了，以前十几行代码，现在只需要一行，而且可读性更强
            this.stream().filter(filter::test).forEach(action::accept);
        }
    }

    class AList2<E> extends ArrayList<E> implements Collection2<E>{

    }

    @Test
    public void test() {
        Stream<BigInteger> iterate = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        iterate.forEach(System.out::println);
    }
}
