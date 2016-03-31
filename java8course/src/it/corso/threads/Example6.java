package it.corso.threads;

/**
 * An exercise in creating synchronized code.
 * Try removing the synchronized block and see for yourself.
 * @author thimoty
 *
 */
class Example6 extends Thread {
	StringBuffer letter;

    public Example6(StringBuffer letter) { this.letter = letter; }

	public void run() {
		synchronized (letter) { // #1
			for (int i = 1; i <= 100; ++i)
				System.out.print(letter);
				System.out.println();
				char temp = letter.charAt(0);
				++temp; // Increment the letter in StringBuffer:
				letter.setCharAt(0, temp);
		} // #2
	}

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("A");
		new Example6(sb).start();
		new Example6(sb).start();
		new Example6(sb).start();
	}
}
