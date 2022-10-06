package ind.milo.demo.function.base;

/**
 * @Date 2022/10/2 16:39
 * @Created by Milo
 */
public class FunctionDemo {
    // 定义方法类型， 方法名称
    // 参数：函数，值参数
//    Function<Integer, Integer> triple= new Function<Integer, Integer>(){
//        @Override
//        public Integer apply(Integer arg) {
//            return arg*3;
//        }
//    };

//    Function<Integer, Integer> square= new Function<Integer, Integer>(){
//        @Override
//        public Integer apply(Integer arg) {
//            return arg*arg;
//        }
//    };

//    static Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
//        return new Function<Integer, Integer>() {
// .           @Override
//            public Integer apply(Integer arg) {
//                return f1.apply(f2.apply(arg));
//            }
//        };
//    }

//    Function<Integer, Integer> triple= arg -> arg*3;
    Function<Integer, Integer> triple = arg -> arg*3;

    Function<Integer, Integer> square = arg -> arg*arg;

    static Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }


    Function<Function<Integer, Integer>,
            Function<Function<Integer, Integer>, Function<Integer, Integer>>> compose =
            x -> y -> z -> x.apply(y.apply(z));



}
