package com.company.ThorLight_codinGame;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.


            if (initialTx > 0 && initialTx < 40 && initialTy > 0 && initialTy < 18){


                if (initialTx > lightX){
                    for (int i = 0; i < initialTx-lightX; i++) {
                        System.out.println("W");
                    }
                }else if (initialTx < lightX){
                    for (int i = 0; i < lightX-initialTx; i++) {
                        System.out.println("E");
                    }
                }


                if (initialTy > lightY){
                 for (int i = 0; i < initialTy-lightY; i++) {
                        System.out.println("N");
                 }

                }else if (initialTy < lightY){
                    for (int i = 0; i < lightY-initialTy; i++) {
                        System.out.println("S");

                    }
                }

            }

        }
    }




}