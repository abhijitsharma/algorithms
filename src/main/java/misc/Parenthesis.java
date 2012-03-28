package misc;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class Parenthesis {

    public boolean matchParenthesis(String s) {
        int n = 0;
        for(char c : s.toCharArray()) {
            if(c == '(')
                n++;
            if(c == ')')
                n--;
            if(n < 0) {
                return false;
            }
        }
        return n == 0;
    }

    //todo
    public boolean matchParenthesisStackBased(String s) {
        return true;
    }
}
