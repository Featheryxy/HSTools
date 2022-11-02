package ind.milo.demo.callbackdemo;

/**
 * @Date 2022/11/2 14:22
 * @Created by Milo
 */
public class Server {
    public void add(int i, int j, IClient client) {
        System.out.printf("beg 服务器响应客户请求%s \n", client.getClientName());
        int res = i+j;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("end 服务器通知客户请求%s \n", client.getClientName());
        client.result(res);

    }
}
