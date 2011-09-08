package org.example.tictactoe.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Piyush Purang
 */
public class Play {

    public static final class Game {
        private final List<Move> moves = new ArrayList<Move>(9);

        public Game nextMove(final Move next) {
            moves.add(next);
            return this;
        }

        @Override
        public String toString() {
            return moves.toString();
        }

        public boolean isFinished() {
            return true;
        }

        public boolean hasWinner() {
            return true;
        }

        public Player winner() {
            return Player.NOUGHT;
        }
    }

    public static final class Move {
        private final int number;
        private final Cell cell;
        private final Player player;

        private Move(final int number, final Cell cell, final Player player) {
            this.number = number;
            this.cell = cell;
            this.player = player;
        }

        @Override
        public String toString() {
            return String.format("%d %s %s", number, cell, player);
        }
    }

    // case class Cell(row: Int, cols: Int)
    public static final class Cell {
        private final int row;
        private final int col;

        private volatile int hashCode = 0;

        public Cell(final int row, final int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", row, col);
        }

        @Override
        public int hashCode() {
            if(hashCode == 0) {
                int result = 17;
                result = 37 * result + (10 * row);
                result = 37 * result + col;
                hashCode = result;
            }
            return hashCode;
        }

        @Override
        public boolean equals(final Object obj) {
            if(this == obj) {
                return true;
            } else {
                if(obj instanceof Cell) {
                    final Cell that = (Cell) obj;
                    return this.row == that.row && this.col == that.col;
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(final String[] args) {
        final Game game = (new Game())
                .nextMove(new Move(1, new Cell(1, 1), Player.NOUGHT))
                .nextMove(new Move(2, new Cell(2, 1), Player.CROSS))
                .nextMove(new Move(3, new Cell(1, 2), Player.NOUGHT))
                .nextMove(new Move(4, new Cell(2, 2), Player.CROSS))
                .nextMove(new Move(5, new Cell(1, 3), Player.NOUGHT));
        if(game.isFinished()) {
            if(game.hasWinner()) {
                System.out.println("Winner is " + game.winner());
            } else {
                System.out.println("No winner!" );
            }
        } else {
            System.out.println("Game isn't finished yet!" );
        }
    }
}
