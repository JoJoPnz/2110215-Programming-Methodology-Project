package board;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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

	public GameBoard() {
		// TODO Auto-generated constructor stub
		initializeSqaureBoard();
		
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
		
	
		
	}

	public void initializeSqaureBoard() {
		myArray[0] = new StartSquare();
		myArray[1] = new PropertySquare("Seoul", new Area(), 100, "first");
		myArray[2] = new PropertySquare("Beijing", new Area(), 130, "first");
		myArray[3] = new PropertySquare("Seville", new Area(), 150, "first");
		myArray[4] = new PropertySquare("Vancouver", new Area(), 150, "first");
		myArray[5] = new PropertySquare("Edinburgh", new Area(), 170, "first");
		myArray[6] = new PropertySquare("Prague", new Area(), 190, "first");
		myArray[7] = new JailSquare();
		myArray[8] = new PropertySquare("Tokyo", new Area(), 210, "second");
		myArray[9] = new PropertySquare("Sydney", new Area(), 210, "second");
		myArray[10] = new PropertySquare("ChiangMai", new Area(), 230, "second");
		myArray[11] = new PropertySquare("Athens", new Area(), 250, "second");
		myArray[12] = new PropertySquare("Dublin", new Area(), 270, "second");
		myArray[13] = new PropertySquare("Zurich", new Area(), 270, "second");
		myArray[14] = new CarParkSquare();
		myArray[15] = new PropertySquare("Dubai", new Area(), 300, "third");
		myArray[16] = new PropertySquare("Madrid", new Area(), 320, "third");
		myArray[17] = new PropertySquare("Chicago", new Area(), 340, "third");
		myArray[18] = new PropertySquare("Quebec City", new Area(), 350, "third");
		myArray[19] = new PropertySquare("Jerusalem", new Area(), 360, "third");
		myArray[20] = new PropertySquare("Toronto", new Area(), 370, "third");
		myArray[21] = new GoToJailSquare();
		myArray[22] = new PropertySquare("Vienna", new Area(), 400, "fourth");
		myArray[23] = new PropertySquare("Tokyo", new Area(), 410, "fourth");
		myArray[24] = new PropertySquare("Istanbul", new Area(), 430, "fourth");
		myArray[25] = new PropertySquare("Budapest", new Area(), 430, "fourth");
		myArray[26] =  new PropertySquare("Munich", new Area(), 450, "fourth");
		myArray[27] = new PropertySquare("Bangkok", new Area(), 470, "fourth");

	}
}
