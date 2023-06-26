package com.example.c_h_e_s_s;

public class Queen extends Pieces{
    public Queen(int type, int color, int col, int row) {
        super(4, color, col, row);
    }
    @Override
    public int getColor() {
        return super.getColor();
    }
    @Override
    public int getCol() {
        return super.getCol();
    }

    @Override
    public int getRow() {
        return super.getRow();
    }

    @Override
    public Pieces[][] move(Pieces[][] board, int desiredCol, int desiredRow) {

        // horizontal/vertical movement
        if (desiredCol == col && desiredRow != row || desiredCol != col && desiredRow == row){ // moving left/right, or up/down
            if (desiredRow > row){ // moving right
                for (int right = row + 1; right < desiredRow; right++){ // move right one space at a time
                    if (board[col][right] != null){ // invalid move, because something was in the way
                        return board;
                    }
                }
                // at this point it has "made it" to the desired position
                board[col][row] = null;
                col = desiredCol;
                row = desiredRow;
                board[col][row] = this;
                return board;
            }

            else if (desiredRow < row){ // moving left
                for (int left = row - 1; left > desiredRow; left--){
                    // move right one space at a time
                    System.out.println("board[" + col + "]" + "[" + row + "]");
                    if (board[col][left] != null){ // invalid move, because something was in the way
                        return board;
                    }
                }
                // at this point it has "made it" to the desired position
                board[col][row] = null;
                col = desiredCol;
                row = desiredRow;
                board[col][row] = this;
                return board;
            }
            if (desiredCol > col){ // moving down
                for (int down = col + 1; down < desiredCol; down++){ // move right one space at a time
                    if (board[down][row] != null){ // invalid move, because something was in the way
                        return board;
                    }
                }
                // at this point it has "made it" to the desired position
                board[col][row] = null;
                col = desiredCol;
                row = desiredRow;
                board[col][row] = this;
                return board;
            }
            else if (desiredCol < col){ // moving up
                for (int up = col - 1; up > desiredCol; up--){ // move up one space at a time
                    if (board[up][row] != null){ // invalid move, because something was in the way
                        return board;
                    }
                }
                // at this point it has "made it" to the desired position
                board[col][row] = null;
                col = desiredCol;
                row = desiredRow;
                board[col][row] = this;
                return board;
            }
        }
        else{
            // diagonal movement
            if (Math.abs(col - desiredCol) != Math.abs(row - desiredRow)){
                return board;
            }
            // up left
            if (desiredCol < col && desiredRow < row){
                for (int i = 1; i < Math.abs(desiredCol - col); i++){ // Math.abs(desiredCol - col) could be row as well, but they're already equal if this is reached
                    if (board[col - i][row - i] != null){ // there is a piece in the way
                        return board; // invalid
                    }
                }
                // means the piece has made it to its desired position without encountering another piece
                board[col][row] = null;
                col = desiredCol;
                row = desiredRow;
                board[col][row] = this;
                return board;
            }


            // up right
            if (desiredCol < col && desiredRow >  row){
                for (int i = 1; i < Math.abs(desiredCol - col); i++){ // Math.abs(desiredCol - col) could be row as well, but they're already equal if this is reached
                    System.out.println("board[" + (col - i) + "]" + "[" + (row + i)  + "]");
                    // col down
                    // row up
                    if (board[col - i][row + i] != null){ // there is a piece in the way
                        return board; // invalid
                    }
                }
                // means the piece has made it to its desired position without encountering another piece
                board[col][row] = null;
                col = desiredCol;
                row = desiredRow;
                board[col][row] = this;
                return board;
            }


            // down left
            if (desiredCol > col && desiredRow < row){
                for (int i = 1; i < Math.abs(desiredCol - col); i++){ // Math.abs(desiredCol - col) could be row as well, but they're already equal if this is reached
                    // col up
                    // row down
                    if (board[col + i][row - i] != null){ // there is a piece in the way
                        return board; // invalid
                    }
                }
                // means the piece has made it to its desired position without encountering another piece
                board[col][row] = null;
                col = desiredCol;
                row = desiredRow;
                board[col][row] = this;
                return board;
            }

            // down right
            if (desiredCol > col && desiredRow > row){
                for (int i = 1; i < Math.abs(desiredCol - col); i++){ // Math.abs(desiredCol - col) could be row as well, but they're already equal if this is reached
                    // col up
                    // row down
                    if (board[col + i][row + i] != null){ // there is a piece in the way
                        return board; // invalid
                    }
                }
                // means the piece has made it to its desired position without encountering another piece
                board[col][row] = null;
                col = desiredCol;
                row = desiredRow;
                board[col][row] = this;
                return board;
            }
        }
        return board;
    }
}
