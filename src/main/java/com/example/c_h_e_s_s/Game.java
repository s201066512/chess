package com.example.c_h_e_s_s;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application {
    final double LENGTH = 800;
    final double HEIGHT = 800;

    @Override
    public void start(Stage stage) {
        Pane pane = drawGrid();

        Scene scene = new Scene(pane, LENGTH, HEIGHT);
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();
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
                    tile.setFill(Color.YELLOWGREEN);
                    tileColor++;
                }
                else{
                    tile.setFill(Color.CORNSILK);
                    tileColor--;
                }
                pane.getChildren().add(tile);
            }
        }
        return pane;
    }
}