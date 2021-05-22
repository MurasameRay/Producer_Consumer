package Producer_Comsumer;

import java.text.MessageFormat;
import java.util.Random;


public class Consumer extends Thread{
	private static final int TIME = 1000;
	Repository r;
    public Consumer(Repository r1) {
    	r=r1;
	}

    
	@Override
	public void run() {
		int id =(int)Thread.currentThread().getId();
		System.out.println("生产者id :"+id);
        Random ra = new Random();
        synchronized(r){
        	while(true){
	                int suiji = ra.nextInt(r.buffer)%20+1;
	                while(r.getCount()-suiji < 0) 
	                {
	                	try{
	                		r.wait();
	                	}
	                	catch (InterruptedException e) {
	                        e.printStackTrace();

	                        System.out.println("生产或消费出问题了，请检查资源是否一致");
//	                        Thread.currentThread().interrupt();
	                    }
	                }
                	int count = r.getCount();
	                System.out.println(MessageFormat.format("周云天{0}消费了{1}个资源，还剩下{2}个资源",id, suiji,count-suiji));
	                Repository.setCount(count-suiji);
                    r.notifyAll();
	                try {
	                	System.out.println("消费者"+id+"进入等待");
	                	Thread.sleep(1000);
						r.wait(6000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
        	
        	}
        
	}
	
}
