//package EASY;
///*
//Implement strStr().
//
//Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//Example 1:
//
//Input: haystack = "hello", needle = "ll"
//Output: 2
//Example 2:
//
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1
//Clarification:
//
//What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//For the purpose of this problem, we will return 0 when needle is an empty string.
//
//This is consistent to C's strstr() and Java's indexOf().
// */
//
//public class $28_Implement_strStr {
//
//    public int strStr(String haystack, String needle) {
//
//        if(haystack.length() == 0 && needle.length() == 0) return 0;
//
//        if(needle.length() > haystack.length()) return -1;
//
//        if(haystack.length() == 0) return -1;
//
//        if(needle.length() == 0) return 0;
//
//        for (int i = 0; i < haystack.length(); i++) {
//
//            if(haystack.charAt(i) == needle.charAt(0)){
//
//                for (int j = 1, x = j; j < needle.length(); j++) {
//                    if(haystack.charAt(i+x))
//                    if(needle.charAt(j) != haystack.charAt(i+x)){
//                        break;
//                    }
//                }
//
//                return i;
//            }
//        }
//
//        return -1;
//
//    }
//}
