package recursion;

import java.util.Arrays;

/**
 * @Description
 * @Author v_liyichen
 * @date 2020.10.12 16:44
 */
public class SelectSort {

    public static void main(String[] args) {

        /**
         *  3,4,46,23,46,57; 第一趟3最小，3和4比较谁更下小？ 3，。。。。。
         *
         *  第一趟完成后 3,4,46,23,46,57
         *
         *  第二趟4最小。。。。。
         *  第三 46最小 23比46小记录，循环完后交换
         *
         */



        int arrays[] = {3,4,46,23,46,57};

        int temp;

         for (int i = 0; i < arrays.length - 1;i++) {

             int maxIndex = i;

             for (int j = i + 1; j < arrays.length;j++) {
                 if (arrays[j] > arrays[maxIndex]) {
                        maxIndex = j;
                 }
             }

             temp = arrays[i];

             arrays[i] = arrays[maxIndex];

             arrays[maxIndex] = temp;

         }

/**
 *
 *  var len = arr.length;
 *     var minIndex, temp;
 *     for (var i = 0; i < len - 1; i++) {
 *         minIndex = i;
 *         for (var j = i + 1; j < len; j++) {
 *             if (arr[j] < arr[minIndex]) {     // 寻找最小的数
 *                 minIndex = j;                 // 将最小数的索引保存
 *             }
 *         }
 *         temp = arr[i];
 *         arr[i] = arr[minIndex];
 *         arr[minIndex] = temp;
 *     }
 */
        for (int array : arrays) {
            System.out.println(array);
        }
    }
}
