import java.util.Arrays;
import java.util.List;

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

    }
}
