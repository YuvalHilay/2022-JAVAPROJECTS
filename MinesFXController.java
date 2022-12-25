package mines;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

//class of controller
public class MinesFXController 
{
	@FXML
	private TextField widthText; //text field of width
	
	@FXML
	private TextField heightText; //text field of height
	
	@FXML
	private TextField minesText; //text field of mines
	
	@FXML
	private VBox fieldPlace; //vbox of filed
	
	private GridPane field; //gridBox of filed
	private MinesFX minesfx; //instance of main
	
	//defualt start
	private int amount = 10, prevWidth = 15, prevHeight = 15, prevMines = 10;
	
	//saving the board details
	public void setMineField(GridPane field)
	{ 
		if (this.field != null)
			fieldPlace.getChildren().remove(this.field);
		
		fieldPlace.setMaxSize(getHeight(), getWidth());
		fieldPlace.getChildren().add(this.field = field);
	}
	
	//getting the instance of the main
	public void saveMain(MinesFX minesfx)
	{ 
		this.minesfx = minesfx;
	}

	
	@FXML
	private void handleReset() //in case reset clicked
	{
		minesfx.restart();
		amount = getMines();
			
		prevWidth = Integer.parseInt(widthText.getText());
		prevHeight = Integer.parseInt(heightText.getText());
		prevMines = Integer.parseInt(minesText.getText());

	}
	
	//return width entered
	public int getWidth()
	{
		return Integer.parseInt(widthText.getText());
	}
	
	//return height entered
	public int getHeight()
	{
		return Integer.parseInt(heightText.getText());
	}
	
	//return number of mines entered
	public int getMines()
	{
		return Integer.parseInt(minesText.getText());
	}
}
