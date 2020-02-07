import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
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

public class ProdutoBoundary extends Application implements EventHandler<ActionEvent>{
	private ProdutoControl control = new ProdutoControl ();
	private TextField txtId = new TextField();
	private TextField txtPreco = new TextField();
	private TextField txtPeso = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtTipo = new TextField();
	private TextField txtDataValidade = new TextField();
	private Button btnInserir = new Button("Inserir");
	private Button btnAtualizar = new Button("Atualizar");
	private Button btnRemover = new Button("Remover");
	private Button btnPesquisar = new Button("Pesquisar");
	private TableView table = new TableView();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
    
	public void start(Stage primaryStage) throws Exception {
		BorderPane painelPrincipal = new BorderPane();
		painelPrincipal.setStyle("-fx-padding: 10px");
		FlowPane painelBotoes = new FlowPane();
		GridPane painelCampos = new GridPane();
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(20);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(50);
		painelCampos.getColumnConstraints().addAll(col0, col1);

		painelPrincipal.setTop(painelCampos);
		painelPrincipal.setCenter(table);
		painelPrincipal.setBottom(painelBotoes);

		painelCampos.add(new Label("Id:"), 0, 0);
		painelCampos.add(txtId, 1, 0);
		painelCampos.add(new Label("Preço:"), 0, 1);
		painelCampos.add(txtPreco, 1, 1);
		painelCampos.add(new Label("Peso:"), 0, 2);
		painelCampos.add(txtPeso, 1, 2);
		painelCampos.add(new Label("Nome:"), 0, 3);
		painelCampos.add(txtNome, 1, 3);
		painelCampos.add(new Label("Tipo:"), 0, 4);
		painelCampos.add(txtTipo, 1, 4);
		painelCampos.add(new Label("Data_Validade:"), 0, 5);
		painelCampos.add(txtDataValidade, 1, 5);

		painelBotoes.getChildren().addAll(btnInserir,btnAtualizar,btnRemover,btnPesquisar);

		addTableColumns();

		btnInserir.addEventHandler(ActionEvent.ANY, this);
		btnPesquisar.addEventHandler(ActionEvent.ANY, this);
		btnRemover.addEventFilter(ActionEvent.ANY, this);
		btnAtualizar.addEventFilter(ActionEvent.ANY, this);
		painelBotoes.setHgap(15);
		Scene scn = new Scene(painelPrincipal, 500, 500);

		primaryStage.setScene(scn);
		primaryStage.setTitle("PRODUTOS");
		primaryStage.show();
	}
	public void addTableColumns() { 
		TableColumn<Produto, Long> columnId = new TableColumn<>("Id");
		columnId.setCellValueFactory(
				new PropertyValueFactory<Produto, Long>("id"));

		TableColumn<Produto, Float> columnPreco = new TableColumn<>("Preço");
		columnPreco.setCellValueFactory(
				new PropertyValueFactory<Produto, Float>("preco"));

		TableColumn<Produto,Float> columnPeso = new TableColumn<>("Peso");
		columnPeso.setCellValueFactory(
				new PropertyValueFactory<Produto,Float>("Peso"));
		
		TableColumn<Produto, String> columnNome = new TableColumn<>("Nome");
		columnNome.setCellValueFactory(
				new PropertyValueFactory<Produto, String>("Nome"));
		
		TableColumn<Produto, String> columnTipo = new TableColumn<>("Tipo");
		columnTipo.setCellValueFactory(
				new PropertyValueFactory<Produto, String>("Tipo"));
		
		TableColumn<Produto, Date> columnVencimento = new TableColumn<>("Data Vencimento");
		columnVencimento.setCellValueFactory(
				new PropertyValueFactory<Produto,Date>("validade"));
		
		table.getColumns().addAll(columnId, columnPreco, columnPeso,columnNome,columnTipo,columnVencimento);
		table.setItems(control.getLista());
	}   
	public Produto boundaryParaEntidade() { 
		Produto p = new Produto();
		try {
			p.setId(Long.parseLong(txtId.getText()));
			p.setPreco(Float.parseFloat(txtPreco.getText()));
			p.setPeso(Float.parseFloat((txtPeso.getText())));
			p.setNome(txtNome.getText());
			p.setTipo(txtTipo.getText());
			Date d = sdf.parse(txtDataValidade.getText());
			p.setValidade(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public void entidadeParaBoundary(Produto p) { 
		if (p != null) {
			txtId.setText(String.valueOf(p.getId()));
			txtPreco.setText(String.valueOf((p.getPreco())));
			txtPeso.setText(String.valueOf((p.getPeso())));
			txtNome.setText(p.getNome());
			txtTipo.setText(p.getTipo());
			String strData = sdf.format(p.getValidade());
			txtDataValidade.setText(strData);
		}
	}
	
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnInserir) { 
			control.Inserir(boundaryParaEntidade());
		}else if(event.getTarget()==btnAtualizar) {
			String nome = txtNome.getText();
			control.remover(nome);
			control.Inserir(boundaryParaEntidade());
		}else if(event.getTarget()==btnRemover) {
			String nome = txtNome.getText();
			control.remover(nome);					
		}
		else if (event.getTarget() == btnPesquisar) {
			String nome = txtNome.getText();
			Produto p = control.pesquisarPorNome(nome);			
			entidadeParaBoundary(p);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}	
	
}
