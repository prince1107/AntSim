package com.example.antsim;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class HelloController {

    @FXML
    public ListView buildingsView;
    @FXML
    public ListView statsView;

    int x = 20;
    int y = 30;

    Button[][] btn = new Button[x][y];
    int[][] gameGrid = new int[x][y];

    int money = 500;
    int entryFee = 10;

    Building selectedBuilding;

    ArrayList<Building> buildings = new ArrayList<>();

    ArrayList<People> people = new ArrayList<>();

    @FXML
    private AnchorPane aPane;
    @FXML
    private GridPane gPane;


    @FXML
    private void handleStart(ActionEvent event) {

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
                int row = GridPane.getRowIndex((Button) event.getSource());
                int column = GridPane.getColumnIndex((Button) event.getSource());

                if(selectedBuilding != null){
                    btn[row][column].setStyle("-fx-background-color:#0000ff");
                    buildings.add(new Building(19,15, 20, System.nanoTime(), "Rocket to Mars", 20));
                }
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
    public void handleAddPerson()
    {
//        if(gameGrid[7][8]==0){
        people.add(new People(19,15));
        gameGrid[people.get(people.size()-1).getX()][people.get(people.size()-1).getY()]=1;
        money += entryFee;
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
                else if (gameGrid[i][j]==2){
                    btn[i][j].setStyle("-fx-background-color:#0000ff");
                }
            }
        }
    }

    public void start() {

        new AnimationTimer() {
            @Override
            public void handle(long now) {
//                System.out.println(now);


                if(people.size()>0){
                    for (People a : people){
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

    @FXML
    public void selectBuilding() {
        int index = buildingsView.getSelectionModel().getSelectedIndex();

        selectedBuilding = buildings.get(index);
    }
}
