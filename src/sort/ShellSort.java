package sort;

import java.util.Arrays;

/**
 * @Description
 * @Author v_liyichen
 * @date 2020.10.27 15:53
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] arrays = new int[]{9,8,7,6,5,4,3,2,1};
        shellSort(arrays);
    }

    public static void shellSort(int[] arrays) {
        // arrays = {24,46,46,35,57,35,67,57,67,464}

        // arrays = {24,46,57,35,57,35,67,46,67,464}
        //           0  1  2  3  4  5  6  7  8  9
        for (int gap = arrays.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arrays.length; i++) {

                for (int j = i - gap; j >= 0; j -= gap) {

                    if (arrays[j] > arrays[j + gap]) {

                        int temp = arrays[j];

                        arrays[j] = arrays[j + gap];

                        arrays[j + gap] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arrays));
        }
        /**
         *  gap = arrays.length / 2 = 5;
         */
        // arrays = [24,46,46]

    }
}
