import java.util.Stack;

public class RemovingOuterParentheses {
    /*

A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.



Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: s = "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".


Constraints:

1 <= s.length <= 105
s[i] is either '(' or ')'.
s is a valid parentheses string.


     */

    public static void main(String[] args) {

        System.out.println(removeOuterParentheses("()()"));//""
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));//"()()()()(())"
        System.out.println(removeOuterParentheses("(()())(())"));//"()()()"
    }
    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder(s);

        int index = 0;
        Stack<Character> parn = new Stack<>();
        parn.push(result.charAt(index));
        result.deleteCharAt(0);
        while (index < result.length()){
            if (result.charAt(index) == ')'){
                parn.pop();
                if (parn.empty()){
                    result.deleteCharAt(index);
                    index--;
                }
            } else {
                parn.push(s.charAt(index));
                if (parn.size()==1){
                    result.deleteCharAt(index);
                    index--;
                }
            }
            index++;
        }


        return result.toString();
    }
}
