package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.*;
public class Methods {
    private int[] startingState = new int[9];
    private int[] victoryState = new int[9];

    public void setStartingState(int[] startingState) {
        this.startingState = startingState;
    }

    public void setVictoryState(int[] startingState) {
        this.victoryState = victoryState;
    }

    public int[] getStartingState() {
        return startingState;
    }

    public int[] getVictoryState() {
        return victoryState;
    }

    public Methods(int[] startingState, int[] victoryState) {
        this.startingState = startingState;
        this.victoryState = victoryState;

    }

    public boolean checkWinner(int[] boardInPlay) {
        if (boardInPlay.equals(victoryState)) {
            return true;
        } else {
            return false;
        }
    }
    // this method takes in a board and tells us how many parts are oop.
    public int heuristic(int[] board) {
        int i;
        int heuristic=0;
        for (i = 0; i < 8; i++) {
            if (board[i] != i + 1) {
                heuristic++;
            }
        }
        if(board[8] != 0){
            heuristic++;
        }

        return heuristic;
    }
    // g value function - pass in the glist and the f list
    // spits out a g value
    public int gValue(ArrayList<Integer> List, ArrayList<Integer> flist){
        int g, f =0;
        if (List.isEmpty()){
            g=0;
        }
        else{
            //get the minimum f index
            int minIndex = flist.indexOf(Collections.min(flist));
            g = List.get(minIndex);
        }
        return g;
    }


    public int indexOfZero(int[] board) {

        int index=0;
        int i;
        for (i = 0; i < 9; i++) {
            if (board[i] == 0) {
                index = i;
            }
        }
        return index;
    }
    //minimum heuristic value
    public int indexNextState(ArrayList<Integer> list){
        int index = 0;
        if(list.isEmpty())
        {
            index = 0;
        }
        else {
            index = list.indexOf(Collections.min(list));
        }
        return index;

    }

    public int[] moveLeft(int[] board) {
        int index = indexOfZero(board);
        board[index] = board[index-1];
        board[index-1] = 0;
        return board;
    }


    public int[] moveRight(int[] board) {
        int index = indexOfZero(board);
        board[index] = board[index+1];
        board[index+1] = 0;
        return board;
    }


    public int[] moveUp(int[] board) {
        int index = indexOfZero(board);
        board[index] = board[index-3];
        board[index-3] = 0;
        return board;
    }

    public int[] moveDown(int[] board) {
        int index = indexOfZero(board);
        board[index] = board[index+3];
        board[index+3] = 0;
        return board;
    }

    public String toString(ArrayList openList) {
        String state = "";
        int i;
        for (i = 0; i < openList.size(); i++) {
            state = state + openList.get(i) + ", ";
        }
        return state;

    }


  /*  public int compareTo(int[] firstBoard, int[] secondBoard) {
        int i;
        int heuristic1 = 0;
        int heuristic2 = 0;
        int comparison;
        for (i = 0; i < 9; i++) {
            if (firstBoard[i] != i + 1) {
                heuristic1++;
            }
        }
        for (i = 0; i < 9; i++) {
            if (secondBoard[i] != i + 1) {
                heuristic2++;
            }
        }
        if(heuristic1>heuristic2){
            comparison = 1;
        }
        else if(heuristic1<heuristic2){
            comparison = -1;
        }
        else {
            comparison = 0;
        }
        return comparison;
        }
*/
}