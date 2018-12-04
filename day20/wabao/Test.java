package banban.study15.fanshe;

/**
 * @ClassName test1
 * @Author zhang-peng-zhan
 * @Date 2018/12/1 23:03
 */

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        // E:\9.22实训班共享\笔记资料
        // 类加载器, 作用：加载一个不在classpath下的类
        ClassLoader cl = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    FileInputStream in = new FileInputStream("D:\\学习笔记\\day18\\Treasure.class");
                    byte[] bytes = new byte[1024 * 8];
                    int len = in.read(bytes);

                    // 调用父类的方法根据字节数组加载类
                    return defineClass(name, bytes, 0, len);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };

        Class<?> clazz = cl.loadClass("com.westos.Treasure"); // 根据类名加载类, 得到类对象
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();  //获取私有构造器
        constructors[0].setAccessible(true);         //true
        Object c = constructors[0].newInstance(null);   //拿到对象
        Method[] declaredMethods = clazz.getDeclaredMethods();   //获取方法数组

        for (Method declaredMethod : declaredMethods) {     //遍历
            Annotation [] annotations = declaredMethod.getAnnotations();   //获取注释数组
            //declaredMethod.setAccessible(true);
            for (Annotation annotation : annotations) {          //遍历注释数组
                if (annotation instanceof Resource) {          //比较
                    declaredMethod.setAccessible(true);         //调方法
                    declaredMethod.invoke(c);               //
                }
            }
        }


    }
}