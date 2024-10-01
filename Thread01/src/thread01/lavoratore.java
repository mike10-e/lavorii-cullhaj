package thread01;

public class lavoratore implements Runnable {
	private int N;
	private int x;
	private int num;
	private boolean complete;
	
	
	public lavoratore (int N,int x) {
		this.N = N;
		this.x = x;
		num = 0;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (num < x) {
			num++;
			System.out.println(Thread.currentThread().getId() +" " + num +" " +x);
			try {
				Thread.sleep(120);
			} catch (InterruptedException e) {}
		}
		complete = true;
	}

	public boolean isComplete() {
		if(complete) {
			System.out.println(Thread.currentThread().getId() + "COMPLETATO ");
		} else {
			System.out.println(Thread.currentThread().getId() + " " + num);
		}
		return complete;
	
	}

		
}
