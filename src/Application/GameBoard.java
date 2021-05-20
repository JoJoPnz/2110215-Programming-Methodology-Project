package Application;

import java.util.ArrayList;

import Logic.GameLogic;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import player.Player;
import property.Area;
import property.Property;
import square.CarParkSquare;
import square.GoToJailSquare;
import square.JailSquare;
import square.PropertySquare;
import square.Square;
import square.StartSquare;

public class GameBoard extends GridPane {
	public static Square[] myArray = new Square[28];
	public static Text  player1Label = new Text("Player 1\nMoney: " + Player.START_MONEY + "$");;
	public static Text  player2Label  = new Text("Player 2\nMoney: " + Player.START_MONEY + "$");;
	public GameBoard() {
		// TODO Auto-generated constructor stub
		initializeSqaureBoard();
		
		player1Label.setFont(new Font("Cordia New",20));
		player2Label.setFont(new Font("Cordia New",20));

		Square square0 = myArray[0];
		Square square1 = myArray[1];
		Square square2 = myArray[2];
		Square square3 = myArray[3];
		Square square4 = myArray[4];
		Square square5 = myArray[5];
		Square square6 = myArray[6];
		Square square7 = myArray[7];
		Square square8 = myArray[8];
		Square square9 = myArray[9];
		Square square10 = myArray[10];
		Square square11 = myArray[11];
		Square square12 = myArray[12];
		Square square13 = myArray[13];
		Square square14 = myArray[14];
		Square square15 = myArray[15];
		Square square16 = myArray[16];
		Square square17 = myArray[17];
		Square square18 = myArray[18];
		Square square19 = myArray[19];
		Square square20 = myArray[20];
		Square square21 = myArray[21];
		Square square22 = myArray[22];
		Square square23 = myArray[23];
		Square square24 = myArray[24];
		Square square25 = myArray[25];
		Square square26 = myArray[26];
		Square square27 = myArray[27];

		this.add(square27, 7, 6);
		this.add(square26, 7, 5);
		this.add(square25, 7, 4);
		this.add(square24, 7, 3);
		this.add(square23, 7, 2);
		this.add(square22, 7, 1);
		this.add(square21, 7, 0);
		this.add(square20, 6, 0);
		this.add(square19, 5, 0);
		this.add(square18, 4, 0);
		this.add(square17, 3, 0);
		this.add(square16, 2, 0);
		this.add(square15, 1, 0);
		this.add(square14, 0, 0);
		this.add(square13, 0, 1);
		this.add(square12, 0, 2);
		this.add(square11, 0, 3);
		this.add(square10, 0, 4);
		this.add(square9, 0, 5);
		this.add(square8, 0, 6);
		this.add(square7, 0, 7);
		this.add(square6, 1, 7);
		this.add(square5, 2, 7);
		this.add(square4, 3, 7);
		this.add(square3, 4, 7);
		this.add(square2, 5, 7);
		this.add(square1, 6, 7);
		this.add(square0, 7, 7);
		//this.add(player1Vbox, 3, 5);
		//this.add(player2Vbox, 4, 5);

		// initialize start position

		ImageView imageViewCharPlayer1 = GameLogic.player1.getCharacterImage();
		ImageView imageViewCharPlayer2 = GameLogic.player2.getCharacterImage();

		this.add(imageViewCharPlayer1, 7, 7);
		this.add(imageViewCharPlayer2, 7, 7);
		this.add( player1Label , 2, 2);
		//this.add(player1IncomeText, 2, 2);
		this.add( player2Label , 5, 4);
		//this.add(player2IncomeText, 4, 5);
		this.setBackground(new Background(new BackgroundFill(Color.web("#d4e8cd"), CornerRadii.EMPTY, Insets.EMPTY)));

		this.setValignment(imageViewCharPlayer1, VPos.BOTTOM);
		this.setHalignment(imageViewCharPlayer1, HPos.LEFT);

		this.setValignment(imageViewCharPlayer2, VPos.BOTTOM);
		this.setHalignment(imageViewCharPlayer2, HPos.RIGHT);

	}

	public void initializeSqaureBoard() {
		myArray[0] = new StartSquare();
		myArray[1] = new PropertySquare("Seoul", null, 100, "first");
		myArray[2] = new PropertySquare("Beijing", null, 130, "first");
		myArray[3] = new PropertySquare("Seville", null, 150, "first");
		myArray[4] = new PropertySquare("Vancouver", null, 150, "first");
		myArray[5] = new PropertySquare("Edinburgh", null, 170, "first");
		myArray[6] = new PropertySquare("Prague", null, 190, "first");
		myArray[7] = new JailSquare();
		myArray[8] = new PropertySquare("Tokyo", null, 210, "second");
		myArray[9] = new PropertySquare("Sydney", null, 210, "second");
		myArray[10] = new PropertySquare("ChiangMai", null, 230, "second");
		myArray[11] = new PropertySquare("Athens", null, 250, "second");
		myArray[12] = new PropertySquare("Dublin", null, 270, "second");
		myArray[13] = new PropertySquare("Zurich", null, 270, "second");
		myArray[14] = new CarParkSquare();
		myArray[15] = new PropertySquare("Dubai", null, 300, "third");
		myArray[16] = new PropertySquare("Madrid", null, 320, "third");
		myArray[17] = new PropertySquare("Chicago", null, 340, "third");
		myArray[18] = new PropertySquare("Quebec City", null, 350, "third");
		myArray[19] = new PropertySquare("Jerusalem", null, 360, "third");
		myArray[20] = new PropertySquare("Toronto", null, 370, "third");
		myArray[21] = new GoToJailSquare();
		myArray[22] = new PropertySquare("Vienna", null, 400, "fourth");
		myArray[23] = new PropertySquare("Tokyo", null, 410, "fourth");
		myArray[24] = new PropertySquare("Istanbul", null, 430, "fourth");
		myArray[25] = new PropertySquare("Budapest", null, 430, "fourth");
		myArray[26] = new PropertySquare("Munich", null, 450, "fourth");
		myArray[27] = new PropertySquare("Bangkok", null, 470, "fourth");

	}
}
