import java.util.*;
/*
Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.



Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: "/a/./b/../../c/"
Output: "/c"
Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"
Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
 */

//label_stack
public class $71_Simplify_Path {
    //nice explanation: https://www.youtube.com/watch?v=l-og2X5GibY
    //https://www.youtube.com/watch?v=SxuGQnlsXcw&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] array = path.split("/");
        for(String s: array){
            if(s.equals("..") ) {
                if(!stack.empty()){
                    stack.pop();
                }
            }
            else if(!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }
        String result = "";
        if(stack.size() == 0) return "/";
        while(!stack.empty()) {
            String popped = stack.pop();
            result = "/" + popped + result;
        }
        return result;
    }

    public static void main(String [] args){
        System.out.println(simplifyPath("/home//foo/")); // "/home/foo"
        System.out.println(simplifyPath("/a/./b/../../c/")); // "/c"
        System.out.println(simplifyPath("/a/../../b/../c//.//")); // "/c"
        System.out.println(simplifyPath("/a//b////c/d//././/..")); // "/a/b/c"
    }
}
