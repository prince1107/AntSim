package com.example.antsim;

public class Food extends Thing {
    private int x;
    private int y;

    private int food = 0;

    String loc;
    private long startTime;
    public Food(int x,int y){
        this.x = x;
        this.y = y;
        startTime = System.nanoTime();
    }
    public void changeLoc(int[][] gameGrid){
        int timeout=0;
        boolean check = false;
        while(!check && timeout<1000){
            timeout++;
            int tempx = x;
            int tempy = y;
            if(Math.random()>.5){
                tempx++;
            }else {
                tempx--;
            }
            if(Math.random()>.5){
                tempy++;
            }else {
                tempy--;
            }
            if (gameGrid[tempx][tempy]==0){
                check=true;
                gameGrid[tempx][tempy]=1;
                gameGrid[x][y]=0;
                x=tempx;
                y=tempy;
            } else if (gameGrid[tempx][tempy]==0){
                check=true;
                gameGrid[tempx][tempy]=1;
                gameGrid[x][y]=0;
                x=tempx;
                y=tempy;
                food++;
                System.out.println(food);
            }
        }

//          System.out.println("x: " + x);

    }

    public int getX(){
        return this.x;
    }
    public void resetStartTime(){
        startTime = System.nanoTime();
    }
    public long getStartTime(){
        return startTime;
    }

    public int getY() {
        return this.y;
    }
}
