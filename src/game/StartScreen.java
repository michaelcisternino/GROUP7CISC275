package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

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
		this.setLayout(new GridLayout(8,1));
		setBackground(Color.CYAN);
		setOpaque(true);
		TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Game1");
		title.setTitleJustification(TitledBorder.CENTER);
		setBorder(title);
		this.add(start);
		start.addActionListener(new Starter(game));
		this.add(new JLabel("Estuary Game"));
		this.add(new JLabel("Instructions:"));
		this.add(new JLabel("Left/right to move"));
		this.add(new JLabel("Up to jump"));
		this.add(new JLabel("Collect trash bags, hay, compost, and seeds."));
		this.add(new JLabel("Use on enemies with "));
		this.add(new JLabel("Don't fall off!"));
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