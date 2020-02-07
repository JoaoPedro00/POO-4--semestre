import java.rmi.RemoteException;

public class Conversao {
	
	public int Juliana(int dia, int mes, int ano) {
		int data = dia + mes + ano;
		int base = 15 + 10 + 1582;
		int dataju = 0;
		if (mes<3) {
			ano -=1;
			mes+= 12;
		}
		if(data>=base) {
		    int	a = ano/100;
			int b = a/4;
			int c = 2 - a+ b;
		    int d = (int) (365.25 *(ano + 4716));
		    int e = (int) (30.6001 * mes +1);
		    dataju = (int) ((d+e+dia+0.5+c-1524.5)+30);
		}
		return dataju;
	}

	public static void main(String[] args) {
		Conversao conversao = new Conversao();
		int data = conversao.Juliana(05, 8, 2016);
		System.out.println("dia convertido para data juliana é : "+data);
	}

}
