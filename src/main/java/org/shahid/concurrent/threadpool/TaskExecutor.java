package org.shahid.concurrent.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * TaskExecutor class will be responsible for executing the tasks
 *
 */
public class TaskExecutor implements Runnable {

	private LinkedBlockingQueue<Runnable> taskQueue;

	public TaskExecutor(LinkedBlockingQueue<Runnable> taskQueue) {
		this.taskQueue = taskQueue;
	}

	public void run() {
		try {
			while (true) {
				String name = Thread.currentThread().getName();
				Runnable task = taskQueue.take();
				Thread.sleep(500);
				System.out.println("Task Started by Thread :" + name);
				Thread.sleep(500);
                task.run();
                System.out.println("Task Finished by Thread :" + name);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}