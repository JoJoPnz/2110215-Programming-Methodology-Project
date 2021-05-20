package dice;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;

public class DiceImages {

    public static Image dice1 = new Image("dice1.png");
    public static Image dice2 = new Image("dice2.png");
    public static Image dice3 = new Image("dice3.png");
    public static Image dice4 = new Image("dice4.png");
    public static Image dice5 = new Image("dice5.png");
    public static Image dice6 = new Image("dice6.png");
    
    private Image diceImage = dice1;
    
    public DiceImages() {
    	
    }
    
    public void setImage(int value)
    {
        if(value == 1)
            diceImage = dice1;
        if(value == 2)
            diceImage = dice2;
        if(value == 3)
            diceImage = dice3;
        if(value == 4)
            diceImage = dice4;
        if(value == 5)
            diceImage = dice5;
        if(value == 6)
            diceImage = dice6;
    }
    
    public Image getImage()
    {
        return diceImage;
    }
}
