package data_structures.array_list;

import java.util.Arrays;

/**
 * Basic Array list implementation
 * @author Brandon Manke
 */
public class MyArrayList<E> {
  private int size = 0;
  private Object[] array;

  public MyArrayList() {
    this(10);
  }

  public MyArrayList(int initSize) {
    if (initSize < 0)
      throw new IllegalArgumentException();

    size = 0;
    array = new Object[initSize];
  }

  public int size() { return size; }

  public boolean isEmpty() { return size == 0; }

  public E get(int index) {
    if (index > size - 1 || index < 0)
      throw new IllegalArgumentException();

    return (E) array[index];
  }

  private void growArray() {
    if (array.length * 2 >= Integer.MAX_VALUE)
      throw new OutOfMemoryError(); // not sure if correct use

    Arrays.copyOf(array, array.length * 2);
  }

  public E remove(int index) {
    if (index > size - 1 || index < 0)
      throw new IllegalArgumentException();

    E removed = (E) array[index];

    for (int i = index; i < size; i++)
      array[i] = array[i+1];

    size--;
    return removed;
  }

  public void pushBack(E element) {
    if (size * 2 >= array.length)
      growArray();

    array[size] = element;
    size++;
  }

  public void pushFront(E element) {
    if (size * 2 >= array.length)
      growArray();

    for (int i = size; i >= 0; i--)
      array[i+1] = array[i];

    array[0] = element;
    size++;
  }

  public void add(E element, int index) {
    if (index > size - 1 || index < 0)
      throw new IllegalArgumentException();

    if (size * 2 >= array.length)
      growArray();

    for (int i = size; i >= index; i--)
      array[i+1] = array[i];

    array[index] = element;
    size++;
  }

  public int indexOf(Object obj) {
    for (int i = 0; i < size; i++) {
      if (array[i].equals(obj))
        return i;
    }
    return -1;
  }

  public void clear() {
    for (int i = 0; i < size; i++)
      array[i] = null;

    size = 0;
    array = null;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    for (int i = 0; i < size - 1; i++)
      sb.append(array[i] + ", ");

    sb.append(array[size-1] + " ]");
    return sb.toString();
  }
}
