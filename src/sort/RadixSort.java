package sort;

/**
 *
 *  基数排序的核心思想是，构建一个二维数组（作为0-9的桶）
 *
 *  把要排序的数组逐个遍历，先获取个位数，根据个位数依次放入各个桶内。个位为1就放入1号桶
 *  再十位、百位...
 *  最后把各个桶内的数字一次放入原数组即可。
 *
 *  需要注意的是
 *  1.我们需要先获取到数组内最大的数是多少位。
 *  2.如果想要获取个位、十位、百位的话需要/对应的值，比如个位是1，十位是10... 再%10
 *  3.如果数组里有负数的情况，我们需要找到最小的负数，把数组内所有的数都 +上这个数，让所有数都变成>=0的数，再通过基数排序排完后再对所有数减掉这个+上的数
 *
 *  可以看出来基数排序是很明显的在用空间换区时间的一个排序算法，也是稳定的。
 * @Description
 * @Author v_liyichen
 * @date 2020.11.03 18:52
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = {53,-3,542,-748,-14,214};
        new RadixSort().radixSort(array);
    }
    public void radixSort(int[] array) {
        int length = getMaxNumber(array);

        for (int m = 0,l = 1; m < String.valueOf(length).length(); m++,l*=10) {


        // 设置桶
        int[][] bocket = new int[10][array.length];

        // 记录每个桶内有多少元素

        int[] countArray = new int[10];

        for (int i = 0; i < array.length; i++) {

            int index = array[i] / l % 10;

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

           countArray[i] = 0;
       }
        }

        for (int i : array) {
            System.out.println(i);
        }


    }


    public int getMaxNumber(int[] array) {

        int maxNum = array[0];
        for (int i : array) {
            if (i > maxNum) {
                maxNum = i;
            }
        }

        return maxNum;
    }
}
