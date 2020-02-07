
public class CaixaEletronico {
	Conta conta;
	
	
	public CaixaEletronico(String numero, String senha) {
	    conta = new Conta(numero,senha);
	}
	
	public Conta autentica(String numero,String senha) {
		return conta;
	}
	
	public static void main(String[] args) {
		CaixaEletronico cx1 = new CaixaEletronico("123", "000");
		cx1.conta.efetuarDeposito(140);
		System.out.println(cx1.autentica("123","000"));
		System.out.println("Saldo da conta é :"+ cx1.conta.getSaldo());
	}

}
