import javax.xml.crypto.Data;

/**
 * @Description
 * @Author v_liyichen
 * @date 2020.08.31 15:24
 */
public class LinkedListDemo {


    public static void main(String[] args) {

        DataNode d1 = new DataNode(1,"01");
        DataNode d2 = new DataNode(2,"02");
        DataNode d2_1 = new DataNode(2,"02");
        DataNode d3 = new DataNode(3,"03");
        DataNode d4 = new DataNode(4,"04");
        DataNode d5 = new DataNode(5,"05");


        SigleLikedList list = new SigleLikedList();
        list.addDataByOrder(d2);
        list.addDataByOrder(d1);
        list.addDataByOrder(d3);

        list.addDataByOrder(d2_1);
        list.addDataByOrder(d5);
        list.addDataByOrder(d4);
        list.printDataNode();
        DataNode d99 = new DataNode(99,"99");
        list.update(5,d99);
        System.out.println("-----------");
        list.printDataNode();

        System.out.println("-------");

        list.delete(03);
        list.printDataNode();

        System.out.println(list.getLastIndexData(1,list.getDataNode()));
    }
}

class SigleLikedList {

    // 需要一个头结点
    DataNode dataNode = new DataNode(0,null);

    public boolean addData(DataNode dataNode) {

        DataNode temp = this.dataNode;

        while (true) {
            if (temp.next == null ) {
                break;
            }
            temp = temp.next;
        }
        temp.next = dataNode;
        return true;
    }
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

        DataNode temp = this.dataNode;

        int len = 0;
        while (true) {
            if (temp.next == null) {
                return len;
            }
            len++;
            temp = temp.next;
        }
    }
    public boolean addDataByOrder(DataNode dataNode) {

       DataNode temp =  this.dataNode;

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

    public boolean delete(int no) {
        DataNode temp = this.dataNode;

        if (temp.next == null) {
            System.out.println("空链");
            return false;
        }
        while (true) {
            if (temp.next == null) {break;}
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public boolean update(int no,DataNode newNode) {

        DataNode temp = this.dataNode;

        if (temp.next == null) {
            System.out.println("空链");
            return false;
        }
        boolean isUpdated;
        while (true) {

            if (temp.next.no == no) {
                isUpdated = true;
                break;
            }

            temp = temp.next;
        }

        if (isUpdated) {
            temp.next = newNode;
        }
        return isUpdated;
    }
    public void printDataNode() {
        DataNode temp = dataNode;

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

    public DataNode getDataNode() {
        return dataNode;
    }
}

class DataNode {

     int no;

     String name;

     DataNode next;

    public DataNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    @Override
    public String toString() {
        return "DataNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
