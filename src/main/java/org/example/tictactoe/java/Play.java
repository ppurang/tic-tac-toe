package org.example.tictactoe.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Piyush Purang
 */
public class Play {
    public static final class Game {
        private final Map<Cell,Move> moves = new HashMap<Cell,Move>();

        public Game nextMove(final Move next) {
            if(moves.get(next.getCell())==null){
                moves.put(next.getCell(), next);
            }else{
                throw new IllegalStateException("move already exists " + next) ; // TODO provide a guard method
            }
            return this;
        }



        @Override
        public String toString() {
            final StringBuilder sb= new StringBuilder();
            final String line="-------";
            for (int i= 1; i < 4;i++){
                sb.append(line).append("\n|");
                for (int j= 1; j < 4;j++){
                    final Cell cell = new Cell(i,j);
                    if(moves.containsKey(cell)){
                        sb.append(moves.get(cell).getPlayer()).append("|");
                    }else{
                        sb.append(" |");
                    }
                }
                sb.append("\n");
            }
            sb.append(line);
            return sb.toString();
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

        public Cell getCell() {
            return cell;
        }

        @Override
        public String toString() {
            return String.format("%d %s %s", number, cell, player);
        }

        public Player getPlayer() {
            return player;
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
                result = 37 * result + row;
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
