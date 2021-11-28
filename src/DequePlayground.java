import java.util.*;
public class DequePlayground {

    public static void main (String[] args){
//        LinkedList<Integer> list = new LinkedList<>();
//        list.push(1);
//        list.add(2);
//        list.offer(3);
//        System.out.println(list);
//        System.out.println(list.pop());
//        System.out.println(list.poll());
//        System.out.println(list.remove());
//        System.out.println(list);

        Deque<Integer> d = new ArrayDeque<>();
        d.offer(9);
        d.push(8);
        d.add(10);
        d.poll();
        d.pop();
        System.out.println(d);
    }

}
