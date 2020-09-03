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

    public static void main(String[] args) {
        JosephQuestion j = new JosephQuestion();
        JosephRing josephRing = j.createJosephRing(5);
        System.out.println(josephRing);
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

    public void setNext(JosephRing next) {
        this.next = next;
    }
}
