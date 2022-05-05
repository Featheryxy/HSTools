package ind.milo.demo.gof.memento.game;


import java.util.ArrayList;
import java.util.Random;

public class Gamer {
    private int money;
    private ArrayList fruits = new ArrayList();

    private Random random = new Random();
    private static String[] fruitsname = {
            "苹果", "葡萄", "香蕉", "橘子"
    };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) { // 骰子为1，加100块
            money += 100;
            System.out.println("所持金钱增加了。");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金钱减半。");
        } else if (dice == 6) {
            String fruit = getFruit();
            fruits.add(fruit);
            System.out.println(String.format("获得了水果：%s", fruit));
        } else {
            System.out.println("nothing happened");
        }
    }

    // 拍摄快照
    public Memento createMemento() {
        Memento memento = new Memento(money, fruits);
        return memento;
    }

    // 撤销
    public void restoreMemento(Memento memento) {
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    private String getFruit() {
        return fruitsname[random.nextInt(fruitsname.length)];
    }



    @Override
    public String toString() {
        return "Gamer{" +
                "money=" + money +
                ", fruits=" + fruits +
                '}';
    }
}
