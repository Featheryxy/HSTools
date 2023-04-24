package ind.milo.demo.basic;

import java.util.HashMap;
import java.util.Map;

public class OOM {
    public static void main(String[] args) throws InterruptedException {
        Map cache = new HashMap();
        for (int i = 0; i < 128; i++) {
//            Thread.sleep(1000);
            cache.put(i, new byte[1024 * 1024]);
        }
    }


}
