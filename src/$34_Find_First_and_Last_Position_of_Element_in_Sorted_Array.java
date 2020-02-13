public class $34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/14734/Easy-java-O(logn)-solution
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private static int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private static int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    public static void main(String [] args){

        int[] arr = {5,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,10};
        System.out.println(searchRange(arr, 8));
    }
}
