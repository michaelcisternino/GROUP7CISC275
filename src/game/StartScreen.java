package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.MainView;

public class StartScreen extends JPanel{

	public static JButton start = new JButton("Start!");
	public static JLabel j = new JLabel("Hey");
	public Container pane;
	//public static StartScreen ss = new StartScreen();
	
	public static void main(String[] args){
		Game game = new Game();
//		game.pack();
//		game.setResizable(false);
//		game.setLocationRelativeTo(null);
//		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//game.add(j);
		game.setVisible(true);
	}
	
	public StartScreen(Game game){
		setBackground(Color.BLACK);
		setOpaque(false);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Crabby"));
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
