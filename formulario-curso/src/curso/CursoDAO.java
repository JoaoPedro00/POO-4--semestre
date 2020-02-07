package curso;

import java.util.List;

public interface CursoDAO {
	void adicionar(Curso c);
	Curso pesquisarPorNome(String nome);
	List<Curso> listar();
}
