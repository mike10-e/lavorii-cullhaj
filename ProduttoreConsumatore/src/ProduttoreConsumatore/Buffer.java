package ProduttoreConsumatore;

public class Buffer {
	private int array[];
	private int coda; //prossimo ins
	private int testa; // primo ele
	private int elementi; //tot elementi
	private int capacità;
	
	public Buffer() {
		array = new int[10];
		coda = 0;
		testa = 0;
		capacità = 10;
	}
	
	public synchronized void inserisci(int n) {
		if(isFull()) {
			System.out.println("l'array è pieno ");
		} else {
			array[coda] = n;
			coda = (coda + 1) % capacità;
			elementi++;
			System.out.println("inserito:"+n);
		}
		
	}
	
	public synchronized int togli() {
		if(isEmpty()) {
			throw new IllegalStateException("l'array è vuoto");	
		} else {
			int n = array[testa];
			testa = (testa + 1) % capacità;
			elementi--;
			return n;
		}
	}
	
	private boolean isFull() {
		if(elementi == capacità) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean isEmpty() {
		if(elementi == 0) {
			return true;
		}else {
			return false;
		}
	}
}
