package queue;

import java.util.Random;
import java.util.Scanner;

/**
 * 用数组模拟的队列
 */
public class ArrayQueue {

    // 队列大小
    private int maxSize = 5;
    // 队头
    private int front = -1;
    // 队尾
    private int rear = -1;
    // 存放数据的队列
    private int[] arrayQueue;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arrayQueue = new int[maxSize];
    }

    public static void main(String[] args) {

        System.out.println("please enter key");

        ArrayQueue queue = new ArrayQueue();

        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();

        switch (i) {
            case 1:
                queue.addData(new Random().nextInt());
                break;
            case 2:
                queue.getData();
                break;
            case 3:
                queue.printQueue();
                break;
            default:
                break;

        }
    }

    public ArrayQueue() {
        this.arrayQueue = new int[maxSize];
    }

    /**
     * 入队操作
     *
     * @param data 数据项
     * @return 入队是否成功
     */
    public boolean addData(int data) {

//        // 判断是否满队
//        if (this.real == this.maxSize - 1
//                && this.front == -1
//        || this.real - 1 == this.front) {
//            System.out.println("---队列已满，无法添加稍后再试!---");
//            return false;
//        }
//        // 队尾指针已满但是队列却没有满，说明队头还有空位置，插入队头
//        if (real == this.maxSize - 1) {
//            real = 0; // 循环队列
//        }
//        real ++;
//        arrayQueue[real] = data;

        // 判断队列是否已满，

        if (isFull()) {
            return false;
        }
        arrayQueue[rear] = data;
//        rear++; 不可直接添加元素，循环队列情况

        // 该结果在[0 - maxsize-1]内
        rear = rear + 1 % maxSize;
        return true;
    }

    /**
     * <p>
     * 如何鉴于一个队列为满队
     * 队头元素和队尾元素重合时
     * <p>
     * 及情况分为两种：
     * case1 ： 队尾元素在队头元素的后面此时队列已满的情况为：rear + 1 == maxsize
     * case2 :  队尾元素在队头元素的前面,此时rear + 1 == front即为满队
     * <p>
     * 考虑到循环队列的情况，采取mod运算
     * 情况结合即为rear + 1 % maxsize == front
     *
     * @return 是否满队
     */
    private boolean isFull() {
        return rear + 1 % maxSize == front;
    }

    // rear - front + maxsize % maxsize

    /**
     * 出队操作
     * TODO -1 是否有局限性？
     *
     * @return 出队数据 -1为未查询到的数据
     */
    public int getData() {

//        if (this.real == this.front) {
//            System.out.println("---队列已空，无法出队稍后再试!---");
//            return -1;
//        }
//        if (front == this.maxSize - 1) {
//            front = 0; // 循环队列
//        }
//        front ++;
//        int result =  arrayQueue[front];
//
//        return result;

        // 队列
        if (isEmpty()) {
            return -1;
        }
        int result = arrayQueue[front];
        front = front + 1 % maxSize;

        return result;
    }

    /**
     * 判断空队情况是队头队尾重合时
     * <p>
     * 因为我们浪费的一个空间，所以只有队头队尾重合时才是空队情况。
     * 如果不用不用额外空间的则无法判断是否满队或空队
     *
     * @return
     */
    private boolean isEmpty() {
        return rear == front;
    }

    /**
     * 输出队列所包含的元素
     * 关键在于求得队列内所有元素的个数
     *
     * @see
     */
    public void printQueue() {

        if (!isFull()) {
            for (int i = front; i < front + quereSize(); i++) {
                // 这里需要注意取值
                System.out.print(arrayQueue[i % maxSize]);
            }
        }
    }

    /**
     * 求队列个数
     * 这里也分两种情况
     * <p>
     * 即：
     * case1: rear在front之后，队列个数为 rear - front
     * case2: rear在front之前，此时队列被分为左右两端，左端为rear - 0 ;右端为 maxsize - front
     * <p>
     * 结合即为rear - front + maxsize % maxsize
     * https://blog.csdn.net/qq_41268977/article/details/106037445
     *
     * @return
     */
    private int quereSize() {
        return rear - front + maxSize % maxSize;
    }

}
