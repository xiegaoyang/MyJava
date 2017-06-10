package com.xgy.thread;
import java.util.concurrent.locks.ReentrantLock;


public class ThreadSync {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		Thread t1 = new Thread(new TestThread3(1));
		Thread t2 = new Thread(new TestThread3(2));
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}

class TestThread3 implements Runnable{
	
	private int type = -1;
	
	private static int count = 100;
	
	private static ReentrantLock lock = new ReentrantLock();
	
	TestThread3(int type)
	{
		this.type = type;
	}
	
	public void run()
	{
		int i = 0;
		
		if (1 == type)
			for (i=0; i<50; ++i)
			//while(count > 0)
			{
				lock.lock();
				count--;
				System.out.println(Thread.currentThread().getName() + ", count = " + count);
				lock.unlock();
			}
		else
			for (i=0; i<50; ++i)
			//while(count > 0)
			{
				lock.lock();
				count--;				
				System.out.println(Thread.currentThread().getName() + ", count = " + count);
				lock.unlock();
			}
	}

}

