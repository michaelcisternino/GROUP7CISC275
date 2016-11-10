package game;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

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
		this.setLayout(new GridLayout(7,1));
		setBackground(Color.CYAN);
		setOpaque(true);
		TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Game1");
		title.setTitleJustification(TitledBorder.CENTER);
		setBorder(title);
		start.setBackground(Color.YELLOW);
		start.setOpaque(true);
		this.add(start);
//        this.add(new Label(" "));
		start.addActionListener(new Starter(game));
		this.add(new JLabel("Estuary Game"));
		this.add(new JLabel("Instructions:"));
		this.add(new JLabel("Left/right to move, up to jump."
				+ " Collect trash bags, hay, compost, and seeds."
				+ " Use on enemies with these keys."
				+ " If you fall off, you lose a life."));
//		this.add(new JLabel("Up to jump"));
//		this.add(new JLabel("Collect trash bags, hay, compost, and seeds."));
//		this.add(new JLabel("Use on enemies with "));
//		this.add(new JLabel("Don't fall off!"));
		this.add(new Label(" "));
		this.add(new Label(" "));
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
