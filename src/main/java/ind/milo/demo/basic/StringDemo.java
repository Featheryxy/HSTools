package ind.milo.demo.basic;

import org.junit.jupiter.api.Test;

/**
 * @Date 2022/12/6 15:35
 * @Created by Milo
 */
public class StringDemo {
    @Test
    public void contains() {
        String str = "202212060001150253581329;202212060001150419581331;";
        boolean contains = str.contains(";");
        System.out.println(contains);
        String[] split = str.split(";");
        System.out.println(split.toString());
    }
}
