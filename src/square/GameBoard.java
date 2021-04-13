package square;

import javafx.scene.layout.GridPane;
import property.Area;
import property.Property;

public class GameBoard extends GridPane {

	public GameBoard() {
		// TODO Auto-generated constructor stub
		Property area = new Area();
		Square square0 = new StartSquare();
		Square square1 = new PropertySquare("Seoul", area, 100,"first");
		Square square2 = new PropertySquare("Beijing", area, 130,"first");
		Square square3 = new PropertySquare("Seville", area, 150,"first");
		Square square4 = new PropertySquare("Vancouver", area, 150,"first");
		Square square5 = new PropertySquare("Edinburgh", area, 170,"first");
		Square square6 = new PropertySquare("Prague", area, 190,"first");
		//Square square7 = new PropertySquare("Kyoto", area, 210,"first");
		Square square7 = new JailSquare();
		//Square square8 = new PropertySquare("เรารักในหลวง", area, 100,"first");
		
		Square square8 = new PropertySquare("Tokyo", area, 210,"second");
		Square square9 = new PropertySquare("Sydney", area, 210,"second");
		Square square10 = new PropertySquare("ChiangMai", area, 230,"second");
		Square square11= new PropertySquare("Athens", area, 250,"second");
		Square square12 = new PropertySquare("Dublin", area, 270,"second");
		Square square13 = new PropertySquare("Zurich", area, 270,"second");
		//Square square15 = new PropertySquare("Kyoto", area, 210,"second");
		Square square14 = new CarParkSquare();
		/*
		 * Square square21 = new PropertySquare("เรารักในหลวง1",area,100); Square
		 * square20 = new PropertySquare("เรารักในหลวง2",area,100); Square square19 =
		 * new PropertySquare("เรารักในหลวง3",area,100); Square square18 = new
		 * PropertySquare("เรารักในหลวง4",area,100); Square square17 = new
		 * PropertySquare("เรารักในหลวง5",area,100); Square square22 = new
		 * GoToJailSquare();
		 */
		Square square15 = new PropertySquare("Seoul", area, 100,"third");
		Square square16 = new PropertySquare("Beijing", area, 130,"third");
		Square square17 = new PropertySquare("Seville", area, 150,"third");
		Square square18 = new PropertySquare("Vancouver", area, 150,"third");
		Square square19 = new PropertySquare("Edinburgh", area, 170,"third");
		Square square20 = new PropertySquare("Prague", area, 190,"third");
		//Square square15 = new PropertySquare("Kyoto", area, 210,"second");
		Square square21 = new GoToJailSquare();
		
		Square square22 = new PropertySquare("Seoul", area, 100,"fourth");
		Square square23 = new PropertySquare("Beijing", area, 130,"fourth");
		Square square24 = new PropertySquare("Seville", area, 150,"fourth");
		Square square25 = new PropertySquare("Vancouver", area, 150,"fourth");
		Square square26 = new PropertySquare("Edinburgh", area, 170,"fourth");
		Square square27 = new PropertySquare("Prague", area, 190,"fourth");
		
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
		this.add(square5,2,7);
		this.add(square4, 3, 7);
		this.add(square3, 4, 7);
		this.add(square2,5,7);
		this.add(square1, 6, 7);
		this.add(square0, 7, 7);
	}

}
