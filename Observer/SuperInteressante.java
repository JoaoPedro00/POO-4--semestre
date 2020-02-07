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
			o.update(String.format("%s | artigo sobre %s", secao,artigo()));
		}
	}

	@Override
	public void registrar(Observer o) {
		lista.add(o);
	}

	@Override
	public String artigo() {
		String art = "carros feitos de vidro";
		return art;
	}

}
