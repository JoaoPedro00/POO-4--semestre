import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculadora extends Application {

	private char[] botoes = { '1','2','3','+',
							 '4','5','6','-',
							 '7','8','9','*',
							 ',','0','=','/'};
	

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane border = new BorderPane(); 
		Scene scn = new Scene(border,400,300);
		FlowPane flow = new FlowPane();
		GridPane grid = new GridPane();
		flow.setHgap(10);
		grid.setHgap(10);
		grid.setVgap(10);
		border.setTop(flow);
		border.setCenter(grid);
		TextField txtDisplay = new TextField();
		flow.getChildren().addAll(txtDisplay,new Button("CE"));
		
		int linha = 0;
		int coluna = 0;
		
		for(char c: botoes) {
			Button button = new Button(String.valueOf(c));
			button.setMaxHeight(Double.MAX_VALUE);
			button.setMaxWidth(Double.MAX_VALUE);
			grid.add(button, coluna++, linha);
			if (coluna >=4) {
				coluna = 0;
				linha++;
			}
			button.setOnAction(e -> {
				String tecla = button.getText();
				String textoAnterior = txtDisplay.getText();
				String textoAtual = textoAnterior + tecla;
				txtDisplay.setText(textoAtual);
			});
		}
		
		
		stage.setScene(scn);
		stage.setTitle("Calculadora");
		stage.show();
	}
	
	public static void main(String[] args) {
		Calculadora.launch(args);
	}

}
