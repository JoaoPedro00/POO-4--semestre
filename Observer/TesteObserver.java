
public class TesteObserver {

	public static void main(String[] args) {
		SuperInteressante S1 = new SuperInteressante("Inovação");
		SuperInteressante S2 = new SuperInteressante("Carros");
		
		Leitor l1 = new Leitor("Samuel");
		Leitor l2 = new Leitor("Marcos");
		Leitor l3 = new Leitor("Andressa");
		Leitor l4 = new Leitor("João");
		
		S1.registrar(l1);
		S2.registrar(l3);
		S1.registrar(l4);
		S2.registrar(l2);
		
		S1.notificar();
		S2.notificar();
		
	}

}
