package recursion;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 八皇后问题，用递归回溯求解，效率较低。
 *
 * 8个皇后，需要不在同一行、同一列、同一斜线上。
 * @Description
 * @Author v_liyichen
 * @date 2020.09.14 10:39
 */
public class Queeen8 {

    int max = 8;

    int[] array = new int[max];

    public static void main(String[] args) throws ParseException {
//        Queeen8 q = new Queeen8();
//        q.putQueen(0);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long start = sdf.parse("1970-01-01 08:00:00").getTime();
        System.out.println(start);
    }
    public void putQueen(int n) {

        if (n == max) {
            print();
            return;
        }

        for (int i = 0; i < max; i++ ) {

            array[n] = i;

            if (judge(n)) {
                putQueen(n + 1);
            }
        }
    }

    private boolean judge(int n) {

        for (int i = 0; i < n; i ++) {

            if (array[n] == array[i]
                || (Math.abs(n - i) ==  Math.abs(array[n] - array[i]))) {
                return false;
            }
        }
        return true;
    }

    private void print() {

        for (int i = 0; i <  max; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("");
    }

}
