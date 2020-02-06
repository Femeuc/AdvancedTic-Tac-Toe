package com.AdvancedTicTacToe.engine;

public class Match {
    private Player crossPlayer = new CrossPlayer();
    private Player circlePlayer = new CirclePlayer();
    private Alliance alliance = Alliance.CROSS;
    private Board board = new Board();

    public void occupyGameBoardSquare(int squareId) {
        board.gameBoard[squareId].setAlliance(alliance);
        setAlliance(alliance.getOppositeAlliance());
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
}
