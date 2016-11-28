import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class main {
	public static final GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static final int screenWidth = gd.getDisplayMode().getWidth();
	public static final int screenHeight = gd.getDisplayMode().getHeight();
	public static final int HEIGHT = 500;
	public static final int WIDTH = 500;
	public static JFileChooser picPath = new JFileChooser();
	public static JFrame mainFrame = new JFrame("Main");
	public static JTextField frameName = new JTextField();
	public static Button browse = new Button("Browse");
	public static Button createNew = new Button("New");

	static class MyCanvas extends JComponent {
		private static final long serialVersionUID = -1799829313910727465L;
		public void paint(Graphics g) {
			g.drawRect(10, 10, 100, 100);
		}
	}

	public static void main(String[] args) {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(HEIGHT, WIDTH);
		mainFrame.setLocation((screenWidth - WIDTH) / 2, (screenHeight - HEIGHT) / 2);
		picPath.setCurrentDirectory(new File(System.getProperty("user.home")));

		createNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String arg = frameName.getText();
				newFrame(arg);
			}
		});

		addItem(mainFrame, frameName, BorderLayout.NORTH);
		// addItem(mainFrame, browse, BorderLayout.CENTER);
		addItem(mainFrame, createNew, BorderLayout.SOUTH);
		mainFrame.getContentPane().add(new MyCanvas());
		mainFrame.setVisible(true); // shows the frame
	}
	// END OF MAIN

	public static void addItem(JFrame frame, Component comp, Object constraints) {
		frame.getContentPane().add(comp, constraints);
	}

	public static void newFrame(String name) {
		JFrame frame = new JFrame(name);
		frame.setSize(HEIGHT, WIDTH);
		frame.setVisible(true);
	}

	public static void newFrame(String name, String picPath) {
		JFrame frame = new JFrame(name);
		frame.add(new JLabel(new ImageIcon(picPath)));
		frame.setSize(HEIGHT, WIDTH);
		frame.setVisible(true);
	}
}
