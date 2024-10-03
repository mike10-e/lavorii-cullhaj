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
        while (isFull()) {
            System.out.println("L'array è pieno. Aspettando che ci sia spazio...");
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
            }
        }
			array[coda] = n;
			coda = (coda + 1) % capacità;
			elementi++;
			System.out.println("inserito:"+n);
			notifyAll();
		
	}
	
	public synchronized int togli() {
		  while (isEmpty()) {
	            System.out.println("L'array è vuoto. Aspettando che ci siano nuovi elementi...");
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt(); 
	            }
	        }
			int n = array[testa];
			testa = (testa + 1) % capacità;
			elementi--;
			notifyAll();
			return n;			
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
