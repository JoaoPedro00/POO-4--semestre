
public class EstouraHeap {
	static class Objeto {
		String Nome;
		Objeto next;
		int [] n = new int[1000000];
	}
	
	public static void main(String[] args) {
		Objeto primeiro = new Objeto();
		Objeto temp = primeiro;
		while (true) { 
			Objeto p = new Objeto();
			temp.next = p;
			temp = p;
		}
	}

}
