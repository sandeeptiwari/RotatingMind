package ds.list;

public class CustomArrayList<T> {

  private T[] arrayList;
  private int count;

  public boolean isEmpty() {
      return count == 0;
  }

  public int size() {
      return count;
  }

    public CustomArrayList() {
        arrayList = (T[]) new Object[1];
    }

    public T get(int index) {
      T item = null;
      if (!isEmpty()) {
          item = arrayList[index];
      }
      return item;
    }

    public boolean add(T item) {

      if (count == arrayList.length) {
          resize(2*count);
      }
      arrayList[count++] = item;

      return true;
    }

    private void resize(int newSize) {
        T[] arrayListCopy = (T[]) new Object[newSize];

        for (int i = 0; i < count; i++) {
            arrayListCopy[i] = arrayList[i];
        }
        arrayList = arrayListCopy;
    }

}
