package Producer_Comsumer;

import java.text.MessageFormat;
import java.util.Random;


public class Producer implements Runnable{
    private static final int TIME = 1000;
    private int remaining_quantity=0;
    Repository r;
    public Producer(Repository r1) {
    	r=r1;
	}

	@Override
    public void run() {
    	int id =(int)Thread.currentThread().getId();
		System.out.println("消费者id :"+id);
        Random ra = new Random();
        synchronized(r){
			while(true){
			    int suiji ;
			    
			    if(remaining_quantity!=0) {
			    	suiji=remaining_quantity;
			    	remaining_quantity=0;
			    }
			    else {
			    	suiji = ra.nextInt(r.buffer)%20+1;
			    }
			    int count = r.getCount();
			    if(count+suiji>20) {
			    	remaining_quantity=r.getCount()+suiji-20;
			    	System.out.println(MessageFormat.format("周云天{0}生产了{1}个资源，放完仓库还剩下20个资源,遗留了{2}",id, suiji,remaining_quantity));
		        	Repository.setCount(20);
			    }else {
			    	System.out.println(MessageFormat.format("周云天{0}生产了{1}个资源，放完仓库还剩下{2}个资源",id, suiji,count+suiji));
		        	Repository.setCount(count+suiji);
		        	remaining_quantity=0;
			    }	
		    	try {
		    		r.notifyAll();;
		    		System.out.println("生产者"+id+"进入等待");
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
