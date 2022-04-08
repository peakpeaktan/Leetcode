import java.util.*;
/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
A solution is:
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 */

//label_string
public class $249_Group_Shifted_Strings {
    //https://www.youtube.com/watch?v=Im-isYiYqDk
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String each : strings){
            int offset = each.charAt(0) - 'a';
            char[] charArray = each.toCharArray();
            charArray[0] = 'a';
            for (int i = 1; i < each.length(); i++) {
                char character = (char)(charArray[i] - offset);
                if(character < 'a'){
                    character = (char)(character + 26);
                }
                charArray[i] = character;
            }
            String str = new String(charArray);
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<String>());
            }
            map.get(str).add(each);
        }
        for (List<String> value : map.values()){
            result.add(value);
        }
        return result;
    }

    public static void main(String[] args){
        groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
    }
}
