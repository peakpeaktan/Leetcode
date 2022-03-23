import java.util.HashMap;

/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
Example 4:

Input: fruits = [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can pick from trees [1,2,1,1,2].


Constraints:

1 <= fruits.length <= 105
0 <= fruits[i] < fruits.length
 */

//label_hashmap
//label_string
//label_twopointers
//similar: 159, 340, 3
public class $904_Fruit_Into_Baskets {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < fruits.length ; i++) {
            map.put(fruits[i], i);
            if(map.size() > 2){
                int leftmost = Integer.MAX_VALUE;
                for(int each : map.values()){
                    leftmost = Math.min(leftmost, each);
                }
                map.remove(fruits[i]);
                index = leftmost + 1;
            }
            result = Math.max(result, i - index + 1);
        }
        return result;
    }
}
