package org.example;

import java.util.Arrays;

public class SudokuSolver {

    public static void main(String[] args) {

        char[][] board =
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        if(helper(board)){
            System.out.println(Arrays.deepToString(board));
        }
        else {
            System.out.println("no solution");
        }
}




    static boolean helper(char[][] board){

        int row=-1;
        int col=-1;
        boolean v = false;
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                if(board[i][j]=='.'){
                    row=i;
                    col=j;
                    v=true;
                    break;
                }
            }
            if(v){
                break;
            }
        }

        if(v==false){
            return true;
        }

        for(int num=1;num<=9;num++){
            if(isSafe(board,row,col,num)){
                board[row][col]=Character.forDigit(num,10);
                if(helper(board)){
                    return true;
                }
                else{
                    board[row][col]='.';
                }
            }

        }
        return false;
    }
    static boolean isSafe(char[][] board, int row, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            if (Character.getNumericValue(board[row][i]) == num) {
                return false;
            }
        }

        for (char[] nums : board) {
            if (Character.getNumericValue(nums[col]) == num) {
                return false;
            }
        }

        int n = (int) Math.sqrt(board.length);
        int start = row - row % n;
        int end = col - col % n;

        for (int i = start; i < start + n; i++) {
            for (int j = end; j < end + n; j++) {
                if (Character.getNumericValue(board[i][j]) == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
