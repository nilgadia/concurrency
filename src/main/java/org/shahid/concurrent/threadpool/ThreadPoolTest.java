package org.shahid.concurrent.threadpool;

public class ThreadPoolTest {
	public static void main(String[] args) throws Exception {
		CustomThreadPool executor = new CustomThreadPool(3, 4);
		for (int taskNumber = 1; taskNumber <= 7; taskNumber++) {
			Task task = new Task(taskNumber);
			executor.execute(task);
		}
	}
}
