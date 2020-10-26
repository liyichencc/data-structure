package sort;

public class BubblingSort {


    public static void main(String[] args) {

        int[] arrays = new int[]{35,42,54,356,64};

        int temp ;

        boolean flag = false;
        /**
         *  需要特别解释一下这块的代码
         *      代码的 - 1 是说长度为n的数组最多只需要n-1次即可完成排序
         *      内层循环的 - i 是说 在一次次的排序过程中，最大的已经放在末尾了，不需要再遍历了，
         *          比如长度为5的，第一次只需要遍历4次即可把最大的放在最末尾
         *                      第二次只需要遍历3次
         *                      第三次只需要遍历2次
         *                      随着循环需要排序的数也就越来越少，所以循环在一次次的减少。
         */
        for (int i = 0 ; i < arrays.length - 1; i ++) {

            for (int j = 0; j < arrays.length - 1 - i; j++) {

                // 若当前值比其后的值大则交换
                if (arrays[j] > arrays[j + 1]) {
                    flag = true;
                    temp = arrays[j];

                    arrays[j] = arrays[j + 1];

                    arrays[j + 1] = temp;
                }

                if (!flag) {
                    break;
                } else {
                    flag = false; // 注意这块把变量的值该回去，再循环下次
                }
            }
        }
    }
}
