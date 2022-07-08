package ind.milo.demo.functionprogram;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2022/7/6 9:28
 * @Created by Milo
 */
public class Payment {
    public final CreditCard cc;
    public final int amount;


    public Payment(CreditCard cc, int amount) {
        this.cc = cc;
        this.amount = amount;
    }

    // cc 为隐式参数, 可以将cc所属的对象作为函数的变量传入，使其成为显式参数
    public Payment combine1(Payment other) throws Exception {
        if (cc.equals(other.cc)) {
            return new Payment(cc, amount + other.amount);
        } else {
            throw new Exception("Can't combine ");
        }
    }

    //
    public static Payment combine2(Payment payment1, Payment payment2) throws Exception {
        if (payment1.cc.equals(payment2.cc)) {
            return new Payment(payment1.cc, payment1.amount + payment2.amount);
        } else {
            throw new Exception("Can't combine ");
        }
    }

    public void test() throws Exception {
        // 类内调用
        combine2(this, new Payment(null, 1));
    }

    public static void main(String[] args) throws Exception {
        Payment p0 = new Payment(null, 1);
        Payment p1 = new Payment(null, 1);
        Payment p2 = new Payment(null, 1);
        Payment p3 = new Payment(null, 1);

        // 对象标记，隐式
        p0.combine1(p1).combine1(p2);

        // 函数标记，显式
        Payment newPayment = combine2(combine2(combine2(p0 , p1 ) , p2) , p3 );
    }
}

class test {
    public void test1() throws Exception {
        // 类外调用
        Payment newPayment = Payment.combine2(null, null) ;
    }
}

@Data
@NoArgsConstructor
class CreditCard {

}