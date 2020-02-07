package control;


import java.sql.SQLException;
import java.util.List;

import DAO.AnimalDAOImpl;
import DAO.DAOException;
import entidade.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AnimalController {
	private ObservableList<Animal> lista =
			FXCollections.observableArrayList();

		
		public void pesquisarPorNome(String nome) {
			try {
				AnimalDAOImpl aDAO = new AnimalDAOImpl();
				lista.clear();
				List<Animal> listaAnimais = aDAO.pesquisarPorNome(nome);
				for (Animal a : listaAnimais) {
					lista.add(a);
				}
			} catch (ClassNotFoundException | SQLException | DAOException e) {
				e.printStackTrace();
			}
		}
		
		public void adicionar(Animal a) {
			AnimalDAOImpl aDAO;
			try {
				aDAO = new AnimalDAOImpl();
				lista.clear();
				getLista().add(a);
				aDAO.adicionar(a);
			} catch (ClassNotFoundException | SQLException | DAOException e) {
				e.printStackTrace();
			}
			
		}
	
		

	public ObservableList<Animal> getLista() {
		return lista;
	}


	}
