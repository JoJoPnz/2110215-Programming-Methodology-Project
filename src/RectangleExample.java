import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage; 
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class RectangleExample extends Application { 
   @Override 
   public void start(Stage stage) { 
      //Drawing a Rectangle 
      /*Rectangle largeRectangle = new Rectangle();  
      Rectangle smallRectangle = new Rectangle();  
      
      //Setting the properties of the rectangle 
      largeRectangle.setX(250.0f); 
      largeRectangle.setY(75.0f); 
      largeRectangle.setWidth(100.0f); 
      largeRectangle.setHeight(150.0f);  
      
      smallRectangle.setX(250.0f); 
      smallRectangle.setY(75.0f); 
      smallRectangle.setWidth(100.0f); 
      smallRectangle.setHeight(25.0f);
         
      largeRectangle.setFill(Color.WHITE);
      largeRectangle.setStroke(Color.BLACK);
      
      smallRectangle.setFill(Color.BLUE);*/
      
      Rectangle largeRectangle = createRectangle(200.0f,75.0f,150.0f,100.0f,Color.WHITE,true);
      Rectangle smallRectangle = createRectangle(250.0f,75.0f,25.0f,100.0f,Color.BLUE,true);
      
      GridPane gridPane = new GridPane();
      gridPane.setAlignment(Pos.CENTER);
      Text nameText = new Text("เรารักในหลวง");
      Text priceText = new Text("Price 112 \n Rent 44");

      
      gridPane.add(smallRectangle, 0, 0);
      gridPane.add(largeRectangle, 0,1);
      gridPane.setValignment(nameText, VPos.CENTER);
      gridPane.setHalignment(nameText,HPos.CENTER);
      
      //root.add(smallRectangle, 0, 1);
      gridPane.add(nameText, 0, 1);
      gridPane.add(priceText, 0, 1);
      
      gridPane.setValignment(priceText, VPos.BOTTOM);
      gridPane.setHalignment(priceText, HPos.CENTER);
      
      //Creating a scene object 
      Scene scene = new Scene(gridPane, 600, 300);  
      
      //Setting title to the Stage 
      stage.setTitle("Drawing a Rectangle"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
      
   }      
   
   public Rectangle createRectangle(float xPos,float yPos,float boxHeight,float boxWidth,Paint color,boolean isStroke) {
	   Rectangle rectangle = new Rectangle();
	      rectangle.setX(xPos); 
	      rectangle.setY(yPos); 
	      rectangle.setWidth(boxWidth); 
	      rectangle.setHeight(boxHeight);  
	      rectangle.setFill(color);
	      if (isStroke) {
	    	  rectangle.setStroke(Color.BLACK);
	      }
	      return rectangle;
	      
	   
   }
   public static void main(String args[]){ 
      launch(args); 
   } 
} 