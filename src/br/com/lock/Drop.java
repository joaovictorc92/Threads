package br.com.lock;

public class Drop {
	private String message;
	
	private boolean empty = true;
	
	public synchronized String take(){
		
		while(empty){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		empty = true;
		notifyAll();
		return message;
	}
	
	public synchronized void put(String message){
		while(!empty){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.message = message;
		empty = false;
		notifyAll();
	}
}
