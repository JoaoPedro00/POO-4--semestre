package boundary;

import java.text.SimpleDateFormat;
import java.util.Date;

import control.AnimalController;
import entidade.Animal;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AnimalForm extends Application implements EventHandler<ActionEvent>{
	private AnimalController control = new AnimalController();
	
	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtNascimento = new TextField();
	private TextField txtPeso = new TextField();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private TableView table = new TableView();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane painelPrincipal = new BorderPane();
		painelPrincipal.setStyle("-fx-padding: 10px");
		GridPane painelCampos = new GridPane();
		FlowPane painelBotoes = new FlowPane();
		
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(30);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(70);
		painelCampos.getColumnConstraints().addAll(col0, col1);
		
		painelPrincipal.setTop(painelCampos);
		painelPrincipal.setBottom(table);
		painelPrincipal.setCenter(painelBotoes);
		
		painelCampos.add(new Label("Id :"), 0, 0);
		painelCampos.add(txtId, 1, 0);
		painelCampos.add(new Label("Nome do animal :"), 0, 1);
		painelCampos.add(txtNome, 1, 1);
		painelCampos.add(new Label("Data de Nascimento :"), 0, 2);
		painelCampos.add(txtNascimento, 1, 2);
		painelCampos.add(new Label("Peso :"), 0, 3);
		painelCampos.add(txtPeso, 1, 3);
		painelCampos.setVgap(10);
		
		btnAdicionar.setMinWidth(390);
		btnPesquisar.setMinWidth(390);
		painelBotoes.getChildren().addAll(btnAdicionar, btnPesquisar);
		
		addTableColumns();
		
		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
		btnPesquisar.addEventHandler(ActionEvent.ANY, this);
		Scene scn = new Scene(painelPrincipal, 800,600);
		
		primaryStage.setScene(scn);
		primaryStage.setTitle("Gestão de Animal");
		primaryStage.show();
	}

	private void addTableColumns() {
		TableColumn<Animal, Long> columnId = new TableColumn<>("Id");
		columnId.setCellValueFactory(
				new PropertyValueFactory<Animal, Long>("id"));
		
		TableColumn<Animal, String> columnNome = new TableColumn<>("Nome");
		columnNome.setCellValueFactory(
				new PropertyValueFactory<Animal, String>("nome"));
		
		TableColumn<Animal, Date> columnNasc = new TableColumn<>("Nascimento");
		columnNasc.setCellValueFactory(
				new PropertyValueFactory<Animal, Date>("nascimento"));
		
		TableColumn<Animal, Float> columnPeso = new TableColumn<>("Peso");
		columnPeso.setCellValueFactory(
				new PropertyValueFactory<Animal, Float>("peso"));
		
		table.getColumns().addAll(columnId, columnNome, columnNasc,columnPeso);
		table.setItems(control.getLista());
		table.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Animal>() {
					@Override
					public void changed(ObservableValue<? extends Animal> observable, 
							Animal oldValue,
							Animal newValue) {
						entidadeParaBoundary(newValue);
					}
				});
	}
		
	

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnAdicionar) { 
			control.adicionar(boundaryParaEntidade());
		} else if (event.getTarget() == btnPesquisar) {
			String nome = txtNome.getText();
			control.pesquisarPorNome(nome);			
		}
	}

	private void entidadeParaBoundary(Animal a) {
		if (a != null) { 
			txtNome.setText(a.getNome());
			txtPeso.setText(String.valueOf(a.getPeso()));
			txtId.setText(String.valueOf(a.getId()));
			String strData = sdf.format(a.getNascimento());
			txtNascimento.setText(strData);
		}
	}

	private Animal boundaryParaEntidade() {
		Animal a = new Animal();
		try {
			a.setNome(txtNome.getText());
			a.setId(Long.parseLong(txtId.getText()));
			a.setPeso(Float.parseFloat(txtPeso.getText()));
			Date d = sdf.parse(txtNascimento.getText());
			a.setNascimento(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public static void main(String[] args) {
		launch(args);
	}	

}
