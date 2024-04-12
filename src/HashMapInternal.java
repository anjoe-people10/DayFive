import java.util.HashMap;
import java.util.Objects;

class HashableStudent {
    final int id;
    String name;

    public HashableStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashableStudent student = (HashableStudent) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class Mentor {
    final int id;
    String name;

    public Mentor(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class HashMapInternal {
    public static void main(String[] args) {
        HashMap<HashableStudent, Mentor> map = new HashMap<>();

        HashableStudent student1 = new HashableStudent(1, "Anjoe");
        HashableStudent student2 = new HashableStudent(2, "Ankit");
        HashableStudent student3 = new HashableStudent(3, "Ananthu");
        HashableStudent student4 = new HashableStudent(1, "TestError");

        Mentor mentor1 = new Mentor(1, "Sminu");
        Mentor mentor2 = new Mentor(2, "Dincy");

        map.put(student1, mentor1);
        map.put(student2, mentor2);
        map.put(student3, mentor1);
        map.put(student4, mentor1);

        for(HashableStudent student : map.keySet()) {
            System.out.printf("Student %s has mentor %s\n", student.name, map.get(student).name);
        }
    }
}
