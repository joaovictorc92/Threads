package br.com.threads;

import javax.swing.JOptionPane;

public class Leitor implements Runnable {
	private Thread thread;

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public void scanner() {
		while (true) {
			String nome = JOptionPane.showInputDialog("Digite a chave para interromper o processo");
			if(nome.equals("trem")){
				this.thread.stop();
				break;
			}
		}
	}

	@Override
	public void run() {
		this.scanner();
	}

}
