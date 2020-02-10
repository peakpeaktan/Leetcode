/*

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */

import java.util.HashMap;

public class $138_Copy_List_With_Random_Pointer {

    public static void main(String [] args){

        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        RandomListNode four = new RandomListNode(4);

        one.next = two;
        one.random = three;

        two.next = three;
        two.random = one;

        three.next = four;
        three.random = two;
        four.next = null;

        // 1 -> 2 -> 3 -> 4 -> null
        // |    |    |
        // 3    1    2

    }

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;

        while(cur != null){

            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = head;

        while (cur != null){

            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);

    }

}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { label = x; }
}
