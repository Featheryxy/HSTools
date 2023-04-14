package ind.milo.demo.basic;

/**
 * @Date 2023/2/2 15:50
 * @Created by Milo
 */
public class ByteDemo {
    public static void main(String[] args) {
        Byte tByte = 127; // 01111111
        System.out.println(Integer.toBinaryString((tByte & 0xFF) + 0x100).substring(1));
        Byte a = -128; // 10000000
        System.out.println(Integer.toBinaryString(( a & 0xFF) + 0x100).substring(1));
        Byte b = -0; // 00000000
        System.out.println(Integer.toBinaryString(( b & 0xFF) + 0x100).substring(1));
        Byte c = -1; // 00000000
        System.out.println(Integer.toBinaryString(( c & 0xFF) + 0x100).substring(1));
    }
}
