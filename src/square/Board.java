package square;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos; 
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import property.Area;
import property.Property;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Board extends Application { 
   @Override 
   public void start(Stage stage) { 

	  Property area = new Area();
	 
	  HBox root = new HBox();
	  Square square1 = new PropertySquare("เรารักในหลวง",area,100);
	  Square square2 = new PropertySquare("เรารักในหลวง",area,100);
	  Square square3 = new PropertySquare("เรารักในหลวง",area,100);
	  Square square4 = new PropertySquare("เรารักในหลวง",area,100);
	  Square square5 = new PropertySquare("เรารักในหลวง",area,100);
	  Square square6 = new PropertySquare("เรารักในหลวง",area,100);
	  
	  root.getChildren().addAll(square1,square2,square3,square4,square5,square6);
      
      //Creating a scene object 
      Scene scene = new Scene(square1, 600, 300);  
      
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