package com.AdvancedTicTacToe.engine;

public class Match {
    private Player crossPlayer = new CrossPlayer();
    private Player circlePlayer = new CirclePlayer();
    private Alliance alliance = Alliance.CROSS;
    private Board board = new Board();
    private Alliance winner = null;

    public boolean occupyGameBoardSquare(int squareId) {
        board.gameBoard[squareId].setAlliance(alliance);
        if(checkForWinner()) {
            setWinner(this.getAlliance());
            return true; // True if there is a winner
        }
        setAlliance(alliance.getOppositeAlliance());
        return false;  // False if there's no winner
    }

    public Alliance getAlliance() {
        return alliance;
    }

    private void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }

    public Board getBoard() {
        return board;
    }

    private boolean checkForWinner() {
        for(int i = 0; i < Board.AMOUNT_OF_COLUNS; i++) {  // This for loop analyses the columns
            if(checkForWinnerOnColumn(i)) {
                return true;
            }
        }
        for(int i = 0; i < Board.AMOUNT_OF_ROWS; i++) {  // This for loop analyses the rows
            if(checkForWinnerOnRow(i)) {
                return true;
            }
        }
        for(int i = 0; i < Board.AMOUNT_OF_ASCENDING_DIAGONALS; i++) {
            if(checkForWinnerOnAscendingDiagonal(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForWinnerOnColumn(int columnNumber) {
        int symbolsInSequence = 0; // symbol here refers to the cross symbol ( X ) or the circle symbol ( O ) which must appear in sequence for a win
        for (int i = 0; i < Board.AMOUNT_OF_SQUARES; i++) {
            if(Board.getColumn(columnNumber)[i]) {  // The column to be checked is determined by the columnNumber parameter
                if(board.gameBoard[i].getAlliance() == this.getAlliance()) {
                    symbolsInSequence += 1;
                } else {
                    symbolsInSequence = 0;
                }
                if(symbolsInSequence == 5)
                    return true;
            }
        }
        return false;
    }

    private boolean checkForWinnerOnRow(int rowNumber) {
        int symbolsInSequence = 0;
        for(int i = 0; i < Board.AMOUNT_OF_SQUARES; i++) {
            if(Board.getRow(rowNumber)[i]) {
                if(board.gameBoard[i].getAlliance() == this.getAlliance()) {
                    symbolsInSequence += 1;
                } else {
                    symbolsInSequence = 0;
                }
                if(symbolsInSequence == 5)
                    return true;
            }
        }
        return false;
    }

    private boolean checkForWinnerOnAscendingDiagonal(int ascendingDiagonalNumber) {
        int symbolsInSequence = 0;
        for(int i = 0; i < Board.AMOUNT_OF_SQUARES; i++) {
            if(Board.getAscendingDiagonal(ascendingDiagonalNumber)[i]) {
                if(board.gameBoard[i].getAlliance() == this.getAlliance()) {
                    symbolsInSequence += 1;
                } else {
                    symbolsInSequence = 0;
                }
                if(symbolsInSequence == 5)
                    return true;
            }
        }
        return false;
    }

    public Alliance getWinner() {
        return winner;
    }

    public void setWinner(Alliance alliance) {
        this.winner = alliance;
    }
}
