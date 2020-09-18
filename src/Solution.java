/**
 * @Description
 * @Author liyichen
 * @date 2020.09.02 19:05
 */

/**
 * 稀疏数组：    将二维数组的行作为[0][0]，列作为[0][1]，有多少不为0的个数作为[0][3]
 *              则从第一行开始，遇到不为0的数字时，原数组的行列分别为稀疏数组的[行][0],[列][1]，[数值][2]
 *
 * 数组实现队列：  判断队满，对空。
 *              循环队列判断队满 front + 1 % maxsize == maxsize
 *              判断队空 front + rear - maxsize % maxsize
 *
 *
 *
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() <= 0) return 0;
        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
        int res = 0, index = 0;
        while (index < str.length() && str.charAt(index) == ' ') index++;
        if (index == str.length()) return 0;
        char firstChar = str.charAt(index);
        boolean positive = true;
        if (!isDigit(firstChar)) {
            if (firstChar != '+' && firstChar != '-') return 0;
            index++;
            positive = firstChar != '-';
        }
        int limit = positive ? -MAX : MIN;

        while (index < str.length() && str.charAt(index) == '0') index++;
        while (index < str.length() && isDigit(str.charAt(index))) {
            int digit = str.charAt(index++) - '0';
            if (res < (limit + digit) / 10) {
                return positive ? MAX : MIN;
            }
            res = res * 10 - digit; //用减法,可以避免越界。
        }
        return positive ? -res : res;
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.myAtoi("42");
    }
}

