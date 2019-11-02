package org.shahid.concurrent.deadlock;

public class DeadlockSolution {
	public static void main(String[] args) {
		DeadlockSolution test = new DeadlockSolution();

		final A a = test.new A();
		final B b = test.new B();

		Runnable block1 = new Runnable() {
			public void run() {
				synchronized (b) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// Thread-1 have A but need B also
					synchronized (a) {
						System.out.println("In block 1");
					}
				}
			}
		};

		// Thread-2
		Runnable block2 = new Runnable() {
			public void run() {
				synchronized (b) {
					// Thread-2 have B but need A also
					synchronized (a) {
						System.out.println("In block 2");
					}
				}
			}
		};

		new Thread(block1).start();
		new Thread(block2).start();
	}

	// Resource A
	private class A {
	}

	// Resource B
	private class B {
	}
}
