package base.collections.List;

public interface List<T> {

    boolean add(T element);

    boolean add(int index, T element);

    boolean remove(T element);

    boolean remove(int index);

    boolean set(int index, T element);

    T get(int index);

    int getSize();

    int indexOf(T element);

    void print();
}
