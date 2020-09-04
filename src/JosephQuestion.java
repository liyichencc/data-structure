/**
 *
 * 约瑟夫问题
 * @Description
 * @Author v_liyichen
 * @date 2020.09.02 10:39
 */
public class JosephQuestion {

    private JosephRing first = null;

    public JosephRing createJosephRing(int n) {

        if (n < 1) {
            System.out.println("不可构建");
        }

        JosephRing temp = null;
        for(int i = 1; i <= n; i++) {
            if (i == 1) {
                first = new JosephRing(1);
                first.setNext(first);
                temp = first;
            } else {
                JosephRing josephRing = new JosephRing(i);
                josephRing.next =  temp.next;
                temp.next = josephRing;
            }
            temp = temp.next;
        }
        return first;
    }

    /**
     *  1. 先让helper指向first的后一个节点，help.next == first 退出循环
     *  2. 让first 和 helper 均指向start - 1 位置
     *  3. 循环出圈，当first == helper时才能退出。
     *      出圈 first = first.next
     *           help.next = first
     * @param start 从第几位开始
     * @param num 一次数多少个
     * @param count 一共有多少位
     */
    public void outCircle(int start,int num,int count) {

        if (start < 1 || num < 1 || count < num) {
            System.out.println("参数不正确");
            return;
        }

        JosephRing helper = first;

        while (true) {

            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }

        for(int j = 0; j < start - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true) {

            if (helper == first) {
                break;
            }

            for (int i = 0; i < num - 1; i++) {
                helper = helper.next;
                first = first.next;
            }
            System.out.printf("小孩%d出圈",first.getNo());

            first = first.next;
            helper.next = first;
        }

        System.out.printf("最后剩余的小孩是%d",first.getNo());
    }

    public static void main(String[] args) {
        JosephQuestion j = new JosephQuestion();
        JosephRing josephRing = j.createJosephRing(5);
        System.out.println(josephRing);

        j.outCircle(1,2,5);
    }
}

class JosephRing {

     int no;

    JosephRing next;

    public JosephRing(int no) {
        this.no = no;
    }

    public JosephRing getNext() {
        return next;
    }

    public int getNo() {
        return no;
    }

    public void setNext(JosephRing next) {
        this.next = next;
    }
}
