package mines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

//mines in JavaFx
public class MinesFX extends Application
{
	//default sizes
	private static final int LEFT_GRID_WIDTH = 180;
	private static final int LEFT_GRID_HEIGHT = 250;
	private static final int ROOT_PADDING = 10;
	private static final int BLOCK_SIZE = 45;
	private static final int BUTTON_GAP = 1;

	

	//showing new window containing the message
	private void popWindow(String titleMsg)
	{ 

		Stage noteStage = new Stage();
		VBox v1=new VBox();
		Label l1=new Label(titleMsg);
		v1.getChildren().add(l1);
		
		Scene scene=new Scene(v1);
		noteStage.setScene(scene);
		noteStage.setTitle("");
		noteStage.show();
		noteStage.setHeight(100);
		noteStage.setWidth(200);
		
	}
	
	//private 

	//used for looking for around places
	private int[][] dirDxDy = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };
	private Random rnd = new Random();
	private Stage primaryStage; //primary stage
	private StackPane rootLayout;
	private MinesFXController control; //controller
	private Mines mines;
	private List<Button> bombButtons = new ArrayList<>();
	
	// set start info
	private int curWidth = 15, curHeight = 15, curMines = 10;
	
	@Override
	public void start(Stage primaryStage) //start function
	{
		this.primaryStage = primaryStage;
		primaryStage.setTitle("The Amazing Mines Sweeper");
		primaryStage.setResizable(false);
		
		// Initializes the root layout
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("MinesFXOverview.fxml"));
			rootLayout = (StackPane) loader.load();
			
			rootLayout.setMinSize(LEFT_GRID_WIDTH, LEFT_GRID_HEIGHT);
			control = loader.getController();
			
			control.saveMain(this);
			
		} 
		catch(Exception e) 
		{ 
			e.printStackTrace(); 
		}

		buildMineField();
		showMineField();
	}
	
	// resets the game
	public void restart()
	{
		int tmpWidth = 0, tmpHeight = 0, tmpMines = 0;
		
		tmpWidth = control.getWidth();
		tmpHeight = control.getHeight();
		tmpMines = control.getMines();
		
		// update the info of board
		curWidth = tmpWidth;
		curHeight = tmpHeight;
		curMines = tmpMines;
		
		
		buildMineField();
		showMineField();
	}
	
	// builds a new board 
	public void buildMineField()
	{
		int width = curWidth;
		int heigth = curHeight;
		Button[][] place = new Button[heigth][width];
		GridPane mineField = new GridPane();
		mines = new Mines(heigth, width, curMines);
		mines.setShowAll(true);
		
		// Initialize mine field
		for (int i = 0 ; i < heigth; i++)
			for ( int j = 0 ; j < width ; j++)
			{
				Button btn = new Button(".");
				place[i][j] = btn;
				btn.setMinSize(BLOCK_SIZE, BLOCK_SIZE);
				btn.setPrefSize(BLOCK_SIZE, BLOCK_SIZE);
				btn.setMaxSize(BLOCK_SIZE, BLOCK_SIZE);
				btn.setAlignment(Pos.CENTER);
				btn.setFont(new Font("Arial",20));
				
				btn.setOnMouseClicked(handleButton(place, i, j));
				mineField.add(btn, j, i, 1, 1); //adding mine to board
				
				if (mines.get(i, j).equals("X"))
					bombButtons.add(btn); //adding mine to list of bombs
			}
		mines.setShowAll(false);
		mineField.setHgap(BUTTON_GAP);
		mineField.setVgap(BUTTON_GAP);
		control.setMineField(mineField);
	}
	
	// eventer function for buttons
	private EventHandler<MouseEvent> handleButton(Button[][] place, int i , int j)
	{
		
		return new EventHandler<MouseEvent>() 
		{ 
			@Override
            public void handle(MouseEvent e)
            {
				if (!mines.open(i, j))
					GameOver(place);
				else
				{
					openConnected(place, i, j);
					if (mines.isDone())
						GameWon(place);
				}
            }
		};
	}
	
	// open the neighbors around the point
	private void openConnected(Button[][] place, int x, int y)
	{
		int nx, ny;
		Button btn = place[x][y];
		String mark = mines.get(x, y);
		if (!mark.equals("F"))
		{
			btn.setText(mark);
			btn.setMouseTransparent(true);
			place[x][y] = null;
		}

		// (x,y) is empty so open nearby places
		if (mark.equals(" "))
		{
			btn.setVisible(false);
			for (int k = 0; k < 8; k++)
			{
				nx = x + dirDxDy[k][0];
				ny = y + dirDxDy[k][1];
				if (mines.isInBounds(nx, ny) && !mines.get(nx, ny).equals("X") && place[nx][ny] != null)
					openConnected(place,nx,ny);
			}
		}
	}
	
	// shows the mine field
	private void showMineField()
	{ // Show the scene containing the root layout
		try { 
			int sceneWidth = LEFT_GRID_WIDTH + curWidth * (BLOCK_SIZE + BUTTON_GAP) + ROOT_PADDING * 2;
			int sceneHeight =  curHeight * (BLOCK_SIZE + BUTTON_GAP) + ROOT_PADDING * 2;
			rootLayout.setPrefSize(sceneWidth, sceneHeight);
			if (primaryStage.getScene() == null)
			{
				Scene scene = new Scene(rootLayout);
				primaryStage.setScene(scene);
			}
			else
			{
				primaryStage.getScene().setRoot(rootLayout);
				primaryStage.sizeToScene();
			}
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// game over situation
	private void GameOver(Button[][] place)
	{
		for (Button[] btnRow : place)
			for (Button btn : btnRow)
				if (btn != null)
				{
					if (bombButtons.contains(btn))
					{
						btn.setText("");
					}
				}
		//game over window
		popWindow("GAME LOST!");
	}
	
	// game won situation
	private void GameWon(Button[][] place)
	{
		for (Button[] btnRow : place) 
			for (Button btn : btnRow)
				if (btn != null)
				{
					if (btn.getText() == ".")
					{
						btn.setText("");
					}
				}
		// game won window
		popWindow("GAME WON!");
	}
	
	//main function
	public static void main(String[] args) {
		launch(args);
	}
}
