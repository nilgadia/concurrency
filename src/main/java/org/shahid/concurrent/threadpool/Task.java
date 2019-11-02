package org.shahid.concurrent.threadpool;

/**
 * Task simulates the task to be submitted to thread pool.
 *
 */
public class Task implements Runnable {
	
	private int number;
	public Task(int number) {
		this.number = number;
	}
	
	@Override
	public void run() {
		System.out.println("Start executing of task number :"+ number);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End executing of task number :"+ number);
	}
}
