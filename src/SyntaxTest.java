import java.util.Arrays;
import java.util.List;
import java.util.*;

public class SyntaxTest {

    public static void main(String [] args){

        String[] array = {"a","b"};
        String string = "hello";
        int primitiveInt = 9;
        Integer integer = 8;

        /*
        Arrays.asList
        */
//        System.out.println(Arrays.asList(array));
//        System.out.println(Arrays.asList("a","b"));

        //String valueOf

        /*
        Integer
        */
//        System.out.println(Integer.valueOf(primitiveInt));
//        System.out.println(Integer.valueOf(string));//could throw NumberFormatException
//        System.out.println(integer.intValue());

        /*
        String split
         */
        String words = "dog cat cat dog";
        System.out.println(words.split(" "));

        //test heap
        double target = 3.7;
        Integer[] arr = {4, 2, 1, 3, 5};
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> Math.abs(o1 - target) > Math.abs(o2 - target) ? -1 : 1);
        for(Integer each : arr){
            heap.add(each);
            if (heap.size() > 2)//keep 2 elements
                heap.remove();
        }
        System.out.println("heap add done");
    }
}
