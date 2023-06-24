/*
- Draw pieces
- Get pieces to move properly
    - Figure out how to get mouse input and get desired column and desired row from that
    - Determine if a move is valid
    - Pawn
    - Knight
    - Bishop
    - Rook
    - Queen
    - King
- Alternate turns
- Take pieces
- Pawn promotion
- Check/Checkmate detection
- Castling
- Display valid moves
- En passant
*/

package com.example.c_h_e_s_s;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Game extends Application {

    // creating all the black pieces
    Pawn blackPawn1 = new Pawn(0, 1, 1, 0, false);
    Pawn blackPawn2 = new Pawn(0, 1, 1, 1, false);
    Pawn blackPawn3 = new Pawn(0, 1, 1, 2, false);
    Pawn blackPawn4 = new Pawn(0, 1, 1, 3, false);
    Pawn blackPawn5 = new Pawn(0, 1, 1, 4, false);
    Pawn blackPawn6 = new Pawn(0, 1, 1, 5, false);
    Pawn blackPawn7 = new Pawn(0, 1, 1, 6, false);
    Pawn blackPawn8 = new Pawn(0, 1, 1, 7, false);
    Knight blackKnight1 = new Knight(1, 1, 0, 1);
    Knight blackKnight2 = new Knight(1, 1, 0, 6);
    Bishop blackBishop1 = new Bishop(2, 1, 0, 2);
    Bishop blackBishop2 = new Bishop(2, 1, 0, 5);
    Rook blackRook1 = new Rook(3, 1, 0, 0);
    Rook blackRook2 = new Rook(3, 1, 0, 7);
    Queen blackQueen = new Queen(4, 1, 0, 3);
    King blackKing = new King(5, 1, 0, 4);

    // white pieces
    Pawn whitePawn1 = new Pawn(0, 0, 6, 0, false);
    Pawn whitePawn2 = new Pawn(0, 0, 6, 1, false);
    Pawn whitePawn3 = new Pawn(0, 0, 6, 2, false);
    Pawn whitePawn4 = new Pawn(0, 0, 6, 3, false);
    Pawn whitePawn5 = new Pawn(0, 0, 6, 4, false);
    Pawn whitePawn6 = new Pawn(0, 0, 6, 5, false);
    Pawn whitePawn7 = new Pawn(0, 0, 6, 6, false);
    Pawn whitePawn8 = new Pawn(0, 0, 6, 7, false);
    Knight whiteKnight1 = new Knight(1, 0, 7, 1);
    Knight whiteKnight2 = new Knight(1, 0, 7, 6);
    Bishop whiteBishop1 = new Bishop(2, 0, 7, 2);
    Bishop whiteBishop2 = new Bishop(2, 0, 7, 5);
    Rook whiteRook1 = new Rook(3, 0, 7, 0);
    Rook whiteRook2 = new Rook(3, 0, 7, 7);
    Queen whiteQueen = new Queen(4, 0, 7, 3);
    King whiteKing = new King(5, 0, 7, 4);

    Color chessGreen = Color.rgb(118, 150, 86);
    Color chessWhite = Color.rgb(238, 238, 210);
    Pieces[][] board = new Pieces[8][8];

    final double LENGTH = 800;
    final double HEIGHT = 800;

    // method variables used for onclick event
    int firstPieceCol;
    int firstPieceRow;
    int secondPieceCol;
    int secondPieceRow;
    int turn = 0;
    boolean selectFirstPiece = true;
    boolean selectSecondPiece = false;

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        // populating the board

        // black pieces
        board[0][0] = blackRook1;
        board[0][1] = blackKnight1;
        board[0][2] = blackBishop1;
        board[0][3] = blackQueen;
        board[0][4] = blackKing;
        board[0][5] = blackBishop2;
        board[0][6] = blackKnight2;
        board[0][7] = blackRook2;

        board[1][0] = blackPawn1;
        board[1][1] = blackPawn2;
        board[1][2] = blackPawn3;
        board[1][3] = blackPawn4;
        board[1][4] = blackPawn5;
        board[1][5] = blackPawn6;
        board[1][6] = blackPawn7;
        board[1][7] = blackPawn8;

        board[7][0] = whiteRook1;
        board[7][1] = whiteKnight1;
        board[7][2] = whiteBishop1;
        board[7][3] = whiteQueen;
        board[7][4] = whiteKing;
        board[7][5] = whiteBishop2;
        board[7][6] = whiteKnight2;
        board[7][7] = whiteRook2;

        board[6][0] = whitePawn1;
        board[6][1] = whitePawn2;
        board[6][2] = whitePawn3;
        board[6][3] = whitePawn4;
        board[6][4] = whitePawn5;
        board[6][5] = whitePawn6;
        board[6][6] = whitePawn7;
        board[6][7] = whitePawn8;

        Pane pane = drawGrid();
        Scene scene = new Scene(pane, LENGTH, HEIGHT);
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();

        // after every move
        pane.getChildren().clear(); // clear board
        // move pieces
        pane.getChildren().add(drawGrid()); // redraw grid
        for (Pieces[] pieces : board) {
            for (int j = 0; j < board.length; j++) {
                if (pieces[j] != null) {
                    pane.getChildren().add(pieces[j].draw());
                }
            }
        }
        // redraw pieces


        pane.setOnMouseClicked(event -> {
            if (selectFirstPiece){
                // first piece row selection
                if (event.getSceneX() >= 0 && event.getSceneX() <= 100){
                    firstPieceRow = 0;
                }
                else if (event.getSceneX() > 100 && event.getSceneX() <= 200){
                    firstPieceRow = 1;
                }
                else if (event.getSceneX() > 200 && event.getSceneX() <= 300){
                    firstPieceRow = 2;
                }
                else if (event.getSceneX() > 300 && event.getSceneX() <= 400){
                    firstPieceRow = 3;
                }
                else if (event.getSceneX() > 400 && event.getSceneX() <= 500){
                    firstPieceRow = 4;
                }
                else if (event.getSceneX() > 500 && event.getSceneX() <= 600){
                    firstPieceRow = 5;
                }
                else if (event.getSceneX() > 600 && event.getSceneX() <= 700){
                    firstPieceRow = 6;
                }
                else{
                    firstPieceRow = 7;
                }

                // column selection
                if (event.getSceneY() >= 0 && event.getSceneY() <= 100){
                    firstPieceCol = 0;
                }
                else if (event.getSceneY() > 100 && event.getSceneY() <= 200){
                    firstPieceCol = 1;
                }
                else if (event.getSceneY() > 200 && event.getSceneY() <= 300){
                    firstPieceCol = 2;
                }
                else if (event.getSceneY() > 300 && event.getSceneY() <= 400){
                    firstPieceCol = 3;
                }
                else if (event.getSceneY() > 400 && event.getSceneY() <= 500){
                    firstPieceCol = 4;
                }
                else if (event.getSceneY() > 500 && event.getSceneY() <= 600){
                    firstPieceCol = 5;
                }
                else if (event.getSceneY() > 600 && event.getSceneY() <= 700){
                    firstPieceCol = 6;
                }
                else{
                    firstPieceCol = 7;
                }
                if (board[firstPieceCol][firstPieceRow] != null){
                    if (turn == 0 && board[firstPieceCol][firstPieceRow].getColor() == 0){
                        System.out.println("What you want to move " + "\n" + "Column: " + firstPieceCol + "\n" + "Row: " + firstPieceRow);
                        selectFirstPiece = false;
                        selectSecondPiece = true;
                    }
                    else if (turn == 1 && board[firstPieceCol][firstPieceRow].getColor() == 1){
                        System.out.println("What you want to move " + "\n" + "Column: " + firstPieceCol + "\n" + "Row: " + firstPieceRow);
                        selectFirstPiece = false;
                        selectSecondPiece = true;
                    }
                    else{
                        System.out.println("Wrong color");
                    }
                }
                else{
                    System.out.println("There is no piece there");
                }
            }

            // choose where to move it to
            else{
                // first piece row selection
                if (event.getSceneX() >= 0 && event.getSceneX() <= 100){
                    secondPieceRow = 0;
                }
                else if (event.getSceneX() > 100 && event.getSceneX() <= 200){
                    secondPieceRow = 1;
                }
                else if (event.getSceneX() > 200 && event.getSceneX() <= 300){
                    secondPieceRow = 2;
                }
                else if (event.getSceneX() > 300 && event.getSceneX() <= 400){
                    secondPieceRow = 3;
                }
                else if (event.getSceneX() > 400 && event.getSceneX() <= 500){
                    secondPieceRow = 4;
                }
                else if (event.getSceneX() > 500 && event.getSceneX() <= 600){
                    secondPieceRow = 5;
                }
                else if (event.getSceneX() > 600 && event.getSceneX() <= 700){
                    secondPieceRow = 6;
                }
                else{
                    secondPieceRow = 7;
                }

                // column selection
                if (event.getSceneY() >= 0 && event.getSceneY() <= 100){
                    secondPieceCol = 0;
                }
                else if (event.getSceneY() > 100 && event.getSceneY() <= 200){
                    secondPieceCol = 1;
                }
                else if (event.getSceneY() > 200 && event.getSceneY() <= 300){
                    secondPieceCol = 2;
                }
                else if (event.getSceneY() > 300 && event.getSceneY() <= 400){
                    secondPieceCol = 3;
                }
                else if (event.getSceneY() > 400 && event.getSceneY() <= 500){
                    secondPieceCol = 4;
                }
                else if (event.getSceneY() > 500 && event.getSceneY() <= 600){
                    secondPieceCol = 5;
                }
                else if (event.getSceneY() > 600 && event.getSceneY() <= 700){
                    secondPieceCol = 6;
                }
                else{
                    secondPieceCol = 7;
                }

                // check if trying to move piece to spot occupied by own piece
                if (board[secondPieceCol][secondPieceRow] != null){ // if piece is not null, check
                    if (turn == 0 && board[secondPieceCol][secondPieceRow].getColor() == 0){ // white attempting to move to spot occupied by white
                        System.out.println("Can't take own piece");
                    }
                    else if (turn == 1 && board[secondPieceCol][secondPieceRow].getColor() == 1){
                        System.out.println("Can't take own piece");
                    }
                    else{ // this means that even though there is a piece, it is not your own piece so try to move
                        System.out.println("Attempting to move piece to " + "\n" + "Column: " + secondPieceCol + "\n" + "Row: " + secondPieceRow);
                        board = board[firstPieceCol][firstPieceRow].move(board, secondPieceCol, secondPieceRow); // actually update the board
                        if (board[firstPieceCol][firstPieceRow] == null) { // did move

                            // switch turn
                            if (turn == 0){
                                turn = 1;
                            }
                            else{
                                turn = 0;
                            }

                            // redraw the board when pieces are moved
                            pane.getChildren().clear();
                            pane.getChildren().add(drawGrid()); // redraw grid

                            for (Pieces[] pieces : board) {
                                for (int j = 0; j < board.length; j++) {
                                    if (pieces[j] != null) {
                                        try {
                                            pane.getChildren().add(pieces[j].draw());
                                        } catch (FileNotFoundException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                }
                            }
                        }
                        else{
                            System.out.println("Invalid move");
                        }
                    }
                }


                else{ // this means that there is no piece where you want to move
                    // try to move the piece
                    System.out.println("Attempting to move piece to " + "\n" + "Column: " + secondPieceCol + "\n" + "Row: " + secondPieceRow);
                    board = board[firstPieceCol][firstPieceRow].move(board, secondPieceCol, secondPieceRow); // actually update the board
                    if (board[firstPieceCol][firstPieceRow] == null) { // did move

                        // switch turn
                        if (turn == 0){
                            turn = 1;
                        }
                        else{
                            turn = 0;
                        }

                        // redraw the board when pieces are moved
                        pane.getChildren().clear();
                        pane.getChildren().add(drawGrid()); // redraw grid

                        for (Pieces[] pieces : board) {
                            for (int j = 0; j < board.length; j++) {
                                if (pieces[j] != null) {
                                    try {
                                        pane.getChildren().add(pieces[j].draw());
                                    } catch (FileNotFoundException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("Invalid move");
                    }
                }
                // regardless of whether the move was valid, it makes more sense to go back to selecting a piece to move again
                System.out.println("Which piece do you want to move?");
                selectSecondPiece = false;
                selectFirstPiece = true;
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
    // board is 8x8
    // each square is 100x100
    private Pane drawGrid(){
        int tileColor = 0; // used for alternating squares
        Pane pane = new Pane();

        // draw squares
        for (int i = 0; i < 8; i++){ // what column
            if (tileColor == 1){
                tileColor = 0;
            }
            else{
                tileColor = 1;
            }
            for (int j = 0; j < 8; j++){ // every tile in that row
                double tileX = (LENGTH / 8) * j;
                double tileY = (HEIGHT / 8) * i;
                Rectangle tile = new Rectangle(tileX, tileY, LENGTH/8, LENGTH/8);
                if (tileColor == 0){
                    tile.setFill(chessGreen);
                    tileColor++;
                }
                else{
                    tile.setFill(chessWhite);
                    tileColor--;
                }
                pane.getChildren().add(tile);
            }
        }
        return pane;
    }
}