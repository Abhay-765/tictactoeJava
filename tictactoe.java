/*
 * 
 * Assign board array empty strings
 * check to see which row and which column you clicked in when you click the screen
 * set board array position to X or Y accordingly
 * draw to screen the X or Y String for tic tac toe
 */

import java.awt. * ;
import java.applet. * ;
import java.util. * ;

import java.net.*;
import java.awt.event.KeyEvent;

public class TicTacToe extends Applet implements Runnable {
   Thread runner;
   Image Buffer;
   Graphics gBuffer;
    Image img; 
    String text="No Coords yet";
   
    int x=50;
    int y=50;
    int row;
    int col;
    boolean turn = false;
    int rowspot;
    int colspot;
    boolean gameReset=false;
    boolean [] [] taken = new boolean[3][3];
  
    String XX = "X";
    String YY = "O";
 String[][] board = new String[3][3];
  
   public void init() {//like a constructor method
       Buffer = createImage(size().width, size().height);
       gBuffer = Buffer.getGraphics();
       
       }   
   
  
   public void update(Graphics g) {
       paint(g);
   }
   public void paint(Graphics g) {
        gBuffer.setColor(Color.black);
       gBuffer.fillRect(0, 0, size().width, size().height);
       gBuffer.setColor(Color.blue);
      
       
        gBuffer.setColor(Color.gray);
       for (int x = 0; x < size().width; x += 100)
       gBuffer.drawLine(x, 0, x, size().height);
       for (int y = 0; y < size().height; y += 100)
       gBuffer.drawLine(0, y, size().width, y);
       
        gBuffer.setColor(Color.green);
        //gBuffer.drawString(text, 30, 30);
      
       
        x=50;
        y=50;
        
       for(int i=0; i<board.length; i++){
           for(int j=0; j<board.length; j++){
               if(board[i][j] != null){
                   gBuffer.drawString(" " + board[i][j], x, y);
                     
                }
               x+=100;
                
               
            }
           
           x=50;
           y+=100;
        }
        
        if(checkforwin() == 1){
            gBuffer.drawString("X Wins", 150, 280);
            if(gameReset==true){
             for(int i=0; i<board.length; i++){
                 for(int j=0; j<board.length; j++){
                     board[i][j]=null;
                 
                }
           }
        }
     }
        if(checkforwin() == 2){
            gBuffer.drawString("O Wins", 150, 280);
            if(gameReset==true){
            for(int i=0; i<board.length; i++){
                 for(int j=0; j<board.length; j++){
                     board[i][j]=null;
                 
                }
           }
         }
        }
        
        
         g.drawImage(Buffer, 0, 0, this);
   }
   
   
   
       
public void getCoordinates(int x, int y){
        if(turn==false){
            if(x<100 && y<100){
                rowspot = 0;
                colspot = 0;
                
            }
            
            if(x>100 && x<200 && y<100){
                rowspot = 0;
                colspot = 1;
                
            } 
            
             if(x>200 && x<300 && y<100){
                rowspot = 0;
                colspot = 2;
                
            } 
            
            if( x<100 && y>100 && y<200){
                rowspot = 1;
                colspot = 0;
                
            } 
            
            if( x>100 && x<200 && y>100 && y<200){
                
                rowspot = 1;
                colspot = 1;
                
            } 
            
            if( x>200 && x<300 && y>100 && y<200){
                rowspot = 1;
                colspot = 2;
                
            } 
            
            if( x<100 && y>200){
                
                rowspot = 2;
                colspot = 0;
                
            } 
            
            if( x>100 && x<200 && y>200){
                rowspot = 2;
                colspot = 1;
                
            } 
            
            if( x>200 && x<300 && y>200){
                rowspot = 2;
                colspot = 2;
                
            } 
        }
        if(turn == true){
            if(x<100 && y<100){
                
                rowspot = 0;
                colspot = 0;
                
            }
            
            if(x>100 && x<200 && y<100){
                rowspot = 0;
                colspot = 1;
                
            } 
            
             if(x>200 && x<300 && y<100){
                rowspot = 0;
                colspot = 2;
                
            } 
            
            if( x<100 && y>100 && y<200){
                rowspot = 1;
                colspot = 1;
            } 
            
            if( x>100 && x<200 && y>100 && y<200){
                rowspot = 1;
                colspot = 1;
                
            } 
            
            if( x>200 && x<300 && y>100 && y<200){
                rowspot = 1;
                colspot = 2;
                
            } 
            
            if( x<100 && y>200){
                rowspot = 2;
                colspot = 0;
                
            } 
            
            if( x>100 && x<200 && y>200){
               
                rowspot = 2;
                colspot = 1;
                
            } 
            
            if( x>200 && x<300 && y>200){
                rowspot=2;
                colspot=2;
                
            } 
            
        }
        
        
         if(turn==false){
            turn = true;
            text="X";
        } else{
            text="O";
            turn  = false;
        }
        
        if(taken[rowspot][colspot] == false){
            board[rowspot][colspot]= text;
            taken[rowspot][colspot] = true;
            checkforwin();
        }
         
        
    }
       
     //CODE HERE
     //set col and row to appropriate numbers accoding to the x and y coords
     
     public int checkforwin(){
         for(int i=0; i<3; i++){
                if(board[i][0] == board[i][1] && board[i][0] == board[i][2]){
                    if(board[i][0] == "X"){
                        return 1; // for x
                    }
                    
                    if(board[i][0] == "O"){
                        return 2; // for o
                    }
                }
                
                if(board[0][i] == board[1][i] && board[0][i] == board[2][i]){
                    if(board[0][i] == "X"){
                        return 1; // for x
                    }
                    
                    if(board[0][i] == "O"){
                        return 2; // for o
                    }
                }
               
                
            }
         
            if(board[0][0] == board [1][1] && board[1][1] == board[2][2]){
                    if(board[0][0] == "X"){
                        return 1; // for x
                    }
                    
                    if(board[0][0] == "O"){
                        return 2; // for 0
                    }
                }
                
                if(board[2][0] == board[1][1] && board[1][1] == board[0][2]){
                    if(board[0][2] == "X"){
                        return 1; // for x
                    }
                    
                    if(board[0][2] == "O"){
                        return 2; // for x
                    }
                }
                
                return 0;
                
        }
    
    
   
    
       public boolean mouseDown(Event e, int xx, int yy)//added(Event e, int x, int y)
       {
           
                  text = "" + xx + " " + yy;
               getCoordinates(xx,yy); 
              
      
      
       return true;
   }
   
   
   
   
   
  
    
    
   
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
     public boolean keyDown(Event e, int key)//added
{
    
   
    if(key == Event.ENTER)
    {
      gameReset=true;
    }
    return true;
}
    
   
    
    
    public void start() {
       if (runner == null) {
           runner = new Thread(this);
           runner.start();
       }
   }
   public void stop() {
       if (runner != null) {
           runner.stop();
           runner = null;
       }
   }
   public void run() {
       while (true) {
           //Thread sleeps for 10 milliseconds here
           try {
               runner.sleep(100);
            
           } catch (Exception e) {}
         
           repaint();
       }//end of while loop
   }
   
