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
        checkForWinOnFirstColumn();
        if(winner != null)
            return true;
        return false;
    }

    private void checkForWinOnFirstColumn() {
        int symbolsInSequenceFor1stColumn = 0;
        int symbolsInSequenceFor2ndColumn = 0;
        int symbolsInSequenceFor3rdColumn = 0;
        int symbolsInSequenceFor4thColumn = 0;
        int symbolsInSequenceFor5thColumn = 0;
        int symbolsInSequenceFor6thColumn = 0;
        int symbolsInSequenceFor7thColumn = 0;
        int symbolsInSequenceFor8thColumn = 0;
        int symbolsInSequenceFor9thColumn = 0;
        int symbolsInSequenceFor10thColumn = 0;
        int symbolsInSequenceFor11thColumn = 0;
        int symbolsInSequenceFor12thColumn = 0;
        int symbolsInSequenceFor13thColumn = 0;

        for(int i = 0; i < Board.AMOUNT_OF_SQUARES; i++) {
            if(Board.FIRST_COLUMN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor1stColumn += 1;
                } else {
                    symbolsInSequenceFor1stColumn = 0;
                }
                if(symbolsInSequenceFor1stColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            } else if(Board.SECOND_COLUNN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor2ndColumn += 1;
                } else {
                    symbolsInSequenceFor2ndColumn = 0;
                }
                if(symbolsInSequenceFor2ndColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            } else if(Board.THIRD_COLUMN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor3rdColumn += 1;
                } else {
                    symbolsInSequenceFor3rdColumn = 0;
                }
                if(symbolsInSequenceFor3rdColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            } else if(Board.FOURTH_COLUMN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor4thColumn += 1;
                } else {
                    symbolsInSequenceFor4thColumn = 0;
                }
                if(symbolsInSequenceFor4thColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            } else if(Board.FIFTH_COLUMN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor5thColumn += 1;
                } else {
                    symbolsInSequenceFor5thColumn = 0;
                }
                if(symbolsInSequenceFor5thColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            } else if(Board.SIXTH_COLUMN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor6thColumn += 1;
                } else {
                    symbolsInSequenceFor6thColumn = 0;
                }
                if(symbolsInSequenceFor6thColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            } else if(Board.SEVENTH_COLUMN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor7thColumn += 1;
                } else {
                    symbolsInSequenceFor7thColumn = 0;
                }
                if(symbolsInSequenceFor7thColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            } else if(Board.EIGHTH_COLUMN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor8thColumn += 1;
                } else {
                    symbolsInSequenceFor8thColumn = 0;
                }
                if(symbolsInSequenceFor8thColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            } else if(Board.NINTH_COLUMN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor9thColumn += 1;
                } else {
                    symbolsInSequenceFor9thColumn = 0;
                }
                if(symbolsInSequenceFor9thColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            } else if(Board.TENTH_COLUMN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor10thColumn += 1;
                } else {
                    symbolsInSequenceFor10thColumn = 0;
                }
                if(symbolsInSequenceFor10thColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            } else if(Board.ELEVENTH_COLUMN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor11thColumn += 1;
                } else {
                    symbolsInSequenceFor11thColumn = 0;
                }
                if(symbolsInSequenceFor11thColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            } else if(Board.TWELFTH_COLUMN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor12thColumn += 1;
                } else {
                    symbolsInSequenceFor12thColumn = 0;
                }
                if(symbolsInSequenceFor12thColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            } else if(Board.THIRTEENTH_COLUMN[i]) {
                if(board.gameBoard[i].getAlliance() == this.alliance) {
                    symbolsInSequenceFor13thColumn += 1;
                } else {
                    symbolsInSequenceFor13thColumn = 0;
                }
                if(symbolsInSequenceFor13thColumn == 5) {
                    setWinner(this.alliance);
                    break;
                }
            }
        }
    }

    public Alliance getWinner() {
        return winner;
    }

    public void setWinner(Alliance alliance) {
        this.winner = alliance;
    }
}
