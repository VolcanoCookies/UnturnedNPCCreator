package util;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OpenURL 
{
	public static void OpenURL(String url)
	{
		String os = System.getProperty("os.name").toLowerCase();
		if(os.indexOf("win") >= 0)
		{
			//Windows System
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Failed to open website automatically, use url: " + url, "Warning",
						JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		} else if (os.indexOf("mac") >= 0)
		{
			//Mac system
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec("open " + url);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Failed to open website automatically, use url: " + url, "Warning",
						JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		} else if (os.indexOf("nix") >=0 || os.indexOf("nux") >=0)
		{
			//Linux system
			Runtime rt = Runtime.getRuntime();
			String[] browsers = { "epiphany", "firefox", "mozilla", "konqueror",
			                                 "netscape", "opera", "links", "lynx" };

			StringBuffer cmd = new StringBuffer();
			for (int i = 0; i < browsers.length; i++)
			    if(i == 0)
			        cmd.append(String.format(    "%s \"%s\"", browsers[i], url));
			    else
			        cmd.append(String.format(" || %s \"%s\"", browsers[i], url)); 
			    // If the first didn't work, try the next browser and so on

			try {
				rt.exec(new String[] { "sh", "-c", cmd.toString() });
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Failed to open website automatically, use url: " + url, "Warning",
						JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		} else
		{
			JOptionPane.showMessageDialog(new JFrame(), "Cant open website in current operating system, use url: " + url, "Warning",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
