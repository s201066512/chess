package com.example.c_h_e_s_s;
import java.lang.Math;
public class Bishop extends Pieces{
    public Bishop(int type, int color, int col, int row) {
        super(2, color, col, row);
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
        if (desiredCol == col || desiredRow == row){ // invalid move
            return board;
        }
        else{ // different row and column
            int columnMovement = Math.abs(col - desiredCol);
            int rowMovement = Math.abs(row - desiredRow);
            if (columnMovement != rowMovement){ // but not moving diagonally
                return board; // so it's invalid
            }
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
        return board;
    }
    public int[][] validMoves(Pieces[][] board){
        int[][] moves = new int[8][8];
        int count = 0;
        // up left
        while (col - count > 0 && row - count > 0){ // while you can still move up and left
            if (board[col - count][row - count] == null){ // check if the tile is empty
                moves[col - count][row - count] = 1; // if it is then it is a valid move
            }
            else{ // there is a piece on that spot
                if (board[col - count][row - count].getColor() == 0 && color == 1){ // it's an enemy piece
                    moves[col - count][row - count] = 1; // you can capture it
                    break; // but not go any further
                }
                else if (board[col - count][row - count].getColor() == 0 && color == 0){ // it's a friendly piece
                    break; // you can't capture it or go any further
                }
                else if (board[col - count][row - count].getColor() == 1 && color == 0){
                    moves[col - count][row - count] = 1; // can capture it
                    break; // can't go any further
                }
                else if (board[col - count][row - count].getColor() == 1 && color == 1){
                    break; // can't go any further
                }
            }
        }

        // up right
        count = 0;
        while (col - count > 0 && row + count < 7){ // while you can still move up and left
            if (board[col - count][row + count] == null){ // check if the tile is empty
                moves[col - count][row + count] = 1; // if it is then it is a valid move
            }
            else{ // there is a piece on that spot
                if (board[col - count][row + count].getColor() == 0 && color == 1){ // it's an enemy piece
                    moves[col - count][row + count] = 1; // you can capture it
                    break; // but not go any further
                }
                else if (board[col - count][row + count].getColor() == 0 && color == 0){ // it's a friendly piece
                    break; // you can't capture it or go any further
                }
                else if (board[col - count][row + count].getColor() == 1 && color == 0){
                    moves[col - count][row + count] = 1; // can capture it
                    break; // can't go any further
                }
                else if (board[col - count][row + count].getColor() == 1 && color == 1){
                    break; // can't go any further
                }
            }
        }

        // down left
        while (col + count < 7 && row - count > 0){ // while you can still move up and left
            if (board[col + count][row - count] == null){ // check if the tile is empty
                moves[col + count][row - count] = 1; // if it is then it is a valid move
            }
            else{ // there is a piece on that spot
                if (board[col + count][row - count].getColor() == 0 && color == 1){ // it's an enemy piece
                    moves[col + count][row - count] = 1; // you can capture it
                    break; // but not go any further
                }
                else if (board[col + count][row - count].getColor() == 0 && color == 0){ // it's a friendly piece
                    break; // you can't capture it or go any further
                }
                else if (board[col + count][row - count].getColor() == 1 && color == 0){
                    moves[col + count][row - count] = 1; // can capture it
                    break; // can't go any further
                }
                else if (board[col + count][row - count].getColor() == 1 && color == 1){
                    break; // can't go any further
                }
            }
        }

        // down right
        while (col + count < 7 && row + count < 7){ // while you can still move up and left
            if (board[col + count][row + count] == null){ // check if the tile is empty
                moves[col + count][row + count] = 1; // if it is then it is a valid move
            }
            else{ // there is a piece on that spot
                if (board[col + count][row + count].getColor() == 0 && color == 1){ // it's an enemy piece
                    moves[col + count][row + count] = 1; // you can capture it
                    break; // but not go any further
                }
                else if (board[col + count][row + count].getColor() == 0 && color == 0){ // it's a friendly piece
                    break; // you can't capture it or go any further
                }
                else if (board[col + count][row + count].getColor() == 1 && color == 0){
                    moves[col + count][row + count] = 1; // can capture it
                    break; // can't go any further
                }
                else if (board[col + count][row + count].getColor() == 1 && color == 1){
                    break; // can't go any further
                }
            }
        }
        return moves;
    }
}
