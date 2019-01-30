package Collection;

public class MyVector {

    Object[] objArr;
    int size;

    MyVector(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("유효하지 않은 값 입니다.");
        objArr = new Object[capacity];
    }

    MyVector() {
        this(10);
    }

    int size() {
        return size;
    }

    int capacitiy() {
        return objArr.length;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void clear() {
        for (int i = 0; i < objArr.length; i++) {
            objArr[i] = null;
        }
        size = 0;
    }

    Object get(int index) {

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("범위르 벗어났습니다.");
        return objArr[index];
    }

    int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (objArr[i].equals(obj)) return 1;
        }
        return -1;
    }

    void setCapacity(int capacity) {
        Object[] tmp = new Object[capacity];
        System.arraycopy(objArr, 0, tmp, 0, Math.min(size, capacity));

        objArr = tmp;
    }

    void ensureCapacity(int minCapacity) {
        if (minCapacity > objArr.length) {
            setCapacity(minCapacity);
        }
    }

    Object remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("범위를 벗어났습니다.");

        Object oldObj = objArr[index];

        if (index != size - 1)
            System.arraycopy(objArr, index + 1, objArr, index, size - 1 - index);

        objArr[--size] = null;

        return oldObj;
    }

    Boolean add(Object obj) {
        ensureCapacity(size + 1);
        objArr[size] = obj;
        size++;

        return true;
    }

    public String toString() {
        String temp = "[";
        for (int i = 0; i < size; i++) {
            temp += objArr[i] + ", ";
        }

        return temp + "]";
    }
}
