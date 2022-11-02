package ind.milo.demo.callbackdemo;

/**
 * @Date 2022/11/2 14:18
 * @Created by Milo
 */
public interface IClient {
    String getClientName();

    void processByServer(int a, int b);

    void processByServer(int a, int b, Server server);

    void result(int i);
}
