package br.com.threads;

public class ThreadMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Processo processo = new Processo();
		Thread thread = new Thread(processo);
		thread.start();
		
		Leitor leitor = new Leitor();
		leitor.setThread(thread);
		Thread thread2 = new Thread(leitor);
		thread2.start();
	}

}
