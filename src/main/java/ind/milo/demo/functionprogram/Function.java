package ind.milo.demo.functionprogram;

/**
 * @Date 2022/7/7 9:20
 * @Created by Milo
 */
public interface Function {
    int apply(int arg);
}

class TestF {
    private TestF() {

    }

    Function triple = new Function() {
        @Override
        public int apply(int arg) {
            return arg * 3;
        }
    };

    Function square = new Function() {
        @Override
        public int apply(int arg) {
            return arg * arg;
        }
    };

    Function compose(Function f1, Function f2) {
        return new Function() {
            @Override
            public int apply(int arg) {
                return f1.apply(f2.apply(arg));
            }
        };
    }

    public static void main(String[] args) {
        System.out.println();
    }
}