package problem;

public class ConsumerII<S> extends Thread{
	
	private Resource<S> re;
	SerializeObjectImpl<S> s;
	String ID;
	int num;
	
	
	public ConsumerII(Resource<S> re, String ID, String path){
		this.re = re;		
		s = new SerializeObjectImpl<S>(path);
		this.ID = ID;
		num =0;
	}
	
	public void run(){
		try {
				S str = null;
				
				while((re.isFinished()==false)||(re.getNumOfRegisters()!=0)){
					if ((str = re.getRegister())!=null){
						s.serializeToFile(str, ID+num);
						num++;
					}
				}
					
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
				
		//System.err.println("parte da matriz com: " + parteMatriz.size()+ " colunas");
	}

}
