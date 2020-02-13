public class $31_Next_Permutation {

    //https://leetcode.com/problems/next-permutation/discuss/13872/Easiest-JAVA-Solution
    //awesome diagram for explanation: https://leetcode.com/problems/next-permutation/discuss/13994/Readable-code-without-confusing-ij-and-with-explanation
    public static void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) {
            i--; // Find 1st id i that breaks descending order
        }
        if(i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while(A[j] <= A[i]) {
                j--;           // Find rightmost first larger id j
            }
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }

    public static void main(String [] args){

        int[] arr = {1, 2, 5, 3, 3, 0};
        nextPermutation(arr);
        System.out.println(arr);
    }
}
