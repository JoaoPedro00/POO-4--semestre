package curso;

import java.text.SimpleDateFormat;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CursoView extends Application implements EventHandler<ActionEvent> {

	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtDescricao = new TextField();
	private RadioButton txtAtivo = new RadioButton();
	private TextField txtHorarioInicio = new TextField();
	private TextField txtHorarioTermino = new TextField();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private TableView<Curso> table = new TableView<Curso>();
	private CursoControl control = new CursoControl();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane painelPrincipal = new BorderPane();
		painelPrincipal.setStyle("-fx-padding: 10px");
		FlowPane painelBotoes = new FlowPane();
		GridPane painelCampos = new GridPane();
		
		
//		ColumnConstraints col0 = new ColumnConstraints();
//		col0.setPercentWidth(30);
//		ColumnConstraints col1 = new ColumnConstraints();
//		col1.setPercentWidth(70);
//		painelCampos.getColumnConstraints().addAll(col0, col1);

		painelPrincipal.setTop(painelCampos);
		painelPrincipal.setCenter(painelBotoes);
		painelPrincipal.setBottom(table);
		definirColunas();
		responsividadeLista();

		painelCampos.add(new Label("Id"), 0, 0);
		painelCampos.add(txtId, 1, 0);
		painelCampos.add(new Label("Nome"), 0, 1);
		painelCampos.add(txtNome, 1, 1);
		painelCampos.add(new Label("Descrição"), 0, 2);
		painelCampos.add(txtDescricao, 1, 2);
		painelCampos.add(new Label("Ativo"), 0, 3);
		painelCampos.add(txtAtivo, 1, 3);
		painelCampos.add(new Label("Horário Início"), 0, 4);
		painelCampos.add(txtHorarioInicio, 1, 4);
		painelCampos.add(new Label("HorárioTermino"), 0, 5);
		painelCampos.add(txtHorarioTermino, 1, 5);

		painelBotoes.getChildren().addAll(btnAdicionar, btnPesquisar);

		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
		btnPesquisar.addEventHandler(ActionEvent.ANY, this);
		painelBotoes.setHgap(15);
		Scene scn = new Scene(painelPrincipal, 400, 600);

		primaryStage.setScene(scn);
		primaryStage.setTitle("Título");
		primaryStage.show();

	}

	public Curso viewParaEntidade() {
		Curso c = new Curso();
		try {
			c.setId(Long.parseLong(txtId.getText()));
			c.setNome(txtNome.getText());
			c.setDescricao(txtDescricao.getText());
			String horarioInicial;
			String horarioTermino;
			horarioInicial = txtHorarioInicio.getText();
			horarioTermino = txtHorarioTermino.getText();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			c.setHorario_inicio(sdf.parse(horarioInicial));
			c.setHorario_fim(sdf.parse(horarioTermino));
			
			if(txtAtivo.isSelected()) {
				c.setAtivo(true);
			}else {
				c.setAtivo(false);
			}
			// como faz o boolean e o horario?

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public void entidadeParaView(Curso c) {
		if (c != null) {
			txtId.setText(String.valueOf(c.getId()));
			txtNome.setText(c.getNome());
			txtDescricao.setText(c.getDescricao());
			txtHorarioInicio.setText(formataData(c.getHorario_fim().toString()));
			txtHorarioTermino.setText(formataData(c.getHorario_fim().toString()));
			
			if(c.isAtivo()) {
				txtAtivo.setSelected(true);
			}else {
				txtAtivo.setSelected(false);
			}
			// como faz o boolean e o horario?
		}
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnAdicionar) {
			control.adicionar(viewParaEntidade());
			limparTela();
		} else if (event.getTarget() == btnPesquisar) {
			String nome = txtNome.getText();
			Curso c = control.pesquisarPorNome(nome);
			entidadeParaView(c);
		}
	}
	
	public void responsividadeLista() {
		this.table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Curso>() {
			@Override
			public void changed(ObservableValue<? extends Curso> arg0, Curso arg1, Curso arg2) {
				if (arg2 != null) {
					entidadeParaView(arg2);					
				}
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public void definirColunas() {
		
		//cria as colunas que representam cada atributo de um objeto do tipo Curso e seta as celulas pra recebe issso.
		//coloca as colunas dentro da tableview
		//preencher a tabela com os elementos da lista que esta no nosso controle

		TableColumn<Curso, Number> colunaId = new TableColumn<>("Id");
		colunaId.setCellValueFactory(itemData -> new ReadOnlyLongWrapper(itemData.getValue().getId()));
		colunaId.setPrefWidth(20);
		
		TableColumn<Curso, String> colunaNome = new TableColumn<>("Nome");
		colunaNome.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getNome()));
		colunaNome.setPrefWidth(40);
		
		TableColumn<Curso, String> colunaDescricao = new TableColumn<>("Descrição");
		colunaDescricao.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getDescricao()));
		colunaDescricao.setPrefWidth(80);

		TableColumn<Curso, Boolean> colunaAtivo = new TableColumn<>("Ativo");
		colunaAtivo.setCellValueFactory(itemData -> new ReadOnlyBooleanWrapper(itemData.getValue().isAtivo()));
		colunaAtivo.setPrefWidth(80);
		
		TableColumn<Curso, String> colunaHoraInicio = new TableColumn<>("Hora Inicio");
		colunaHoraInicio.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(formataData(itemData.getValue().getHorario_inicio().toString())));
		colunaHoraInicio.setPrefWidth(80);
		
		TableColumn<Curso, String> colunaHoraFim = new TableColumn<>("Hora Fim");
		colunaHoraFim.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(formataData(itemData.getValue().getHorario_fim().toString())));
		colunaHoraFim.setPrefWidth(80);
		
		
		table.getColumns().addAll(colunaId, colunaNome, colunaDescricao, colunaAtivo, colunaHoraInicio, colunaHoraFim);

		table.setItems(control.getLista());
		
	}

	public void limparTela() {
		txtId.setText("");
		txtNome.setText("");
		txtDescricao.setText("");
		txtHorarioInicio.setText("");
		txtHorarioTermino.setText("");
		txtAtivo.setSelected(false);
	}
	
	public String formataData(String data) {
		//1994-03-19
		String[] dataVetor = data.split("-");
		String dataFormatada = dataVetor[2]+ "/"+ dataVetor[1] + "/" + dataVetor[0];
		return dataFormatada;
	}
	
}
