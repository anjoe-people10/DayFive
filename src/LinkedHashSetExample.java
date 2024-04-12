import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(53);
        set.add(12);
        set.add(47);
        set.add(71);
        set.add(30);
        set.add(63);

        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        //LinkedHashSet, where the order is preserved
        System.out.println();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(12);
        linkedHashSet.add(53);
        linkedHashSet.add(47);
        linkedHashSet.add(71);
        linkedHashSet.add(30);
        linkedHashSet.add(63);

        itr = linkedHashSet.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}
