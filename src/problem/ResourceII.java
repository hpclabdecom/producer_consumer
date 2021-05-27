package problem;


import java.util.concurrent.ConcurrentLinkedQueue;

public class ResourceII<S> extends Resource<S>{
	private ConcurrentLinkedQueue<S> registers;
	
	public ResourceII(){
		this.registers = new ConcurrentLinkedQueue<S>();
		finished= false;	
	}
	
	public void putRegister(S register){
		
			this.registers.offer(register);
			wakeup();
		
	}	
	
	
	public S getRegister() throws Exception{
		
			if(!this.registers.isEmpty())
				return this.registers.poll();
			else {
				if(finished==false)
					suspend();
				return null;		
			}		
	}
	
	public int getNumOfRegisters(){
		return this.registers.size();
	}
}
