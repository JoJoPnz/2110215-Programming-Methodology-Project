import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage; 
import javafx.scene.shape.Rectangle;

public class RectangleExample extends Application { 
   @Override 
   public void start(Stage stage) { 
      //Drawing a Rectangle 
      Rectangle largeRectangle = new Rectangle();  
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
      
      smallRectangle.setFill(Color.BLUE);

      
      //Creating a Group object  
      Group root = new Group(largeRectangle,smallRectangle); 
         
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300);  
      
      //Setting title to the Stage 
      stage.setTitle("Drawing a Rectangle"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   }      
   
   public void createRectangle(int xPos,int yPos,int boxHeight,int boxWidth,Paint color,boolean isStroke) {
	   Rectangle rectangle = new Rectangle();
	      rectangle.setX(xPos); 
	      rectangle.setY(yPos); 
	      rectangle.setWidth(boxWidth); 
	      rectangle.setHeight(boxHeight);  
	      rectangle.setFill(color);
	      if (isStroke) {
	    	  rectangle.setStroke(Color.BLACK);
	      }
	      
	      
	   
   }
   public static void main(String args[]){ 
      launch(args); 
   } 
} 