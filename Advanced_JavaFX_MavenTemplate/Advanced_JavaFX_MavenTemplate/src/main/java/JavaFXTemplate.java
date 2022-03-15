import java.io.IOException;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class JavaFXTemplate extends Application {

	Stage window;
	Scene scene1, scene2, scene3, currentScene;

	private int i = 0, j = 0, k = 0, m = 0;

	private static ArrayList<ToggleButton> tglist = new ArrayList<ToggleButton>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		// Scene 3 Text (Shows rules or odds based on user's choice)
		Text text1 = new Text();

		/* Scene 1 Starts */
		VBox layout1 = new VBox(10);
		scene1 = new Scene(layout1, 800, 640);

		// Menu
		Menu rules = new Menu("Rules");
		Menu odds = new Menu("Odds of Winning");
		Menu exitMenu = new Menu("Exit");

		// Create a menu bar
		MenuBar menuBar = new MenuBar();
		// Add menus to a menu bar
		menuBar.getMenus().addAll(rules, odds, exitMenu);

		// Create the Menu Box
		HBox menu = new HBox(20);
		// Add the MenuBar to the Menu Box
		menu.getChildren().add(menuBar);

		// Sub Menu
		MenuItem exitConfirm = new MenuItem("Confirm Exit");
		exitConfirm.setOnAction(e -> window.close());
		MenuItem rule1 = new MenuItem("Rules");
		rule1.setOnAction((ActionEvent) -> {

			text1.setText("The game of Keno is played by picking a set of numbers between 1 and 80. From there, 20 numbers are drawn randomly.\nIf the numbers drawn match the numbers you selected, you win. The amount of numbers you picked and how many of them you got right determine the amount of your payout.\n"
					+ "\n"
					+ "You do not need to match all 20 numbers to get the jackpot. The jackpots are usually awarded for a 9- or 10-number ticket in which all numbers were hit. On average, people usually play between 3-9 numbers.\n"
					+ "\n"
					+ "");
			text1.setX(50);
			text1.setY(50);


			currentScene = scene1;
			window.setScene(scene3);
		});
		MenuItem odd1 = new MenuItem("Odds");
		odd1.setOnAction((ActionEvent) -> {

			
		    text1.setText("10 Spot Game: 1 in 9.05\n"
		    		+ "8 Spot Game: 1 in 9.77\n"
		    		+ "4 Spot Game: 1 in 3.86\n"
		    		+ "1 Spot Game: 1 in 4.00\n");
			text1.setX(50);
			text1.setY(50);

			currentScene = scene1;
			window.setScene(scene3);
		});

		// Adding Sub Menu
		exitMenu.getItems().addAll(exitConfirm);
		rules.getItems().addAll(rule1);
		odds.getItems().addAll(odd1);

		// Button 1
		Button button1 = new Button("Start Game");
		button1.setOnAction(e -> window.setScene(scene2));

		// Welcome
		Label welcomeText = new Label("Welcome to Keno");
		welcomeText.setAlignment(Pos.BASELINE_CENTER);
		welcomeText.setStyle("-fx-font: 24px \"Serif\";");

		layout1.setStyle("-fx-padding: 5;");
		layout1.getChildren().addAll(menu, welcomeText, button1);

		/* Scene 2 Starts */

		VBox layout2 = new VBox(10);
		scene2 = new Scene(layout2, 800, 640);

		// Texts
		Label amountText = new Label("Amount");
		Label drawText = new Label("Draws");
		Label spotText = new Label("Spots");

		// Random input CheckBox
		Label checkBoxText = new Label("Random Input");
		CheckBox randomBox = new CheckBox();
		randomBox.setDisable(true);
		HBox checkBoxBox = new HBox(10);
		checkBoxBox.getChildren().addAll(checkBoxText, randomBox);

		// Menu
		Menu rulesMenu2 = new Menu("Rules");
		Menu winOddsMenu2 = new Menu("Odds of Winning");
		Menu newLook2 = new Menu("New Look");
		Menu exitMenu2 = new Menu("Exit");

		// Sub Menu
		MenuItem exitConfirm2 = new MenuItem("Confirm Exit");
		exitConfirm2.setOnAction(e -> window.close());
		MenuItem rule2 = new MenuItem("Rules");
		rule2.setOnAction((ActionEvent) -> {
			text1.setText("The game of Keno is played by picking a set of numbers between 1 and 80. From there, 20 numbers are drawn randomly.\nIf the numbers drawn match the numbers you selected, you win. The amount of numbers you picked and how many of them you got right determine the amount of your payout.\n"
					+ "\n"
					+ "You do not need to match all 20 numbers to get the jackpot. The jackpots are usually awarded for a 9- or 10-number ticket in which all numbers were hit. On average, people usually play between 3-9 numbers.\n"
					+ "\n"
					+ "");
			text1.setX(50);
			text1.setY(50);
			currentScene = scene2;
			window.setScene(scene3);
		});
		MenuItem odd2 = new MenuItem("Odds");
		odd2.setOnAction((ActionEvent) -> {
		    text1.setText("10 Spot Game: 1 in 9.05\n"
		    		+ "8 Spot Game: 1 in 9.77\n"
		    		+ "4 Spot Game: 1 in 3.86\n"
		    		+ "1 Spot Game: 1 in 4.00\n");
			text1.setX(50);
			text1.setY(50);
			currentScene = scene2;
			window.setScene(scene3);
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

		// Back Button
		Button returnButton = new Button("Back");

		// Clear Button
		Button clearButton = new Button("Clear");

		// Draw Button
		Button draw = new Button("Draw");
		draw.setDisable(true);
		
		GameplayDriver.init_GameplayDriver(100);
		// Bet Amount
		RadioButton bet1 = new RadioButton("$1");
		RadioButton bet2 = new RadioButton("$2");
		RadioButton bet3 = new RadioButton("$3");
		RadioButton bet5 = new RadioButton("$5");
		RadioButton bet10 = new RadioButton("$10");

		// Spot ToggleGroup
		ToggleGroup betGroup = new ToggleGroup();

		// Assigning Toggle Group
		bet1.setToggleGroup(betGroup);
		bet2.setToggleGroup(betGroup);
		bet3.setToggleGroup(betGroup);
		bet5.setToggleGroup(betGroup);
		bet10.setToggleGroup(betGroup);

		// Set Default amount to $1
		betGroup.selectToggle(bet1);

		// Set No. of Draws
		bet1.setOnAction(e -> GameplayDriver.setBet(1));
		bet2.setOnAction(e -> GameplayDriver.setBet(2));
		bet3.setOnAction(e -> GameplayDriver.setBet(3));
		bet5.setOnAction(e -> GameplayDriver.setBet(5));
		bet10.setOnAction(e -> GameplayDriver.setBet(10));

		// No. of Drawings Holder
		HBox amountBox = new HBox(20, bet1, bet2, bet3, bet5, bet10);

		// No. of Drawings
		RadioButton numDraw1 = new RadioButton("1");
		RadioButton numDraw2 = new RadioButton("2");
		RadioButton numDraw3 = new RadioButton("3");
		RadioButton numDraw4 = new RadioButton("4");

		// Spot ToggleGroup
		ToggleGroup drawGroup = new ToggleGroup();

		// Assigning Toggle Group
		numDraw1.setToggleGroup(drawGroup);
		numDraw2.setToggleGroup(drawGroup);
		numDraw3.setToggleGroup(drawGroup);
		numDraw4.setToggleGroup(drawGroup);

		// Set Default draws to 1
		drawGroup.selectToggle(numDraw1);

		//Set Number of drawings
		numDraw1.setOnAction(e -> GameplayDriver.setRepeat(1));
		numDraw2.setOnAction(e -> GameplayDriver.setRepeat(2));
		numDraw3.setOnAction(e -> GameplayDriver.setRepeat(3));
		numDraw4.setOnAction(e -> GameplayDriver.setRepeat(4));

		// No. of Drawings Holder
		HBox numDrawBox = new HBox(20, numDraw1, numDraw2, numDraw3, numDraw4);
		

		// Spots
		RadioButton spot1 = new RadioButton("1");
		RadioButton spot4 = new RadioButton("4");
		RadioButton spot8 = new RadioButton("8");
		RadioButton spot10 = new RadioButton("10");


		// Spot ToggleGroup
		ToggleGroup spotsGroup = new ToggleGroup();

		// Assigning Toggle Group
		spot1.setToggleGroup(spotsGroup);
		spot4.setToggleGroup(spotsGroup);
		spot8.setToggleGroup(spotsGroup);
		spot10.setToggleGroup(spotsGroup);

		// Spot Holder
		HBox spotBox = new HBox(20, spot1, spot4, spot8, spot10);

		// Create a Grid Pane to Hold Spots 1-80
		GridPane gridPane = new GridPane();

		// Nodes are disabled until spots are selected
		gridPane.setDisable(true);

		// Enable Grid Pane when the spot is selected
		spot1.setOnAction((ActionEvent) -> {

			gridPane.setDisable(false);
			randomBox.setDisable(false);
			draw.setDisable(false);
			GameplayDriver.reset();
			GameplayDriver.validNumSpots(1);
			spot1.setDisable(true);
			spot4.setDisable(true);
			spot8.setDisable(true);
			spot10.setDisable(true);
			

			
		});
		spot4.setOnAction((ActionEvent) -> {

			gridPane.setDisable(false);
			randomBox.setDisable(false);
			draw.setDisable(false);
			GameplayDriver.reset();
			GameplayDriver.validNumSpots(4);
			gridPane.setDisable(false);
		});
		spot8.setOnAction((ActionEvent) -> {

			gridPane.setDisable(false);
			randomBox.setDisable(false);
			draw.setDisable(false);
			GameplayDriver.reset();
			GameplayDriver.validNumSpots(8);

		});
		spot10.setOnAction((ActionEvent) -> {

			gridPane.setDisable(false);
			randomBox.setDisable(false);
			draw.setDisable(false);
			GameplayDriver.reset();
			GameplayDriver.validNumSpots(10);
		});
		
		// Create 80 Buttons Dynamically
		for (i = 1; i < 81; i++) {
			ToggleButton btnNumber = new ToggleButton();
			btnNumber.setText(String.valueOf(i));
			btnNumber.setMinWidth(40);
			
			btnNumber.setOnAction((ActionEvent) -> {
				if (!btnNumber.isSelected()) {
					GameplayDriver.decSelected();
					GameplayDriver.removeNumberPlayerSelections(Integer.parseInt(btnNumber.getText()));
					btnNumber.setSelected(false);
				}
				
				else {
					if (GameplayDriver.incSelected()) {
						GameplayDriver.addNumberToPlayerSelections(Integer.parseInt(btnNumber.getText()));
						btnNumber.setSelected(true);
					}
					else {
						btnNumber.setSelected(false);
					}
				}
			});
			

			// Adding buttons to a list for later operations.
			tglist.add(btnNumber);
			// Adding buttons to the gridPane
			gridPane.add(btnNumber, j, k, 1, 1);

			j++;
			if (i % 8 == 0) {
				k++;
				j = 0;
			}

		}

		// Draw Output Label
		Label drawNotice = new Label("Draw Result:");
		Label drawOutput = new Label("NILL");
		Label amountWonNotice = new Label("Amount Won:");
		Label amountWonOutput = new Label("NILL");

		// Labels for Result History Tab
		Label selectedChoiceText = new Label("Choices Provided:");
		Label selectedChoice = new Label("NILL");
		Label selectedBetText = new Label("Bet");
		Label selectedBet = new Label("NILL");
		Label totalBetText = new Label("Total Bet");
		Label totalBet = new Label("NILL");

		Label itemsMatchedText = new Label("Matched Items");
		Label wonText = new Label("Won");
		Label drawNoText = new Label("Draw");
		Label draw1 = new Label("1");
		Label draw2 = new Label("2");
		Label draw3 = new Label("3");
		Label draw4 = new Label("4");

		Label oneMatch = new Label("NILL");
		Label oneWon = new Label("NILL");

		Label twoMatches = new Label("NILL");
		Label twoWon = new Label("NILL");

		Label threeMatches = new Label("NILL");
		Label threeWon = new Label("NILL");

		Label fourMatches = new Label("NILL");
		Label fourWon = new Label("NILL");
		
		Label printOutput = new Label("Press Draw to Start");
		printOutput.setStyle("-fx-padding: 80; -fx-font: 24px \"Serif\";");


		// Show Results in a single horizontal tab
		HBox drawBox = new HBox(10);
		drawBox.getChildren().addAll(drawNotice, drawOutput, amountWonNotice, amountWonOutput);

		// Let the draw Begin
		Boolean buttonClicked = false;
		
		draw.setOnAction((ActionEvent) -> {
			if(buttonClicked ==false) {
				//buttonClicked = true;

			// check validity of inputs and remaining draws before proceeding
			if (GameplayDriver.readyToPlay()) {
				

				// Extracting button's text
				GameplayDriver.setRepeat(1);
				RadioButton selectedDraws = (RadioButton) drawGroup.getSelectedToggle();
				String draws = selectedDraws.getText();

				// Update Labels
				// Selected Choices by user or random
				selectedChoice.setText(GameplayDriver.extractSelectionsString() );
				
				selectedBet.setText("$" + GameplayDriver.getBet());
				
				totalBet.setText("$" + GameplayDriver.getBet() * Integer.parseInt(draws));

				printOutput.setText("Drawing!");
				GameplayDriver.findWinners();
				// Disable unnecessary tabs
				amountBox.setDisable(true);
				spotBox.setDisable(true);
				numDrawBox.setDisable(true);
				gridPane.setDisable(true);
				draw.setDisable(true);
				returnButton.setDisable(true);
				clearButton.setDisable(true);
				randomBox.setDisable(true);

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
						
						drawOutput.setText(GameplayDriver.extractDrawingsString());
						
						GameplayDriver.findWinners();
						String temp = " " + GameplayDriver.calculateWinnings(GameplayDriver.getBet());
						amountWonOutput.setText("$" + temp);

						// Looping until all draws are complete
						m++;
						//int x = GameplayDriver.getRepeat();
						
						
						if (m==1) {

							printOutput.setText("Continue to Next Draw");
							System.out.println("Continue to next draw");
							if (Integer.parseInt(draws) == GameplayDriver.getRepeat()) {
								printOutput.setText("Game Over");
								draw.setDisable(true);
								// User can go back after game overs
								returnButton.setDisable(false);
								// User can Clear after game overs
								clearButton.setDisable(false);
							} else {
								draw.setDisable(false);
							}
						}

							// Show results
							amountWonOutput.setText("$" + GameplayDriver.getWinnings());
							

						if (GameplayDriver.getRepeat() == 1) {
							System.out.println("draw1");
							oneMatch.setText(GameplayDriver.getMatches());
							oneWon.setText("$" + temp);
						} else if (GameplayDriver.getRepeat() == 2) {
							System.out.println("draw2");
							twoMatches.setText(GameplayDriver.getMatches());
							twoWon.setText("$" + temp);
						} else if (GameplayDriver.getRepeat() == 3) {
							System.out.println("draw3");
							threeMatches.setText(GameplayDriver.getMatches());
							threeWon.setText("$" + temp);
						} else if (GameplayDriver.getRepeat() == 4) {
							System.out.println("draw4");
							fourMatches.setText(GameplayDriver.getMatches());
							fourWon.setText("$" + temp);
						} else {
							
							throw new RuntimeException("Illegal Draw");
						}
						
						
						GameplayDriver.decRepeat();
						
						
						}
				
					} ));

				// Reset positions
				m = 0;
				GameplayDriver.resetDraw();

				// 20 Draws
				timeline.setCycleCount(GameplayDriver.getRepeat());
				timeline.play();

			} else {
				// do Warn User
				printOutput.setText("Check Your Spots");
			}
			}
		});
		
	

		// Back Button Returns to Main Menu and Resets the Game
		returnButton.setOnAction((ActionEvent) -> {
			i = 0;
			j = 0;
			k = 0;
			spotBox.setDisable(false);
			amountBox.setDisable(false);
			numDrawBox.setDisable(false);
			betGroup.selectToggle(bet1);
			drawGroup.selectToggle(numDraw1);
			spotsGroup.selectToggle(null);
			draw.setDisable(true);
			drawOutput.setText("NILL");
			selectedChoice.setText("NILL");
			amountWonOutput.setText("NILL");

			oneMatch.setText("NILL");
			twoMatches.setText("NILL");
			threeMatches.setText("NILL");
			fourMatches.setText("NILL");
			totalBet.setText("NILL");
			selectedBet.setText("NILL");
			oneWon.setText("NILL");
			twoWon.setText("NILL");
			threeWon.setText("NILL");
			fourWon.setText("NILL");

			// Enabling gridPane to fire
			gridPane.setDisable(false);
			// Reset all nodes
			for (i = 1; i <= 80; i++) {
				ToggleButton btn = new ToggleButton();
				btn = tglist.get(i - 1);
				if (btn.isSelected())
					btn.fire();
			}
			gridPane.setDisable(true);

			// Enabling checkBox to fire
			randomBox.setDisable(false);
			if (randomBox.isSelected())
				randomBox.fire();
			randomBox.setDisable(true);

			GameplayDriver.reset();

			// Go to Main Menu
			window.setScene(scene1);
		});

		clearButton.setOnAction((ActionEvent) -> {

			spot1.setDisable(false);
			spot4.setDisable(false);
			spot8.setDisable(false);
			spot10.setDisable(false);
			i = 0;
			j = 0;
			k = 0;
			spotBox.setDisable(false);
			amountBox.setDisable(false);
			numDrawBox.setDisable(false);
			betGroup.selectToggle(bet1);
			drawGroup.selectToggle(numDraw1);
			spotsGroup.selectToggle(null);
			draw.setDisable(true);
			randomBox.setDisable(true);
			drawOutput.setText("NILL");
			selectedChoice.setText("NILL");
			amountWonOutput.setText("NILL");

			oneMatch.setText("NILL");
			twoMatches.setText("NILL");
			threeMatches.setText("NILL");
			fourMatches.setText("NILL");
			totalBet.setText("NILL");
			selectedBet.setText("NILL");
			oneWon.setText("NILL");
			twoWon.setText("NILL");
			threeWon.setText("NILL");
			fourWon.setText("NILL");

			// Enabling gridPane to fire
			gridPane.setDisable(false);
			// Reset all nodes
			for (i = 1; i <= 80; i++) {
				ToggleButton btn = new ToggleButton();
				btn = tglist.get(i - 1);
				if (btn.isSelected())
					btn.fire();
			}
			gridPane.setDisable(true);

			randomBox.setDisable(false);
			if (randomBox.isSelected())
				randomBox.fire();
			randomBox.setDisable(true);

			GameplayDriver.reset();
		});

		// On setting checkBox, manual input is restricted
		randomBox.setOnAction((ActionEvent) -> {

			if (randomBox.isSelected() == true) {
				RadioButton sRB = (RadioButton) spotsGroup.getSelectedToggle();
				String str = sRB.getText();
				GameplayDriver.autoPicks(Integer.parseInt(str));

				// Prevent manual input
				gridPane.setDisable(false);
				// Reset all nodes
				for (i = 1; i <= 80; i++) {
					ToggleButton btn = new ToggleButton();
					btn = tglist.get(i - 1);
					if (btn.isSelected())
						btn.fire();
				}
				gridPane.setDisable(true);

				spotBox.setDisable(true);

			} else {
				gridPane.setDisable(false);
				spotBox.setDisable(false);
			}

		});

		/*
		 * Setting User Interface Arranging tabs
		 */
		VBox vbox1 = new VBox(10);
		VBox vbox21 = new VBox(10);
		VBox vbox2 = new VBox(10);
		HBox drawAndClear = new HBox(20);

		drawAndClear.getChildren().addAll(draw, clearButton);

		vbox1.getChildren().addAll(returnButton, amountText, amountBox, drawText, numDrawBox, spotText, spotBox, gridPane,
				checkBoxBox, drawAndClear);

		// Displays history Tab (Right Window below Selected Choice)
		GridPane tab = new GridPane();
		tab.setHgap(30);
		tab.setVgap(10);

		tab.add(drawNoText, 0, 0, 1, 1);
		tab.add(itemsMatchedText, 2, 0, 1, 1);
		tab.add(wonText, 3, 0, 1, 1);

		tab.add(draw1, 0, 1, 1, 1);
		tab.add(oneMatch, 2, 1, 1, 1);
		tab.add(oneWon, 3, 1, 1, 1);

		tab.add(draw2, 0, 2, 1, 1);
		tab.add(twoMatches, 2, 2, 1, 1);
		tab.add(twoWon, 3, 2, 1, 1);

		tab.add(draw3, 0, 3, 1, 1);
		tab.add(threeMatches, 2, 3, 1, 1);
		tab.add(threeWon, 3, 3, 1, 1);

		tab.add(draw4, 0, 4, 1, 1);
		tab.add(fourMatches, 2, 4, 1, 1);
		tab.add(fourWon, 3, 4, 1, 1);

		HBox betTab = new HBox(20);
		betTab.getChildren().addAll(selectedBetText, selectedBet, totalBetText, totalBet);

		vbox21.getChildren().addAll(selectedChoiceText, selectedChoice, betTab, tab, printOutput);

		vbox2.getChildren().addAll(drawBox, vbox21);

		HBox hbox12 = new HBox(30);
		hbox12.getChildren().addAll(vbox1, vbox2);

		layout2.getChildren().addAll(menu2, hbox12);
		layout2.setStyle("-fx-padding: 5;");

		/*
		 * New Look (Modern) Adding CSS
		 */
		modernLook.setOnAction((ActionEvent) -> {

			layout2.setStyle("-fx-padding: 5; -fx-background-color: #a52a2a;");
			menuBar2.setStyle("-fx-background-color: #f0f8ff; -fx-font: 14px \"Serif\";");
			draw.setStyle("-fx-background-color: NAVY; -fx-text-fill: white;" + " -fx-font: 14px \"Serif\";");
			clearButton.setStyle("-fx-background-color: Black; -fx-text-fill: white;" + " -fx-font: 18px \"Serif\";");
			returnButton.setStyle("-fx-background-color: Black; -fx-text-fill: white;" + "-fx-font: 18px \"Serif\";");
			checkBoxText.setStyle("-fx-font: 14px \"Serif\"; -fx-font-style: italic;");
			amountText.setStyle("-fx-font: 14px \"Serif\"; -fx-font-style: italic;");
			drawText.setStyle("-fx-font: 14px \"Serif\"; -fx-font-style: italic;");
			spotText.setStyle("-fx-font: 14px \"Serif\"; -fx-font-style: italic;");
			vbox2.setStyle("-fx-font: 14px \"Serif\"; -fx-font-style: italic;");
			tab.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: White;");


			for (i = 1; i <= 80; i++) {
				ToggleButton btn = new ToggleButton();
				btn = tglist.get(i - 1);
				btn.setStyle("-fx-text-fill: Black; -fx-font: 14 \"Serif\"; -fx-border-color: White;");
			}

		});

		// Default look resets all CSS set by the Modern Look
		defaultLook.setOnAction((ActionEvent) -> {

			layout2.setStyle("-fx-padding: 5;");
			menuBar2.setStyle(null);
			draw.setStyle(null);
			clearButton.setStyle(null);
			returnButton.setStyle(null);
			checkBoxText.setStyle(null);
			amountText.setStyle(null);
			drawText.setStyle(null);
			spotText.setStyle(null);
			vbox2.setStyle(null);
			tab.setStyle(null);


			for (i = 1; i <= 80; i++) {
				ToggleButton btn = new ToggleButton();
				btn = tglist.get(i - 1);
				btn.setStyle(null);
			}
		});

		/* Scene 3 Starts */
		VBox layout3 = new VBox(10);
		scene3 = new Scene(layout3, 800, 640);

		// Back Button Scene 3
		Button rulesreturnButton = new Button("Return");
		rulesreturnButton.setOnAction(e -> window.setScene(currentScene));

		ScrollPane scrollArea1 = new ScrollPane();

		text1.wrappingWidthProperty().bind(scene3.widthProperty());
		scrollArea1.setFitToWidth(true);
		scrollArea1.setContent(text1);

		layout3.getChildren().addAll(rulesreturnButton, scrollArea1);
		layout3.setStyle("-fx-padding: 5;");

		window.setScene(scene1);
		window.setTitle("KENO");
		window.show();
	}

	private String valueOf(int l) {
		// TODO Auto-generated method stub
		return null;
	}
}
