
public class IteratorLesson {
    public static void main(String[] args) {
        List list = new ArrayList();
        Iterator iterator = list.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface List {
    Iterator getIterator();
}

class ArrayList implements List {
    int[] array={1,4,7};

    @Override
    public Iterator getIterator() {
        return new ArrayIterator();
    }

    class ArrayIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return (index<array.length?true:false);
        }

        @Override
        public Object next() {
            return array[index++];
        }
    }
}
