package ind.milo.demo.gof.observer;

public class ListenerTest {

    public static class A {

        private Listener listener;

        public long doAction() {
            long l = System.currentTimeMillis();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long l2 = System.currentTimeMillis();
            if (null != listener) {
                listener.onAction(l, l2);
            }
            return l2 - l;
        }

        public Listener getListener() {
            return listener;
        }

        public void setListener(Listener listener) {
            this.listener = listener;
        }

    }

    @FunctionalInterface
    interface Listener {
        void onAction(long a, long b);
    }


    // 仅在 main 方法添加代码，打印出 timeDiff 是由哪两个数字计算出来的
    public static void main(String[] args) {
        A a = new A();
        a.setListener((beg, end)->{
            System.out.println(beg);
            System.out.println(end);
        });
        long timeDiff = a.doAction();
        System.out.println(timeDiff);
    }
}
