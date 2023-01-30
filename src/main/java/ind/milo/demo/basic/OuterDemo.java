package ind.milo.demo.basic;

interface Inter{
    void show();
}

class Outer{
    // 补齐代码，输出HelloWorld
//    public static Inter method(){
//        Inter i = new Inter() {
//            @Override
//            public void show() {
//                System.out.println("HelloWorld");
//            }
//        };
//        return i;
//    }
    public static Inter method(){
        return () -> System.out.println("HelloWorld");
    }
}


class OuterDemo{
    public static void main(String[] args) {
        Outer.method().show();
    }
}