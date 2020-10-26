package sort;

public class InsertSort {


    public static void main(String[] args) {

        int arrays[] = {134,2,35,35,46};

//        for (int i = 1; i < arrays.length; i++) {
//            int insertVal = arrays[i];
//
//            int insertIndex = i - 1;
//
//            // 满足寻址的值小于寻址值的前一位时，循环继续
//            // insertVal < arrays[insertIndex] 这个条件满足的时候说明还没有找到适当的位置，
//            // 当前的位置还要后移当前位置移到当前位置的后一位，让出当前位置，让寻址的数据到当前位置去，再去和当前位置的前一位进行比较
//
//            while (insertIndex >= 0 && insertVal < arrays[insertIndex]) {
//                arrays[insertIndex + 1] = arrays[insertIndex];
//                insertIndex --;
//            }
//            arrays[insertIndex + 1] = insertVal;
//        }
        insertSort(arrays);
        for (int i : arrays) {
            System.out.println(i);
        }
    }



    public static int[] insertSort(int[] arrays) {
//        int arrays[] = {134,2,35,35,46};
        for(int i = 1; i < arrays.length; i++) {

            int temp = arrays[i];

            int j;
            for (j = i; j > 0 && arrays[j - 1] > temp; j--) {
                arrays[j] = arrays[j - 1];
            }
            arrays[j] = temp;
        }

        return arrays;
    }
}
