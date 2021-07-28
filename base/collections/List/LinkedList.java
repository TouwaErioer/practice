package base.collections.List;

/**
 * @description: 自定义LinkedList
 * @author: chobit
 * @created: 2021/07/26 16:15
 */
public class LinkedList<T> implements List<T> {

    private int size;

    private static class Node<T> {

        private T element;
        private Node<T> prev;
        private Node<T> next;

        public Node(Node<T> prev, T element, Node<T> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    private Node<T> first;
    private Node<T> last;

    /**
     * 在末尾添加元素
     *
     * @param element 新元素
     * @return boolean
     */
    public boolean add(T element) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, element, null);
        last = newNode;
        // 如果last节点为空，证明原来为空，第一个就是新节点
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * 在指定位置插入新节点
     *
     * @param index   指定的位置
     * @param element 新元素
     * @return boolean
     */
    public boolean add(int index, T element) {
        checkPositionIndex(index);
        // 如果插入位置与长度相等，在末尾插入
        if (index == size) {
            add(element);
        } else {
            // 根据位置查找节点，在该节点的前面插入节点
            Node<T> node = node(index);
            final Node<T> pre = node.prev;
            final Node<T> current = new Node<>(pre, element, node);
            node.prev = current;
            // 被查找到的节点前节点为null，在第一个位置插入节点
            if (pre == null) {
                first = current;
            } else {
                pre.next = current;
            }
            size++;
        }
        return true;
    }

    /**
     * 检查下标越界
     *
     * @param index 下标
     */
    public void checkPositionIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    /**
     * 根据下标返回节点
     *
     * @param index 下标
     * @return node
     */
    public Node<T> node(int index) {
        // 下标小于前半部分，从头往后找
        if (index < (size >> 1)) {
            Node<T> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else { // 下标大于后半部分，从尾往前找
            Node<T> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    /**
     * 删除第一次出现的元素的节点
     *
     * @param element 元素
     * @return boolean
     */
    public boolean remove(T element) {
        if (element == null) {
            for (Node<T> current = first; current != null; current = current.next) {
                if (current.element == null) {
                    unlink(current);
                    return true;
                }
            }
        } else {
            for (Node<T> current = first; current != null; current = current.next) {
                if (current.element.equals(element)) {
                    unlink(current);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除指定位置的节点
     *
     * @param index 位置
     * @return boolean
     */
    public boolean remove(int index) {
        checkPositionIndex(index);
        unlink(node(index));
        return true;
    }

    /**
     * 删除节点
     *
     * @param node 节点
     */
    private void unlink(Node<T> node) {
        final Node<T> pre = node.prev;
        final Node<T> next = node.next;
        // 处理前节点，如果前节点为null，该节点为首节点
        if (pre == null) {
            first = next;
        } else {
            pre.next = next;
            node.prev = null;
        }
        // 处理后节点，如果后节点为null，该节点为未节点
        if (next == null) {
            last = pre;
        } else {
            next.prev = pre;
            node.next = null;
        }
        // 让CG回收
        node.element = null;
        size--;
    }

    /**
     * 修改指定位置的元素
     *
     * @param index   位置
     * @param element 元素
     * @return boolean
     */
    public boolean set(int index, T element) {
        checkPositionIndex(index);
        Node<T> node = node(index);
        node.element = element;
        return true;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 位置
     * @return 元素
     */
    public T get(int index) {
        checkPositionIndex(index);
        return node(index).element;
    }

    /**
     * 查询第一次查询元素的下标
     *
     * @param element 元素
     * @return 下标
     */
    public int indexOf(T element) {
        int i = 0;
        if (element == null) {
            for (Node<T> current = first; current != null; current = current.next) {
                if (current.element == null) {
                    return i;
                }
                i++;
            }
        } else {
            for (Node<T> current = first; current != null; current = current.next) {
                if (current.element.equals(element)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    /**
     * 打印链表
     */
    public void print() {
        System.out.print("[");
        for (Node<T> current = first; current != null; current = current.next) {
            if (current.prev != null) {
                System.out.print(" ,");
            }
            System.out.print(current.element);
        }
        System.out.print("]");
    }

    /**
     * 获取链表长度
     *
     * @return 长度
     */
    public int getSize() {
        return size;
    }
}