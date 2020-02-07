import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;


class Palavra { 
	String nome;
	String definicao ;
	
	Palavra(String palavra, String def) { 
		nome = palavra;
		definicao = def;
	}
}

public class Dicionario {

	public static void main(String[] args) {
		System.out.println("");
		Map<String, Palavra> palavras = new HashMap<>();
		while (true) {
		
		String PalavraDigitada = null;
		PalavraDigitada = JOptionPane.showInputDialog("Digite uma palavra");
		
		Palavra p1 = null;
		
		p1 = palavras.get(PalavraDigitada);
		if (p1 != null) {
			String nome = p1.nome;
			String def = p1.definicao;
			JOptionPane.showMessageDialog(null,""+nome+ "\n definição : "+def);
		}
		else {
		JOptionPane.showMessageDialog(null, "Palavra nao cadastrada");
		String Definicao = null;
		Definicao = JOptionPane.showInputDialog("Digite uma definicao");
		palavras.put(PalavraDigitada, new Palavra(PalavraDigitada, Definicao));
		}
	  }
   }	
}
