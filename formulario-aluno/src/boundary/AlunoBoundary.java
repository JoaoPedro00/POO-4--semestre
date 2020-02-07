package boundary;

import java.text.SimpleDateFormat;
import java.util.Date;

import control.AlunoController;
import entidade.Aluno;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
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

public class AlunoBoundary extends Application implements EventHandler<ActionEvent> {
private AlunoController control = new AlunoController();
	
	private TextField txtRa = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtNascimento = new TextField();
	private TextField txtIdade = new TextField();
	
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnAtualizar = new Button("Atualizar");
	
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
		
		painelCampos.add(new Label("RA :"), 0, 0);
		painelCampos.add(txtRa, 1, 0);
		painelCampos.add(new Label("Nome do aluno :"), 0, 1);
		painelCampos.add(txtNome, 1, 1);
		painelCampos.add(new Label("Data de Nascimento :"), 0, 2);
		painelCampos.add(txtNascimento, 1, 2);
		painelCampos.add(new Label("Idade :"), 0, 3);
		painelCampos.add(txtIdade, 1, 3);
		painelCampos.setVgap(10);
		
		painelBotoes.setHgap(100);
		painelBotoes.getChildren().addAll(btnAdicionar, btnPesquisar,btnExcluir,btnAtualizar);
		
		addTableColumns();
		
		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
		btnPesquisar.addEventHandler(ActionEvent.ANY, this);
		btnExcluir.addEventHandler(ActionEvent.ANY, this);
		btnAtualizar.addEventHandler(ActionEvent.ANY, this);
		Scene scn = new Scene(painelPrincipal, 800,600);
		
		primaryStage.setScene(scn);
		primaryStage.setTitle("Gestão de Aluno");
		primaryStage.show();
	}

	private void addTableColumns() {
		TableColumn<Aluno, String> columnId = new TableColumn<>("Id");
		columnId.setCellValueFactory(
				new PropertyValueFactory<Aluno, String>("ra"));
		
		TableColumn<Aluno, String> columnNome = new TableColumn<>("Nome");
		columnNome.setCellValueFactory(
				new PropertyValueFactory<Aluno, String>("nome"));
		
		TableColumn<Aluno, Date> columnNasc = new TableColumn<>("Nascimento");
		columnNasc.setCellValueFactory(
				new PropertyValueFactory<Aluno, Date>("nascimento"));
		
		TableColumn<Aluno, Integer> columnIdade = new TableColumn<>("Idade");
		columnIdade.setCellValueFactory(
				new PropertyValueFactory<Aluno, Integer>("idade"));
		
		table.getColumns().addAll(columnId, columnNome, columnNasc,columnIdade);
		table.setItems(control.getLista());
		table.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Aluno>() {
					@Override
					public void changed(ObservableValue<? extends Aluno> observable, 
							Aluno oldValue,
							Aluno newValue) {
						entidadeParaBoundary(newValue);
					}
				});
	}
		
	

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnAdicionar) { 
			control.adicionar(boundaryParaEntidade());
		} else if (event.getTarget() == btnPesquisar) {
			String RA = txtRa.getText();
			control.pesquisarPorRA(RA);			
		} else if(event.getTarget() == btnExcluir) {
			control.exclui(boundaryParaEntidade());
			ObservableList<Aluno> productSelected, allProducts;
			allProducts = table.getItems();
			productSelected = table.getSelectionModel().getSelectedItems();
			productSelected.forEach(allProducts::remove);
		} else if(event.getTarget() == btnAtualizar) {
			control.atualizar(boundaryParaEntidade());
		}
	}

	private void entidadeParaBoundary(Aluno a) {
		if (a != null) { 
			txtNome.setText(a.getNome());
			txtRa.setText(a.getRa());
			txtIdade.setText(String.valueOf(a.getIdade()));
			String strData = sdf.format(a.getNascimento());
			txtNascimento.setText(strData);
		}
	}

	private Aluno boundaryParaEntidade() {
		Aluno a = new Aluno();
		try {
			a.setNome(txtNome.getText());
			a.setIdade(Integer.parseInt(txtIdade.getText()));
			a.setRa(txtRa.getText());
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

