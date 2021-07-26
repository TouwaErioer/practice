package base.proxy;

import base.proxy.cglib.HelloMethodInterceptor;
import base.proxy.dynamic.HelloDynamicProxy;
import base.proxy.stationary.HelloStaticProxy;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description: 测试类
 * @author: chobit
 * @created: 2021/07/26 13:31
 */
public class Test {

    public static void main(String[] args) {
        // JDK静态代理
        HelloStaticProxy helloStaticProxy = new HelloStaticProxy();
        helloStaticProxy.say();

        // JDK动态代理
        Hello hello = new Hello();
        hello.setText("dynamic proxy");
        InvocationHandler handler = new HelloDynamicProxy(hello);
        // 传入handler的类加载器和被代理类的接口，以此动态创建代理类
        HelloInterface helloInterface = (HelloInterface) Proxy.newProxyInstance(
                handler.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                handler
        );
        helloInterface.say();

        // cglib
        // 底层把方法全部放入数组，通过数组索引直接调用方法
        // 不能对final类或方法进行代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new HelloMethodInterceptor());
        HelloInterface helloInterface1 = (HelloInterface) enhancer.create();
        helloInterface1.say();
    }
}