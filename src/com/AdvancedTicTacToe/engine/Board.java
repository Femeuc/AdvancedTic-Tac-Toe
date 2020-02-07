package com.AdvancedTicTacToe.engine;

public class Board {

    public final static int AMOUNT_OF_SQUARES = calculateAmountOfSquares();
    public final static int AMOUNT_OF_ROWS = 13;
    public final static int AMOUNT_OF_COLUNS = 13;

    public Square[] gameBoard;

    public static final boolean[] FIRST_COLUMN = initCol(0);
    public static final boolean[] SECOND_COLUNN = initCol(1);
    public static final boolean[] THIRD_COLUMN = initCol(2);
    public static final boolean[] FOURTH_COLUMN = initCol(3);
    public static final boolean[] FIFTH_COLUMN = initCol(4);
    public static final boolean[] SIXTH_COLUMN = initCol(5);
    public static final boolean[] SEVENTH_COLUMN = initCol(6);
    public static final boolean[] EIGHTH_COLUMN = initCol(7);
    public static final boolean[] NINTH_COLUMN = initCol(8);
    public static final boolean[] TENTH_COLUMN = initCol(9);
    public static final boolean[] ELEVENTH_COLUMN = initCol(10);
    public static final boolean[] TWELFTH_COLUMN = initCol(11);
    public static final boolean[] THIRTEENTH_COLUMN = initCol(12);

    public Board() {
        this.gameBoard = initBoard();
    }

    public static int calculateAmountOfSquares() {
        return AMOUNT_OF_ROWS * AMOUNT_OF_COLUNS;
    }

    private Square[] initBoard() {
        Square[] squares = new Square[AMOUNT_OF_SQUARES];
        for(int i = 0; i < AMOUNT_OF_SQUARES; i++) {
            squares[i] = new Square(i);
        }
        return squares;
    }

    private static boolean[] initCol(int columnNumber) {
        final boolean[] column = new boolean[AMOUNT_OF_SQUARES];
        do {
            column[columnNumber] = true;
            columnNumber += AMOUNT_OF_COLUNS;
        } while(columnNumber < AMOUNT_OF_SQUARES);
        return column;
    }

}
