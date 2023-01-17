package ind.milo.demo.reflection;

import java.lang.reflect.Constructor;

/**
 * @Date 2023/1/17 10:58
 * @Created by Milo
 */
public class Constructors {
    public static void main(String[] args) throws Exception {
        //1.加载Class对象
        Class clazz = Class.forName("ind.milo.demo.reflection.Student");
        //2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] conArray = clazz.getConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }
        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        conArray = clazz.getDeclaredConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }
        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor con = clazz.getConstructor(null);
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。
        System.out.println("con = " + con);
        //调用构造方法
        Object obj = con.newInstance();
        System.out.println("obj = " + obj);
        Student stu = (Student)obj;
        System.out.println("stu = " + stu);
        System.out.println("强转后对象是否相同：" + (stu == obj));
        System.out.println("equals: "+stu.equals(obj));
        System.out.println("******************获取私有构造方法，并调用*******************************");
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);
        //调用构造方法
//        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        obj = con.newInstance('男');
        System.out.println("******************多态*******************************");
        Student student = (Student)(new Object());
        System.out.println(student);
        // java.lang.Object cannot be cast to ind.milo.demo.reflection.Student
    }
}
