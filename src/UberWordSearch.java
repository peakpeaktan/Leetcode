//public class Solution {
//        public static void main(String[] args) {
//            char[][] exampleMatrix = {{'A',  'U',  'I',  'K',  'F',  'W',  'N'},
//                    {'W',  'Q',  'B' , 'O',  'L', 'X',  'P'},
//                    {'T', 'L', 'A', 'E', 'R', 'E', 'S'},
//                    {'Y', 'Z', 'X', 'E', 'R', 'L', 'W'}
//            };
//            System.out.println(search(exampleMatrix, "UBER"));
//        }
//
//        public static boolean search(char[][] matrix, String word){
//            if(matrix.length == 0 || word == null || word.length() == 0){
//                return false;
//            }
//            for(int i = 0; i< matrix.length; i++){
//                for(int j = 0; j < matrix[0].length; j++){
//                    if(search(i, j, matrix, 0, word, true, false, false, false, false, false, false, false)){
//                        return true;
//                    }
//                    if(search(i, j, matrix, 0, word, false, true, false, false, false, false, false, false)){
//                        return true;
//                    }
//                    if(search(i, j, matrix, 0, word, false, false, true, false, false, false, false, false)){
//                        return true;
//                    }
//                    if(search(i, j, matrix, 0, word, false, false, false, true, false, false, false, false)){
//                        return true;
//                    }
//                    if(search(i, j, matrix, 0, word, false, false, false, false, true, false, false, false)){
//                        return true;
//                    }
//                    if(search(i, j, matrix, 0, word, false, false, false, false, false, true, false, false)){
//                        return true;
//                    }
//                    if(search(i, j, matrix, 0, word, false, false, false, false, false, false, true, false)){
//                        return true;
//                    }
//                    if(search(i, j, matrix, 0, word, false, false, false, false, false, false, false, true)){
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }
//
//        public static boolean search(int row, int column, char[][] matrix, int index, String word, boolean right, boolean left, boolean up, boolean down, boolean upperRight, boolean upperLeft, boolean lowerLeft, boolean lowerRight) {
//            if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[0].length) {
//                return false;
//            }
//            if (matrix[row][column] != word.charAt(index)) {
//                return false;
//            }
//            if (index == word.length() - 1) {
//                return true;
//            }
//            if (right) {
//                return search(row, column + 1, matrix, index + 1, word, true, false, false, false, false, false, false, false);
//            }
//            if (left) {
//                return search(row, column - 1, matrix, index + 1, word, false, true, false, false, false, false, false, false);
//            }
//            if (up) {
//                return search(row - 1, column , matrix, index + 1, word, false, false, true, false, false, false, false, false);
//            }
//            if (down) {
//                return search(row + 1, column, matrix, index + 1, word, false, false, false, true, false, false, false, false);
//            }
//            if (upperRight) {
//                return search(row - 1, column + 1, matrix, index + 1, word, false, false, false, false, true, false, false, false);
//            }
//            if (upperLeft) {
//                return search(row - 1, column - 1, matrix, index + 1, word, false, false, false, false, false, true, false, false);
//            }
//            if (lowerLeft) {
//                return search(row + 1, column - 1, matrix, index + 1, word, false, false, false, false, false, false, true, false);
//            }
//            if (lowerRight) {
//                return search(row + 1, column + 1, matrix, index + 1, word, false, false, false, false, false, false, false, true);
//            }
//            return false;
//        }
//}
