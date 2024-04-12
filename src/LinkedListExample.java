import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

class LinkedStudent implements Comparable<LinkedStudent> {
    private final int rollNumber;
    private final String name;

    public LinkedStudent(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(LinkedStudent that) {
        return this.name.compareTo(that.name);
    }
}

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<LinkedStudent> linkedList = new LinkedList<>();

        //add()
        linkedList.add(new LinkedStudent(1, "Sebin"));
        linkedList.add(new LinkedStudent(2, "John"));
        linkedList.add(new LinkedStudent(3, "Anjoe"));

        System.out.println(linkedList);

        //get()
        System.out.println(linkedList.get(2));

        //remove()
        LinkedStudent removedStudent = linkedList.remove(1);
        System.out.println("\nRemoved " + removedStudent);

        //addFirst() (Not declared in the List interface, so cannot access these methods with List reference)
        linkedList.addFirst(removedStudent);
        System.out.println(linkedList);

        //removeFirst()
        removedStudent = linkedList.removeLast();
        System.out.println(linkedList);

        //addLast()
        linkedList.addLast(removedStudent);
        System.out.println(linkedList);

        //sort using Comparable interface
        System.out.println("Sorted based on name");
        Collections.sort(linkedList);
        System.out.println(linkedList);

        Comparator<LinkedStudent> comp = new Comparator<LinkedStudent>() {
            @Override
            public int compare(LinkedStudent linkedStudent, LinkedStudent t1) {
                return 0;
            }
        };

        //sort using Comparator
        System.out.println("Sorted using roll number(Reverse Iterator)");
        linkedList.sort((i, j) -> Integer.compare(i.getRollNumber(), j.getRollNumber()));
        Iterator<LinkedStudent> iterator = linkedList.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //clear()
        System.out.println("Cleared list");
        linkedList.clear();
        System.out.println(linkedList);
    }
}
