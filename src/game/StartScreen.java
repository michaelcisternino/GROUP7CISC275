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
import javax.swing.JPanel;

import view.MainView;

/**
 * A start screen for the game.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public class StartScreen extends JPanel{

	public static JButton start = new JButton("Start!");
	public Container pane;
	//public static StartScreen ss = new StartScreen();
	
//	public static void main(String[] args) {
//		System.out.println("in start screen");
//		//Game game = new Game();
//		//JFrame frame = new JFrame(TITLE);;
//		game.pack();
//		game.setResizable(false);
//		game.setLocationRelativeTo(null);
//		//start.addActionListener(new Starter());
//		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		game.setVisible(true);
//	}
//
	/**
	 * Constructor for the start screen. Sets the background, draws a nice border, and adds a button with an ActionListener.
	 * @param game
	 */
	public StartScreen(Game game){
		setBackground(Color.BLACK);
		setOpaque(false);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Crabby"));
		this.add(start);
		start.addActionListener(new Starter(game));
	}
	
	class Starter implements ActionListener{
		
		Game g;
		
		/**
		 * Constructor for the starter actionlistener.
		 * Takes in a game.
		 * @param g
		 */
		Starter(Game g){
			this.g = g;
		}
		
		/**
		 * Action listener calls DoIt().
		 */
		public void actionPerformed(ActionEvent e) {
			DoIt();
		}
		/**
		 * Sets the game playing status to true.
		 */
		public void DoIt(){
			g.setPlaying(true);
		}
		
	}
	
}
