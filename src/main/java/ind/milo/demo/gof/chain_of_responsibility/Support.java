package ind.milo.demo.gof.chain_of_responsibility;

/**
 * 1. 定义处理器类的执行流程, 2. 自我聚合
 * 子类只需要实现 resolve 方法即可
 */
public abstract class Support {
    private String name; // 处理器名称
    private Support next; // 保存下一个处理器，聚合

    public Support(String name) {
        this.name = name;
    }

    /**
     * 为当前对象设置下一个处理器，并且返回下一个处理器对象
     * @param next
     * @return
     */
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    /**
     * template method
     * 处理器处理流程，如果当前处理器处理失败，则交给下一个处理器处理，否则处理失败
     * @param trouble
     */
    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }

//        if () {
//
//        } else {
//            if () {
//
//            }else{
//
//            }
//        }
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " can't be resolved");
    }

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this);
    }

    protected abstract boolean resolve(Trouble trouble);

    public String toString() {
        return "[" + name + "]";
    }


}
