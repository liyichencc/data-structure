package array;

/**
 * 稀松数组和普通二维数组的相互转换
 * <p>
 * 稀松数组
 * [0][0] 存放原数组有多少行
 * [0][1] 存放原数组有多少列
 * [0][2] 存放原数组有多少个非0（或是有意义值的）个数
 * <p>
 * [1][0] 存放第一个有意义数据在第几行
 * [1][1] 存放第一个有意义数据在第几列
 * [1][2] 存放第一个有意义数据的值
 * <p>
 * ......以此类推
 * <p>
 * 所以稀松数组的大小应该是[原数组有意义的值的个数 + 1][3]
 * <p>
 * tips: 我们为了学习，所以假设传入的值都是不为空的，有意义的数据。即不为null
 */
public class SparseArray2Array {

    public static void main(String[] args) {
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
        array[4][5] = 1;
        SparseArray2Array s = new SparseArray2Array();
        int[][] ints = s.array2SparseArray(array);

//        for (int i = 0; i < ints.length; i++) {
//            for (int y = 0; y < 3; y++) {
//                System.out.print(ints[i][y] + "\t");
//            }
//            System.out.println();
//        }

        int[][] ints1 = s.sparseArray2Array(ints);

        for (int i = 0; i < ints1.length; i++) {
            for (int y = 0; y < ints1[0].length; y++) {
                System.out.print(ints1[i][y] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 数组转稀松数组 array.length = 行的个数 array[0].length = 列的个数
     *
     * @param array 原数组
     * @return 转换后的稀松数组
     */
    public int[][] array2SparseArray(int[][] array) {

        // 计算出原数组有意义数据的个数(这里假设就是不为0),用于稀松数组的行的构建

        int sparseRowNum = 0;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] != 0) {
                    sparseRowNum++;
                }
            }
        }

        // 构建稀松数组
        int[][] sparseArray = new int[sparseRowNum + 1][3];

        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sparseRowNum;
        // 都可以，这两个的值应该是一样的
//        sparseArray[0][2] = sparseArray[0].length;

        // 给稀松数组赋值
        int tag = 1;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] != 0) {
                    sparseArray[tag][0] = row;
                    sparseArray[tag][1] = col;
                    sparseArray[tag][2] = array[row][col];
                    tag++;
                }
            }
        }


        return sparseArray;
    }

    /**
     * 稀疏数组转数组
     *
     * @param sparseArray 原稀疏数组
     * @return 转后的数组
     */
    public int[][] sparseArray2Array(int[][] sparseArray) {

        int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++) {

            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];

        }

        return array;
    }
}
