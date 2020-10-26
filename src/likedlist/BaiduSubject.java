package likedlist;

import java.util.Stack;

/**
 *  百度面试题
 *
 *  倒叙输出原链表，不改变原链表的结构
 *
 * 1.可逆序后再输出，但此方式会破坏原数据结构的数据
 * 2.可以利用栈元素，先入后出的特点。（采用）
 */
public class BaiduSubject {

    private BaiduDataNode headNode = new BaiduDataNode(0);


    public BaiduDataNode reversal() {

        if (headNode.next == null) {
            return headNode;
        }

        Stack<BaiduDataNode> stack = new Stack<>();

        BaiduDataNode temp = headNode.next;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        BaiduDataNode baiduDataNode
                = new BaiduDataNode(0);

        BaiduDataNode temp2
                = baiduDataNode;
        while (stack.size() > 0) {
            while (temp2.next != null) {temp2 = temp2.next;}
            temp2.next = stack.pop();
        }
        return baiduDataNode.next;
    }

    public boolean addDataByOrder(BaiduDataNode dataNode) {

        BaiduDataNode temp =  this.headNode;

        while (true) {

            if (temp.next == null) {
                break;
            }

            if (temp.next.no > dataNode.no) {
                break;
            }
            temp = temp.next;
        }

        dataNode.next = temp.next;
        temp.next = dataNode;
        return true;
    }
    /**
     *  测试一下
     * @param args
     */
    public static void main(String[] args) {
        BaiduSubject baiduSubject
                = new BaiduSubject();
        
        BaiduDataNode baiduDataNode1
                = new BaiduDataNode(1);

        BaiduDataNode baiduDataNode2
                = new BaiduDataNode(2);
        baiduSubject.addDataByOrder(baiduDataNode1);
        baiduSubject.addDataByOrder(baiduDataNode2);
        BaiduDataNode reversal = baiduSubject.reversal();
        System.out.println(reversal);
    }
}

class BaiduDataNode {

     int no;

     BaiduDataNode next;

    @Override
    public String toString() {
        return "BaiduDataNode{" +
                "no=" + no +
                '}';
    }

    public BaiduDataNode(int no) {
        this.no = no;
    }
}
