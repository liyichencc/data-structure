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


        String s1 = s.infix2suffix("1+((2+3)*4)-5");
        int result = s.getResult(s1);
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

    /**
     *  初始化两个栈，一个存放运算符，一个存放中间结果
     *
     *  从左至右开始遍历中缀表达式
     *
     *  如果遇到符号：
     *     1. 如果栈顶为空，则直接入栈
     *     2. 如果栈顶不为空，则判断栈顶的运算符优先级是否大于当前符号？
     *          2.1 若大于则直接入栈
     *          2.2 如果不大于则需要把当前符号栈栈顶元素移动到中间结果栈内，在从2判断一次。
     *  如果遇到数字：
     *      1.则直接入数字栈
     *  如果遇到括号:
     *      1.左括号直接入符号栈，
     *      2.右括号则弹出符号栈的元素，直到遇到左括号则讲这一对括号废除
     *
     * 重复遍历过程，直到遇到表达式的最右端，此时将符号栈的所有内容都入数字栈。
     * 依次弹出数字栈的所有元素即为后缀表达式。
     * @param infixExpress
     * @return
     */
    private String infix2suffix(String infixExpress) {

        char[] chars = infixExpress.toCharArray();

        Stack<Character> operStack = new Stack<>();

        Stack<Character> numberStack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            // 如果遇到数字则直接入数字栈
            if (isNumber(chars[i])) {
                numberStack.push(chars[i]);


            }
//            "1+((2+3)*4)-5");
            // 12
            // +((
            //   如果遇到括号:
            //           1.左括号直接入符号栈，
            //           2.右括号则弹出符号栈的元素，直到遇到左括号则讲这一对括号废除
            else if (isBrackets(chars[i])) {
                if (chars[i] == '(') {
                    operStack.push(chars[i]);
                } else {
                    while (!operStack.isEmpty()) {
                        Character pop = operStack.pop();
                        if (pop == '(') {
                            break;
                        }
                        numberStack.push(pop);
                    }
                }

            }
//            如果遇到符号：
//     *     1. 如果栈顶为空，则直接入栈
//                    *     2. 如果栈顶不为空，则判断栈顶的运算符优先级是否大于当前符号？
//     *          2.1 若大于则直接入栈
//                    *          2.2 如果不大于则需要把当前符号栈栈顶元素移动到中间结果栈内，在从2判断一次。
            else {

                if (operStack.isEmpty()) {
                    operStack.push(chars[i]);
                } else {
//                    "1+((2+3)*4)-5");
                    while(true) {
                        if (operStack.isEmpty()) {
                            operStack.push(chars[i]);
                            break;
                        }
                        Character pop = operStack.pop();
                        if (currentChartsHigherPriority(chars[i],pop)) {
                            operStack.push(pop);
                            operStack.push(chars[i]);
                            break;
                        } else {
                            numberStack.push(pop);
                        }
                    }
                }
            }
        }

        while (!operStack.isEmpty()) {
            numberStack.push(operStack.pop());
        }
        StringBuffer str = new StringBuffer();
        while (!numberStack.isEmpty()) {
            str.append(numberStack.pop());
        }
        return str.reverse().toString();
    }

    private boolean currentChartsHigherPriority(char aChar, Character pop) {
        return CalculationQuestion.getPriority(aChar)
                > CalculationQuestion.getPriority(pop)
                ? true
                : false;
    }

    private boolean isBrackets(char aChar) {
        return aChar == '(' || aChar == ')';
    }


}
