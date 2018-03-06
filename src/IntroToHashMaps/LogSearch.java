package IntroToHashMaps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import IntroToArrayLists.GuestBook;

public class LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	JFrame frame = new JFrame();
		JButton button1 = new JButton("Add Entry");
		JButton button2 = new JButton("Search IDs");
		JButton button3 = new JButton("View List");
		JButton button4 = new JButton("Remove Items");
		JPanel panel = new JPanel();
		HashMap<Integer, String> names = new HashMap<Integer, String>();
		String output="";
	public static void main(String[] args) {
		
		LogSearch logSearch = new LogSearch();
		
		logSearch.initiate();
	}
	void initiate() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 250);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		frame.add(panel);
		frame.pack();
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1) {
			String integer = JOptionPane.showInputDialog("Enter ID Value");
			int integers = Integer.parseInt(integer);
			names.put(integers, JOptionPane.showInputDialog("Enter Name"));
		}
		if(e.getSource()==button2) {
			String search = JOptionPane.showInputDialog("Which ID are you looking for?");
			int integers = Integer.parseInt(search);
			if(names.containsKey(integers)) {
			JOptionPane.showMessageDialog(null,"That ID contains the name: " + names.get(integers));
			}
			else {
				JOptionPane.showMessageDialog(null, "Error 404: Entry not found");
			}
		}
		if(e.getSource()==button3) {
			output = "";
			for(Integer nameID:names.keySet()) {
				output+="ID: ";
				output+=nameID;
				output+="     Name: ";
				output+=names.get(nameID);
				output+="\n";
			}
			JOptionPane.showMessageDialog(null, output, "IDs", 3);
		}
		if(e.getSource()==button4) {
			String remove = JOptionPane.showInputDialog("Which ID would you like to remove?");
			int integers = Integer.parseInt(remove);
			names.remove(integers);
		}
	}
}
	

