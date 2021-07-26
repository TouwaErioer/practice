package base.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 反射测试类
 * @author: chobit
 * @created: 2021/07/26 09:04
 */
public class Test {
    private static Class<?> targetClass;
    private static Target target;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        targetClass = Class.forName("base.reflection.Target");
        Constructor<?> constructor = targetClass.getConstructor(String.class);
        // 通过反射创建对象有两种方式：1. 通过clazz.newInstance 2. 通过constructor.newInstance
        // 前者只能使用默认的构造方法，后者可以选择构造方法
        target = (Target) constructor.newInstance("constructor arg");

        System.out.println("---initialization---");
        print();

        System.out.println("\n---reflection---");
        Field field = targetClass.getDeclaredField("value");
        field.setAccessible(true);
        field.set(target, "reflection value");
        print();

        System.out.println("\n---setValue---");
        target.setValue("invoke setValue");
        print();
    }

    public static void print() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = targetClass.getDeclaredMethod("print");
        method.setAccessible(true);
        method.invoke(target);
    }
}