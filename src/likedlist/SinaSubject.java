package likedlist;


/**
 *  新浪面试题，求倒数index位置的元素
 */
public class SinaSubject {

    public DataNode getLastIndexData(int index,DataNode dataNode) {


        if (dataNode.next == null) {
            return null;
        }

        int length = getLength(dataNode);

        if (index <= 0 || index > length) {
            return null; // error param
        }

        DataNode temp = dataNode;
        for (int i = 0; i <= length - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int getLength(DataNode dataNode) {

        if (dataNode.next == null) {
            return 0;
        }

        DataNode temp = dataNode;

        int len = 0;
        while (true) {
            if (temp.next == null) {
                return len;
            }
            len++;
            temp = temp.next;
        }
    }
}
