package com.codegym.test;

import  java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to TicTacToe!\n");
        Scanner console = new Scanner(System.in);
        TicTacToe game = new TicTacToe();


        while(game.checkWin()){
            if (game.checkMaxed()){
                break;
            }

            String turn = "X";
            if (game.getTurn() % 2 != 0){
                turn = "O";
            }

            System.out.println("!!! Player "+ turn + "'s turn !!!");

            game.printBoard();


            while(true){
                System.out.print("Enter a position! Ex: (1,1) is the center...  ");
                String input = console.next();
                int row = Integer.parseInt(input.substring(0,input.indexOf(",")));
                int col = Integer.parseInt(input.substring(input.indexOf(",")+1));

                if (game.pickLocation(row,col)){
                    game.takeTurn(row,col);
                    break;
                }
                else{
                    System.out.println("\nThat spot has been taken!");
                }
            }

            System.out.println("______________________________");
        }

        game.printBoard();

        if (!game.checkWin()){
            if (game.getTurn() % 2 == 0){
                System.out.println("Player [O] wins!!!");
            }
            else{
                System.out.println("Player [X] wins!!!");
            }
        }
        else{
            System.out.println("\t[DRAW] The game board has been maxed out...re-run to play again!");
        }

    }
}
