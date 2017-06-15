package br.com.threads;

public class Processo implements Runnable{
	public void start(){
		int i=0;
		while(true){
			System.out.println("trem "+i);
			i++;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.start();
	}
}
