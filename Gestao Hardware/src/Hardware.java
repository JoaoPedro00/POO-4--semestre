import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Hardware extends Application{

	public static void main(String[] args) {
		Hardware.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		GridPane panel = new GridPane();
		
		panel.setStyle("-fx-padding:20px");
		panel.setHgap(5);
		panel.setVgap(20);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(20);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(70);
		panel.getColumnConstraints().addAll(col1, col2);
		
		FlowPane panel2 = new FlowPane();
		panel2.setHgap(10);
0
		Scene scn = new Scene(panel);
		
		Label id = new Label("ID :");
		TextField idtxt = new TextField();
		
		Label tipo = new Label("Tipo :");
		TextField tipotxt = new TextField();
		
		Label fabricante = new Label("Fabricante :");
		TextField fabtxt = new TextField();
		
		Label preco = new Label("Preço :");
		TextField precotxt = new TextField();
		
		Label dtcompra = new Label("Dt compra :");
		TextField dtcompratxt = new TextField();
		
		Label desc = new Label("Descrição :");
		TextField desctxt = new TextField();
		
		Button add = new Button("Adicionar");
		Button pesquisar = new Button("Pesquisar");
		
		add.setMinWidth(50);
		pesquisar.setMinWidth(50);
		
		panel2.getChildren().addAll(add,pesquisar);
		
		panel.add(id, 0, 0);
		panel.add(idtxt, 1, 0);
		panel.add(tipo, 0, 1);
		panel.add(tipotxt, 1, 1);
		panel.add(fabricante, 0, 2);
		panel.add(fabtxt, 1, 2);
		panel.add(preco,0,3);
		panel.add(precotxt,1,3);
		panel.add(dtcompra,0,4);
		panel.add(dtcompratxt,1,4);
		panel.add(desc,0,5);
		panel.add(desctxt,1,5);
		panel.add(panel2,0,6,2,1);

		
		stage.setTitle("Gestão de Hardware");
		stage.setScene(scn);
		stage.show();
		
	}

}
