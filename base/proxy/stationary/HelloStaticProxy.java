package base.proxy.stationary;

import base.proxy.Hello;
import base.proxy.HelloInterface;

/**
 * @description: 代理类
 * @author: chobit
 * @created: 2021/07/26 13:27
 */
public class HelloStaticProxy implements HelloInterface {

    private Hello hello;

    @Override
    public void say() {
        if (hello == null) {
            hello = new Hello();
        }
        hello.setText("static proxy");
        hello.say();
    }
}