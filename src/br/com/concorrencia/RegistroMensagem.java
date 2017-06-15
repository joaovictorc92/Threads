package br.com.concorrencia;

import java.util.Collection;
import java.util.Vector;

public class RegistroMensagem {

	public static void main(String[] args) throws InterruptedException {
		Collection<String> mensagens = new Vector<String>();

		Thread thread1 = new Thread(new Mensagem("Thread 1", 4, mensagens));
		Thread thread2 = new Thread(new Mensagem("Thread 2", 4, mensagens));
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println("Threads produtoras de mensagens finalizadas!");

		if (!mensagens.isEmpty())
			for (String mensagem : mensagens) {
				System.out.println(mensagem);
			}

	}

}
