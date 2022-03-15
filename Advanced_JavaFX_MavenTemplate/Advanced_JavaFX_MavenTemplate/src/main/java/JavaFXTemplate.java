import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class JavaFXTemplate extends Application {
	
	private static ArrayList<ToggleButton> list = new ArrayList<ToggleButton>();
	Scene startScene, gameScene, changed, current;
	private int i = 0, j = 0, k = 0, m = 0;

	Stage main;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		main = primaryStage;

		// Shows rules or odds based on user's choice)
		Text rules1 = new Text();
		VBox layout1 = new VBox(10);
		startScene = new Scene(layout1, 800, 800);

		// Menu
		Menu rules = new Menu("Rules");
		Menu odds = new Menu("Odds of Winning");
		Menu exit = new Menu("Exit");

		// Create a menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(rules, odds, exit);
		HBox menu = new HBox(20);
		menu.getChildren().add(menuBar);
		
		MenuItem confirmEx = new MenuItem("Confirm Exit");
		confirmEx.setOnAction(e -> main.close());
		
		
		MenuItem rule1 = new MenuItem("Rules");  //output Rules by click
		rule1.setOnAction((ActionEvent) -> {

			rules1.setText("The game of Keno is played by picking a set of numbers between 1 and 80. From there, 20 numbers are drawn randomly.\nIf the numbers drawn match the numbers you selected, you win. The amount of numbers you picked and how many of them you got right determine the amount of your payout.\n"
					+ "\n"
					+ "You do not need to match all 20 numbers to get the jackpot. The jackpots are usually awarded for a 9- or 10-number ticket in which all numbers were hit. On average, people usually play between 3-9 numbers.\n"
					+ "\n"
					+ "");
			rules1.setX(50);
			rules1.setY(50);


			current = startScene;
			main.setScene(changed);
		});
		
		
		
		MenuItem odd1 = new MenuItem("Odds");  //output Odds of Winning by click
		odd1.setOnAction((ActionEvent) -> {

			
		    rules1.setText("10 Spot Game: 1 in 9.05\n"
		    		+ "8 Spot Game: 1 in 9.77\n"
		    		+ "4 Spot Game: 1 in 3.86\n"
		    		+ "1 Spot Game: 1 in 4.00\n");
			rules1.setX(50);
			rules1.setY(50);

			current = startScene;
			main.setScene(changed);
		});

		// Adding Sub Menu
		exit.getItems().addAll(confirmEx);
		rules.getItems().addAll(rule1);
		odds.getItems().addAll(odd1);

		Button start1 = new Button("Start Game");
		start1.setOnAction(e -> main.setScene(gameScene));

		
		Label welcomeText = new Label("Welcome to Keno");
		welcomeText.setAlignment(Pos.BASELINE_CENTER);
		welcomeText.setStyle("-fx-font: 22px \"Serif\";");

		layout1.setStyle("-fx-padding: 5;");
		layout1.getChildren().addAll(menu, welcomeText, start1);

		// Game starts here

		VBox modern = new VBox(10);
		gameScene = new Scene(modern, 800, 800);
		
		Label checkBoxText = new Label("Random Input");
		CheckBox random = new CheckBox();
		random.setDisable(true);
		HBox checkBoxBox = new HBox(10);
		checkBoxBox.getChildren().addAll(checkBoxText, random);

		Label amountText = new Label("Amount");
		Label drawText = new Label("Draws");
		Label spotText = new Label("Spots");


		// Menu
		Menu rulesMenu2 = new Menu("Rules");
		Menu winOddsMenu2 = new Menu("Odds of Winning");
		Menu newLook2 = new Menu("New Look");
		Menu exitMenu2 = new Menu("Exit");

		// Sub Menu
		MenuItem exitConfirm2 = new MenuItem("Confirm Exit");
		exitConfirm2.setOnAction(e -> main.close());
		MenuItem rule2 = new MenuItem("Rules");
		rule2.setOnAction((ActionEvent) -> {
			rules1.setText("The game of Keno is played by picking a set of numbers between 1 and 80. From there, 20 numbers are drawn randomly.\nIf the numbers drawn match the numbers you selected, you win. The amount of numbers you picked and how many of them you got right determine the amount of your payout.\n"
					+ "\n"
					+ "You do not need to match all 20 numbers to get the jackpot. The jackpots are usually awarded for a 9- or 10-number ticket in which all numbers were hit. On average, people usually play between 3-9 numbers.\n"
					+ "\n"
					+ "");
			rules1.setX(50);
			rules1.setY(50);
			current = gameScene;
			main.setScene(changed);
		});
		
		
		MenuItem odd2 = new MenuItem("Odds");
		odd2.setOnAction((ActionEvent) -> {
		    rules1.setText("10 Spot Game: 1 in 9.05\n"
		    		+ "8 Spot Game: 1 in 9.77\n"
		    		+ "4 Spot Game: 1 in 3.86\n"
		    		+ "1 Spot Game: 1 in 4.00\n");
			rules1.setX(50);
			rules1.setY(50);
			current = gameScene;
			main.setScene(changed);
		});

		// Two flavors of look are provided
		MenuItem defaultLook = new MenuItem("Default");
		MenuItem modernLook = new MenuItem("Modern");

		// Menu Bar
		MenuBar menuBar2 = new MenuBar();
		menuBar2.getMenus().addAll(rulesMenu2, winOddsMenu2, newLook2, exitMenu2);

		// Placing Menu Bar in HBOX, to be placed at top of the window
		HBox menu2 = new HBox(20);
		menu2.getChildren().add(menuBar2);

		// Adding sub menu
		exitMenu2.getItems().addAll(exitConfirm2);
		newLook2.getItems().addAll(defaultLook, modernLook);
		rulesMenu2.getItems().addAll(rule2);
		winOddsMenu2.getItems().addAll(odd2);


		Button returnButton = new Button("Return");
		Button clearButton = new Button("Clear");
		Button draw = new Button("Draw");
		draw.setDisable(true);
		
		GameplayDriver.init_GameplayDriver(100);
		// Bet Amount
		
		
		// Set up Number of draws(1,2,3 or 4)
		RadioButton numDraw1 = new RadioButton("1");
		RadioButton numDraw2 = new RadioButton("2");
		RadioButton numDraw3 = new RadioButton("3");
		RadioButton numDraw4 = new RadioButton("4");
		ToggleGroup drawGroup = new ToggleGroup();
		numDraw1.setToggleGroup(drawGroup);
		numDraw2.setToggleGroup(drawGroup);
		numDraw3.setToggleGroup(drawGroup);
		numDraw4.setToggleGroup(drawGroup);
		drawGroup.selectToggle(numDraw1);
		numDraw1.setOnAction(e -> GameplayDriver.setRepeat(1));
		numDraw2.setOnAction(e -> GameplayDriver.setRepeat(2));
		numDraw3.setOnAction(e -> GameplayDriver.setRepeat(3));
		numDraw4.setOnAction(e -> GameplayDriver.setRepeat(4));
		HBox numDrawBox = new HBox(20, numDraw1, numDraw2, numDraw3, numDraw4);
		
		RadioButton bet1 = new RadioButton("$1");
		RadioButton bet2 = new RadioButton("$2");
		RadioButton bet3 = new RadioButton("$3");
		RadioButton bet5 = new RadioButton("$5");
		RadioButton bet10 = new RadioButton("$10");
		ToggleGroup betGroup = new ToggleGroup();
		bet1.setToggleGroup(betGroup);
		bet2.setToggleGroup(betGroup);
		bet3.setToggleGroup(betGroup);
		bet5.setToggleGroup(betGroup);
		bet10.setToggleGroup(betGroup);
		betGroup.selectToggle(bet1);  //default $1
		bet1.setOnAction(e -> GameplayDriver.setBet(1));
		bet2.setOnAction(e -> GameplayDriver.setBet(2));
		bet3.setOnAction(e -> GameplayDriver.setBet(3));
		bet5.setOnAction(e -> GameplayDriver.setBet(5));
		bet10.setOnAction(e -> GameplayDriver.setBet(10));
		HBox betBox = new HBox(20, bet1, bet2, bet3, bet5, bet10);


		// Spots
		RadioButton spot1 = new RadioButton("1");
		RadioButton spot4 = new RadioButton("4");
		RadioButton spot8 = new RadioButton("8");
		RadioButton spot10 = new RadioButton("10");
		ToggleGroup spotsGroup = new ToggleGroup();
		spot1.setToggleGroup(spotsGroup);
		spot4.setToggleGroup(spotsGroup);
		spot8.setToggleGroup(spotsGroup);
		spot10.setToggleGroup(spotsGroup);
		HBox spotBox = new HBox(20, spot1, spot4, spot8, spot10);

		// Create a Grid Pane to Hold Spots 1-80
		GridPane grid = new GridPane();
		grid.setDisable(true);  //disable grid until user chose number of spots(1,4,8,10)
		spot1.setOnAction((ActionEvent) -> {

			grid.setDisable(false);
			random.setDisable(false);
			draw.setDisable(false);
			GameplayDriver.reset();
			GameplayDriver.validNumSpots(1);
			spot1.setDisable(true);
			spot4.setDisable(true);
			spot8.setDisable(true);
			spot10.setDisable(true);
			

			
		});
		spot4.setOnAction((ActionEvent) -> {

			grid.setDisable(false);
			random.setDisable(false);
			draw.setDisable(false);
			GameplayDriver.reset();
			GameplayDriver.validNumSpots(4);
			grid.setDisable(false);
		});
		spot8.setOnAction((ActionEvent) -> {

			grid.setDisable(false);
			random.setDisable(false);
			draw.setDisable(false);
			GameplayDriver.reset();
			GameplayDriver.validNumSpots(8);

		});
		spot10.setOnAction((ActionEvent) -> {

			grid.setDisable(false);
			random.setDisable(false);
			draw.setDisable(false);
			GameplayDriver.reset();
			GameplayDriver.validNumSpots(10);
		});
		
		// Create 80 Buttons Dynamically
		for (i = 1; i < 81; i++) {
			ToggleButton number = new ToggleButton();
			number.setText(String.valueOf(i));
			number.setMinWidth(40);
			
			number.setOnAction((ActionEvent) -> {
				if (!number.isSelected()) {
					GameplayDriver.decSelected();
					GameplayDriver.removeNumberPlayerSelections(Integer.parseInt(number.getText()));
					number.setSelected(false);
				}
				
				else {
					if (GameplayDriver.incSelected()) {
						GameplayDriver.addNumberToPlayerSelections(Integer.parseInt(number.getText()));
						number.setSelected(true);
					}
					else {
						number.setSelected(false);
					}
				}
			});
			

			list.add(number);
			grid.add(number, j, k, 1, 1);

			j++;
			if (i % 8 == 0) {
				k++;
				j = 0;
			}

		}

		// Labels for Result History Tab
		Label choices = new Label("Numbers Chosen:");
		Label outputNumbers = new Label("");
		Label betText = new Label("Bet");
		Label bet = new Label("");
		Label totalBetText = new Label("Total Bet");
		Label totalBet = new Label("");

		Label numbersMatched = new Label("Matched Numbers");
		Label oneMatch = new Label("NULL");
		Label twoMatches = new Label("NULL");
		Label threeMatches = new Label("NULL");
		Label fourMatches = new Label("NULL");

		Label drawNoText = new Label("Draw");
		Label draw1 = new Label("1");
		Label draw2 = new Label("2");
		Label draw3 = new Label("3");
		Label draw4 = new Label("4");
		// Draw Output Label
		Label drawResult = new Label("Draw Result:");
		Label result = new Label("");
		Label amountWon = new Label("Amount Won:");
		Label total = new Label("");



		
		Label printOutput = new Label("Press Draw to Start");
		printOutput.setStyle("-fx-padding: 80; -fx-font: 20px \"Serif\";");


		HBox drawBox = new HBox(10);
		drawBox.getChildren().addAll(drawResult, result);  //Hbox that shows Draw Result
		
		Boolean buttonClicked = false;
		
		draw.setOnAction((ActionEvent) -> {
			if(buttonClicked ==false) {
				//buttonClicked = true;

			// check validity of inputs and remaining draws before proceeding
			if (GameplayDriver.readyToPlay()) {
				

				// Extracting numbers's text
				RadioButton selectedDraws = (RadioButton) drawGroup.getSelectedToggle();
				String draws = selectedDraws.getText();


				outputNumbers.setText(GameplayDriver.extractSelectionsString() );				
				bet.setText("$" + GameplayDriver.getBet());
				totalBet.setText("$" + GameplayDriver.getBet() * Integer.parseInt(draws));
				printOutput.setText("Waiting for Results...");
				
				GameplayDriver.findWinners();
				// Disable unnecessary tabs
				betBox.setDisable(true);
				spotBox.setDisable(true);
				numDrawBox.setDisable(true);
				grid.setDisable(true);
				draw.setDisable(true);
				returnButton.setDisable(true);
				clearButton.setDisable(true);
				random.setDisable(true);

				/*
				 * Adding Pause between Draws Threaded Execution, allows other functions to
				 * execute between drawings.
				 */

				 /*PauseTransition p1 = new PauseTransition(Duration.seconds(2));
				 PauseTransition p2 = new PauseTransition(Duration.seconds(2));
				 p1.setOnFinished(e -> {
				   //Do some UI change
				   p2.play();
				  });
				  p2.setOnFinished(e -> {
				   //Do some UI change
				   //If there is more things to display, make more PauseTransitions and call next chain pause here
				  });
				  
				  //After all the pauses are setup, queue the first pausetransition
				  p1.play();
				  */

				Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						
						result.setText(GameplayDriver.extractDrawingsString());
						
						GameplayDriver.findWinners();
						String temp = " " + GameplayDriver.calculateWinnings(GameplayDriver.getBet());
						total.setText("$" + temp);

						// Looping until all draws are complete(4,3,2,1)
						m++;
												
						if (m==1) {

							printOutput.setText("Next Draw");
							//System.out.println("Continue to next draw");
							if (Integer.parseInt(draws) == GameplayDriver.getRepeat()) {
								printOutput.setText("The End");
								draw.setDisable(true);
								returnButton.setDisable(false);
								clearButton.setDisable(false);
							} else {
								draw.setDisable(false);
							}
						}

							// Show results
							total.setText("$" + GameplayDriver.getWinnings());
							

						if (GameplayDriver.getRepeat() == 1) {
							//System.out.println("draw1");
							oneMatch.setText(GameplayDriver.getMatches());

						} else if (GameplayDriver.getRepeat() == 2) {
							//System.out.println("draw2");
							twoMatches.setText(GameplayDriver.getMatches());
						} else if (GameplayDriver.getRepeat() == 3) {
							
							//System.out.println("draw3");
							threeMatches.setText(GameplayDriver.getMatches());
						} else if (GameplayDriver.getRepeat() == 4) {
							
							//System.out.println("draw4");
							fourMatches.setText(GameplayDriver.getMatches());
						} else {
							
							throw new RuntimeException("Draw > 4 or < 1");
						}
						
						
						GameplayDriver.decRepeat();
						
						
						}
				
					} ));

				// Reset positions
				m = 0;
				GameplayDriver.reset();

				timeline.setCycleCount(GameplayDriver.getRepeat());  //Loop till draws=1(default)
				timeline.play();

			} else { //If we get here then user didn`t chose appropriate # of spots
				// More spots to chose
				String remains=GameplayDriver.remainingPicks();
				printOutput.setText(remains);
			}
			}
		});
		
	

		

		clearButton.setOnAction((ActionEvent) -> {
			i = 0;j = 0;k = 0;
			spot1.setDisable(false);
			spot4.setDisable(false);
			spot8.setDisable(false);
			spot10.setDisable(false);
			
			oneMatch.setText("NULL");
			twoMatches.setText("NULL");
			threeMatches.setText("NULL");
			fourMatches.setText("NULL");
			totalBet.setText("");
			bet.setText("");
			
			betGroup.selectToggle(bet1);
			drawGroup.selectToggle(numDraw1);
			spotsGroup.selectToggle(null);

			spotBox.setDisable(false);
			betBox.setDisable(false);
			numDrawBox.setDisable(false);
			
			draw.setDisable(true);
			random.setDisable(true);
			result.setText("");
			outputNumbers.setText("");
			total.setText("");


			// Enabling gridPane to fire
			grid.setDisable(false);
			// Reset all nodes
			for (i = 1; i <= 80; i++) {
				ToggleButton btn = new ToggleButton();
				btn = list.get(i - 1);
				if (btn.isSelected())
					btn.fire();
			}
			grid.setDisable(true);

			random.setDisable(false);
			if (random.isSelected())
				random.fire();
			random.setDisable(true);

			GameplayDriver.reset();
		});

		// On setting checkBox, manual input is restricted
		random.setOnAction((ActionEvent) -> {

			if (random.isSelected() == true) {
				RadioButton sRB = (RadioButton) spotsGroup.getSelectedToggle();
				String str = sRB.getText();
				GameplayDriver.autoPicks(Integer.parseInt(str));

				// Prevent manual input
				grid.setDisable(false);
				// Reset all nodes
				for (i = 1; i <= 80; i++) {
					ToggleButton btn = new ToggleButton();
					btn = list.get(i - 1);
					if (btn.isSelected())
						btn.fire();
				}
				grid.setDisable(true);

				spotBox.setDisable(true);

			} else {
				grid.setDisable(false);
				spotBox.setDisable(false);
			}

		});
		
		// Back Button Returns to Main Menu and Resets the Game
				returnButton.setOnAction((ActionEvent) -> {
					i = 0; j=0 ; k=0;

					oneMatch.setText("NULL");
					twoMatches.setText("NULL");
					threeMatches.setText("NULL");
					fourMatches.setText("NULL");
					totalBet.setText("");
					bet.setText("");
					
					draw.setDisable(true);
					result.setText("");
					outputNumbers.setText("");
					total.setText("");
					
					spotBox.setDisable(false);
					betBox.setDisable(false);
					numDrawBox.setDisable(false);
					betGroup.selectToggle(bet1);
					drawGroup.selectToggle(numDraw1);
					spotsGroup.selectToggle(null);



					// Enabling gridPane to fire
					grid.setDisable(false);
					// Reset all nodes
					for (i = 1; i <= 80; i++) {
						ToggleButton btn = new ToggleButton();
						btn = list.get(i - 1);
						if (btn.isSelected())
							btn.fire();
					}
					grid.setDisable(true);

					// Enabling checkBox to fire
					random.setDisable(false);
					if (random.isSelected())
						random.fire();
					random.setDisable(true);

					GameplayDriver.reset();

					// Go to Main Menu
					main.setScene(startScene);
				});


		VBox vbox1 = new VBox(10);
		VBox vbox2 = new VBox(10);
		VBox vbox3 = new VBox(10);
		HBox drawAndClear = new HBox(20);

		drawAndClear.getChildren().addAll(draw, clearButton);

		vbox1.getChildren().addAll(returnButton, amountText, betBox, drawText, numDrawBox, spotText, spotBox, grid,
				checkBoxBox, drawAndClear);

		// Displays history Tab (Right Window below Selected Choice)
		GridPane tab = new GridPane();
		tab.setHgap(30);
		tab.setVgap(10);

		tab.add(drawNoText, 0, 0, 1, 1);
		tab.add(numbersMatched, 2, 0, 1, 1);
		tab.add(amountWon, 3, 0, 1, 1);
		tab.add(total, 4, 0, 1, 1);

		tab.add(draw1, 0, 1, 1, 1);
		tab.add(draw2, 0, 2, 1, 1);
		tab.add(draw3, 0, 3, 1, 1);
		tab.add(draw4, 0, 4, 1, 1);
		
		tab.add(oneMatch, 2, 1, 1, 1);
		tab.add(twoMatches, 2, 2, 1, 1);
		tab.add(threeMatches, 2, 3, 1, 1);
		tab.add(fourMatches, 2, 4, 1, 1);


		HBox betTab = new HBox(20);
		betTab.getChildren().addAll(betText, bet, totalBetText, totalBet);

		vbox2.getChildren().addAll(choices, outputNumbers, betTab, tab, printOutput);

		vbox3.getChildren().addAll(drawBox, vbox2);

		HBox hbox12 = new HBox(30);
		hbox12.getChildren().addAll(vbox1, vbox3);

		modern.getChildren().addAll(menu2, hbox12);
		modern.setStyle("-fx-padding: 5;");

	    
		modernLook.setOnAction((ActionEvent) -> {  //Modern look using CSS format
			
			modern.setStyle("-fx-padding: 5; -fx-background-color: #a52a2a;");
			menuBar2.setStyle("-fx-background-color: #f0f8ff; -fx-font: 14px \"Serif\";");
			draw.setStyle("-fx-background-color: NAVY; -fx-text-fill: white;" + " -fx-font: 14px \"Serif\";");
			clearButton.setStyle("-fx-background-color: Black; -fx-text-fill: white;" + " -fx-font: 18px \"Serif\";");
			returnButton.setStyle("-fx-background-color: Black; -fx-text-fill: white;" + "-fx-font: 18px \"Serif\";");
			checkBoxText.setStyle("-fx-font: 14px \"Serif\"; -fx-font-style: italic;");
			amountText.setStyle("-fx-font: 14px \"Serif\"; -fx-font-style: italic;");
			drawText.setStyle("-fx-font: 14px \"Serif\"; -fx-font-style: italic;");
			spotText.setStyle("-fx-font: 14px \"Serif\"; -fx-font-style: italic;");
			vbox3.setStyle("-fx-font: 14px \"Serif\"; -fx-font-style: italic;");
			tab.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: White;");


			for (i = 1; i <= 80; i++) {
				ToggleButton btn = new ToggleButton();
				btn = list.get(i - 1);
				btn.setStyle("-fx-text-fill: Black; -fx-font: 14 \"Serif\"; -fx-border-color: White;");
			}

		});

		// Default look resets all CSS set by the Modern Look
		defaultLook.setOnAction((ActionEvent) -> {

			modern.setStyle("-fx-padding: 5;");
			menuBar2.setStyle(null);
			draw.setStyle(null);
			clearButton.setStyle(null);
			returnButton.setStyle(null);
			checkBoxText.setStyle(null);
			amountText.setStyle(null);
			drawText.setStyle(null);
			spotText.setStyle(null);
			vbox3.setStyle(null);
			tab.setStyle(null);


			for (i = 1; i <= 80; i++) {
				ToggleButton btn = new ToggleButton();
				btn = list.get(i - 1);
				btn.setStyle(null);
			}
		});

		/* Scene 3 Starts */
		VBox layout3 = new VBox(10);
		changed = new Scene(layout3, 800, 800);

		// Back Button Scene 3
		Button rulesreturnButton = new Button("Return");
		rulesreturnButton.setOnAction(e -> main.setScene(current));

		ScrollPane scrollArea1 = new ScrollPane();

		rules1.wrappingWidthProperty().bind(changed.widthProperty());
		scrollArea1.setFitToWidth(true);
		scrollArea1.setContent(rules1);

		layout3.getChildren().addAll(rulesreturnButton, scrollArea1);
		layout3.setStyle("-fx-padding: 5;");

		main.setScene(startScene);
		main.setTitle("KENO");
		main.show();
	}

	private int pattern(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	private String valueOf(int l) {
		// TODO Auto-generated method stub
		return null;
	}
}
