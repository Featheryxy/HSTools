package ind.milo.demo.functionprogram;

/**
 * @Date 2022/7/7 9:20
 * @Created by Milo
 */
public interface Function {
    int apply(int arg);
}

class TestF {
    // 类对象的名称 triple 实例变量
    Function triple = new Function() {
        @Override
        public int apply(int arg) {
            return arg * 3;
        }
    };

    Function suare(int arg) {
        return new Function() {
            @Override
            public int apply(int arg1) {
                return arg1 * 3;
            }
        };
    }

    Function square = new Function() {
        @Override
        public int apply(int arg) {
            return arg * arg;
        }
    };

    // 成员方法。todo 为什么定义成final?
    Function compose(final Function f1, final Function f2) {
        return arg -> f1.apply(f2.apply(arg));
    }




    public static void main(String[] args) {
        TestF testF = new TestF();
        System.out.println(testF.triple.apply(2));
        System.out.println(testF.compose(testF.square, testF.triple).apply(2));
        System.out.println(testF.compose(testF.square, testF.triple).apply(2));
    }

}