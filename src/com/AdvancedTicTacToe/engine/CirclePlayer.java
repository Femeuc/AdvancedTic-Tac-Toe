package com.AdvancedTicTacToe.engine;

public class CirclePlayer extends Player {

    public CirclePlayer() {
        this.alliance = Alliance.CIRCLE;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }
}
