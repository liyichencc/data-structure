package sort;

public class QuickSort {

    public static void main(String[] args) {

         int[] arrays = {26,5,89,11,4,9,6};

        quickSort(arrays,0,arrays.length - 1);

        for (int i : arrays) {
            System.out.println(i);
        }


    }

    public static void quickSort(int[] array,int left,int right) {


        if (left > right) {
            return;
        }

        int l = left;

        int r = right;

        int key = array[left];

        while ( l < r) {

            while (array[r] >= key && l < r) {
                r--;
            }

            while (array[l] <= key && l < r) {
                l++;
            }

            if (l < r) {
                int temp = array[l];

                array[l] = array[r];

                array[r] = temp;
            }
        }

        array[left] = array[l];
        array[l] = key;

        // 交换完成后就变成了两部分。 基数左边的 也就是 left - r-1 和 基数右边的 也就是 r+1 - right
        quickSort(array,left,l - 1);
        quickSort(array,l + 1,right );
    }

}
