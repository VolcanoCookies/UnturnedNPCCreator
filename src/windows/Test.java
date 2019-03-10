package windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class Test
{
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
        final JFrame frame = new JFrame("JColorChooser Demo");
 
        
        JPanel p = new JPanel();
        JColorChooser cc = new JColorChooser();
        cc.setPreviewPanel(p);
        Component[] panels = cc.getChooserPanels();
        panels[panels.length] = (Component) p;
        
        JOptionPane.showMessageDialog(null, panels);
        Color newColor = JColorChooser.showDialog(
                frame,
                "Choose Background Color",
                frame.getBackground());
        if(newColor != null){
            frame.getContentPane().setBackground(newColor);
        }
 
        Container pane = frame.getContentPane();
        pane.setLayout(new FlowLayout());
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}