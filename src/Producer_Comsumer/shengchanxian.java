package Producer_Comsumer;

public class shengchanxian {

	public static void main(String[] args) {
		Repository r1=new Repository();
		Producer p1 = new Producer(r1);
        Producer p2 = new Producer(r1);
        Producer p3 = new Producer(r1);
        Consumer c1 = new Consumer(r1);
        Consumer c2 = new Consumer(r1);
        Consumer c3 = new Consumer(r1);
        Thread thread1 = new Thread(p1); 
        Thread thread2 = new Thread(p2); 
        Thread thread3 = new Thread(p3);
        Thread thread4 = new Thread(c1);
        Thread thread5 = new Thread(c2);
        Thread thread6 = new Thread(c3);
        thread1.start(); 
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
	}

}
