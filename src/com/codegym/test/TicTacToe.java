package com.codegym.test;

public class TicTacToe
{
    //copy over your constructor from the Tic Tac Toe Board activity in the previous lesson!
    private int turn;
    private String[][] board;


    TicTacToe(){

        turn = 0;

        board = new String[4][4];
        board[0][0] = " ";
        for (int x = 1; x < board.length; x++){
            board[0][x] = " " + Integer.toString(x-1);
        }
        for (int i = 1; i < board.length; i++){
            board[i][0] = Integer.toString(i-1) + " ";
            for (int k = 1; k < board[0].length; k++){
                board[i][k] = "- ";
            }
        }
    }
    
    //this method returns the current turn
    public int getTurn()
    {
        return this.turn;
    }

    /*This method prints out the board array on to the console
     */
    public void printBoard()
    {
        for (int i = 0; i < board.length; i++){
            for (int k = 0; k < board[0].length; k++){
                System.out.print(board[i][k]);
            }
            System.out.println();
        }
    }

    //This method returns true if space row, col is a valid space
    public boolean pickLocation(int row, int col)
    {
        if (board[row+1][col+1] == "- "){
            return true;
        }
        return false;
    }

    //This method places an X or O at location row,col based on the int turn
    public void takeTurn(int row, int col)
    {
        if ((turn % 2) == 0){
            board[row+1][col+1] = "X ";
        }
        else{
            board[row+1][col+1] = "O ";
        }
        turn++;
    }

    //This method returns a boolean that returns true if a row has three X or O's in a row
    public boolean checkRow()
    {
        for (int i = 0; i < board.length; i++){
            if (board[i][1].equals(board[i][2]) && board[i][2].equals(board[i][3])){
                if (!(board[i][2].equals("- "))){
                    return true;
                }
            }
        }


        return false;
    }

    //This method returns a boolean that returns true if a col has three X or O's
    public boolean checkCol()
    {
        for (int i = 0; i < board.length; i++){
            if (board[1][i].equals(board[2][i]) && board[2][i].equals(board[3][i])){
                if (!(board[1][i].equals("- "))){
                    return true;
                }
            }
        }
        return false;
    }

    //This method returns a boolean that returns true if either diagonal has three X or O's
    public boolean checkDiag()
    {    if (!(board[2][2].equals("- "))){
        if (board[1][1].equals(board[2][2]) && board[2][2].equals(board[3][3])){
            return true;
        }
        if (board[1][2].equals(board[2][2]) && board[2][2].equals(board[3][1])){
            return true;
        }
    }
        return false;
    }

    //This method returns a boolean that checks if someone has won the game
    public boolean checkWin()
    {
        if (checkDiag() || checkCol() || checkRow()){
            return false;
        }

        return true;
    }

    public boolean checkMaxed(){
        for (int i = 1; i < board.length; i++){
            for (int k = 1; k < board.length; k++){
                if (board[i][k].equals("- ")){
                    return false;
                }
            }
        }
        return true;
    }

}