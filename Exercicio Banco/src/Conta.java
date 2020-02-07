import java.util.Date;

public class Conta {
	private double saldo;
	private String numero;
	private String senha;
	private Transacao[] historico;
	
	public Conta(String numeroConta, String senha) {
		this.numero = numeroConta;
		this.senha = senha;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public boolean efetuarSaque(double valor) {
		this.saldo -= valor;
		return true;
	}
	
	public boolean efetuarDeposito(double valor) {
		this.saldo += valor;
		return true;
		
	}
	
	public boolean efetuarPagamento(String boleto, double valor) {
		this.saldo -= valor;
		return true;
	}
	
	public Transacao[] extrato(Date incio,Date Final) {
		return historico;
		
	}
	
	public String toString() { 
		return getnumero();
	}



	private String getnumero() {
		
		return "Numero da conta :" +this.numero;
	}

}
