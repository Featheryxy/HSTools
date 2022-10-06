package ind.milo.demo.function.checkemail;

/**
 * @Date 2022/10/5 22:19
 * @Created by Milo
 */
public interface Effect<T> {
    void apply(T t);
}
