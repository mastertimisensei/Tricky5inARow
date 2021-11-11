/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tricky5inarow;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

/**
 *
 * @author BISOLA-OJO
 */
public class Model {
    public int size;
    private Player p;
    private Player[][] grid;
    private ArrayList<ArrayList<Integer>> listX;
    private ArrayList<ArrayList<Integer>> listO;
    public Collect c1,c2;
    
    public Model(int size){
        this.size=size;
        p=Player.X;
        listX = new ArrayList();
        listO = new ArrayList();
        
        grid = new Player[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                grid[i][j]=Player.NOBODY;
            }
        }
    }
    
    public Player step(int row, int column){
        if (grid[row][column] != Player.NOBODY){
            return grid[row][column];
        }
        grid[row][column] = p;
        
        if (p == Player.X){
           ArrayList<Integer> temp = new ArrayList();
           temp.add(row);
           temp.add(column);
           listX.add(temp);
           //this.PUnstep(p);
           p = Player.O;
        }else{
           ArrayList<Integer> temp = new ArrayList();
           temp.add(row);
           temp.add(column);
           listO.add(temp);
           //this.PUnstep(p);
            p= Player.X;
        }
        return grid[row][column];
    }
    
    public Collect unstep(Player p){
       boolean t= false;
       Random random = new Random();
       if (p == Player.X){
       int max = listX.size();
       int ind = random.nextInt(max);;
       int x = listX.get(ind).get(0);
       int y = listX.get(ind).get(1);
       grid[x][y] = Player.NOBODY;
       listX.remove(ind);
       return new Collect(true,x,y);
       }
       if (p == Player.O){
       int max = listO.size();
       int ind =  random.nextInt(max);
       int x = listO.get(ind).get(0);
       int y = listO.get(ind).get(1);
       grid[x][y] = Player.NOBODY;
       listO.remove(ind);
       return new Collect(true,x,y);
       }
       return null;
    }
    
    public Player getWinner(){
    for (int i = 0; i < size; i++){
        for (int j=0; j < size - 4; j++){
           if (grid[i][j] != Player.NOBODY){
               int count = 0;
               int temp = j;
               Player ptemp = grid[i][j];
               while(temp < size && ptemp == grid[i][temp]){
                   count++;
                   temp++;
                   if (count >= 5){
                   return ptemp;
               }
               }
           } 
        }
    }
    
        for (int i = 0; i < size; i++){
        for (int j=0; j < size; j++){
           if (grid[j][i] != Player.NOBODY){
               int count = 1;
               int temp = j+1;
               Player ptemp = grid[j][i];
               while(temp < size && ptemp == grid[temp][i]){
                   count++;
                   temp++;
               }
               if (count >= 5){
                   return ptemp;
               }
           } 
        }
    }
     for (int i = 0; i < size; i++){
        for (int j=0; j < size; j++){
            if (grid[i][j] != Player.NOBODY){
               int count = 1;
               int tempX = j+1;
               int tempY = i+1;
               Player ptemp = grid[i][j];
               while(tempX < size && tempY < size && ptemp == grid[tempY][tempX]){
                   count++;
                   tempX++;
                   tempY++;
               }
               if (count >= 5){
                   return ptemp;
               }
            }
        }
     }

      for (int i = 0; i < size; i++){
        for (int j=0; j < size; j++){
            if (grid[i][j] != Player.NOBODY){
               int count = 1;
               int tempX = j-1;
               int tempY = i+1;
               Player ptemp = grid[i][j];
               while(tempX >= 0 && tempY >= 0 && tempY < size && ptemp == grid[tempY][tempX]){
                   count++;
                   tempX--;
                   tempY++;
               }
               if (count >= 5){
                   return ptemp;
               }
            }
            
        }
     }
    return Player.NOBODY;
    }
    
    public void PUnstep (Player p){
         for (int i = 0; i < size; i++){
        for (int j=0; j < size ; j++){
           if (grid[i][j] != Player.NOBODY && grid[i][j] == p){
               int count = 0;
               int temp = j;
               //Player ptemp = grid[i][j];
               while(temp < size && p == grid[i][temp]){
                   count++;
                   temp++;
               }
                       if (count == 3){
                    c1=this.unstep(p);
               }
               if (count == 4){
                    c1=this.unstep(p);
                    c2= this.unstep(p);
               }
           }
        if (grid[j][i] != Player.NOBODY && grid[j][i] == p){
               int count = 1;
               int temp = j+1;
               Player ptemp = grid[j][i];
               while(temp < size && p == grid[temp][i]){
                   count++;
                   temp++;
               }
               if (count == 3){
                    c1=this.unstep(ptemp);
               }
               if (count == 4){
                    c1=this.unstep(ptemp);
                    c2= this.unstep(ptemp);
               }   
        }
    }
    }
        for (int i = 0; i < size; i++){
        for (int j=0; j < size; j++){
            if (grid[i][j] != Player.NOBODY && p == grid[i][j]){
               int count = 1;
               int tempX = j-1;
               int tempY = i+1;
               Player ptemp = grid[i][j];
               while(tempX >= 0 && tempY >= 0 && tempY < size && ptemp == grid[tempY][tempX]){
                   count++;
                   tempX--;
                   tempY++;
               }
                              if (count == 3){
                    c1=this.unstep(ptemp);
               }
               if (count == 4){
                    c1=this.unstep(ptemp);
                    c2= this.unstep(ptemp);
               }
            }    
        }
     }
        for (int i = 0; i < size; i++){
        for (int j=0; j < size; j++){
            if (grid[i][j] != Player.NOBODY && p == grid[i][j] ){
               int count = 1;
               int tempX = j+1;
               int tempY = i+1;
               Player ptemp = grid[i][j];
               while(tempX < size && tempY < size && ptemp == grid[tempY][tempX]){
                   count++;
                   tempX++;
                   tempY++;
               }
                 if (count == 3){
                    c1=this.unstep(p);
               }
               if (count == 4){
                    c1=this.unstep(p);
                    c2= this.unstep(p);
               }
            }
        }
     }     
}
}
