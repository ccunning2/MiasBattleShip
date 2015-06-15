package bs.view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Board test = new Board();
		Group root = new Group(test);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Testing Board");
		primaryStage.sizeToScene();
		primaryStage.show();
		System.out.println("Height: " +scene.getHeight() + " Width: " + scene.getWidth());

	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
