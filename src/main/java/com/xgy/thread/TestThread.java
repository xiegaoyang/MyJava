package com.xgy.thread;



public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("main thread name = " + Thread.currentThread().getName());
		
		Thread t1 = new Thread(new MyThread());
		int priority = t1.getPriority();
		System.out.println("priority = " + priority);//�߳�Ĭ�����ȼ���5
		System.out.println("name = " + t1.getName());
		
		t1.start();
		
		
		
		try {
			
			Thread.sleep(100);
			//Thread.yield();	//�ó�cpu
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}





class MyThread implements Runnable{
	

	public void run()
	{
		int i = 0;
		for (i=0; i<10; ++i)
		{
			System.out.println("i = " + i);
		}
	}
}