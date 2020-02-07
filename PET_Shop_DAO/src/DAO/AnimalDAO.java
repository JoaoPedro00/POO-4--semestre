package DAO;

import java.util.List;

import entidade.Animal;

public interface AnimalDAO {
	void adicionar(Animal a) throws DAOException;
	List<Animal> pesquisarPorNome(String nome) throws DAOException;

}
