package stack;

/**
 * @Description 用栈实现计算器，暂不可多位数计算，不可小括号。
 * @Author v_liyichen
 * @date 2020.09.07 15:00
 */
public class CalculationQuestion {

    public static void main(String[] args) {
        CalculationQuestion s = new CalculationQuestion();
        int calculation = s.calculation("6*2*3/9");
        System.out.println(calculation);
    }

    public int calculation(String str) {

        if (str == null || str.trim().length() < 0) {
            return 0;
        }

        MyStack numberStack = new MyStack(str.length());
        MyStack operStack = new MyStack(str.length());

        char[] strChar = str.toCharArray();

        for (int i = 0; i < strChar.length; i++) {
            checkCurrentIndex(strChar[i],numberStack,operStack);
        }

        /**
         *  当所有都遍历完成以后，我们把数字栈的所有元素依次取出计算即可
         */

        while (true) {

            if (operStack.isEmpty()) {
                break;
            }

            int n1= numberStack.pop();
            int n2 = numberStack.pop();

            int oper = operStack.pop();

            numberStack.push(calculation(n1,n2,(char)oper));
        }
        return numberStack.pop();
    }

    private int getPriority(char c) {

        if (c == '*' || c == '/') {
            return 1;
        } else if (c == '+' || c == '-') {
            return 0;
        } else {
            return -1;
        }

    }

    private int calculation(int num1,int num2,char oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
                default:
                    return 0;
        }
    }

    /**
     *  如果当前值是数字，则直接如数字栈
     *  如果当前值是符号，
     *  则判断符号栈内是否为空？
     *    若为空则直接入栈
     *
     *    若不为空则需要从符号栈内取出一个元素
     *      若当前元素的优先级小于等于栈顶元素的优先级，则需要从数字栈内弹出2位，符号栈内弹出1位，先进行计算，再把当前的符号如符号栈
     *      若当前元素的优先级大于栈顶元素的优先级，则直接入栈。
     * @param c
     * @param numberStack
     * @param operStack
     */
    private void checkCurrentIndex(char c, MyStack numberStack, MyStack operStack) {

        if (c >= '0' && c <= '9') {
            numberStack.push(c - 48); // 这里是'0'不是0
        } else {
            // 先检查符号栈的元素是否为空？
            if (operStack.isEmpty()) {
                // 为空则直接入栈,入栈是入当前元素的优先级
                operStack.push(c);
            } else {
                // 栈不为空的情况下，需要从看当前的符号和栈顶的优先级
                // 若优先级小，则需要先计算
                if (getPriority(c) <= getPriority((char)operStack.peek())) {
                    // 此时需要计算
                    int number1 = numberStack.pop();
                    int number2 = numberStack.pop();

                    int pop = operStack.pop();

                    int calculation
                            = calculation(number1, number2, (char) pop);
                    // 结果入数字栈
                    numberStack.push(calculation);

                    // 别忘了符号栈还需要把当前的符号存入符号栈

                    operStack.push(c);

                } else {
                    // 优先级大则直接入符号栈
                    operStack.push(c);
                }
            }
        }
        
    }


}


