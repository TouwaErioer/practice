package base.reflection;

/**
 * @description: 反射目标类
 * @author: chobit
 * @created: 2021/07/26 09:01
 */
public class Target {

    private String value;

    public Target() {
        this.value = "initialization value";
    }

    public Target(String value){
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private void print() {
        System.out.println(this.value);
    }
}
