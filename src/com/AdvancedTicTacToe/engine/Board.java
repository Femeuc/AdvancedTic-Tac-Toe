package com.AdvancedTicTacToe.engine;

public class Board {

    public final static int AMOUNT_OF_SQUARES = calculateAmountOfSquares();
    public final static int AMOUNT_OF_ROWS = 13;
    public final static int AMOUNT_OF_COLUNS = 13;

    public Square[] gameBoard;

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

//    public static Square getSquare(int squareId) { Todo apagar isso depois
//        return gameBoard[squareId];
//    }

//    public static occupyGameBoardSquare(int squareId) {
//        gameBoard[squareId].setAlliance();
//    }

}
