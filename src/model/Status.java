package model;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import game.Game;
/**
 * On-screen status bar.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 */
public class Status extends JPanel {
	JLabel statusLabel = new JLabel();
	/**
	 * Creates the status bar and adds it to the frame.
	 */
	public Status(){
//		super();
//		super.setPreferredSize(new Dimension(Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE));
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		setPreferredSize(new Dimension(100, 20));
		setLayout(new BorderLayout());
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(statusLabel);
	}
	
	/**
	 * Updates the status bar. Gets information on the quantities of items from the controller.
	 */
	public void update(){
		statusLabel.setText("Lives: " + Game.gameControl.crabby.getLives() + " Trash Bags: " + Game.gameControl.crabby.trashBagCnt + " Hay: " + Game.gameControl.crabby.hayCnt + " Seeds: " + Game.gameControl.crabby.seedCnt + " Compost: " + Game.gameControl.crabby.compCnt + " Oysters: " + Game.gameControl.crabby.oysterCnt + " Trash: " + Game.gameControl.crabby.trashCnt + " Recyclables: " + Game.gameControl.crabby.recycleCnt);
	}

}
