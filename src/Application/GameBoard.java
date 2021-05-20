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
	public static Square[] gameSquareArray = new Square[28];
	public static Text  player1Label = new Text("Player 1\nMoney: " + Player.START_MONEY + "$");;
	public static Text  player2Label  = new Text("Player 2\nMoney: " + Player.START_MONEY + "$");;
	public GameBoard() {
		// TODO Auto-generated constructor stub
		initializeSqaureBoard();
		
		player1Label.setFont(new Font("Cordia New",20));
		player2Label.setFont(new Font("Cordia New",20));

		Square square0 = gameSquareArray[0];
		Square square1 = gameSquareArray[1];
		Square square2 = gameSquareArray[2];
		Square square3 = gameSquareArray[3];
		Square square4 = gameSquareArray[4];
		Square square5 = gameSquareArray[5];
		Square square6 = gameSquareArray[6];
		Square square7 = gameSquareArray[7];
		Square square8 = gameSquareArray[8];
		Square square9 = gameSquareArray[9];
		Square square10 = gameSquareArray[10];
		Square square11 = gameSquareArray[11];
		Square square12 = gameSquareArray[12];
		Square square13 = gameSquareArray[13];
		Square square14 = gameSquareArray[14];
		Square square15 = gameSquareArray[15];
		Square square16 = gameSquareArray[16];
		Square square17 = gameSquareArray[17];
		Square square18 = gameSquareArray[18];
		Square square19 = gameSquareArray[19];
		Square square20 = gameSquareArray[20];
		Square square21 = gameSquareArray[21];
		Square square22 = gameSquareArray[22];
		Square square23 = gameSquareArray[23];
		Square square24 = gameSquareArray[24];
		Square square25 = gameSquareArray[25];
		Square square26 = gameSquareArray[26];
		Square square27 = gameSquareArray[27];

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

		ImageView imageViewCharPlayer1 = GameLogic.player1.getCharacterImage();
		ImageView imageViewCharPlayer2 = GameLogic.player2.getCharacterImage();

		this.add(imageViewCharPlayer1, 7, 7);
		this.add(imageViewCharPlayer2, 7, 7);
		this.add( player1Label , 2, 2);
		this.add( player2Label , 5, 4);
		
		this.setBackground(new Background(new BackgroundFill(Color.web("#d4e8cd"), CornerRadii.EMPTY, Insets.EMPTY)));

		this.setValignment(imageViewCharPlayer1, VPos.BOTTOM);
		this.setHalignment(imageViewCharPlayer1, HPos.LEFT);

		this.setValignment(imageViewCharPlayer2, VPos.BOTTOM);
		this.setHalignment(imageViewCharPlayer2, HPos.RIGHT);

	}

	public void initializeSqaureBoard() {
		gameSquareArray[0] = new StartSquare();
		gameSquareArray[1] = new PropertySquare("Seoul", null, 100, "first");
		gameSquareArray[2] = new PropertySquare("Beijing", null, 130, "first");
		gameSquareArray[3] = new PropertySquare("Seville", null, 150, "first");
		gameSquareArray[4] = new PropertySquare("Vancouver", null, 150, "first");
		gameSquareArray[5] = new PropertySquare("Edinburgh", null, 170, "first");
		gameSquareArray[6] = new PropertySquare("Prague", null, 190, "first");
		gameSquareArray[7] = new JailSquare();
		gameSquareArray[8] = new PropertySquare("Tokyo", null, 210, "second");
		gameSquareArray[9] = new PropertySquare("Sydney", null, 210, "second");
		gameSquareArray[10] = new PropertySquare("ChiangMai", null, 230, "second");
		gameSquareArray[11] = new PropertySquare("Athens", null, 250, "second");
		gameSquareArray[12] = new PropertySquare("Dublin", null, 270, "second");
		gameSquareArray[13] = new PropertySquare("Zurich", null, 270, "second");
		gameSquareArray[14] = new CarParkSquare();
		gameSquareArray[15] = new PropertySquare("Dubai", null, 300, "third");
		gameSquareArray[16] = new PropertySquare("Madrid", null, 320, "third");
		gameSquareArray[17] = new PropertySquare("Chicago", null, 340, "third");
		gameSquareArray[18] = new PropertySquare("Quebec City", null, 350, "third");
		gameSquareArray[19] = new PropertySquare("Jerusalem", null, 360, "third");
		gameSquareArray[20] = new PropertySquare("Toronto", null, 370, "third");
		gameSquareArray[21] = new GoToJailSquare();
		gameSquareArray[22] = new PropertySquare("Vienna", null, 400, "fourth");
		gameSquareArray[23] = new PropertySquare("Tokyo", null, 410, "fourth");
		gameSquareArray[24] = new PropertySquare("Istanbul", null, 430, "fourth");
		gameSquareArray[25] = new PropertySquare("Budapest", null, 430, "fourth");
		gameSquareArray[26] = new PropertySquare("Munich", null, 450, "fourth");
		gameSquareArray[27] = new PropertySquare("Bangkok", null, 470, "fourth");

	}
}
