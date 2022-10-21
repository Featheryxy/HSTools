import ind.milo.util.RegUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;

public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    @org.junit.jupiter.api.Test
    public void test() {

        // 1. 创建文件输入流
        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            fin = new FileInputStream("hello.txt");
            fout = new FileOutputStream("hello-copy.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 2. 创建FileChannel对象， 用于读取、写入、映射和操作文件的通道。
        FileChannel finChannel = fin.getChannel();
        FileChannel foutChannel = fout.getChannel();

        // 3. 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //  4. 将数据从通道读到缓冲区
        int eof; // 缓冲区的字符长度为
        try {
            while (true) {
                eof = finChannel.read(buffer);
                if (eof == -1) {
                    break;
                }
                // 重设一下buffer的position=0，limit=position
                buffer.flip();
                foutChannel.write(buffer);

                // 重置buffer，重设position=0,limit=capacity
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (finChannel != null) {
                try {
                    finChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (foutChannel != null) {
                try {
                    foutChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @org.junit.jupiter.api.Test
    public void test2() throws IOException {
        // 声明源文件和目标文件
        // 从readandshow.txt读取内容到copy.txt
        FileInputStream fi = new FileInputStream(new File("hello.txt"));
        FileOutputStream fo = new FileOutputStream(new File("hello-copy.txt"));

        // 获得传输通道channel
        FileChannel inChannel = fi.getChannel();
        FileChannel outChannel = fo.getChannel();

        // 获得容器buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            // 判断是否读完文件
            int eof = inChannel.read(buffer);
            if (eof == -1) {
                break;
            }
            // 重设一下buffer的position=0，limit=position
            buffer.flip();
            // 开始写
            outChannel.write(buffer);
            // 写完要重置buffer，重设position=0,limit=capacity
            buffer.clear();
        }

        // 释放资源
        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();
    }

    @org.junit.jupiter.api.Test
    public void test3() throws InterruptedException {
        logger.debug("begin");
        System.out.println("hello,...");
        Thread.sleep(3000);
        logger.debug("end");
    }

    @org.junit.jupiter.api.Test
    public void test4(){
        int a = 0;
        System.out.println(a);
        HashMap<String, Double> map = new HashMap<>();
        System.out.println(map.get("cfmVol") == null);
        map.put("cfmVol", 200.0);
        map.put("cfmVol", 300.0);
        System.out.println(map);

    }
}

