package org.example.tictactoe.java;

public enum Player  {
    NOUGHT() {
        @Override
        public Player nextPlayer() {
           return CROSS;
       }
        @Override
        public String toString() {
            return "O";
        }
    },
    CROSS() {
        @Override
        public Player nextPlayer() {
           return NOUGHT;
       }
        @Override
        public String toString() {
            return "X";
        }
    };

    public Player nextPlayer() {
        throw new AbstractMethodError();
    }
}
