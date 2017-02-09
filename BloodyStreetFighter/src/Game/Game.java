package Game;


import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Game extends Application {
	private Stage primaryStage;
	GoodGuy player = new GoodGuy(1);
	BadGuy badGuy = new BadGuy(player.getLevel());
	String ryu = new String("/Images/ryu_third_strike_hd_by_steamboy33-d4tcf9b.gif");
	String spider = new String("/Images/spidat.gif");
	String mummy = new String("/Images/Mummy_Zombie.gif");
	String alien = new String("/Images/green-alien-walking-b.gif");
	String cookie = new String("/Images/cookie-monster1-35823.gif");
	String smartGuy = new String("/Images/animated-fight-image-0025.gif");
	String zombie = new String("/Images/zombie.gif");
	final String []badPool = {ryu, spider, mummy, alien, cookie, smartGuy, zombie};
	Image fighter1;
	Image fighter2;

	public static void main(String[] args) {
		launch(args);
    
	}
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		
		
		intro();
	    
	}
	//this is the first page that will show up
	public void intro() {
		Pane pane = new Pane();
		Image background = new Image("/Images/cityBackground.jpg");
		Image title = new Image("/Images/StreetFighter.png"); 
		ImageView kenRyu = new ImageView("/Images/Ryu_and_ken_hadoken_double_hit.gif");
		
		
		// the graphics of Ken and Ryu in the intro
		kenRyu.setLayoutX(150);
		kenRyu.setLayoutY(300);
		kenRyu.setFitHeight(200);
		kenRyu.setFitWidth(500);
	    
		ImageView titleView = new ImageView(title);
	
		// this the path that the "Bloody" text will follow
		Line line1 = new Line();
	    line1.setStartX(400);
	    line1.setStartY(100);
	    line1.setEndX(370);
	    line1.setEndY(-25);
	    line1.setStroke(Color.RED);
	   	    
	    Text bloody = new Text("Bloody");
	    bloody.setFont(Font.font ("courier", 50));
	    bloody.setFill(Color.RED);
	    bloody.setLayoutY(100);
	    
	    // setting "Bloody" In motion
	    PathTransition pt = new PathTransition();
	    pt.setDuration(Duration.millis(4000));
	    pt.setPath(line1);
	    pt.setNode(bloody);
	    pt.setOrientation(
	    PathTransition.OrientationType.NONE);
	    
	    pt.play();
	    
	    titleView.setLayoutX(70);
	   
	    // creating Play Button
	    Button play = new Button("PLAY");
	    play.setMinWidth(100);
	    play.setMinHeight(50);
	    play.setLayoutX(350);
	    play.setLayoutY(450);
	    
	    // handler for "Play" button
	    play.setOnAction(e -> {
	    	// selects a bad guy
	    	fighter2 = new Image(badguySelection(badPool));
	    	
	    	// changes to the character Select Scene
	    	characterSelect();
		});
	    
	    
	    pane.getChildren().addAll(new ImageView(background), play, bloody, titleView, kenRyu);
	    Scene scene = new Scene(pane);
	    primaryStage.setTitle("Bloody Street Fighter"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	    
	} // end into scene method
	
	// this is the actual fight scene
	public void fightScene(){
	
	// rectangles the represent health bar
    Rectangle pmhp1 = new Rectangle(25, 10, 100, 15);
	Rectangle pmhp2 = new Rectangle(25, 10, 100, 15);
	Rectangle ph1 = new Rectangle(25, 10, 100, 15);
	Rectangle ph2 = new Rectangle(25, 10, 100, 15);
	
	// sets the width of player rectagle to the percentage equivalent
	ph1.setWidth(((double)player.getHitpoints()/player.getMaxHitpoints())*100);
	ph2.setWidth(((double)badGuy.getHitpoints()/badGuy.getMaxHitpoints())*100);
	
	
	Pane pane = new Pane();
    Image background = new Image("cityBackground.jpg");
   
    HBox fight = new HBox(70);// HBox with one fighter in each spot
    
    //healthbar and hitpoint amount
    VBox player1Status = new VBox();
    VBox player2Status = new VBox();
    
    Group progressBar1 = new Group();
	Group progressBar2 = new Group();
	
	HBox buttons = new HBox(10);
	Button hit = new Button("HIT");
    hit.setMinWidth(100);
    hit.setMinHeight(50);
    hit.setLayoutX(350);
    hit.setLayoutY(450);
	
    // heal button that shows how many heals are available
	Button heal = new Button("HEAL (" + player.getHeals() + ")");
    heal.setMinWidth(100);
    heal.setMinHeight(50);
    heal.setLayoutX(350);
    heal.setLayoutY(450);
	
	buttons.getChildren().addAll(hit, heal);
	//Text lvlNum = new Text("Level ");
	
	
	buttons.setLayoutX(300);
	buttons.setLayoutY(500);
	
	
	VBox player1 = new VBox(20);
	VBox player2 = new VBox(20);
	
	// sets location of each fighter
	ImageView f1 = new ImageView(fighter1);
	ImageView f2 = new ImageView(fighter2);
	
	f1.setFitHeight(250);
	f2.setFitHeight(250);
	f1.setFitWidth(125);
	f2.setFitWidth(125);
	fight.setLayoutY(200);
	fight.setLayoutX(250);
	
	// makes the health bars
	progressBar1.getChildren().addAll( pmhp1, ph1);
	progressBar2.getChildren().addAll(pmhp2, ph2);
	
	// changes the int hitpoints into a string
	String playerHPAmount = Integer.toString(player.getHitpoints());
	String badguyHPAmount = Integer.toString(badGuy.getHitpoints());
	Text pHP = new Text(playerHPAmount);
	Text bHP = new Text(badguyHPAmount);
	player1Status.getChildren().addAll(progressBar1, pHP);
	player2Status.getChildren().addAll(progressBar2, bHP);
	pHP.setFont(Font.font ("Courier", 20));
    pHP.setFill(Color.YELLOW);
    bHP.setFont(Font.font ("Courier", 20));
    bHP.setFill(Color.YELLOW);
	player1.getChildren().addAll(player1Status, f1);
	player2.getChildren().addAll(player2Status, f2);
    
    fight.getChildren().addAll(player1, player2);
	pmhp1.setStroke(Color.RED);
    pmhp1.setFill(Color.WHITE);
	pmhp2.setStroke(Color.RED);
    pmhp2.setFill(Color.WHITE);
    ph1.setStroke(Color.RED);
    ph1.setFill(Color.RED);
    ph2.setStroke(Color.BLUE);
    ph2.setFill(Color.BLUE);
    
    // shows the players level
    HBox yourLevel = new HBox();
    String lvl = Integer.toString(player.getLevel());
    yourLevel.getChildren().addAll(new Text("Your Level: "),new Text(lvl));
    yourLevel.setLayoutX(350);
    
	pane.getChildren().addAll( new ImageView(background), fight, buttons, yourLevel);
    
	// hit handler that figures how much the hit was for and refreshes the scene
	hit.setOnAction(e -> {
		hit();
		
		int hitAmount = player.getLevel() * hit();
		badGuy.setHitpoints(badGuy.getHitpoints() - hitAmount);
		
		
		if(badGuy.getHitpoints() > 0) {

			hitAmount = player.getLevel() * hit();
			player.setHitpoints(player.getHitpoints() - hitAmount);
				if (player.getHitpoints() > 0 ){
					fightScene();
				} else {
					gameOver();
				}
		} else {
			winnerScreen();
		}
		
		
		});// end hit handler
	
	// handler for heal that figures how much heal is for and refreshes scene
	heal.setOnAction(e -> {
		heal(); 
		
		int healAmount;
		
		if (player.getHeals() > 0) {
			healAmount = player.getLevel() * heal();
			
			player.setHeals(player.getHeals() - 1);
			player.setHitpoints(player.getHitpoints() + healAmount);
			}
		fightScene();
		}); //end heal handler
	
	Scene scene = new Scene(pane);
    
    primaryStage.setTitle("Bloody Street Fighter"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
	} // end fightScene method
	
	// decides how much the hit is for
	public static int hit () {
		int hit = (int)(Math.random() * 5);
		return hit;
	} //end hit method
	
	// decides how much to heal
	public static int heal() {
		int heal = (int)((Math.random() * 7) + 5); //cannot be lower than 5

		return heal;
	} //end heal method
	
	// if player wins the round
	public void winnerScreen() {
		Image background = new Image("/Images/cityBackground.jpg");
			
		    
		    Pane winnerPlayer = new Pane();
		    VBox winner = new VBox();
		    ImageView youWin = new ImageView(new Image("/Images/You-win.gif"));		    
		    ImageView stormTrooper = new ImageView(new Image("/Images/stormtrooper-dancing-animated-gif-win-rz.gif"));
		    
		    winner.getChildren().addAll(youWin, stormTrooper);
		    
		    winner.setLayoutX(250);
		    winner.setLayoutY(20);
		    
		    // button that lets player move to the next round
		    Button nextLevel = new Button("Play Level " + (player.getLevel() + 1));
		    
		    nextLevel.setMinWidth(100);
		    nextLevel.setMinHeight(50);
		    nextLevel.setLayoutX(150);
		    nextLevel.setLayoutY(450);
		    
		    HBox lvlComp = new HBox();
		    
		    String lvl = ("Level " + Integer.toString(player.getLevel()));
		    lvlComp.getChildren().addAll(new Text(lvl), new Text("Complete!!!"));
		    lvlComp.setLayoutX(350);
		  
		    winnerPlayer.getChildren().addAll(new ImageView(background),winner , nextLevel, lvlComp);
		    // handler that resets all the stats and increases the level
		    nextLevel.setOnAction(e -> {
		    	
		    	fighter2 = new Image(badguySelection(badPool));
		    	player.setLevel(player.getLevel() + 1);
		    	player.setMaxHitpoints(player.getLevel() * 25);
		    	badGuy.setMaxHitpoints(player.getLevel() * 27);
		    	player.setHitpoints(player.getMaxHitpoints());
		    	badGuy.setHitpoints(badGuy.getMaxHitpoints());
		    	player.setHeals(3);
		    	
		    	fightScene();
			});// end next level handler

		    
		    Scene scene = new Scene(winnerPlayer);
		    primaryStage.setTitle("Bloody Street Fighter"); // Set the stage title
		    primaryStage.setScene(scene); // Place the scene in the stage
		    primaryStage.show(); // Display the stage
		
		}// end winner screen scene
	
	// game over scene
	public void gameOver() {
		Image background = new Image("/Images/cityBackground.jpg");
		
	    Pane pane = new Pane();
	    Image gameOver = new Image("/Images/drax-gameover.gif");

	    ImageView youLost = new ImageView(gameOver);
	    youLost.setLayoutX(250);
	    youLost.setLayoutY(200);
	    Button newGame = new Button("New Game");
	    
	    // shows the highest level achieved
	    HBox highestLevel = new HBox();
	    String lvl = Integer.toString(player.getLevel());
	    highestLevel.getChildren().addAll(new Text("Highest Level: "),new Text(lvl));
	    highestLevel.setLayoutX(350);
	    
	    newGame.setMinWidth(100);
	    newGame.setMinHeight(50);
	    newGame.setLayoutX(350);
	    newGame.setLayoutY(450);
	  
	    pane.getChildren().addAll(new ImageView(background),youLost, newGame, highestLevel);
	    
	    // newGame button handler that resets all stats and returns to intro scene
	    newGame.setOnAction(e -> {
	    		
	    	player.setLevel( 1);
	    	player.setMaxHitpoints(player.getLevel() * 25);
	    	player.setHitpoints(player.getMaxHitpoints());
	    	player.setHeals(3);
	    	badGuy.setLevel(player.getLevel());
	    	badGuy.setMaxHitpoints(badGuy.getLevel() * 27);
	    	badGuy.setHitpoints(badGuy.getMaxHitpoints());
	    	
	    	intro();
		}); // end new Game handler

	    
	    Scene scene = new Scene(pane);
	    primaryStage.setTitle("Bloody Street Fighter"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	
	} // end gameOver scene
	
	// method to select the badguy model randomly
	public static String badguySelection(String[] badPool ) {
		int location = (int)(Math.random() * badPool.length);
		String badguy;
		badguy = badPool[location];
		return badguy;
	} // end bad guy selection
	
	// scene for character selection of good guy
	public void characterSelect() {
		Pane pane = new Pane();
		Image background = new Image("/Images/cityBackground.jpg");
		
		Pane characters = new HBox(20);
		ImageView ken = new ImageView( new Image("/Images/Ken_face.gif"));
		ImageView guile = new ImageView( new Image("/Images/guile_portrait.gif"));
		ImageView chunLi = new ImageView(new Image("/Images/Chun-li.gif"));
		ImageView dhalsim = new ImageView(new Image("/Images/Dhalsim_face.gif"));
		
		ken.setFitWidth(100);
		ken.setPreserveRatio(true);
		guile.setFitWidth(100);
		guile.setPreserveRatio(true);
		chunLi.setFitWidth(100);
		chunLi.setPreserveRatio(true);
		dhalsim.setFitWidth(100);
		dhalsim.setPreserveRatio(true);
		
		VBox characterSelection = new VBox(50);
		characterSelection.setLayoutX(200);
		characterSelection.setLayoutY(350);
		characters.getChildren().addAll(ken, guile, chunLi, dhalsim);
		
		Text select = new Text("Click on your Character.");
		characterSelection.getChildren().addAll( characters ,select);
		
		select.setFont(Font.font ("Courier", 20));
	  
		// handler to select Ken
		ken.setOnMousePressed(e -> {
			fighter1 = new Image("/Images/ken_idle_final_g.gif");
			fightScene();
			}); // end ken handler
		
		// handler to select Guile
		guile.setOnMousePressed(e -> {
			fighter1 = new Image("/Images/Guile-hdstance.gif");
			fightScene();
			}); //end Guile handler
		
		// handler to select Chun Li
		chunLi.setOnMousePressed(e -> {
			fighter1 = new Image("/Images/Chunli-hdstance.gif");
			fightScene();
			}); // end Chun Li handler
		
		// handler to select Dhalsim
		dhalsim.setOnMousePressed(e -> {
			fighter1 = new Image("/Images/Dhalsim-hdstance.gif");
			fightScene();
			}); // end Dhalsim handler

	    pane.getChildren().addAll(new ImageView(background), characterSelection);
	    Scene scene = new Scene(pane);
	    primaryStage.setTitle("Bloody Street Fighter"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	} // end character select scene
} // end Game
	

