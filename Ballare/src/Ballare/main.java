package Ballare;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persone persona = new Persone();
		for (int i = 0; i < 20; i++) {	
			Thread thread = new Thread(persona);
			thread.start();
		}
		
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println(persona.getTotPersone());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
