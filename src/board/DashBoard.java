package board;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DashBoard extends GridPane {

	public DashBoard() {
		// TODO Auto-generated constructor stub
		//this.setSpacing(10);
		this.setPadding(new Insets(10, 10, 10, 10));
		HBox player1Vbox = new HBox();
		player1Vbox.setPadding(new Insets(10, 10, 10, 10));
		HBox player2Vbox = new HBox();
		player2Vbox.setSpacing(10);
		player1Vbox.setSpacing(10);
		player2Vbox.setPadding(new Insets(10, 10, 10, 10));
		Label player1Label = new Label("Player 1 Income:");
		Text player1Income = new Text("10");
		Text player2Income = new Text("10");
		player1Income.setFont(new Font("Cordia New", 30));
		player2Income.setFont(new Font("Cordia New", 30));
		Label player2Label = new Label("Player 2 Income:");
		player1Label.setFont(new Font("Cordia New", 30));
		player1Label.setAlignment(Pos.CENTER);
	
		player2Label.setFont(new Font("Cordia New", 30));
		player2Label.setAlignment(Pos.CENTER);
		player1Vbox.getChildren().addAll(player1Label,player1Income);
		player2Vbox.getChildren().addAll(player2Label,player2Income);
		
		this.setHgap(20);
		this.setVgap(20);
		this.add(player1Vbox, 0, 0);
		this.add(player2Vbox, 7, 7);
		this.setAlignment(Pos.CENTER);
	}

}
