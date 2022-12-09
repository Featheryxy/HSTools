package ind.milo.demo.basic;

/**
 * @Date 2022/12/9 16:10
 * @Created by Milo
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(classLoader);
        // sun.misc.Launcher$AppClassLoader@18b4aac2

    }
}
