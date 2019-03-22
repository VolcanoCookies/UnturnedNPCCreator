package windows;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test
{
	static final String VERSION = "0.4.0";
	static final String FILE_URL = "https://github.com/VolcanoCookies/UnturnedNPCCreator/releases/download/0.3.3/UnturnedNPCCreator.zip";
	static final String FILE_NAME = "downloadtestjava.zip";
	
	public static String string = "test";
	
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(0, 0, 200, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		JButton button = new JButton("test");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.invalidate();
				
				
			}
		});
		JTextField textField = new JTextField();
		textField.setText(string);
		frame.add(button, BorderLayout.CENTER);
		frame.add(textField, BorderLayout.SOUTH);
		frame.pack();
		string = "yeeyeejuice";
	}
}