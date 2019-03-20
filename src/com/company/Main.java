package com.company;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        int[] initialBoard = new int[]{1, 0, 2, 4, 5, 3, 7, 8, 6};
        int i;
        int[] winningBoard = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0};
        int[] leftCheck = new int[9];
        int[] rightCheck = new int[9];
        int[] upCheck = new int[9];
        int[] downCheck = new int[9];


        Methods arrays = new Methods(initialBoard, winningBoard);
        ArrayList<int[]> closedList = new ArrayList<int[]>();
        ArrayList<int[]> openList = new ArrayList<int[]>();
        ArrayList<Integer> heuristicList = new ArrayList<Integer>();
        ArrayList<Integer> gList = new ArrayList<Integer>();
        ArrayList<Integer> fandgList = new ArrayList<Integer>();
		/*
		Maintain a seperate list of g values
		whatever g list I just used the next g states are G plus 1
		f gets tested on the combined g and f list
		*/


        // while loop controller
        int g = 0;
        //create a board checker

        int controller = arrays.heuristic(initialBoard);


        while (controller != 0 && g < 100) {
            controller = arrays.heuristic(initialBoard);
            System.out.println();
            System.out.println("Loop " + g + " size of open list: " + openList.size());
            // find the highest index
            int index = arrays.indexOfZero(initialBoard);

            // Switch statements that will call methods to move depending on where the 0 is
            switch (index) {
                case 0:
                    for (i = 0; i < 9; i++) {
                        rightCheck[i] = initialBoard[i];
                        downCheck[i] = initialBoard[i];
                    }


                    arrays.moveRight(rightCheck);
                    arrays.moveDown(downCheck);

                    if ((!closedList.contains(rightCheck)) && (!openList.contains(rightCheck))) {
                        openList.add(rightCheck);
                        gList.add(g);
                        heuristicList.add(arrays.heuristic(rightCheck));
                    }

                    if ((!closedList.contains(downCheck)) && (!openList.contains(downCheck))) {
                        openList.add(downCheck);
                        gList.add(g);
                        heuristicList.add(arrays.heuristic(downCheck));
                    }

                    System.out.println("Case 0");
                    break;
                case 1:
                    for (i = 0; i < 9; i++) {
                        rightCheck[i] = initialBoard[i];
                        downCheck[i] = initialBoard[i];
                        leftCheck[i] = initialBoard[i];
                    }

                    arrays.moveRight(rightCheck);
                    arrays.moveDown(downCheck);
                    arrays.moveLeft(leftCheck);

                    if ((!closedList.contains(rightCheck)) && (!openList.contains(rightCheck))) {
                        openList.add(rightCheck);
                        gList.add(g);
                        heuristicList.add(arrays.heuristic(rightCheck));
                    }

                    if ((!closedList.contains(downCheck)) && (!openList.contains(downCheck))) {
                        openList.add(downCheck);
                        gList.add(g);
                        heuristicList.add(arrays.heuristic(downCheck));
                    }

                    if ((!closedList.contains(leftCheck)) && (!openList.contains(leftCheck))) {
                        openList.add(leftCheck);
                        gList.add(g);
                        heuristicList.add(arrays.heuristic(leftCheck));
                    }

                    System.out.println("Case 1");
                    break;
                case 2:
                    for (i = 0; i < 9; i++) {
                        leftCheck[i] = initialBoard[i];
                        downCheck[i] = initialBoard[i];
                    }

                    arrays.moveLeft(leftCheck);
                    arrays.moveDown(downCheck);

                    if ((!closedList.contains(leftCheck)) && (!openList.contains(leftCheck))) {
                        openList.add(leftCheck);
                        heuristicList.add(arrays.heuristic(leftCheck));
                        gList.add(g);
                    }

                    if ((!closedList.contains(downCheck)) && (!openList.contains(downCheck))) {
                        openList.add(downCheck);
                        gList.add(g);
                        heuristicList.add(arrays.heuristic(downCheck));
                    }


                    System.out.println("Case 2");
                    break;
                case 3:
                    for (i = 0; i < 9; i++) {
                        rightCheck[i] = initialBoard[i];
                        downCheck[i] = initialBoard[i];
                        upCheck[i] = initialBoard[i];
                    }

                    arrays.moveRight(rightCheck);
                    arrays.moveDown(downCheck);
                    arrays.moveUp(upCheck);

                    if ((!closedList.contains(downCheck)) && (!openList.contains(downCheck))) {
                        openList.add(downCheck);
                        heuristicList.add(arrays.heuristic(downCheck));
                        gList.add(g);
                    }

                    if ((!closedList.contains(rightCheck)) && (!openList.contains(rightCheck))) {
                        openList.add(rightCheck);
                        heuristicList.add(arrays.heuristic(rightCheck));
                        gList.add(g);
                    }
                    if ((!closedList.contains(upCheck)) && (!openList.contains(upCheck))) {
                        openList.add(upCheck);
                        heuristicList.add(arrays.heuristic(upCheck));
                        gList.add(g);
                    }


                    System.out.println("Case 3");
                    break;
                case 4:
                    for (i = 0; i < 9; i++) {
                        rightCheck[i] = initialBoard[i];
                        downCheck[i] = initialBoard[i];
                        leftCheck[i] = initialBoard[i];
                        upCheck[i] = initialBoard[i];
                    }
                    arrays.moveRight(rightCheck);
                    arrays.moveDown(downCheck);
                    arrays.moveLeft(leftCheck);
                    arrays.moveUp(upCheck);

                    if ((!closedList.contains(downCheck)) && (!openList.contains(downCheck))) {
                        openList.add(downCheck);
                        heuristicList.add(arrays.heuristic(downCheck));
                        gList.add(g);
                    }
                    if ((!closedList.contains(upCheck)) && (!openList.contains(upCheck))) {
                        openList.add(upCheck);
                        heuristicList.add(arrays.heuristic(upCheck));
                        gList.add(g);
                    }
                    if ((!closedList.contains(rightCheck)) && (!openList.contains(rightCheck))) {
                        openList.add(rightCheck);
                        heuristicList.add(arrays.heuristic(rightCheck));
                        gList.add(g);
                    }
                    if ((!closedList.contains(leftCheck)) && (!openList.contains(leftCheck))) {
                        openList.add(leftCheck);
                        heuristicList.add(arrays.heuristic(leftCheck));
                        gList.add(g);
                    }

                    break;
                case 5:
                    // down - up - Left
                    for (i = 0; i < 9; i++) {
                        leftCheck[i] = initialBoard[i];
                        upCheck[i] = initialBoard[i];
                        downCheck[i] = initialBoard[i];
                    }
                    arrays.moveLeft(leftCheck);
                    arrays.moveUp(upCheck);
                    arrays.moveDown(downCheck);
                    System.out.println("Case 5");

                    if ((!closedList.contains(leftCheck)) && (!openList.contains(leftCheck))) {
                        openList.add(leftCheck);
                        heuristicList.add(arrays.heuristic(leftCheck));
                        gList.add(g);
                    }
                    if ((!closedList.contains(downCheck)) && (!openList.contains(downCheck))) {
                        openList.add(downCheck);
                        heuristicList.add(arrays.heuristic(downCheck));
                        gList.add(g);
                    }
                    if ((!closedList.contains(upCheck)) && (!openList.contains(upCheck))) {
                        openList.add(upCheck);
                        heuristicList.add(arrays.heuristic(upCheck));
                        gList.add(g);
                    }

                    break;
                case 6:
                    for (i = 0; i < 9; i++) {
                        upCheck[i] = initialBoard[i];
                        rightCheck[i] = initialBoard[i];
                    }
                    arrays.moveUp(upCheck);
                    arrays.moveRight(rightCheck);

                    if ((!closedList.contains(upCheck)) && (!openList.contains(upCheck))) {
                        openList.add(upCheck);
                        heuristicList.add(arrays.heuristic(upCheck));
                        gList.add(g);
                    }
                    if ((!closedList.contains(rightCheck)) && (!openList.contains(rightCheck))) {
                        openList.add(rightCheck);
                        heuristicList.add(arrays.heuristic(rightCheck));
                        gList.add(g);
                    }


                    System.out.println("Case 6");
                    break;
                case 7:
                    //copy the boards
                    for (i = 0; i < 9; i++) {
                        upCheck[i] = initialBoard[i];
                        rightCheck[i] = initialBoard[i];
                        leftCheck[i] = initialBoard[i];
                    }
                    //move the 0's
                    arrays.moveUp(upCheck);
                    arrays.moveRight(rightCheck);
                    arrays.moveLeft(leftCheck);

                    if ((!closedList.contains(upCheck)) && (!openList.contains(upCheck))) {
                        openList.add(upCheck);
                        heuristicList.add(arrays.heuristic(upCheck));
                        gList.add(g);
                    }
                    if ((!closedList.contains(rightCheck)) && (!openList.contains(rightCheck))) {
                        openList.add(rightCheck);
                        heuristicList.add(arrays.heuristic(rightCheck));
                        gList.add(g);
                    }
                    if ((!closedList.contains(leftCheck)) && (!openList.contains(leftCheck))) {
                        openList.add(leftCheck);
                        heuristicList.add(arrays.heuristic(leftCheck));
                        gList.add(g);
                    }
                    System.out.println("Case 7");
                    break;
                case 8:
                    for (i = 0; i < 9; i++) {
                        upCheck[i] = initialBoard[i];
                        leftCheck[i] = initialBoard[i];
                    }

                    arrays.moveUp(upCheck);
                    arrays.moveLeft(leftCheck);

                    if ((!closedList.contains(leftCheck)) && (!openList.contains(leftCheck))) {
                        openList.add(leftCheck);
                        heuristicList.add(arrays.heuristic(leftCheck));
                        gList.add(g);
                    }
                    if ((!closedList.contains(upCheck)) && (!openList.contains(upCheck))) {
                        openList.add(upCheck);
                        heuristicList.add(arrays.heuristic(upCheck));
                        gList.add(g);
                    }

                    System.out.println("Case 8");
                    break;
            }
            g++;

            System.out.println();
            System.out.print("Glist: ");
            for (i = 0; i < gList.size(); i++) {

                System.out.print(gList.get(i) + ", ");
            }
            System.out.println();
            System.out.print("Flist: ");
            for (i = 0; i < gList.size(); i++) {

                System.out.print(heuristicList.get(i) + ", ");
            }

            //gList.add(arrays.gValue(gList, heuristicList));

            System.out.println();
            System.out.print("Combined heuristic : ");
            for (i = 0; i < heuristicList.size(); i++) {
                fandgList.add(gList.get(i) + heuristicList.get(i));
                System.out.print(fandgList.get(i) + ",");
            }
            System.out.println();
            System.out.println("Lowest Heurisitic : " + arrays.indexNextState(fandgList));

            //find index of lowest heuristic
            int ind = arrays.indexNextState(fandgList);

            //set up next board
            for (i = 0; i < 9; i++) {
                initialBoard[i] = (openList.get(ind)[i]);
                //System.out.print(initialBoard[i] + ",");
            }
            System.out.println();
            for (i = 0; i < openList.size(); i++) {
                System.out.println("Open List element "+ i + " ::: " + openList.get(i)[0] +", " + openList.get(i)[1]+", " + openList.get(i)[2]+", " + openList.get(i)[3]+", "
                        + openList.get(i)[4]+", " + openList.get(i)[5]+", " + openList.get(i)[6]+", " + openList.get(i)[7]+", " + openList.get(i)[8]);
            }

            for (i = 0; i < closedList.size(); i++) {
                System.out.println("Closed List element "+ i + " ::: " + closedList.get(i)[0] +", " + closedList.get(i)[1]+", " + closedList.get(i)[2]+", " + closedList.get(i)[3]+", "
                        + closedList.get(i)[4]+", " + closedList.get(i)[5]+", " + closedList.get(i)[6]+", " + closedList.get(i)[7]+", " + closedList.get(i)[8]);
            }

            //make this a remove function and add a closed list.

            controller = arrays.heuristic(initialBoard);
            if (controller == 0) {
                System.out.println();
                System.out.println("You found the correct state! After XXX Moves");
            }
            else{
                closedList.add(openList.get(arrays.indexNextState(fandgList)));
                //openList.remove(arrays.indexNextState(fandgList));
                heuristicList.remove(arrays.indexNextState(fandgList));
                gList.remove(arrays.indexNextState(fandgList));
                System.out.println();
                System.out.println("Next State to Check : ");
                for (i = 0; i < 9; i++) {
                    System.out.print(initialBoard[i] + ",");
                }
            }
            openList.remove(arrays.indexNextState(fandgList));
            fandgList.clear();

        }
        System.out.println();
        for (i = 0; i < openList.size(); i++) {
            System.out.println("Open List element "+ i + " ::: " + openList.get(i)[0] +", " + openList.get(i)[1]+", " + openList.get(i)[2]+", " + openList.get(i)[3]+", "
                    + openList.get(i)[4]+", " + openList.get(i)[5]+", " + openList.get(i)[6]+", " + openList.get(i)[7]+", " + openList.get(i)[8]);
        }

        if (controller == 0) {
            System.out.println();
            System.out.println("You found the correct state! After XXX Moves");
        }




    }


}