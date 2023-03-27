package ind.milo.demo.basic;

import org.junit.jupiter.api.Test;

/**
 * @Date 2022/12/6 15:35
 * @Created by Milo
 */
public class StringDemo {
    public static void main(String[] args) {
        String a = "abc";
        String a1 = "abc";
        String b = new String("abc");
        String b1 = new String("abc");

        System.out.println(a == a1);
        System.out.println(a == b);
        System.out.println(b == b1);
    }

    private int c;
}

class AA{
    public void say(){
        System.out.println("AA");
    }
}

class BB extends AA{
    @Override
    public void say() {
        System.out.println("BB");
    }

    public static void main(String[] args) {
        AA aa = new BB();
        aa.say();
    }
}
