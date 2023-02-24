import java.util.Arrays;
import java.util.List;
import java.util.*;

public class SyntaxTest {

    public static void main(String [] args){

        String[] array = {"a","b"};

        /*
        Arrays.asList
        */
        System.out.println(Arrays.asList(array));
        System.out.println(Arrays.asList("a","b"));

        //String valueOf

        //Integer.valueOf, intValue
        int primitiveInt = 9;
        Integer integer = 8;
        String string = "10";
        System.out.println(Integer.valueOf(primitiveInt));
        System.out.println(Integer.valueOf(string));//could throw NumberFormatException
        System.out.println(Integer.valueOf(string, 10));
        System.out.println(integer.intValue());

        /*
        String split
         */
        String words = "dog cat cat dog";
        String[] split1 = words.split(" ");
        System.out.println(split1);
        String[] split2 = words.split("\\s");
        System.out.println(split2);

        //StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("1");//append string
        sb.append('1');//append char, can also append char[]
        sb.append(1);//append int
        sb.setCharAt(0, '2');// takes a char here!!
        sb.deleteCharAt(1);
        char c = sb.charAt(0);
        sb.setLength(1);
        sb.insert(1, '1');
        sb.reverse();
        int l = sb.length();

        //HashMap
        Map<Integer, String> map = new HashMap<>();
        String oldValue = map.put(1, "1");//put returns old value if successful, otherwise return null if no such key
        oldValue = map.put(1, "2");
        String getOrDefault = map.getOrDefault(1, "0");

        //Arrays
        int[] arr = {1,2,3};
        Arrays.fill(arr, 0);
        Arrays.toString(arr);//print array string representation
        List<Integer> asList = Arrays.asList(new Integer[]{1,2,3});//immutable fixed-size list, https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/

        //List
        List<Integer> lis = new ArrayList();
        lis.add(2);
        lis.add(0, 1);
        lis.set(1, 2);
        lis.remove(0);
        Integer[] lisToArray = lis.toArray(new Integer[0]);//primitive types won't work here, only reference types, https://stackoverflow.com/questions/9572795/convert-list-to-array-in-java

        //String
        String str = "ABCD";
        str.toLowerCase();
        str.equals("str");//Compare String equality!!
        String.valueOf(new char[]{'a'});//convert char[] to string
        //startsWith, substring(i,j), substring(index) returns the substring til the end

        //Character
        char ch = 'A';
        Character.toLowerCase(ch);
        Character.isLetterOrDigit(ch);//check if alphanumeric
        Character.isDigit(ch);


        //test heap
        double target = 3.7;
        //Integer[] arr = {4, 2, 1, 3, 5};
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> Math.abs(o1 - target) > Math.abs(o2 - target) ? -1 : 1);
        for(Integer each : arr){
            heap.add(each);
            if (heap.size() > 2)//keep 2 elements
                heap.remove();
        }
        System.out.println("heap add done");

        //priority queue syntax
        //min heap
        Queue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> pq2 = new PriorityQueue<>((i1, i2) -> i1 - i2);//might cause overflow problem
        Queue<Integer> pq3 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(02);
            }
        });
        Queue<Integer> pq4 = new PriorityQueue<>((i1, i2) -> i1.compareTo(i2) );
        //max heap
        Queue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> maxPQ2 = new PriorityQueue<>((i1, i2) -> i2 - i1);//might cause overflow problem
        Queue<Integer> maxPQ3 = new PriorityQueue<>((i1, i2) -> i2.compareTo(i1) );
    }
}
