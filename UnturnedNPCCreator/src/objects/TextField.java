package objects;

import javax.swing.JTextField;

public class TextField extends JTextField {

	public String getValue()
	{
		return this.getName().substring(8, this.getName().length()) + " " + this.getText();
	}
}
