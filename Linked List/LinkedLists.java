import java.util.*;

public class LinkedLists {

    // ===================== 1. SINGLY LL - STUDENT =====================
    static class StudentNode {
        int roll;
        String name;
        int age;
        String grade;
        StudentNode next;

        StudentNode(int r, String n, int a, String g) {
            roll = r; name = n; age = a; grade = g;
        }
    }

    static StudentNode studentHead = null;

    static void addStudent(int r, String n, int a, String g) {
        StudentNode newNode = new StudentNode(r, n, a, g);
        newNode.next = studentHead;
        studentHead = newNode;
    }

    static void displayStudents() {
        StudentNode temp = studentHead;
        while (temp != null) {
            System.out.println(temp.roll + " " + temp.name + " " + temp.grade);
            temp = temp.next;
        }
    }

    static void deleteStudent(int roll) {
        StudentNode temp = studentHead, prev = null;
        while (temp != null) {
            if (temp.roll == roll) {
                if (prev == null) studentHead = temp.next;
                else prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    // ===================== 2. DOUBLY LL - MOVIES =====================
    static class Movie {
        String title, director;
        int year;
        double rating;
        Movie prev, next;

        Movie(String t, String d, int y, double r) {
            title = t; director = d; year = y; rating = r;
        }
    }

    static Movie headM = null, tailM = null;

    static void addMovie(String t, String d, int y, double r) {
        Movie m = new Movie(t, d, y, r);
        if (headM == null) headM = tailM = m;
        else {
            tailM.next = m;
            m.prev = tailM;
            tailM = m;
        }
    }

    static void displayMoviesForward() {
        Movie temp = headM;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.rating);
            temp = temp.next;
        }
    }

    static void displayMoviesReverse() {
        Movie temp = tailM;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.rating);
            temp = temp.prev;
        }
    }

    // ===================== 3. CIRCULAR LL - TASK =====================
    static class Task {
        int id;
        String name;
        Task next;

        Task(int i, String n) {
            id = i; name = n;
        }
    }

    static Task taskHead = null;

    static void addTask(int id, String name) {
        Task newTask = new Task(id, name);
        if (taskHead == null) {
            taskHead = newTask;
            newTask.next = taskHead;
        } else {
            Task temp = taskHead;
            while (temp.next != taskHead) temp = temp.next;
            temp.next = newTask;
            newTask.next = taskHead;
        }
    }

    static void displayTasks() {
        if (taskHead == null) return;
        Task temp = taskHead;
        do {
            System.out.println(temp.id + " " + temp.name);
            temp = temp.next;
        } while (temp != taskHead);
    }

    // ===================== 4. SINGLY LL - INVENTORY =====================
    static class Item {
        int id, qty;
        String name;
        double price;
        Item next;

        Item(int i, String n, int q, double p) {
            id = i; name = n; qty = q; price = p;
        }
    }

    static Item itemHead = null;

    static void addItem(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);
        newItem.next = itemHead;
        itemHead = newItem;
    }

    static double totalInventoryValue() {
        double total = 0;
        Item temp = itemHead;
        while (temp != null) {
            total += temp.qty * temp.price;
            temp = temp.next;
        }
        return total;
    }

    // ===================== 5. DOUBLY LL - LIBRARY =====================
    static class Book {
        int id;
        String title, author;
        boolean available;
        Book prev, next;

        Book(int i, String t, String a, boolean av) {
            id = i; title = t; author = a; available = av;
        }
    }

    static Book headB = null;

    static void addBook(int id, String t, String a) {
        Book b = new Book(id, t, a, true);
        b.next = headB;
        if (headB != null) headB.prev = b;
        headB = b;
    }

    static void displayBooks() {
        Book temp = headB;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.available);
            temp = temp.next;
        }
    }

    // ===================== 6. CIRCULAR LL - ROUND ROBIN =====================
    static class Process {
        int id, burst;
        Process next;

        Process(int i, int b) {
            id = i; burst = b;
        }
    }

    static Process processHead = null;

    static void addProcess(int id, int burst) {
        Process p = new Process(id, burst);
        if (processHead == null) {
            processHead = p;
            p.next = processHead;
        } else {
            Process temp = processHead;
            while (temp.next != processHead) temp = temp.next;
            temp.next = p;
            p.next = processHead;
        }
    }

    static void roundRobin(int quantum) {
        if (processHead == null) return;

        Process temp = processHead;
        do {
            if (temp.burst > quantum) {
                temp.burst -= quantum;
                System.out.println("Process " + temp.id + " executed");
            } else {
                System.out.println("Process " + temp.id + " finished");
                temp.burst = 0;
            }
            temp = temp.next;
        } while (temp != processHead);
    }

    // ===================== 7. SINGLY LL - SOCIAL =====================
    static class User {
        int id;
        String name;
        ArrayList<Integer> friends = new ArrayList<>();
        User next;

        User(int i, String n) {
            id = i; name = n;
        }
    }

    static User userHead = null;

    static void addUser(int id, String name) {
        User u = new User(id, name);
        u.next = userHead;
        userHead = u;
    }

    static void addFriend(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if (u1 != null && u2 != null) {
            u1.friends.add(id2);
            u2.friends.add(id1);
        }
    }

    static User findUser(int id) {
        User temp = userHead;
        while (temp != null) {
            if (temp.id == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // ===================== 8. DOUBLY LL - UNDO/REDO =====================
    static class State {
        String text;
        State prev, next;

        State(String t) { text = t; }
    }

    static State current = null;

    static void addState(String text) {
        State s = new State(text);
        if (current != null) current.next = s;
        s.prev = current;
        current = s;
    }

    static void undo() {
        if (current != null && current.prev != null)
            current = current.prev;
    }

    static void redo() {
        if (current != null && current.next != null)
            current = current.next;
    }

    // ===================== 9. CIRCULAR LL - TICKETS =====================
    static class Ticket {
        int id;
        String name, movie;
        Ticket next;

        Ticket(int i, String n, String m) {
            id = i; name = n; movie = m;
        }
    }

    static Ticket ticketHead = null;

    static void addTicket(int id, String name, String movie) {
        Ticket t = new Ticket(id, name, movie);
        if (ticketHead == null) {
            ticketHead = t;
            t.next = ticketHead;
        } else {
            Ticket temp = ticketHead;
            while (temp.next != ticketHead) temp = temp.next;
            temp.next = t;
            t.next = ticketHead;
        }
    }

    static void displayTickets() {
        if (ticketHead == null) return;
        Ticket temp = ticketHead;
        do {
            System.out.println(temp.id + " " + temp.name + " " + temp.movie);
            temp = temp.next;
        } while (temp != ticketHead);
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {

        // Student
        addStudent(1, "Aman", 20, "A");
        addStudent(2, "Riya", 21, "B");
        displayStudents();

        // Movie
        addMovie("Inception", "Nolan", 2010, 9.0);
        displayMoviesForward();

        // Task
        addTask(1, "Task1");
        displayTasks();

        // Inventory
        addItem(1, "Pen", 10, 5);
        System.out.println("Total Value: " + totalInventoryValue());

        // Library
        addBook(1, "Java", "James");
        displayBooks();

        // Round Robin
        addProcess(1, 10);
        roundRobin(4);

        // Social
        addUser(1, "A");
        addUser(2, "B");
        addFriend(1, 2);

        // Undo/Redo
        addState("Hello");
        addState("Hello World");
        undo();
        System.out.println("Current: " + current.text);

        // Ticket
        addTicket(1, "John", "Avengers");
        displayTickets();
    }
}