package problem;

import java.util.Random;

public class ProducerII<S> extends Thread{
	private Resource<S> re;
	
	public ProducerII(Resource<S> re){
		this.re = re;
	}
	
	public void run(){
		int numeroProducoes = 1000;
		
		//criando blocos
		int[][] bloco = new int[100][100];
		Random r = new Random();
		int k=0;
		while( k<numeroProducoes){
			for( int x = 0; x<bloco.length;x++){
				for(int y =0; y<bloco[0].length; y++){
					bloco[x][y] = r.nextInt(1000);
				}
					
			}
			re.putRegister((S)bloco);
			k++;
		}
	}

}
