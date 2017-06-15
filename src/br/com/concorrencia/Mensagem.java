package br.com.concorrencia;

import java.util.Collection;

public class Mensagem implements Runnable{
	private String mensagem;
	private int quantidade;
	Collection<String> mensagens;
	private static boolean semaforo = true;
	
	public Mensagem(String mensagem, int quantidade, Collection<String> mensagens){
		this.mensagem = mensagem;
		this.quantidade = quantidade;
		this.mensagens =  mensagens;
	}
	
	
	
	public synchronized void produzMensagem() throws InterruptedException{
		for(int i=0; i < this.quantidade ; i++){
			if(mensagem.equals("Thread 1") && semaforo==true){
				semaforo = false;
			}else if (mensagem.equals("Thread 1") && semaforo==false){
				Thread.sleep(10000);
			}else if (mensagem.equals("Thread 2") && semaforo==false){
				semaforo = true;
			}else{
				Thread.sleep(10000);
			}
				
			mensagens.add(mensagem + " "+ (i+1)+ " mensagens");
			System.out.println(mensagem + " "+ (i+1)+ " mensagens --");
		}
	}
	
	@Override
	public void run() {
		
		try {
			this.produzMensagem();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
