package ind.milo.demo.gof.flyweight;

import java.util.HashMap;

public class BigCharFactory {
    //用于保存已经生成的BigChar实例
    private HashMap<String, BigChar> pool = new HashMap();

    private static BigCharFactory singleton = new BigCharFactory();

    private BigCharFactory() {

    }

    public static BigCharFactory getInstance() {
        return singleton;
    }

    // 生成（共享）BigChar类的实例
    public synchronized BigChar getBigChar(char charName) {
        BigChar bigChar = (BigChar) pool.get("" + charName);
        if (bigChar == null) {
            bigChar = new BigChar(charName);
            pool.put("" + charName, bigChar);
        }
        return bigChar;
    }

}

