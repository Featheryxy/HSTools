package ind.milo.demo.function.checkemail;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * @Date 2022/10/5 21:38
 * @Created by Milo
 */
public class Main {
    static final Pattern emialPattern =
            Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");

//    final Function<String, Boolean> emialChecker = s -> emialPattern.matcher(s).matches();

    // todo 将流程控制改成函数式
    static final Function<String, Result<String>> emialChecker = s -> {
        if (s == null) {
            return new Result.Failure("email must not be null");
        } else if (s.length() == 0) {
            return new Result.Failure("email must not be empty");
        } else if (emialPattern.matcher(s).matches()) {
            return new Result.Success(s);
        } else {
            return new Result.Failure("email " + s + " is invalid");
        }
    };

//    static final Function<String, Result> emialChecker = s ->
//            s == null ?
//                    new Result.Failure("email must not be null") :
//                    s.length() == 0 ?
//                            new Result.Failure("email must not be empty") :
//                            emialPattern.matcher(s).matches() ?
//                                    new Result.Success() :
//                                    new Result.Failure("email " + s + " is invalid");
//
//    };

//    void testMail(String email) {
//        if (emialChecker.apply(email)) {
//            sendVerificationMail(email);
//        } else {
//            logError("email " + email + " is invalid");
//        }
//    }


//    static void validate(String s) {
//        Result result = emialChecker.apply(s);
//        if (result instanceof Result.Success) {
//            sendVerificationMail(s);
//        }else {
//            logError(((Result.Failure)result).getErrorMsg());
//        }
//    }

//    static Executable validate(String s) {
//        Result result = emialChecker.apply(s);
//        return (result instanceof Result.Success)
//                ? () -> sendVerificationMail(s)
//                : () -> logError(((Result.Failure) result).getErrorMsg());
//    }

    private static void logError(String s) {
        System.out.println("Error message logged: " + s);
    }

    private static void sendVerificationMail(String s) {
        System.out.println("Verification mail sent to " + s);
    }

    static Effect<String> success = s -> System.out.println("Error message logged: " + s);
    static Effect<String> failure = s -> System.out.println("Verification mail sent to " + s);

//    @Test
//    public void test() {
//        validate("john@acme.com").exec();
//        validate("").exec();
//        validate(null).exec();
//        validate("paul@acme.com").exec();
//    }

    @Test
    public void finalTeset() {
        emialChecker
                .apply("john@acme.com")
                .bind(success, failure);
        emialChecker.apply("").bind(success, failure);;
        emialChecker.apply(null).bind(success, failure);;
        emialChecker.apply("paul@acme.com").bind(success, failure);;
    }
}
