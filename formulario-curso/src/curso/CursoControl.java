package curso;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CursoControl {

	private ObservableList<Curso> lista = FXCollections.observableArrayList();

	public void adicionar(Curso c) {
		CursoDAO cDao = new CursoDAOImpl();
		cDao.adicionar(c);
		lista.clear();
		getLista();
		JOptionPane.showMessageDialog(null, "CURSO ADICIONADO COM SUCESSO!!");
	}

	public Curso pesquisarPorNome(String nome) {
		Curso c;
		CursoDAO cDao = new CursoDAOImpl();
		c = cDao.pesquisarPorNome(nome);
		return c;
	}

	public ObservableList<Curso> getLista() {
		lista.clear();
		CursoDAO cDao = new CursoDAOImpl();
		lista.addAll(cDao.listar());
		return lista;
	}

}
