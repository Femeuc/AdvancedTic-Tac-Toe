package com.AdvancedTicTacToe.engine;

public class Board {

    public final static int AMOUNT_OF_SQUARES = calculateAmountOfRows();
    public final static int AMOUNT_OF_ROWS = 13;
    public final static int AMOUNT_OF_COLUNS = 13;

    public static int calculateAmountOfRows() {
        return AMOUNT_OF_ROWS * AMOUNT_OF_COLUNS;
    }
}
