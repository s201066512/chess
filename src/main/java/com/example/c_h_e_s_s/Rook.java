package com.example.c_h_e_s_s;

public class Rook extends Pieces{
    int maxLeft = row;
    int maxRight = 7 - row;
    int maxUp = col;
    int maxDown = 7 - col;

    public Rook(int type, int color, int col, int row) {
        super(3, color, col, row);
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
        if (desiredCol != col && desiredRow != row){ // this would mean you want to move illegally
            return board;
        }

        if (desiredCol == col && desiredRow != row){ // moving left or right
            if (desiredRow > row){ // moving right
                for (int right = row + 1; right <= desiredRow; right++){ // move right one space at a time
                    if (board[col][right] != null){ // invalid move, because something was in the way
                        return board;
                    }
                    // at this point it has "made it" to the desired position
                    board[col][row] = null;
                    col = desiredCol;
                    row = desiredRow;
                    board[col][row] = this;
                    return board;
                }
            }
            else{ // moving left
                for (int left = row - 1; left >= desiredRow; left--){ // move right one space at a time
                    if (board[col][left] != null){ // invalid move, because something was in the way
                        return board;
                    }
                    // at this point it has "made it" to the desired position
                    board[col][row] = null;
                    col = desiredCol;
                    row = desiredRow;
                    board[col][row] = this;
                    return board;
                }
            }
        }

        if (desiredCol != col && desiredRow == row){ // moving up or down
            if (desiredCol > col){ // moving down
                for (int down = col + 1; down <= desiredCol; down++){ // move right one space at a time
                    if (board[down][row] != null){ // invalid move, because something was in the way
                        return board;
                    }
                    // at this point it has "made it" to the desired position
                    board[col][row] = null;
                    col = desiredCol;
                    row = desiredRow;
                    board[col][row] = this;
                    return board;
                }
            }
            else{ // moving up
                for (int up = col - 1; up >= desiredCol; up--){ // move right one space at a time
                    if (board[up][row] != null){ // invalid move, because something was in the way
                        return board;
                    }
                    // at this point it has "made it" to the desired position
                    board[col][row] = null;
                    col = desiredCol;
                    row = desiredRow;
                    board[col][row] = this;
                    return board;
                }
            }
        }
        return board;
    }
}
