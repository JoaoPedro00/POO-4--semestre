import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExercicioJanela extends Application {
	
	public void start (Stage stage) throws Exception {
		GridPane panel = new GridPane();
		panel.setStyle("-fx-padding:20px");
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(30);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(70);
		panel.getColumnConstraints().addAll(col1, col2);
		
		FlowPane panel2 = new FlowPane();
		panel2.setHgap(5);
		panel.setHgap(5);
		panel.setVgap(10);
		Scene scn = new Scene(panel);
		
		Label id = new Label("ID :");
		TextField txtId = new TextField();
		
		Label nome = new Label("Nome :");
		TextField txtnome = new TextField();
		
		Label telefone = new Label("Telefone :");
		TextField txttelefone = new TextField();
		
		Button salvar = new Button("Salvar");
		Button pesquisar = new Button("Pesquisar");
		panel2.getChildren().addAll(salvar,pesquisar);
		
		//panel.add(new Label("ID"), 0, 0);
		
		panel.add(id, 0, 0);
		panel.add(txtId, 1, 0);
		panel.add(nome, 0, 1);
		panel.add(txtnome, 1, 1);
		panel.add(telefone, 0, 2);
		panel.add(txttelefone, 1, 2);
		panel.add(panel2, 0, 3, 2, 1);
		
		stage.setTitle("Gestao de contatos");
		stage.setScene(scn);
		stage.show();
		
	}

	public static void main(String[] args) {
		ExercicioJanela.launch(args);
	}

}
