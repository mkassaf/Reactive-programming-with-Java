import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {


    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");

        System.out.println("queue: " + queue);
        System.out.println("queue.peek: " + queue.peek());
        queue.remove();//Remove last
        System.out.println("queue.peek: " + queue.peek());
        System.out.println("queue.poll: " + queue.poll());
        System.out.println("queue: " + queue);
        System.out.println("queue.poll: " + queue.poll());
        System.out.println("queue.poll: " + queue.isEmpty());
        System.out.println("queue.poll: " + queue.poll());//null
    }
}
