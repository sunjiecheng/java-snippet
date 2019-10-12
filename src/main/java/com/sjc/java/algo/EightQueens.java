package com.sjc.java.algo;

/**
 * 八皇后问题（回溯算法）
 *
 * @author jiecheng
 * @create 2019-10-12 下午1:58
 */
public class EightQueens {

    public static void main(String[] args) {
        EightQueens queens = new EightQueens();
        queens.cal8Queens(0);
    }

    int[] result = new int[8];

    public void cal8Queens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOK(row, column)) {
                result[row] = column;
                cal8Queens(row + 1);
            }
        }
    }

    private boolean isOK(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;
            }
            if (leftUp >= 0 && result[i] == leftUp) {
                return false;
            }
            if (rightUp < 8 && result[i] == rightUp) {
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    public void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
