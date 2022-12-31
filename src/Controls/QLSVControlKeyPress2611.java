package Controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class QLSVControlKeyPress2611 implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
//		if ( e.getKeyCode() ) {
//			
//		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		System.out.println("Phim vua nhấn " + e.getKeyCode());
	}

}
