package application;
	
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			Button b = new Button("Hello, world!");
			b.setOnAction(e -> {
				System.out.print("Foo");
			});
			root.setCenter(b);

			TextField f = new TextField();
			f.setText("Hello, world!");
			b.textProperty().bind(f.textProperty());
			root.setTop(f);
			
			ScrollBar scroller = new ScrollBar();
			scroller.setValue(1);
			scroller.setMin(1);
			scroller.setMax(10);
			b.scaleXProperty().bind(scroller.valueProperty());
			b.scaleYProperty().bind(scroller.valueProperty());
			
			RotateTransition rotate = new RotateTransition(Duration.millis(3_000), b);
			rotate.setFromAngle(0);
			rotate.setToAngle(360);
			rotate.setAutoReverse(true);
			rotate.setCycleCount(RotateTransition.INDEFINITE);
			
			FadeTransition fade = new FadeTransition(Duration.millis(3_000), b);
			fade.setFromValue(1);
			fade.setToValue(0);
			fade.setAutoReverse(true);
			fade.setCycleCount(RotateTransition.INDEFINITE);
			
			ParallelTransition p = new  ParallelTransition(rotate, fade);
			p.play();
			
			scroller.setOrientation(Orientation.VERTICAL);
			root.setRight(scroller);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
