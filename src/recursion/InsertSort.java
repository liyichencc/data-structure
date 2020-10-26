package recursion;

/**
 * @Description
 * @Author v_liyichen
 * @date 2020.10.13 10:56
 */
public class InsertSort {


    public void insertSort(int[] ins) {

        // 4,6,8,1,5,7
        for (int i = 1; i < ins.length; i++) {

            int temp = ins[i];
            int j;
            for (j = i; j > 0 && ins[j] > temp; j --) {
                ins[j] = ins[j - 1];
            }

            ins[j] = temp;
        }
    }
}
