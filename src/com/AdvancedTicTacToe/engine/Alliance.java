package com.AdvancedTicTacToe.engine;

public enum Alliance {
    CROSS {
        @Override
        public Alliance getOppositeAlliance() {
            return CIRCLE;
        }

        @Override
        public boolean isCross() {
            return true;
        }

        @Override
        public boolean isCircle() {
            return false;
        }
    },
    CIRCLE {
        @Override
        public Alliance getOppositeAlliance() {
            return CROSS;
        }

        @Override
        public boolean isCross() {
            return false;
        }

        @Override
        public boolean isCircle() {
            return true;
        }
    };

    public abstract Alliance getOppositeAlliance();

    public abstract boolean isCross();

    public abstract boolean isCircle();
}
