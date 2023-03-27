package ind.milo.demo.generate;

/**
 * @Date 2023/2/3 15:00
 * @Created by Milo
 */
public class Generic<T> implements Generator<T>{
    private T t;
    @Override
    public T next() {
        return null;
    }

    public Generic(T t){
        this.t = t;
    }

    public T getT(){
        return t;
    }

}
