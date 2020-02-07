
public class Leitor implements Observer {

	private String nome;
	
	public Leitor(String n) {
		nome = n;
	}
	@Override
	public void update(String materia) {
		System.out.println(this.nome + " lendo o artigo : "+materia);
	}

}
