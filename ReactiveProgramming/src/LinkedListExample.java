import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) throws Exception {
        // Create a Linked List
        LinkedList<String> students = new LinkedList();

        // Add students to the Linked List
        students.add("Charlie");
        students.add("Sally");
        students.add("Morgan");
        students.add("Taylor");
        students.add("Jamie");
        System.out.println("Midd student: " + findMiddle(students));

        System.out.println("student: " + students);
        deleteMiddle(students);
        System.out.println("After delete student: " + students);

        students.addFirst("Sarah");
        System.out.println("addFirst Student: " + students);
        students.addLast("Hailey");
        System.out.println("addLast Student: " + students);
        students.add(2, "Tara");

        // Retrieve items from a Linked List by placement
        String firstStudent = students.getFirst();
        System.out.println("First Student: " + firstStudent);

        String lastStudent = students.getLast();
        System.out.println("Last Student: " + lastStudent);

        // Retrieve items from a Linked List by index
        String secondStudent = students.get(1);
        System.out.println("Second Student: " + secondStudent);

        // Retrieve index of specific item
        int i = students.indexOf("Morgan");
        System.out.println("Index of Morgan: " + i);

        // Access size of a Linked List
        System.out.println("Size: " + students.size());

        // Remove items by placement, object, and index
        students.removeFirst();
        students.removeLast();
        students.remove("Jamie");
        students.remove(1);
        System.out.println(students);

        // Search for items in a Linked List
        boolean hasTaylor = students.contains("Taylor");
        System.out.println("Have taylor? " + hasTaylor);

        // Empty the list
        students.clear();
        System.out.println(students);
    }

    private static String findMiddle(LinkedList<String> students) throws Exception {
        if (students.isEmpty()) throw new Exception("Empty data");
        return students.get(students.size()/2);

    }

    private static void deleteMiddle(LinkedList<String> nodes) throws Exception {
        if (nodes.isEmpty()) throw new Exception("Empty data");

        nodes.remove(nodes.size()/2);

    }
}
