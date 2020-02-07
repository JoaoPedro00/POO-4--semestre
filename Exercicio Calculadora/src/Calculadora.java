import javafx.application.Application;
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
		flow.getChildren().addAll(new TextField(),new Button("CE"));
		
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
		}
		
		stage.setScene(scn);
		stage.setTitle("Calculadora");
		stage.show();
	}
	
	public static void main(String[] args) {
		Calculadora.launch(args);
	}

}
