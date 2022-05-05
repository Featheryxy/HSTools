package ind.milo.demo.gof.memento;

import ind.milo.demo.gof.memento.game.Gamer;
import ind.milo.demo.gof.memento.game.Memento;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();

        for (int i = 0; i < 100; i++) {
            System.out.println("===== " + i);
            System.out.println("当前状态： " + gamer);
            gamer.bet();
            System.out.println("所持金钱为 "+gamer.getMoney());

            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("游戏胜利：增加Money，存档");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("游戏失败：Load");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println();
        }
    }
}
