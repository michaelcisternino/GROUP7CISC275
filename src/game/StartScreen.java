
package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

//	public static JButton start = new JButton("Start!", new ImageIcon("Final Images/UI Buttons, Icons, Symbols/smallButton.png"));
//	public static JButton easy = new JButton("Easy");
//	public static JButton med = new JButton("Medium");
//	public static JButton hard = new JButton("Hard");
//	public static JButton quit = new JButton("Quit");
//	public Container pane;
//	public GridBagConstraints c;
	
	public Rectangle playButton = new Rectangle(Game.WIDTH *2 - 50, 150, 100, 50);
	public Rectangle helpButton = new Rectangle(Game.WIDTH *2 - 50, 250, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH *2 - 50, 350, 100, 50);
	
	
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
//		setBackground(Color.WHITE);
//		JLabel label = new JLabel(new ImageIcon("Final Images/Backgrounds/Estuary_Background_1.jpg"));
//		setOpaque(false);
//		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Super Estuary"));
		//this.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
//		this.add(start);
////		this.add(quit);
//		start.setPreferredSize(new Dimension(300,300));
//		start.addActionListener(new Starter(game));
//		game.addMouseListener(this);
//		c = new GridBagConstraints();
//		c.fill = GridBagConstraints.VERTICAL;
//		c.gridx = 1;
//		c.gridy = 1;
//		this.add(start, c);
//		this.add(quit,c);
//		this.add(start);
//		this.add(quit);
//		quit.addActionListener(new Quit());
//		this.setSize(new Dimension(Game.WIDTH*Game.SCALE,Game.HEIGHT*Game.SCALE));
//		this.setPreferredSize(new Dimension(Game.WIDTH*3,Game.HEIGHT*3));
	}
	
	public void paintComponent(Graphics g){
//		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g.drawImage(createImage("Final Images/Backgrounds/Estuary_Background_1.jpg"),0,0,Game.WIDTH*4,Game.HEIGHT*4, Color.BLACK,null);
		g.drawImage(createImage("Final Images/UI Buttons, Icons, Symbols/smallButton.png"), playButton.x, playButton.y, 100, 50, Color.BLUE, null);
		g.drawImage(createImage("Final Images/UI Buttons, Icons, Symbols/smallButton.png"), helpButton.x, helpButton.y, 100, 50, Color.BLUE, null);
		g.drawImage(createImage("Final Images/UI Buttons, Icons, Symbols/smallButton.png"), quitButton.x, quitButton.y, 100, 50, Color.BLUE, null);
	
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Super Estuary!", 350, 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x + 19, playButton.y + 35);
//		g2d.draw(playButton);
		g.drawString("Help", helpButton.x + 19, helpButton.y + 35);
//		g2d.draw(helpButton);
		g.drawString("Quit", quitButton.x + 19, quitButton.y + 35);
//		g2d.draw(quitButton);
	}
	
	/**
	 * Attempts to load an image given the filename.
	 * @param file
	 * @return img
	 */
	private Image createImage(String file) {
		Image img;
		try{
			img = ImageIO.read(new File(file));
			return img;
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	class Quit implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
		
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
