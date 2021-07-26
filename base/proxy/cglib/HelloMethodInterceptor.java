package base.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: 方法拦截器
 * @author: chobit
 * @created: 2021/07/26 14:08
 */
public class HelloMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object object = methodProxy.invokeSuper(o, objects);
        return object;
    }
}