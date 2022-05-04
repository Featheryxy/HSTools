package ind.milo.demo.gof.chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        Support alice   = new NoSupport("Alice");
        Support elmo    = new OddSupport("Elmo");
        Support bob     = new LimitSupport("Bob", 100);
//        Support charlie = new SpecialSupport("Charlie", 429);
//        Support diana   = new LimitSupport("Diana", 200);
//        Support fred    = new LimitSupport("Fred", 300);
        // 形成职责链
//        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
//        // 制造各种问题
//        for (int i = 0; i < 500; i += 33) {
//            alice.support(new Trouble(i));
//        }

        alice.setNext(elmo).setNext(bob);
        alice.support(new Trouble(112));


    }
}
