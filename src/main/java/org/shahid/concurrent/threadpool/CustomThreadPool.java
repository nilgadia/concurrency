package org.shahid.concurrent.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

	private LinkedBlockingQueue<Runnable> taskQueue;

	public CustomThreadPool(int queueSize, int nThreads) {

		taskQueue = new LinkedBlockingQueue<Runnable>(queueSize);
		String threadName = null;
        TaskExecutor taskExecutor = null;
		for (int i = 1; i <= nThreads; i++) {
			taskExecutor = new TaskExecutor(taskQueue);
			threadName = "Thread-" + i;
			System.out.println("Thread-" + i + " created in ThreadPool.");
			Thread thread = new Thread(taskExecutor, threadName);
            thread.start();
		}
	}

    // Execute the task, task must be of Runnable type.
	public synchronized void execute(Runnable task) throws Exception {
		System.out.println("task has been added.");
		this.taskQueue.put(task);
	}

}
