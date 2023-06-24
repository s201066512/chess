/*
- Draw pieces
- Get pieces to move properly
    - Figure out how to get mouse input and get desired column and desired row from that
    - Determine if a piece is valid
- Display valid moves
- Take pieces
- Pawn promotion
- Check/Checkmate detection
- Castling
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
    Pawn blackPawn1 = new Pawn(0, 1, 1, 0);
    Pawn blackPawn2 = new Pawn(0, 1, 1, 1);
    Pawn blackPawn3 = new Pawn(0, 1, 1, 2);
    Pawn blackPawn4 = new Pawn(0, 1, 1, 3);
    Pawn blackPawn5 = new Pawn(0, 1, 1, 4);
    Pawn blackPawn6 = new Pawn(0, 1, 1, 5);
    Pawn blackPawn7 = new Pawn(0, 1, 1, 6);
    Pawn blackPawn8 = new Pawn(0, 1, 1, 7);
    Knight blackKnight1 = new Knight(1, 1, 0, 1);
    Knight blackKnight2 = new Knight(1, 1, 0, 6);
    Bishop blackBishop1 = new Bishop(2, 1, 0, 2);
    Bishop blackBishop2 = new Bishop(2, 1, 0, 5);
    Rook blackRook1 = new Rook(3, 1, 0, 0);
    Rook blackRook2 = new Rook(3, 1, 0, 7);
    Queen blackQueen = new Queen(4, 1, 0, 3);
    King blackKing = new King(5, 1, 0, 4);

    // white pieces
    Pawn whitePawn1 = new Pawn(0, 0, 6, 0);
    Pawn whitePawn2 = new Pawn(0, 0, 6, 1);
    Pawn whitePawn3 = new Pawn(0, 0, 6, 2);
    Pawn whitePawn4 = new Pawn(0, 0, 6, 3);
    Pawn whitePawn5 = new Pawn(0, 0, 6, 4);
    Pawn whitePawn6 = new Pawn(0, 0, 6, 5);
    Pawn whitePawn7 = new Pawn(0, 0, 6, 6);
    Pawn whitePawn8 = new Pawn(0, 0, 6, 7);
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
                    System.out.println("What you want to move " + "\n" + "Column: " + firstPieceCol + "\n" + "Row: " + firstPieceRow);
                    selectFirstPiece = false;
                    selectSecondPiece = true;
                }
                else{
                    System.out.println("There is no piece there");
                }
            }
            else{ // to select second piece's column and row
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
                    System.out.println("Where you want to move it to " + "\n" + "Column: " + secondPieceCol + "\n" + "Row: " + secondPieceRow);
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