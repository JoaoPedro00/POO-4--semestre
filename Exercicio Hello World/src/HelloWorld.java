import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloWorld extends javafx.application.Application {

	@Override
	public void start(Stage stage) throws Exception {
		Pane panel = new Pane();
		Scene scn = new Scene(panel);
		Label ola = new Label("Hello World");
		stage.setWidth(400);
		stage.setHeight(200);
		
		panel.getChildren().add(ola);
				
		stage.setTitle("Janela de teste");
		stage.setScene(scn);
		stage.show();
		
	}
	
	
	public static void main(String[] args) {
 		HelloWorld.launch(args);
	}
	


}