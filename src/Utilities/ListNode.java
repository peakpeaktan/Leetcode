package Utilities;

public class ListNode {
    int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode insert(ListNode root, int item)
    {
        ListNode temp = new ListNode(-1);
        ListNode ptr;
        temp.val = item;
        temp.next = null;

        if (root == null)
            root = temp;
        else
        {
            ptr = root;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = temp;
        }
        return root;
    }

    public static ListNode fromArray(int arr[], int n)
    {
        ListNode root = null;
        for (int i = 0; i < n; i++)
            root = insert(root, arr[i]);
        return root;
    }

    public static void toString(ListNode root)
    {
        while (root != null)
        {
            System.out.print( root.val + " ");
            root = root.next;
        }
    }
}

