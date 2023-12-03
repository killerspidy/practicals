package Alternate;
import java.util.Enumeration;
import java.util.Iterator;

// Adapter class to convert Enumeration to Iterator
class EnumerationAdapter<E> implements Iterator<E> {
    private Enumeration<E> enumeration;

    public EnumerationAdapter(Enumeration<E> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public E next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported by Enumeration.");
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        // Create an Enumeration (e.g., Vector)
        java.util.Vector<String> vector = new java.util.Vector<>();
        vector.add("Item 1");
        vector.add("Item 2");
        vector.add("Item 3");

        // Adapt the Enumeration to an Iterator
        Iterator<String> iterator = new EnumerationAdapter<>(vector.elements());

        // Use the adapted Iterator
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
