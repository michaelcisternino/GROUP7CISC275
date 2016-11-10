package game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.MainView;

public class StartScreen extends JPanel{

	public static JButton start = new JButton("Start!");
	public Container pane;
	//public static StartScreen ss = new StartScreen();
	
	public static void main(String[] args) {
		Game game = new Game();
//		JFrame frame = new JFrame(TITLE);;
		game.pack();
		game.setResizable(false);
		game.setLocationRelativeTo(null);
		//start.addActionListener(new Starter());
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
	}
	
	public StartScreen(Game game){
		this.add(start);
		start.addActionListener(new Starter(game));
	}
	
	class Starter implements ActionListener{
		
		Game g;
		
		Starter(Game g){
			this.g = g;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DoIt();
		}
		
		public void DoIt(){
			g.setPlaying(true);
		}
		
	}
	
}
