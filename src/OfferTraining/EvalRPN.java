package OfferTraining;

import java.util.Stack;

/**
 * @auther Alessio
 * @date 2022/2/12
 **/
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            if (s != "+" && s != "-" && s != "*" && s != "/") {
                st.push(Integer.valueOf(s));
            } else {
                int b = st.pop();
                int a = st.pop();
                st.push(cal(s, a, b));
            }
        }

        return st.pop();
    }

    private int cal(String op, int a, int b) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }


}
