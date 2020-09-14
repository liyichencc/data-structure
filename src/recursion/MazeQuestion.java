package recursion;

/**
 * @Description 迷宫问题
 * <p>
 * [ 1,1,1,1,1,1,1
 * 1,0,0,0,0,0,1
 * 1,0,0,0,0,0,1
 * 1,1,1,0,0,0,1
 * 1,0,0,0,0,0,1
 * 1,0,0,0,0,0,1
 * 1,0,0,0,0,0!,1
 * 1,1,1,1,1,1,1
 * ]
 * <p>
 * 假设这是一个迷宫，1代表墙，请从1，1位置到达0!所表示的位置。6,6
 * @Author v_liyichen
 * @date 2020.09.11 15:38
 */
public class MazeQuestion {


    /**
     * 递归寻找
     * 1. 递归返回 当[6,6] = 2时。
     * 2. 我们设 1=墙，2=已经走过 0=还未到达,3为不可达
     * 3. 策略为 右 -> 下 ->左 -> 上
     *
     * @param map
     * @param i
     * @param j
     * @return
     */
    public boolean setWay(int[][] map, int i, int j) {

        if (map[6][5] == 2) {
            return true;
        } else {

            if (map[i][j] == 0) {

                map[i][j] = 2;
                if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else if (setWay(map,i -1,j )) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("-------------------------------------------");
        MazeQuestion mazeQuestion = new MazeQuestion();

        mazeQuestion.setWay(map,1,1);


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }


    }


}
