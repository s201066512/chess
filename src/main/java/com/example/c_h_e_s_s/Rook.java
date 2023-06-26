package com.example.c_h_e_s_s;

public class Rook extends Pieces{

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
                for (int right = row; right < desiredRow; right++){ // move right one space at a time
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
            else{ // moving left
                for (int left = row; left > desiredRow; left--){ // move right one space at a time
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
        }

        if (desiredCol != col && desiredRow == row){ // moving up or down
            if (desiredCol > col){ // moving down
                for (int down = col; down < desiredCol; down++){ // move right one space at a time
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
            else{ // moving up
                for (int up = col; up > desiredCol; up--){ // move right one space at a time
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
        return board;
    }
    public int[][] validMoves(Pieces[][] board){
        int[][] moves = new int[8][8];

        // right
        for (int right = row; right < 7; right++){ // moving right from current column to the edge
            if (board[col][right] == null){ // if nothing is there it is a valid move
                moves[col][right] = 1;
            }
            else{ // something is there
                if (board[col][right].getColor() == 0 && color == 1){ // enemy piece
                    moves[col][right] = 1; // there is a piece which can be captured, so it is a valid move
                    break; // but you can't go any further, so break
                }
                else if (board[col][right].getColor() == 0 && color == 0){ // friendly piece
                    break; // can't go any further
                }
                if (board[col][right].getColor() == 1 && color == 0){
                    moves[col][right] = 1; // there is a piece which can be captured, so it is a valid move
                    break; // but you can't go any further, so break
                }
                else if (board[col][right].getColor() == 1 && color == 1){
                    break;
                }
            }
        }

        // left
        for (int left = row; left > 0; left--){
            if (board[col][left] == null){ // if nothing is there it is a valid move
                moves[col][left] = 1;
            }
            else{ // something is there
                if (board[col][left].getColor() == 0 && color == 1){ // enemy piece
                    moves[col][left] = 1; // there is a piece which can be captured, so it is a valid move
                    break; // but you can't go any further, so break
                }
                else if (board[col][left].getColor() == 0 && color == 0){ // friendly piece
                    break; // can't go any further
                }
                if (board[col][left].getColor() == 1 && color == 0){
                    moves[col][left] = 1; // there is a piece which can be captured, so it is a valid move
                    break; // but you can't go any further, so break
                }
                else if (board[col][left].getColor() == 1 && color == 1){
                    break;
                }
            }
        }

        // up
        for (int up = col; up > 0; up--){
            if (board[col][up] == null){ // if nothing is there it is a valid move
                moves[col][up] = 1;
            }
            else{ // something is there
                if (board[col][up].getColor() == 0 && color == 1){ // enemy piece
                    moves[col][up] = 1; // there is a piece which can be captured, so it is a valid move
                    break; // but you can't go any further, so break
                }
                else if (board[col][up].getColor() == 0 && color == 0){ // friendly piece
                    break; // can't go any further
                }
                if (board[col][up].getColor() == 1 && color == 0){
                    moves[col][up] = 1; // there is a piece which can be captured, so it is a valid move
                    break; // but you can't go any further, so break
                }
                else if (board[col][up].getColor() == 1 && color == 1){
                    break;
                }
            }
        }


        // down
        for (int down = col; down < 7; down++){
            if (board[col][down] == null){ // if nothing is there it is a valid move
                moves[col][down] = 1;
            }
            else{ // something is there
                if (board[col][down].getColor() == 0 && color == 1){ // enemy piece
                    moves[col][down] = 1; // there is a piece which can be captured, so it is a valid move
                    break; // but you can't go any further, so break
                }
                else if (board[col][down].getColor() == 0 && color == 0){ // friendly piece
                    break; // can't go any further
                }
                if (board[col][down].getColor() == 1 && color == 0){
                    moves[col][down] = 1; // there is a piece which can be captured, so it is a valid move
                    break; // but you can't go any further, so break
                }
                else if (board[col][down].getColor() == 1 && color == 1){
                    break;
                }
            }
        }

        return moves;
    }
}
