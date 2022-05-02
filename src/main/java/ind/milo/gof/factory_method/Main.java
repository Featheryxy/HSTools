package ind.milo.gof.factory_method;


import ind.milo.gof.factory_method.framework.Factory;
import ind.milo.gof.factory_method.framework.Product;
import ind.milo.gof.factory_method.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("小红");
        Product card2 = factory.create("小明");
        card1.use();
        card2.use();
    }
}
