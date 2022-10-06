package ind.milo.demo.function.base;

/**
 * 函数式接口主要用于类型推断，接口中只定义了一个方法，实现类只需书写实现内容即可
 * @param <T>
 * @param <U>
 */
@FunctionalInterface
public interface Function <T, U>{
    U apply(T arg);
}

//class FunctionImp implements Function<Integer, Integer> {
//    @Override
//    public Integer apply(Integer arg) {
//        return arg*arg;
//    }
//}



//class FunctionTest {
//    // 成员变量
////    static FunctionImp square1 = new FunctionImp();
//
//    // 成员内部类
////    static class FunctionImp implements Function<Integer, Integer> {
////        @Override
////        public Integer apply(Integer arg) {
////            return arg*arg;
////        }
////    }
//
////    Function<Integer, Integer> square2
//
//    // 1.子类实现了函数式接口中的方法; 2.创建了该子类对象
////    static Function<Integer, Integer> square2 = new Function<Integer, Integer>() {
////        @Override
////        public Integer apply(Integer arg) {
////            return arg * arg;
////        }
////    };
////    static Function<Integer, Integer> square2 = arg -> arg * arg;
//
//    static Function<Integer , Function<Integer , Integer>> add = x -> y -> x + y;
//
//    Function<Double, Double> sin = Math::sin;
//    Function<Double, Double> sin2 = a -> Math.sin(a);
//
//    public static void main(String[] args) {
////        System.out.println(square1.apply(2));
////        System.out.println(new FunctionImp().apply(2));
////        System.out.println(square2.apply(2));
//        System.out.println(add.apply(2).apply(3));
//    }
//}
