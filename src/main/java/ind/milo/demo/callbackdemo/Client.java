package ind.milo.demo.callbackdemo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Date 2022/11/2 14:19
 * @Created by Milo
 */
@Data
@AllArgsConstructor
public class Client implements IClient{
    private String name;


    @Override
    public String getClientName() {
        return name;
    }

    @Override
    public void processByServer(int a, int b) {
        new Thread(() -> {
//            server.add(a, b, this);
        });
    }

    @Override
    public void processByServer(int a, int b, Server server) {
        new Thread(() -> {
            System.out.printf("client %s is doing add \n", name);
            server.add(a, b,this);
        }).start();
        System.out.printf("client %s is doing something else \n", name);
    }

    @Override
    public void result(int i) {
        System.out.printf("Client %s's result is %s%n \n", this.name, i);
    }

    public static void main(String[] args) {
        Client a = new Client("A");
        Server server = new Server();
        a.processByServer(1, 2, server);

    }
}
