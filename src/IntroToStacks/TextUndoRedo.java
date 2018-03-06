package IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame frame= new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> texts = new Stack<String>();
	String output = "";
	Stack<String> last = new Stack<String>();
	public static void main(String[] args) {
		TextUndoRedo textUndoRedo = new TextUndoRedo();
		textUndoRedo.initiate();
	}
	void initiate() {
		panel.add(label);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE) {
			if(!texts.isEmpty()) {
			last.push(texts.pop());
			}
		}
		else if(e.getKeyChar()==KeyEvent.VK_ESCAPE) {
			if(!last.isEmpty()) {
			texts.push(last.pop());
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			texts.push("\n");
			
		}
	else if(e.getKeyCode()!=KeyEvent.VK_SHIFT){
			System.out.println(e.getKeyCode());
			texts.push(""+e.getKeyChar());
		}
		output = "";
		for(String text:texts) {
			output+=text;
			output+="";
		}
		label.setText(output);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
