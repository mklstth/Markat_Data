package com.mthree.ui;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu(){
        scanner = new Scanner(System.in);
    }

    public static void clear() {
        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
    }

    public int[] menuLogic() throws InputDataIsInvalidException, EndingTheCodeException {
        int[] selected = new int[2];

        selected[0] = selectFunc();
        if(selected[0] == 6) throw new EndingTheCodeException("The application is closing");
        checkData(selected[0]);

        selected[1] = selectMenuItem();
        checkData(selected[1]);

        return selected;
    }

    private void checkData(int a) throws InputDataIsInvalidException{
        if(a > 5 || a < 1 ){
            throw new InputDataIsInvalidException("The given input was incorrect, please try again");
        }
    }

    private int selectFunc(){
        printMenuFunctions();
        return  pickMenuItem();
    }

    private int selectMenuItem(){
       printMenuTradeType();
       return pickMenuItem();
    }

    private void printMenuTradeType(){
        System.out.println("Select the Trade that you are interested in: " );
        System.out.println("1. A as Agilent Technologies" );
        System.out.println("2. AAPL as Apple" );
        System.out.println("3. BRK as Berkshire Hathaway (class A shares)L" );
        System.out.println("4. C as Citigroup");
        System.out.println("5. GOOG as Alphabet Inc." );
    }

    private void printMenuFunctions(){
        System.out.println("Select action:" );
        System.out.println("1. Show the open price" );
        System.out.println("2. Show the close price" );
        System.out.println("3. Show the Avg Price without open and close" );
        System.out.println("4. Show vwap" );
        System.out.println("5. Show vwap without reported trades" );
        System.out.println("6. EXIT application" );
    }

    private int pickMenuItem(){
        int selected = 0;

        boolean bError = true;
        while (bError) {
            if (scanner.hasNextInt())
                selected = scanner.nextInt();
            else {
                scanner.next();
                continue;
            }
            bError = false;
        }
        return selected;
    }
}

