import java.util.Objects;
import java.util.TreeMap;

class Employee implements Comparable<Employee> {
    int id;

    public Employee(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Employee that) {
        return Integer.compare(this.id, that.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Employee, Integer> treeMap = new TreeMap<>();

        Employee employee1 = new Employee(109);
        Employee employee2 = new Employee(109);

        System.out.println(employee1.equals(employee2));

        treeMap.put(employee1, 10500);
        treeMap.put(new Employee(104), 17000);
        treeMap.put(new Employee(102), 16000);
        treeMap.put(new Employee(101), 11000);
        treeMap.put(new Employee(106), 10000);
        treeMap.put(new Employee(111), 20000);


        //remove()
        treeMap.remove(employee2);

        for (Employee employee : treeMap.keySet()) {
            System.out.println("Emp id: " + employee.id + ", Salary: " + treeMap.get(employee));
        }
    }
}
