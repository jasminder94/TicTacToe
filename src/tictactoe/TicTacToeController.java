package tictactoe;

import java.awt.Toolkit;
import java.util.Random;
import java.util.Timer;
import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class TicTacToeController {
	
   @FXML Button b1; 
   @FXML Button b2;
   @FXML Button b3;
   @FXML Button b4;
   @FXML Button b5;
   @FXML Button b6;
   @FXML Button b7;
   @FXML Button b8;
   @FXML Button b9;
   @FXML Button b10;
   @FXML Button b11;
   @FXML Button b12;
   @FXML Button b13;
   int l=1,win=0,lose=0,tie=0;
   int temp2=0,s1=0,s2=0,s3=0;
   int temp3=0;
   int temp4,sum=0,sumc=0;
   @FXML GridPane gameBoard;
   Toolkit toolkit;
   Timer timer;
   
   private boolean isFirstPlayer = true;
   
   public void buttonClickHandler(ActionEvent evt){
	   
	    b10.getStyleClass().add("win");
	    b11.getStyleClass().add("lose");
	    b12.getStyleClass().add("tie");
	    b10.setText("WIN    "+win);
	    b11.setText("LOSE    "+lose);
	    b12.setText("TIE    "+tie);
		Button clickedButton = (Button) evt.getTarget();
		String buttonLabel = clickedButton.getText();
		if ("".equals(buttonLabel) && isFirstPlayer){
			clickedButton.setText(String.valueOf(l));
			temp2=l%2;
			sum=sum+l;
			l++;
			isFirstPlayer = false;
			find3InARow();
			if(l>9){
				isFirstPlayer = true;
			}
			if((s1>0 || s2>0 || s3>0) && (s1<l || s2<l || s3<l)){
				isFirstPlayer = true;
			}
		} 
		if(!isFirstPlayer){
			loopplay();
			find3InARow();
			}
   }	
  
private void loopplay() {
	String [] cps = {b1.getText(), b2.getText(), b3.getText(), b4.getText(),
			b5.getText(), b6.getText(), b7.getText(),
			b8.getText(), b9.getText()};
	Random random = new Random();
	int value = random.nextInt(cps.length);
	if( cps[value] == ""){
		switch(value){
		case 0: b1.setText(String.valueOf(l));
				temp3=l%2;
				sumc=sumc+l;
				l++;
				isFirstPlayer = true;
				break;
				
		case 1: b2.setText(String.valueOf(l));
		temp3=l%2;
		sumc=sumc+l;
		l++;
		isFirstPlayer = true;
		break;
		
		case 2: b3.setText(String.valueOf(l));
		temp3=l%2;
		sumc=sumc+l;
		l++;
		isFirstPlayer = true;
		break;
		
		case 3: b4.setText(String.valueOf(l));
		temp3=l%2;
		sumc=sumc+l;
		l++;
		isFirstPlayer = true;
		break;
		
		case 4: b5.setText(String.valueOf(l));
		temp3=l%2;
		sumc=sumc+l;
		l++;
		isFirstPlayer = true;
		break;
		
		case 5: b6.setText(String.valueOf(l));
		temp3=l%2;
		sumc=sumc+l;
		l++;
		isFirstPlayer = true;
		break;
		
		case 6: b7.setText(String.valueOf(l));
		temp3=l%2;
		sumc=sumc+l;
		l++;
		isFirstPlayer = true;
		break;
		
		case 7: b8.setText(String.valueOf(l));
		temp3=l%2;
		sumc=sumc+l;
		l++;
		isFirstPlayer = true;
		break;
		
		case 8: b9.setText(String.valueOf(l));
		temp3=l%2;
		sumc=sumc+l;
		l++;
		isFirstPlayer = true;
		break;
		}
		}
	else if(cps[value]!=""){
		loopplay();}
}



private boolean find3InARow(){
	   //Row 1
	   if (""!=b1.getText() && ""!=b2.getText() && ""!=b3.getText() &&
			   (Integer.parseInt(b1.getText())+Integer.parseInt(b2.getText())
			   +Integer.parseInt(b3.getText()))>=15 &&
			   ((Integer.parseInt(b1.getText())%2 == temp2 && 
			   Integer.parseInt(b2.getText())%2 == temp2 
			   && Integer.parseInt(b3.getText())%2 == temp2)
			   || (Integer.parseInt(b1.getText())%2 == temp3  && 
			   Integer.parseInt(b2.getText())%2 == temp3 && 
			   Integer.parseInt(b3.getText())%2 == temp3))){
		   porc();
		   highlightWinningCombo(b1,b2,b3);
		   return true;
	   }
	   //Row 2
	   if (""!=b4.getText() && ""!=b5.getText() && ""!=b6.getText() 
		   && (Integer.parseInt(b4.getText())+Integer.parseInt(b5.getText())
		   +Integer.parseInt(b6.getText()))>=15 && ((Integer.parseInt(b4.getText())%2 == temp2 && 
				   Integer.parseInt(b5.getText())%2 == temp2 
				   && Integer.parseInt(b6.getText())%2 == temp2)
				   || (Integer.parseInt(b4.getText())%2 == temp3  && 
				   Integer.parseInt(b5.getText())%2 == temp3 && 
				   Integer.parseInt(b6.getText())%2 == temp3))){
		   porc();
		   highlightWinningCombo(b4,b5,b6);
		   return true;
	   }
	   //Row 3
	   if (""!=b7.getText() && ""!=b8.getText() && ""!=b9.getText()
		   && (Integer.parseInt(b7.getText())+Integer.parseInt(b8.getText())
		   +Integer.parseInt(b9.getText()))>=15 &&  ((Integer.parseInt(b7.getText())%2 == temp2 && 
				   Integer.parseInt(b8.getText())%2 == temp2 
				   && Integer.parseInt(b9.getText())%2 == temp2)
				   || (Integer.parseInt(b7.getText())%2 == temp3  && 
				   Integer.parseInt(b8.getText())%2 == temp3 && 
				   Integer.parseInt(b9.getText())%2 == temp3))){
		   porc();
		   highlightWinningCombo(b7,b8,b9);
		   return true;
	   }
	   //Column 1
	   if (""!=b1.getText() && ""!=b4.getText() && ""!=b7.getText()
		   && (Integer.parseInt(b1.getText())+Integer.parseInt(b4.getText())
		   +Integer.parseInt(b7.getText()))>=15 && ((Integer.parseInt(b1.getText())%2 == temp2 && 
				   Integer.parseInt(b4.getText())%2 == temp2 
				   && Integer.parseInt(b7.getText())%2 == temp2)
				   || (Integer.parseInt(b1.getText())%2 == temp3  && 
				   Integer.parseInt(b4.getText())%2 == temp3 && 
				   Integer.parseInt(b7.getText())%2 == temp3))){
		   porc();
		   highlightWinningCombo(b1,b4,b7);
		   return true;
	   }
	   //Column 2
	   if (""!=b2.getText() && ""!=b5.getText() && ""!=b8.getText() 
		   && ((Integer.parseInt(b2.getText())%2 == temp2 &&
				   (Integer.parseInt(b2.getText())+Integer.parseInt(b5.getText())
				   +Integer.parseInt(b8.getText()))>=15 &&
				   Integer.parseInt(b5.getText())%2 == temp2 
				   && Integer.parseInt(b8.getText())%2 == temp2)
				   || (Integer.parseInt(b2.getText())%2 == temp3  && 
				   Integer.parseInt(b5.getText())%2 == temp3 && 
				   Integer.parseInt(b8.getText())%2 == temp3))){
		   porc();
		   highlightWinningCombo(b2,b5,b8);
		   return true;
	   }
	   //Column 3
	   if (""!=b3.getText() && ""!=b6.getText() && ""!=b9.getText()
		   && (Integer.parseInt(b3.getText())+Integer.parseInt(b6.getText())
		   +Integer.parseInt(b9.getText()))>=15 && ((Integer.parseInt(b3.getText())%2 == temp2 && 
				   Integer.parseInt(b6.getText())%2 == temp2 
				   && Integer.parseInt(b9.getText())%2 == temp2)
				   || (Integer.parseInt(b3.getText())%2 == temp3  && 
				   Integer.parseInt(b6.getText())%2 == temp3 && 
				   Integer.parseInt(b9.getText())%2 == temp3))){
		   porc();
		   highlightWinningCombo(b3,b6,b9);
		   return true;
	   }
	   //Diagonal 1
	   if (""!=b1.getText() && ""!=b5.getText() && ""!=b9.getText()
		   && (Integer.parseInt(b1.getText())+Integer.parseInt(b5.getText())
		   +Integer.parseInt(b9.getText()))>=15 && ((Integer.parseInt(b1.getText())%2 == temp2 && 
				   Integer.parseInt(b5.getText())%2 == temp2 
				   && Integer.parseInt(b9.getText())%2 == temp2)
				   || (Integer.parseInt(b1.getText())%2 == temp3  && 
				   Integer.parseInt(b5.getText())%2 == temp3 && 
				   Integer.parseInt(b9.getText())%2 == temp3))){
		   porc();
		   highlightWinningCombo(b1,b5,b9);
		   return true;
	   }
	   //Diagonal 2
	   if (""!=b3.getText() && ""!=b5.getText() && ""!=b7.getText()
		   &&  (Integer.parseInt(b3.getText())+Integer.parseInt(b5.getText())
		   +Integer.parseInt(b7.getText()))>=15 &&((Integer.parseInt(b3.getText())%2 == temp2 && 
				   Integer.parseInt(b5.getText())%2 == temp2 
				   && Integer.parseInt(b7.getText())%2 == temp2)
				   || (Integer.parseInt(b3.getText())%2 == temp3  && 
				   Integer.parseInt(b5.getText())%2 == temp3 && 
				   Integer.parseInt(b7.getText())%2 == temp3))){
		   porc();
		   highlightWinningCombo(b3,b5,b7);
		   return true;
	   }	   
	   if(l==10){
		   b13.setText("Tie");
		   tie++;
		   s1=l;
	   }
	   return false;
   }
   
   private void porc() {
	   b13.getStyleClass().add("youwin");
	   if(l%2==0 && sum>=15){
		   b13.setText("You Won");
	   }
	   if(l%2!=0 && sumc>=15){
	   b13.setText("You Lose");
	   }
   }


private void highlightWinningCombo(Button first, Button second, Button third){
       first.getStyleClass().add("winning-button");
       second.getStyleClass().add("winning-button");
       third.getStyleClass().add("winning-button");
       winorlose();

   }
   
   private void winorlose() {
	   if(l%2==0 && sum>=15){
		   		win++;
		   		s2=l;
		   		l=1;
		   }
	   
	   else if(l%2!=0 && sum>=15) {
		   lose++;
		   s3=l;
		   l=1;
		   }
   }


public void menuClickHandler(ActionEvent evt){
		MenuItem clickedMenu = (MenuItem) evt.getTarget();
		String menuLabel = clickedMenu.getText();
		
		if ("Play Again?".equals(menuLabel)){
			ObservableList<Node> buttons = 
					gameBoard.getChildren();
			
			buttons.forEach(btn -> {
				((Button) btn).setText("");
				 btn.getStyleClass().remove("winning-button");
				 l=1;
				 sum=0;
				 sumc=0;
			});
			s1=0;s2=0;s3=0;
			b10.getStyleClass().add("win");
		 	b11.getStyleClass().add("lose");
		    b12.getStyleClass().add("tie");
		    b10.setText("WIN    "+win);
		    b11.setText("LOSE    "+lose);
		    b12.setText("TIE    "+tie);
			isFirstPlayer = true;
		}
   }
   public void exit(){
	   System.exit(0);
   }  
}