package IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener{
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame = new JFrame();
	JButton button1 = new JButton("Add Names");
	JButton button2 = new JButton("View Names");
	JPanel panel = new JPanel();
	ArrayList<String> names = new ArrayList<String>();
	String output="";
public static void main(String[] args) {
	GuestBook guestbook = new GuestBook();
	
	guestbook.initiate();
}
void initiate() {
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300, 250);
	panel.add(button1);
	panel.add(button2);
	frame.add(panel);
	frame.pack();
	button1.addActionListener(this);
	button2.addActionListener(this);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==button1) {
		names.add(JOptionPane.showInputDialog("Who would you like to add?"));
	}
	if(e.getSource()==button2) {
		for(String name:names) {
			output+=name;
			output+="\n";
		}
		JOptionPane.showMessageDialog(null, output, "Big Extravagant Guestlist for a Big Extravagant Party", 3);
	}
}
}
