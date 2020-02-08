package com.AdvancedTicTacToe.engine;

public class Board {

    public final static int AMOUNT_OF_SQUARES = calculateAmountOfSquares();
    public final static int AMOUNT_OF_ROWS = 13;
    public final static int AMOUNT_OF_COLUNS = 13;
    public final static int AMOUNT_OF_ASCENDING_DIAGONALS = 17;  // There is a relation between the amount of ascending rows and the number of rows and columns

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

    public static final boolean[] FIRST_ROW = initRow(0);
    public static final boolean[] SECOND_ROW = initRow(13);
    public static final boolean[] THIRD_ROW = initRow(26);
    public static final boolean[] FOURTH_ROW = initRow(39);
    public static final boolean[] FIFTH_ROW = initRow(52);
    public static final boolean[] SIXTH_ROW = initRow(65);
    public static final boolean[] SEVENTH_ROW = initRow(78);
    public static final boolean[] EIGHTH_ROW = initRow(91);
    public static final boolean[] NINTH_ROW = initRow(104);
    public static final boolean[] TENTH_ROW = initRow(117);
    public static final boolean[] ELEVENTH_ROW = initRow(130);
    public static final boolean[] TWELFTH_ROW = initRow(143);
    public static final boolean[] THIRTEENTH_ROW = initRow(156);

    public static final boolean[] FIRST_ASCENDING_DIAGONAL = initDiagonal(52);
    public static final boolean[] SECOND_ASCENDING_DIAGONAL = initDiagonal(65);
    public static final boolean[] THIRD_ASCENDING_DIAGONAL = initDiagonal(78);
    public static final boolean[] FOURTH_ASCENDING_DIAGONAL = initDiagonal(91);
    public static final boolean[] FIFTH_ASCENDING_DIAGONAL = initDiagonal(104);
    public static final boolean[] SIXTH_ASCENDING_DIAGONAL = initDiagonal(117);
    public static final boolean[] SEVENTH_ASCENDING_DIAGONAL = initDiagonal(130);
    public static final boolean[] EIGHTH_ASCENDING_DIAGONAL = initDiagonal(143);
    public static final boolean[] NINTH_ASCENDING_DIAGONAL = initDiagonal(156);
    public static final boolean[] TENTH_ASCENDING_DIAGONAL = initDiagonal(157);
    public static final boolean[] ELEVENTH_ASCENDING_DIAGONAL = initDiagonal(158);
    public static final boolean[] TWELFTH_ASCENDING_DIAGONAL = initDiagonal(159);
    public static final boolean[] THIRTEENTH_ASCENDING_DIAGONAL = initDiagonal(160);
    public static final boolean[] FOURTEENTH_ASCENDING_DIAGONAL = initDiagonal(161);
    public static final boolean[] FIFTEENTH_ASCENDING_DIAGONAL = initDiagonal(162);
    public static final boolean[] SIXTEENTH_ASCENDING_DIAGONAL = initDiagonal(163);
    public static final boolean[] SEVENTEENTH_ASCENDING_DIAGONAL = initDiagonal(164);

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

    private static boolean[] initRow(int rowStart) {
        final boolean[] row = new boolean[AMOUNT_OF_SQUARES];
        int rowSquare = rowStart;
        do {
            row[rowSquare] = true;
            rowSquare += 1;
        } while(rowSquare < rowStart + AMOUNT_OF_ROWS);
        return row;
    }

    private static boolean[] initDiagonal(int diagonalStartCoordinate) {
        final boolean[] ascendingDiagonal = new boolean[AMOUNT_OF_SQUARES];
        ascendingDiagonal[diagonalStartCoordinate] = true;
        do {
            diagonalStartCoordinate -= (AMOUNT_OF_ROWS - 1); // TODO maybe it is better to get rid of these parenthesis
            ascendingDiagonal[diagonalStartCoordinate] = true;
        } while(!getRow(0)[diagonalStartCoordinate] && !getColumn(AMOUNT_OF_COLUNS - 1)[diagonalStartCoordinate]);
        return ascendingDiagonal;
    }

    public static boolean[] getColumn(int columnNUmber) {
        switch (columnNUmber) {
            case 0:
                return FIRST_COLUMN;
            case 1:
                return SECOND_COLUNN;
            case 2:
                return THIRD_COLUMN;
            case 3:
                return FOURTH_COLUMN;
            case 4:
                return FIFTH_COLUMN;
            case 5:
                return SIXTH_COLUMN;
            case 6:
                return SEVENTH_COLUMN;
            case 7:
                return EIGHTH_COLUMN;
            case 8:
                return NINTH_COLUMN;
            case 9:
                return TENTH_COLUMN;
            case 10:
                return ELEVENTH_COLUMN;
            case 11:
                return TWELFTH_COLUMN;
            case 12:
                return THIRTEENTH_COLUMN;
            default:
                throw new RuntimeException("Invalid column number");
        }
    }

    public static boolean[] getRow(int rowNumber) {
        switch (rowNumber) {
            case 0:
                return FIRST_ROW;
            case 1:
                return SECOND_ROW;
            case 2:
                return THIRD_ROW;
            case 3:
                return FOURTH_ROW;
            case 4:
                return FIFTH_ROW;
            case 5:
                return SIXTH_ROW;
            case 6:
                return SEVENTH_ROW;
            case 7:
                return EIGHTH_ROW;
            case 8:
                return NINTH_ROW;
            case 9:
                return TENTH_ROW;
            case 10:
                return ELEVENTH_ROW;
            case 11:
                return TWELFTH_ROW;
            case 12:
                return THIRTEENTH_ROW;
            default:
                throw new RuntimeException("Invalid row number");
        }
    }

    public static boolean[] getAscendingDiagonal(int ascendingDiagonalNumber) {
        switch (ascendingDiagonalNumber) {
            case 0:
                return FIRST_ASCENDING_DIAGONAL;
            case 1:
                return SECOND_ASCENDING_DIAGONAL;
            case 2:
                return THIRD_ASCENDING_DIAGONAL;
            case 3:
                return FOURTH_ASCENDING_DIAGONAL;
            case 4:
                return FIFTH_ASCENDING_DIAGONAL;
            case 5:
                return SIXTH_ASCENDING_DIAGONAL;
            case 6:
                return SEVENTH_ASCENDING_DIAGONAL;
            case 7:
                return EIGHTH_ASCENDING_DIAGONAL;
            case 8:
                return NINTH_ASCENDING_DIAGONAL;
            case 9:
                return TENTH_ASCENDING_DIAGONAL;
            case 10:
                return ELEVENTH_ASCENDING_DIAGONAL;
            case 11:
                return TWELFTH_ASCENDING_DIAGONAL;
            case 12:
                return THIRTEENTH_ASCENDING_DIAGONAL;
            case 13:
                return FOURTEENTH_ASCENDING_DIAGONAL;
            case 14:
                return FIFTEENTH_ASCENDING_DIAGONAL;
            case 15:
                return SIXTEENTH_ASCENDING_DIAGONAL;
            case 16:
                return SEVENTEENTH_ASCENDING_DIAGONAL;
            default:
                throw new RuntimeException("Invalid ascending diagonal number");
        }
    }

}
