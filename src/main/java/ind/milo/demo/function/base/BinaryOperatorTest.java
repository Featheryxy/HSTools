package ind.milo.demo.function.base;

import org.junit.jupiter.api.Test;

/**
 * @Date 2022/10/3 12:46
 * @Created by Milo
 */
public class BinaryOperatorTest {
    // Function<Integer, Function<Integer, Integer>>
    // 接收一个 Integer 为参数并返回一个从 Integer 到 Integer 的函数
    BinaryOperator add = x->y->x+y;
    BinaryOperator mult = x->y->x*y;

    @Test
    public void addTest(){
        System.out.println(add.apply(3).apply(5));
    }
}
