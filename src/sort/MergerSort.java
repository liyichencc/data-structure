package sort;

/**
 * @Description
 * @Author v_liyichen
 * @date 2020.11.02 13:39
 */
public class MergerSort {

    public static void main(String[] args) {
        int[] array = {2,8,9,10,4,5,6,7};
        merger(array,0,array.length - 1,4);
    }
    public static void merger(int array[], int left, int right, int mid) {

        int[] leftArray = new int[mid - left];

        int[] rightArray = new int[right - mid + 1];

        for (int i = left; i < mid; i++) {
            leftArray[i - left] = array[i];
        }

        for (int i = mid; i <= right; i++) {
            rightArray[i - mid] = array[i];
        }
//
//        for (int i : leftArray) {
//            System.out.println(i);
//        }
//        System.out.println("-----------");
//        for (int i : rightArray) {
//            System.out.println(i);
//        }

        int i = 0; // 指向left数组第一个
        int j = 0; // 指向right数组第一个
        int k = left; // 指向array数组第一个


        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }

        }

       while (i < leftArray.length) {
           array[k++] = leftArray[i++];
       }

       while (j < rightArray.length) {
           array[k++] = rightArray[j++];
       }

       for (int s : array) {
           System.out.println(s);
       }

    }
}
