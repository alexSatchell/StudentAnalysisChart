package edu.seminolestate.studentanalysis;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StudentAnalysis extends Application {
	
	// Create constants for number of students
	private static final int FRESHMAN_COUNT = 1200;
	private static final int SOPHMORE_COUNT = 1000;
	private static final int JUNIOR_COUNT = 800;
	private static final int SENIOR_COUNT = 600;
	private static final int GRADUATE_COUNT = 200;
	
	// Get total number of students 
	int total = FRESHMAN_COUNT+SOPHMORE_COUNT+JUNIOR_COUNT+SENIOR_COUNT+GRADUATE_COUNT;
	
	// Convert to percent of students in each class
	double freshmanPercentage = (double)FRESHMAN_COUNT / total;
	double sophmorePercentage = (double)SOPHMORE_COUNT / total;
	double juniorPercentage = (double)JUNIOR_COUNT / total;
	double seniorPercentage = (double)SENIOR_COUNT / total;
	double graduatePercentage = (double)GRADUATE_COUNT / total;
	
	public void start (Stage primaryStage) {	
		
		// Create a Pane for the scene
		BorderPane pane = new BorderPane();
		pane.setTop(headerPane());
		pane.setBottom(bottom());
		pane.setCenter(pieChart());
		
		// Create a new scene and display it
		Scene scene = new Scene(pane, 800, 650);
		primaryStage.setTitle("Student Class Analysis");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	// Create a StackPane to hold the header
	public StackPane headerPane() {
		StackPane headerPane = new StackPane();
		headerPane.setPadding(new Insets (10,5,0,5));
		Text header = new Text("Percent of Students by Class");
		header.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 38));
		header.setStyle("-fx-fill: #333433");
		headerPane.setStyle("-fx-background-color: #F9ECDF"); // set background of pane
		headerPane.getChildren().add(header); 
		return headerPane;
	}
	
	// Create a Pie chart to display student percentages
	public StackPane pieChart() {
		// Create a pane to hold Arc (pie chart)
		StackPane pane = new StackPane();
		Arc freshman = new Arc(300,300,200,200,0,360 * freshmanPercentage);
		freshman.setType(ArcType.ROUND);
		freshman.setStyle("-fx-fill: #FFFFFF");
		
		Arc sophmore = new Arc(300,300,200,200,freshman.getStartAngle() + freshman.getLength(), 360 * sophmorePercentage);
		sophmore.setType(ArcType.ROUND);
		sophmore.setStyle("-fx-fill: #FCC67C");
		
		Arc junior = new Arc(300,300,200,200,sophmore.getStartAngle() + sophmore.getLength(), 360 * juniorPercentage);
		junior.setType(ArcType.ROUND);
		junior.setStyle("-fx-fill: #81B99D");
		
		Arc senior = new Arc(300,300,200,200,junior.getStartAngle() + junior.getLength(),360 *seniorPercentage);
		senior.setType(ArcType.ROUND);
		senior.setStyle("-fx-fill: #FC6358");
		
		Arc graduate = new Arc(300,300,200,200,senior.getStartAngle() + senior.getLength(),360 * graduatePercentage);
		graduate.setType(ArcType.ROUND);
		graduate.setStyle("-fx-fill: #2D7DD2");
		
		Group group = new Group();
		group.getChildren().addAll(freshman,sophmore,junior,senior,graduate);
		pane.getChildren().add(group);
		pane.setStyle("-fx-background-color: #F9ECDF");
		return pane;
	}
	
	// Create an HBox to hold the student names and percentages	
	public HBox bottom() {
		HBox footer = new HBox();
		// Create Strings and add label for each
		Text freshman = new Text (Math.round(freshmanPercentage * 100) + "% Freshman");
		freshman.setFont(Font.font("Helvetica", FontWeight.LIGHT, 16));
		freshman.setStyle("-fx-fill: #333433");
		// Add Circle Display around Text
		StackPane freshmanStack = new StackPane();
		Circle circle1 = new Circle ();
		circle1.setStyle("-fx-fill: #FFFFFF");
		circle1.setRadius(60);
		freshmanStack.getChildren().addAll(circle1,freshman);
		
		Text sophmore = new Text (Math.round(sophmorePercentage * 100)  + "% Sophmore");
		sophmore.setFont(Font.font("Helvetica", FontWeight.LIGHT, 16));
		sophmore.setStyle("-fx-fill: #333433");
		// Add Circle Display around Text
		StackPane sophmoreStack = new StackPane();
		Circle circle2 = new Circle ();
		circle2.setRadius(60);
		circle2.setStyle("-fx-fill: #FCC67C");
		sophmoreStack.getChildren().addAll(circle2,sophmore);
		
		
		Text junior = new Text (Math.round(juniorPercentage * 100) + "% Junior");
		junior.setFont(Font.font("Helvetica", FontWeight.LIGHT, 16));
		junior.setStyle("-fx-fill: #333433");
		// Add Circle Display around Text
		StackPane juniorStack = new StackPane();
		Circle circle3 = new Circle ();
		circle3.setRadius(60);
		circle3.setStyle("-fx-fill: #81B99D");
		juniorStack.getChildren().addAll(circle3,junior);
		
		Text senior = new Text (Math.round(seniorPercentage * 100) + "% Senior");
		senior.setFont(Font.font("Helvetica", FontWeight.LIGHT, 16));
		senior.setStyle("-fx-fill: #333433");
		// Add Circle Display around Text
		StackPane seniorStack = new StackPane();
		Circle circle4 = new Circle ();
		circle4.setRadius(60);
		circle4.setStyle("-fx-fill: #FC6358");
		seniorStack.getChildren().addAll(circle4,senior);
		
		Text graduate = new Text (Math.round(graduatePercentage * 100) + "% Graduate");
		graduate.setFont(Font.font("Helvetica", FontWeight.LIGHT, 16));
		graduate.setStyle("-fx-fill: #333433");
		// Add Circle Display around Text
		StackPane graduateStack = new StackPane();
		Circle circle5 = new Circle ();
		circle5.setRadius(60);
		circle5.setStyle("-fx-fill: #2D7DD2");
		graduateStack.getChildren().addAll(circle5,graduate);
		
		footer.setAlignment(Pos.CENTER);
		footer.setPadding(new Insets(10,5,10,5));
		footer.setSpacing(30);
		footer.setStyle("-fx-background-color: #F9ECDF");
		footer.getChildren().addAll(freshmanStack, sophmoreStack, juniorStack, seniorStack, graduateStack);
		return footer;
	}
	
	// Launch application
	public static void main (String [] args) {
		launch(args);
	}
}