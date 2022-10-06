package ind.milo.demo.function.checkemail;

/**
 * @Date 2022/10/5 21:51
 * @Created by Milo
 */
public interface Result<T> {
    void bind(Effect<T> success, Effect<T> failure);

    public static <T> Result<T> failure(String value) {
        return new Failure<>(value);
    }

    public static <T> Result<T> success(T value) {
        return new Success<>(value);
    }

    public class Success<T> implements Result<T> {
        private final T value;

        public Success(T t) {
            value=t;
        }

        @Override
        public void bind(Effect<T> success, Effect<T> failure) {
            success.apply(value);
        }
    }

    public class Failure<T> implements Result<T> {
        private final String errorMsg;

        public Failure(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        @Override
        public void bind(Effect<T> success, Effect<T> failure) {
            failure.apply((T) errorMsg);
        }
    }
}
