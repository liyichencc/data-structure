package stack;

/**
 * @Description
 * @Author v_liyichen
 * @date 2020.09.04 16:27
 */
public class StackDemo {

    public static void main(String[] args) {

        MyStack stack = new MyStack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.show();

        stack.pop();
        stack.show();
        stack.pop();stack.pop();stack.pop();

        stack.show();
    }

}

class MyStack {

    private int[] stackArray;

    private int top = -1;

    public MyStack(int n) {
        this.stackArray = new int[n];
    }

    public boolean push(int data) {

        if (top == stackArray.length - 1) {
            System.out.println("满栈");
            return false;
        }
        stackArray[++top] = data;
        return true;
    }

    public int pop() {

        if (top <= -1) {
            throw new RuntimeException("error.the stack maybe null");
        }

        return stackArray[top--];
    }

    public void show() {

        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }
}


