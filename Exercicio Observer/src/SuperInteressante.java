import java.util.ArrayList;
import java.util.List;

public class SuperInteressante implements Revista,Subject {
	
	private String secao;
	 public SuperInteressante(String sec) {
		this.secao = sec;
	}
	 
	 List<Observer> lista = new ArrayList<>();

	@Override
	public void notificar() {
		for(Observer o : lista) {
			o.update(String.format("artigo sobre %s",secao ));
		}
	}

	@Override
	public void registrar(Observer o) {
		lista.add(o);
	}

	@Override
	public String artigo() {
		return secao;
	}

}
