package sort;

/**
 * @Description
 * @Author v_liyichen
 * @date 2020.11.03 18:52
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = {53,3,542,748,14,214};
        new RadixSort().radixSort(array);
    }
    public void radixSort(int[] array) {

        // 设置桶
        int[][] bocket = new int[10][array.length];

        // 记录每个桶内有多少元素

        int[] countArray = new int[10];

        for (int i = 0; i < array.length; i++) {

            int index = array[i] % 10;

            bocket[ index ][ countArray[index]] = array[i];

            countArray[ index ]++;

        }

        int j = 0;
       for(int i = 0; i < countArray.length;i++) {

           if (countArray[i] > 0) {

               for (int k = 0; k < countArray[i];k++) {
                   array[j++] = bocket[i][k];
               }
           }
       }

       for (int i : array) {
           System.out.println(i);
       }
    }
}
