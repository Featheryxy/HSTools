package ind.milo.demo.basic;

import org.junit.jupiter.api.Test;

/**
 * @Date 2022/12/6 15:35
 * @Created by Milo
 */
public class StringDemo {
    public static void main(String[] args) {
        String str1 = "a";
        String str2 = new String("a");
        String str3 = "a";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2) );
        System.out.println(str1.hashCode() == str2.hashCode());
        System.out.println("+++++");
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3) );
        System.out.println(str1.hashCode() == str3.hashCode());
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
