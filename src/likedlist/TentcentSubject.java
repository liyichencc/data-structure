package likedlist;


/**
 *  腾讯面试题，反转链表
 */
public class TentcentSubject {


    public DataNode reverter(DataNode dataNode) {

        if (dataNode.next == null || dataNode.next.next == null) {
            return dataNode;
        }

        DataNode newDataNode = new DataNode(0,null);

            DataNode current = dataNode.next;
            DataNode next;

            while (current != null) {
                next = current.next;
                current.next = newDataNode.next;
                newDataNode.next = current;
                current = next;
            }
            dataNode.next = newDataNode.next;

        return newDataNode;
    }

    public static void main(String[] args) {
        DataNode d1 = new DataNode(1,"01");
        DataNode d2 = new DataNode(2,"02");
        DataNode d3 = new DataNode(3,"03");

        SigleLikedList list = new SigleLikedList();

        list.addData(d1);
        list.addData(d2);
        list.addData(d3);
        TentcentSubject subject = new TentcentSubject();


        DataNode reverter = subject.reverter(list.dataNode);



    }
}
