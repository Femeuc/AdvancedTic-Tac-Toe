package com.AdvancedTicTacToe.engine;

public class Match {
    private Player crossPlayer = new CrossPlayer();
    private Player circlePlayer = new CirclePlayer();
    private static Alliance alliance = Alliance.CROSS;
    private static Board board = new Board();

    public static Square getBoardSquare(int squareId) {
        return board.gameBoard[squareId];
    }

    public static void occupyGameBoardSquare(int squareId) {
        board.gameBoard[squareId].setAlliance(alliance);
    }
}
