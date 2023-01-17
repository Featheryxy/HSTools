package ind.milo.demo.exceptionDemo;

public class FinallyReturnDemo {
    public static void main(String[] args) {
        int re = foo();
        System.out.println(re);
    }

    private static int bar() {
        try{
            return 1;
        } finally {
            return 2;
        }
    }

    private static int foo(){
        try {
            int a = 5 / 0;
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("分母为0");
        } finally {
            return 2;
        }

    }
}
