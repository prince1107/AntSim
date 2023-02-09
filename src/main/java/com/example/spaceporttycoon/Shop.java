package com.example.spaceporttycoon;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Random;

public class Shop {
    private Building[] buildingList;

    private ArrayList<Building> currentList = new ArrayList<>();

    public Shop(Building[] buildingList){
        this.buildingList = buildingList;
    }

    protected void randomizeShop(ListView listView){
        ArrayList<String> tempList = new ArrayList<>();
        currentList.clear();

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int index = random.nextInt(buildingList.length);
            tempList.add(buildingList[index].getName() + "; Price: " + buildingList[index].getShopPrice());
            currentList.add(buildingList[index]);
        }

        listView.getItems().clear();
        listView.getItems().addAll(tempList);
    }

    public ArrayList<Building> getCurrentList() {
        return currentList;
    }
}
