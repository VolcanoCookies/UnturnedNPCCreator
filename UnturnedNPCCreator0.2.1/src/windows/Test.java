package windows;

import javax.swing.JFrame;

import processing.CheckIDConflict;

public class Test
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Test");
		frame.add(new CheckIDConflict());
	}
}
