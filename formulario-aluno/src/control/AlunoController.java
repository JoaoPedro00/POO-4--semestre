package control;

import java.sql.SQLException;
import java.util.List;

import DAO.AlunoDAOImpl;
import DAO.DAOException;
import entidade.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlunoController {
	private ObservableList<Aluno> lista =
			FXCollections.observableArrayList();

		
		public void pesquisarPorRA(String nome) {
			try {
				AlunoDAOImpl aDAO = new AlunoDAOImpl();
				lista.clear();
				List<Aluno> listaAlunos = aDAO.pesquisarPorRA(nome);
				for (Aluno a : listaAlunos) {
					lista.add(a);
					}
				} catch (ClassNotFoundException | SQLException | DAOException e) {
					e.printStackTrace();
				}
		}
		
		public void adicionar(Aluno a) {
			AlunoDAOImpl aDAO;
				try {
					aDAO = new AlunoDAOImpl();
					lista.clear();
					getLista().add(a);
					aDAO.adicionar(a);
				} catch (ClassNotFoundException | SQLException | DAOException e) {
					e.printStackTrace();
				}
			}

		public void exclui(Aluno a) {
			try {
				AlunoDAOImpl aDAO = new AlunoDAOImpl();
				getLista().remove(a);
				aDAO.excluiAluno(a);
			} catch (ClassNotFoundException | SQLException | DAOException e1) {
				e1.printStackTrace();
			}
		}
		
		public void atualizar(Aluno a) {
			try {
				AlunoDAOImpl aDAO = new AlunoDAOImpl();
				lista.clear();
				getLista().add(a);
				aDAO.atualizaAluno(a);
			}catch (ClassNotFoundException | SQLException | DAOException e1) {
				e1.printStackTrace();
			}
		}
		

	public ObservableList<Aluno> getLista() {
		return lista;
	}


	}

