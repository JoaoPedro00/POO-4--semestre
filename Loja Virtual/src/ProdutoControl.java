
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProdutoControl {
	private ObservableList<Produto> lista = 
			FXCollections.observableArrayList();

	public void Inserir(Produto p) { 
		getLista().add(p);
	}
		
	public Produto pesquisarPorNome(String nome) { 
		for (Produto p : getLista()) { 
			if (p.getNome().contains(nome)) { 
				return p;
			}
		}
		return null;
	}
	public ObservableList<Produto> getLista() {
		return lista;
	}
	public void remover(String nome ) {
		Produto p = pesquisarPorNome(nome);
		getLista().remove(p);
		}
}
