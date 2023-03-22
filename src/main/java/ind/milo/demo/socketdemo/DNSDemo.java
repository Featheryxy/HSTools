package ind.milo.demo.socketdemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Date 2023/2/28 22:52
 * @Created by Milo
 */
public class DNSDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip= InetAddress.getByName("www.baidu.com");
        System.out.println(ip);
    }
}
