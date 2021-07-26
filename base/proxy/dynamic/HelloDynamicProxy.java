package base.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 代理类
 * @author: chobit
 * @created: 2021/07/26 13:34
 */

public class HelloDynamicProxy implements InvocationHandler {

    private Object subject;

    public HelloDynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(subject, args);
        return null;
    }
}