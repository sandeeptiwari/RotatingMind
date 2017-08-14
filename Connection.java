package com.test.teggig;

import java.util.concurrent.Semaphore;

public class Connection {
	private Semaphore sem = new Semaphore(10);
	private int connections;
	
	private Connection(){
		
	}
	
	public static Connection getInstance(){
		return LazyHolder.INSTANCE;
	}
	
	private static class LazyHolder {
        static final Connection INSTANCE = new Connection();
    }
	
	public void connect(){
		
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try{
			doConnect();
		}finally{
			sem.release();
		}
		
	}
	
	public void doConnect(){
		synchronized (this) {
			connections++;
			System.out.println("Current Connection :: "+connections);
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (this) {
			connections--;
			System.out.println("Current Connection :: "+connections);
		}
		
	}
}
