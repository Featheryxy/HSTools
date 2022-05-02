package ind.milo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NIOUtil {
    private NIOUtil(){

    }

    public static String read(String path){
        return NIOUtil.read(path, 1024);
    }

    /**
     *
     * @param path 文件路径
     * @param byteLeng buffer数组长度
     * @return 文本中的内容
     */
    public static String read(String path, int byteLeng){
        StringBuilder retStr = new StringBuilder();

        FileInputStream fin = null;
        try {
            fin = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileChannel channel = null;
        if (fin != null) {
            channel = fin.getChannel();
        }

        ByteBuffer buffer = ByteBuffer.allocate(byteLeng);

        int eof = -1;
        while (true) {
            try {
                eof = channel.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (eof == -1) {
                break;
            }
            buffer.flip();
            retStr.append(new String(buffer.array(), 0, buffer.limit()));
        }
        return retStr.toString();
    }

    public static void makeFile(String text, String path) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        FileChannel outChannel = fileOutputStream.getChannel();

        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes.length; i++) {
            byteBuffer.put(bytes[i]);
        }

        try {
            outChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
