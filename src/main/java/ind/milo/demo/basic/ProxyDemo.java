package ind.milo.demo.basic;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService proxy = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new UserServiceProxy(userService)
        );
        proxy.addUser("Alice");
    }
}
 interface UserService {
    void addUser(String name);
}

 class UserServiceImpl implements UserService {
    public void addUser(String name) {
        System.out.println("Adding user: " + name);
    }
}

// 该代理类中实现了在原始方法调用前后打印日志的逻辑
 class UserServiceProxy implements InvocationHandler {
    private Object target;

    public UserServiceProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method: " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("After method: " + method.getName());
        return result;
    }
}
