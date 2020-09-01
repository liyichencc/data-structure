/**
 * @Description
 * @Author v_liyichen
 * @date 2020.09.01 11:25
 */
public class TwoWayLikedListDemo {

    private TwoWayDataNode headNode = new TwoWayDataNode(0);


    public boolean add(TwoWayDataNode node) {

        if (headNode.next == null) {
            node.pre = headNode;
            headNode.next = node;
            return true;
        }

        TwoWayDataNode temp = headNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        node.pre = temp;

        temp.next = node;
        return true;
    }

    public boolean addByOrder(TwoWayDataNode node) {

        if (headNode.next == null) {
            node.pre = headNode;
            headNode.next = node;
            return true;
        }
            TwoWayDataNode temp = headNode;
            boolean flag = false;
            while (temp.next != null) {
                if (temp.next.val > node.val) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (temp.next != null) {
                node.next = temp.next;
            }
             temp.next = node;
            node.pre = temp;
        return flag;

    }
    public boolean update(TwoWayDataNode node,TwoWayDataNode newNode) {

        if (headNode.next == null) {
            return false;
        }

        TwoWayDataNode temp = headNode.next;
        while (temp != null) {
            if (temp.val == node.val) {
               temp.pre.next = newNode;
                newNode.next = temp.next;
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public boolean del(TwoWayDataNode node) {

        if (headNode.next == null) {
            return false;
        }

        TwoWayDataNode temp = headNode.next;

        while (temp != null) {
            if (temp.val == node.val) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }

                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void printDataNode() {
        TwoWayDataNode temp = headNode;

        if (temp.next == null) {
            System.out.println("空链");
            return;
        }

        while (true) {

            if (temp.next == null) {
                break;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }

    }

}

class TwoWayDataNode {

    int val;

    TwoWayDataNode pre;

    TwoWayDataNode next;

    @Override
    public String toString() {
        return "TwoWayDataNode{" +
                "val=" + val +
                '}';
    }

    public TwoWayDataNode(int val) {
        this.val = val;
    }
}

class Test {
    public static void main(String[] args) {
        TwoWayLikedListDemo list = new TwoWayLikedListDemo();

        list.printDataNode();

        TwoWayDataNode node1 = new TwoWayDataNode(1);
        TwoWayDataNode node2 = new TwoWayDataNode(2);
        TwoWayDataNode node3 = new TwoWayDataNode(3);


        TwoWayDataNode node4 = new TwoWayDataNode(4);

        list.addByOrder(node2);
        list.addByOrder(node1);
        list.addByOrder(node3);
        list.printDataNode();
        System.out.println("-----------");

        list.printDataNode();
        System.out.println("-----------");
        list.update(node1,node4);
        System.out.println("-----------");
        list.printDataNode();
    }
}