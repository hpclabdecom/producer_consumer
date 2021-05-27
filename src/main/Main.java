package main;

import problem.Consumer;
import problem.Producer;
import problem.Resource;
import problem.ResourceII;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();

	}
	
	public Main(){
		long inicio = System.nanoTime();
		final int numProdutores = 2;
		final int numConsumidores = 10;
				
		//criamos um resource
		Resource<String> recurso = new Resource<String>();
		
		//lista de arquivos
		String[] arquivos = {"matriz" , "matriz2"};
		
		//criamos o numero de produtores compativel com o numero de arquivos/discos
		Producer<String>[] produtores = new Producer[numProdutores];
		//cada arquivo possui 9699 linhas
		for(int i=0; i<produtores.length; i++)
			produtores[i] = new Producer<String>(arquivos[i], recurso);
		
				
		//criamos os consumidores
		Consumer<String>[] consumidores = new Consumer[numConsumidores];
		for(int i=0; i<consumidores.length; i++)
			consumidores[i] = new Consumer<String>(recurso);
		
		//executar		
		for(int i=0; i<produtores.length; i++)
			produtores[i].start();
		for(int i=0; i<consumidores.length; i++)
			consumidores[i].start();
		
		
		
		//finalizamos
		try{
			for(int i=0; i<produtores.length; i++)
				produtores[i].join();
			
			recurso.setFinished();
												
			for(int i=0; i<consumidores.length; i++)
				consumidores[i].join();
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		System.err.println("tempo de execucao: "+ (System.nanoTime()-inicio));
	}

}
