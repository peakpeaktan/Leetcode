package EASY;

public class $374_Guess_Number_Higher_or_Lower {

    public int guessNumber(int n) {

        int i = 1, j = n;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if(guess(mid) == 0) {
                return mid;
            } else if(guess(mid) == 1) {
                i = mid + 1;
            } else {
                j = mid-1;
            }
        }
        return i;

        //another way of doing binary search
//        int i = 1, j = n;
//        while(i < j) {
//            int mid = i + (j - i) / 2;
//            if(guess(mid) == 0) {
//                return mid;
//            } else if(guess(mid) == 1) {
//                i = mid + 1;
//            } else {
//                j = mid;
//            }
//        }
//        return i;
    }

    public int guess(int num){
        return 1;
    }
}
