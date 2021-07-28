package base.collections.List;

import java.util.Arrays;
import java.util.Collection;

/**
 * @description: 自定义ArrayList
 * @author: chobit
 * @created: 2021/07/23 14:01
 */
public class ArrayList<E> implements List<E> {

    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;

    // 保存元素的数组
    private Object[] elementData;

    // 当前元素个数
    private int size;

    /**
     * 没有参数新建一个空数组，添加元素时才扩容（懒汉式）
     */
    public ArrayList() {
        elementData = new Object[]{};
    }

    /**
     * 指定初始容量的构造方法
     *
     * @param initialCapacity 初始容量
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("容量不能为负数");
        } else if (initialCapacity == 0) {
            elementData = new Object[]{};
        } else {
            elementData = new Object[initialCapacity];
        }
    }

    /**
     * 指定包含元素的集合的构造方法
     *
     * @param c 指定包含元素的集合
     */
    public ArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
        if (elementData.length != 0) {
            // 如果集合元素不属于Object，全部转为Object
            if (elementData.getClass() != Object[].class) {
                elementData = Arrays.copyOf(elementData, elementData.length, Object[].class);
            }
        } else {
            elementData = new Object[]{};
        }
    }

    /**
     * 数组长度小于当前最大长度时扩容为原数组的1.5倍
     */
    private void grow() {
        if (elementData.length < size + 1) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity == 0 ? DEFAULT_CAPACITY : oldCapacity + (oldCapacity >> 1);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    /**
     * 检查下标越界
     *
     * @param index 下标
     */
    private void rangeCheck(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    /**
     * 在数组末尾添加元素
     *
     * @param element 元素
     */
    public boolean add(E element) {
        grow();
        elementData[size++] = element;
        return true;
    }

    /**
     * 在指定位置添加元素
     *
     * @param index   指定位置
     * @param element 元素
     */
    public boolean add(int index, E element) {
        rangeCheck(index);
        grow();
        System.arraycopy(elementData, index, elementData, index + 1, size - index - 1);
        elementData[index] = element;
        size++;
        return true;
    }

    /**
     * 根据下标删除元素
     *
     * @param index 下标
     */
    public boolean remove(int index) {
        rangeCheck(index);
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[size] = null;
        size--;
        return true;
    }

    @Override
    public boolean remove(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return remove(i);
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elementData[i].equals(element)) {
                    return remove(i);
                }
            }
        }
        return false;
    }

    /**
     * 根据下标更新元素
     *
     * @param index   下标
     * @param element 元素
     */
    public boolean set(int index, E element) {
        rangeCheck(index);
        elementData[index] = element;
        return true;
    }

    /**
     * 根据下标获取元素
     *
     * @param index 下标
     * @return 元素
     */
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    /**
     * 获取元素在数组第一次出现的位置
     *
     * @param o 元素
     * @return 位置
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elementData[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 数组是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 根据已存在的元素打印数组
     */
    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(elementData[i]);
        }
        System.out.print("]\n");
    }

    /**
     * 获取数组元素的个数
     *
     * @return 个数
     */
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("在第1个位置添加元素0：" + list.add(0, 1));
        System.out.println("删除第9个位置上的元素：" + list.remove(10));
        System.out.println("设置第1个元素为0：" + list.set(0, 1));
        System.out.println("第一个元素为：" + list.get(0));
        System.out.println("数组的长度为：" + list.getSize());
        System.out.println("元素1的首次出现位置为：" + list.indexOf(1));
        list.print();
    }
}