package base.proxy;

/**
 * @description: 实现类
 * @author: chobit
 * @created: 2021/07/26 13:25
 */
public class Hello implements HelloInterface {

    private String text = "cglib proxy";

    @Override
    public void say() {
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}