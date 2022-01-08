package robatortas.code.files;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class bot {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.out.println("Spam Bot" + "\n");
		
		Robot robot = new Robot();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Input your text:");
			String text = scanner.nextLine();
			
			StringSelection stringSelection = new StringSelection(text);
			Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			clip.setContents(stringSelection, null);
			
			System.out.println("(ONLY INPUT NUMBERS ELSE IT'LL CRASH!)" + "\n" + "Input time in seconds:");
			
			String time = scanner.nextLine();
			
			System.out.println("time set to: " + time + "\n");
			
			System.out.println("Spamming will being in 5 seconds." + "\n" + "Close this window to exit the program");
			Thread.sleep(5000);
			
			while(Thread.currentThread().isAlive()) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);

				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
				int t = Integer.parseInt(time);
				Thread.sleep(t*1000);
			}
		} catch (HeadlessException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
}