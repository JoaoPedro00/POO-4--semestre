
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InterfaceSimples extends javafx.application.Application {
	class ManipuladorMouse implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent arg0) {
			System.exit(0);
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane panel = new BorderPane();
		Scene scn = new Scene(panel);
		Label ola = new Label("Ola...!!!");
		stage.setWidth(200);
		stage.setHeight(200);
		
		Button sair = new Button("Sair");
		EventHandler<MouseEvent> manipulador = new ManipuladorMouse();
		sair.addEventFilter(MouseEvent.MOUSE_CLICKED, manipulador);
		sair.setMinWidth(200);

		panel.setCenter(ola);
		
		panel.setBottom(sair);
		
		stage.setTitle("Janela de teste");
		stage.setScene(scn);
		stage.show();
		
		
	}
	
	
	
	public static void main(String[] args) {
		InterfaceSimples.launch(args);
	}
	


}
