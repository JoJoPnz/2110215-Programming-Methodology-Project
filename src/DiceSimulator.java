
       
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.Random;

public class DiceSimulator extends Application
{
     private ImageView viewDie1 = new ImageView();
     private ImageView viewDie2 = new ImageView();
     private Label resultDie;
     private Label message1;
     private Label message2;
     
     public static void main(String[] args)
       {
          // Launch the application.
          launch(args);
       }
       
       @Override
       public void start(Stage primaryStage)
       {
           primaryStage.setTitle("Dice Simulator");
           Label message1 = new Label("Welcome to the Dice Simulator!");
           Label message2 = new Label("Please hit start to roll the dice!");
           
           resultDie = new Label();
           Button startButton = new Button("Start!");
           
           startButton.setOnAction(new StartButtonHandler()); 
           
           HBox hbox = new HBox(10, viewDie1, viewDie2);
           
           VBox vbox = new VBox(10, message1, message2, startButton, hbox, resultDie);
           vbox.setPadding(new Insets(15));
           vbox.setAlignment(Pos.CENTER);
           
           Scene simulatorScene = new Scene(vbox);
           primaryStage.setScene(simulatorScene);
           primaryStage.show();
           
           
       }
       
       class StartButtonHandler implements EventHandler<ActionEvent>
       {
           @Override
           public void handle(ActionEvent event)
           {
               int num1 = 0;
               int num2 = 0;
               Image diePic1; 
               Image diePic2;

               DieRoll dieI = new DieRoll();
               DieRoll dieII = new DieRoll();
               dieI.roll();
               dieII.roll();
               num1 = dieI.getRoll();
               num2 = dieII.getRoll();
               
               DieImages image1 = new DieImages();
               DieImages image2 = new DieImages();
               image1.setImage(num1);
               image1.setImage(num2);
               diePic1 = image1.getImage();
               diePic2 = image2.getImage();
               
               viewDie1 = new ImageView(diePic1);
               viewDie2 = new ImageView(diePic2);
               
               resultDie.setText("You rolled a " + num1 + " and " + num2 + "!");
           }
       }
       
         
}