package ind.milo.demo.functionprogram;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

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

    // 方法
    Function suare(int arg) {
        return new Function() {
            @Override
            public int apply(int arg1) {
                return arg1 * 3;
            }
        };
    }

    // 成员变量
    Function square = new Function() {
        @Override
        public int apply(int arg) {
            return arg * arg;
        }
    };

    // 成员方法。todo 为什么定义成final?
    Function compose( Function f1,  Function f2) {
        return new Function() {
            @Override
            public int apply(int arg) {
                return f1.apply(f2.apply(arg));
            }
        };
    }

    Function compose = new Function() {
        Function f1;
        Function f2;
        @Override
        public int apply(int arg) {
            return f1.apply(f2.apply(arg));
        }
    };


    @Test
    public void Test1() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1", "2");
        map.put("1", "1");
        System.out.println(map.toString());
        System.out.println(map.get("123"));
    }


    public static void main(String[] args) {
        TestF testF = new TestF();
        System.out.println(testF.triple.apply(2));
        System.out.println(testF.square.apply(2));
        System.out.println(testF.compose(testF.square, testF.triple).apply(2));
        System.out.println(testF.compose(testF.square, testF.triple).apply(2));
    }

}