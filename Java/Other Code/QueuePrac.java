import java.util.*;
import java.io.*;

public class QueuePrac {
    public static void main(String[] args) throws IOException {
        Queue<Integer> ll = new LinkedList<>();
        LinkedList<Integer> ll2 = new LinkedList<>();

        ll.add(10);
        ll.add(20);
        ll.add(15);

        System.out.println(ll.peek());
        System.out.println(ll.poll());
        System.out.println(ll.peek());

        ll2.add(10);
        ll2.add(20);
        ll2.add(15);

        System.out.println(ll2.peek());
        System.out.println(ll2.poll());
        System.out.println(ll2.peek());
    }
}
