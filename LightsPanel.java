package berger_may_muehlehner_lights_out;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Optische Oberflaeche des Programms
 * 
 * @author benedikt berger
 * @version 1.0
 * 
 */
public class LightsPanel extends JPanel {

	private static int amount = 5;
	
	private JButton[][] lights;
	private JButton reset;
	private static final long serialVersionUID = 1L;
	private JPanel buttons, bottom;
	private LightsController control;

	public LightsPanel(LightsController controller){
		this.control = controller;
		buttons = new JPanel();
		bottom = new JPanel();
		
		this.setLayout(new BorderLayout());
		buttons.setLayout(new GridLayout(amount,amount,5,5));
		bottom.setLayout(new BorderLayout());
		
		lights = new JButton[amount][amount];
		
		
		for(int x=0;x<amount;x++){
			for(int y=0;y<amount;y++){
				lights[x][y] = new JButton();
				lights[x][y].setBackground(Color.BLACK);
				lights[x][y].setOpaque(true);
				lights[x][y].setBorderPainted(false);
				lights[x][y].addActionListener(control);
				lights[x][y].setActionCommand(y+" "+x);
				buttons.add(lights[x][y], BorderLayout.CENTER);
			}
		}
		buttons.setBounds(20, 20, 200, 100);
		
		reset = new JButton("Reset");
		reset.addActionListener(control);
		reset.setActionCommand("reset");
		bottom.add(reset, BorderLayout.CENTER);
		
		this.add(bottom, BorderLayout.SOUTH);
		this.add(buttons,BorderLayout.CENTER);
	}
	
	/**
	 * Ermoeglicht das aktivieren und deaktivieren von bestimmten Lights
	 * @param x Koordinate fuer das Array
	 * @param y Koordinate fuer das Array
	 * @param status an oder aus
	 */
	public void control(int x, int y, boolean status){
		if(status){
			lights[y][x].setBackground(Color.YELLOW);
		} else {
			lights[y][x].setBackground(Color.BLACK);
		}
	}
	
	/**
	 * Setzte alle Lights zurueck
	 */
	public void reset(){
		for(int x=0;x<amount;x++){
			for(int y=0;y<amount;y++){
				lights[x][y].setBackground(Color.BLACK);
			}
		}
	}
	
	/**
	 * Getter fuer Lights
	 * @return lights
	 */
	public JButton[][] getLight() {
		return lights;
	}
}