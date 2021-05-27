package main;

import problem.Consumer;
import problem.ConsumerII;
import problem.DirCreation;
import problem.Producer;
import problem.ProducerII;
import problem.Resource;

public class MainII {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainII();

	}
	
	public MainII(){
		long inicio = System.nanoTime();
		final int numProdutores = 1;
		final int numConsumidores = 4;
				
		//criamos um resource
		Resource<int[][]> recurso = new Resource<int[][]>();
		
		//criamos o numero de produtores compativel com o numero de arquivos/discos
		ProducerII<int[][]>[] produtores = new ProducerII[numProdutores];
		for(int i=0; i<produtores.length; i++)
			produtores[i] = new ProducerII<int[][]>(recurso);
		
				
		//criamos os consumidores
		DirCreation.createDirs("../consumidor/");
		ConsumerII<int[][]>[] consumidores = new ConsumerII[numConsumidores];
		for(int i=0; i<consumidores.length; i++)
			consumidores[i] = new ConsumerII<int[][]>(recurso,String.valueOf(i), "../consumidor/");
		
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
