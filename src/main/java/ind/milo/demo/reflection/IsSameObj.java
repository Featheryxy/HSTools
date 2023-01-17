package ind.milo.demo.reflection;

import java.lang.reflect.Constructor;

/**
 * @Date 2023/1/17 15:57
 * @Created by Milo
 */
public class IsSameObj {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("ind.milo.demo.reflection.Student");
        Constructor con = clazz.getConstructor(null);
        Object obj = con.newInstance();
        Student stu = (Student)obj;
//        System.out.println(clazz == obj); // false
        System.out.println("强转后对象是否相同：" + (stu == obj));
        System.out.println("equals: "+stu.equals(obj));
    }
}
