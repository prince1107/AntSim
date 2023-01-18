package com.example.antsim;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class HelloController {
    int x = 20;
    int y = 30;
    Button[][] btn = new Button[x][y];
    int[][] gameGrid = new int[x][y];
    ArrayList<Ant> ants = new ArrayList<>();
    //GridPane gPane = new GridPane();
//    Image k = new Image("resources/Koala.jpg");
    @FXML
    private AnchorPane aPane;

    @FXML
    private GridPane gPane;


    @FXML
    private void handleStart(ActionEvent event) {

        //after adding the gridpane in scenebuilder, modify the fxml manually to eliminate
        // rows and columns


//        gPane.setMinSize(0,0);
        //gPane.setPadding(new Insets(btn[i][j]));
        //gPane.setHgap(10);
        //gPane.setVgap(10);
        //gPane.setGridLinesVisible(true);
        //gPane.setAlignment(Pos.CENTER);

        for(int i=0; i<btn.length; i++){
            for(int j=0; j<btn[0].length;j++){

                //Initializing 2D buttons with values i,j
                btn[i][j] = new Button();
                btn[i][j].setStyle("-fx-background-color:#d3d3d3");

                btn[i][j].setPrefWidth(25);

//                btn[i][j].setPrefSize(25, 5);
                //Parameters:  object, columns, rows
                gPane.add(btn[i][j], j, i);
                gameGrid[i][j]=0;


            }
        }

        gPane.setGridLinesVisible(true);

        gPane.setVisible(true);

        EventHandler z = new EventHandler<MouseEvent>()
        {

            @Override
            public void handle(MouseEvent t)
            {
                //ObservableList<Node> children = gPane.getChildren();
                //used to get a list of all children in gridpane
//                System.out.println("hello");
//                ((ImageView) t.getSource()).setImage(new Image("resources/Penguins.jpg"));
//
//                System.out.println("Row:    " + GridPane.getRowIndex(((ImageView) t.getSource())));
//                System.out.println("Column: " + GridPane.getColumnIndex(((ImageView) t.getSource())));
            }

        };
        for(int i=0; i<btn.length; i++){
            for(int j=0; j<btn[0].length;j++){
                btn[i][j].setOnMouseClicked(z);

            }
        }

        start();
    }
    @FXML
    public void handleAddAnt()
    {
//        if(gameGrid[7][8]==0){
        ants.add(new Ant(7,8));
        gameGrid[ants.get(ants.size()-1).getX()][ants.get(ants.size()-1).getY()]=1;
//            System.out.println("test");
//        }
        updateScreen();
    }

    @FXML
    public void handleAddFood()
    {
//        if(gameGrid[7][8]==0){
        ants.add(new Ant(7,8));
        gameGrid[ants.get(ants.size()-1).getX()][ants.get(ants.size()-1).getY()]=2;
//            System.out.println("test");
//        }
        updateScreen();
    }


    public void updateScreen(){

        for(int i=0; i<btn.length; i++) {
            for (int j = 0; j < btn[0].length; j++) {
                if (gameGrid[i][j]==0){
                    btn[i][j].setStyle("-fx-background-color:#d3d3d3");
                }
                else if (gameGrid[i][j]==1){
                    btn[i][j].setStyle("-fx-background-color:#ff0000");
                }
            }
        }
    }

    public void start() {

        new AnimationTimer() {
            @Override
            public void handle(long now) {
//                System.out.println(now);


                if(ants.size()>0){
                    for (Ant a : ants){


                        if(now - a.getStartTime() > 1000000000.0){
                            a.changeLoc(gameGrid);
                            a.resetStartTime();
                        }
                    }

                }
                updateScreen();

//                System.out.println("test");
            }
        }.start();
    }
}
