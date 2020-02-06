package com.AdvancedTicTacToe.engine;

public class CrossPlayer extends Player {

    public CrossPlayer() {
        this.alliance = Alliance.CROSS;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }
}
