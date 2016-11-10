package game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.MainView;

public class StartScreen extends JFrame{

	public static JButton start = new JButton("Start!");
	public Container pane;
	//public static StartScreen ss = new StartScreen();
	
	public static void main(String[] args) {
		Game game = new Game();
//		JFrame frame = new JFrame(TITLE);;
		game.pack();
		game.setResizable(false);
		game.setLocationRelativeTo(null);
		game.add(start);
		//start.addActionListener(new Starter());
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
	}
	
	public StartScreen(){
		pane = getContentPane();
		Dimension size = new Dimension(WIDTH*4, HEIGHT*4);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		MainView view = new MainView();
		pane.add(view, BorderLayout.CENTER);
	}
	
	class Starter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
}
