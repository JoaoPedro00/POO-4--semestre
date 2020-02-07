package DAO;

import java.util.List;

import entidade.Aluno;


public interface AlunoDAO {
	void adicionar(Aluno a) throws DAOException;
	void atualizaAluno(Aluno a) throws DAOException;
	void excluiAluno(Aluno a) throws DAOException;
	List<Aluno> pesquisarPorRA(String RA) throws DAOException;
}
