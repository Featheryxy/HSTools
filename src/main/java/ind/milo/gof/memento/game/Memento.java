package ind.milo.gof.memento.game;

import java.util.ArrayList;
import java.util.List;

/**
 * 保存Gamer的用户状态
 */
public class Memento {
    int money;
    ArrayList fruits;

    Memento(int money, ArrayList fruits) {
        this.money = money;
        this.fruits = fruits;
    }

    public int getMoney(){
        return money;
    }


    ArrayList getFruits() {
        return (ArrayList) fruits.clone();
    }
}
