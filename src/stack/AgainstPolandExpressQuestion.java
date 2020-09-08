package stack;

import java.util.Stack;

/**
 * @Description
 * @Author v_liyichen
 * @date 2020.09.08 14:15
 */
public class AgainstPolandExpressQuestion {


    public static void main(String[] args) {
        AgainstPolandExpressQuestion s = new AgainstPolandExpressQuestion();
        int result = s.getResult("34+5*6-");
        System.out.println(result);
    }


    /**
     *  逆波兰表达式：
     *      给定一个逆波兰表达式，从左至右开始遍历
     *      如果遇到数字则入数字栈，
     *      如果遇到操作符则弹出数字栈的次栈顶元素和栈顶元素做运算，并将结果入数字栈
     *      最后数字栈的栈顶即为结果
     *
     *  tips： 我们假定所给的波兰表达式都是不为空且起码满足一个计算式的
     * @param againstPolandExpress
     * @return
     */
    public int getResult(String againstPolandExpress) {

        char[] chars
                = againstPolandExpress.toCharArray();

        Stack<Integer> numberStack = new Stack<>();

        for (int i = 0; i < chars.length;i++) {

            if (isNumber(chars[i])) {

                numberStack.push(chars[i] - 48);
            } else {
                numberStack.push(calculat(numberStack.pop(),numberStack.pop(),chars[i]));
            }
        }

        return numberStack.pop();
    }

    private Integer calculat(Integer pop, Integer pop1, char aChar) {

        switch (aChar) {
            case  '+':
                return pop1 + pop;
            case '-':
                return pop1 - pop;

            case '*':
                return pop1 * pop;
            case '/':
                return pop1 / pop;
                default:
                    break;
        }
        return 0;
    }

    private boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }
}
