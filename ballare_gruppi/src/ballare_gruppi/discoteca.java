package ballare_gruppi;

public class discoteca {

	    private int totPersone = 0; 

	  
	    public synchronized void entra(int n) {
	        totPersone+=n; 
	        System.out.println(n + " persone sono entrate nella discoteca.");

	    }

	   
	    public synchronized void esci(int n) {
	        totPersone-=n; 
	        System.out.println(n + " persone sono uscite dalla discoteca.");
	    }


	    public synchronized int getTotPersone() {
	        return totPersone;
	    }
	


}
