package problem;



public class Consumer<S> extends Thread{
	
	private Resource<S> re;
	
	public Consumer(Resource<S> re){
		this.re = re;
		//parteMatriz = new LinkedList<S>();
	}
	
	public void run(){
		try {
				S str = null;
				
				while((re.isFinished()==false)||(re.getNumOfRegisters()!=0)){
					if ((str = re.getRegister())!=null){
						//fazer algo com o recurso que foi consumido
						//if (((String)str).endsWith("100"))
							System.err.println(str);
					}
				}
					
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
				
		//System.err.println("parte da matriz com: " + parteMatriz.size()+ " colunas");
	}

}
