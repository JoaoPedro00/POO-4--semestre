
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class CriacaoTela extends Application{

public void start (Stage stage) throws Exception {
		TilePane panel = new TilePane();
		panel.setStyle("-fx-padding:20px");
		
		
		panel.setHgap(5);
		panel.setVgap(100);
		Scene scn = new Scene(panel);
		
		Label phone = new Label("Enter your phone number :");
		TextField txtphone = new TextField();
		
		Label nome = new Label("Enter your name :");
		TextField txtnome = new TextField();
		
		
		Button ok = new Button("OK");
		Button cancel = new Button("Cancel");
		
		ok.setMinWidth(200);
		cancel.setMinWidth(200);
		
		panel.setPrefColumns(2);
		panel.getChildren().addAll(phone,txtphone,nome,txtnome,ok,cancel);
	
		
		stage.setTitle("Graphic User Interface Test");
		stage.setScene(scn);
		stage.show();
		
	}

	public static void main(String[] args) {
		CriacaoTela.launch(args);
	}
}