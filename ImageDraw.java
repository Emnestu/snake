import javax.swing.*;
import java.awt.*;

public class ImageDraw extends JPanel{
	private int width;
	private int height;
	private char[][] b;
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	this.setBackground(Color.WHITE);
    	
    	g.setColor(Color.BLACK);
    	for(int i=0; i < width; i++) {
    		for(int j=0; j < height; j++) {
    			g.drawRect(i*20, j*20, 20, 20);
    			if(b[i][j] == 'O') {
    				g.setColor(Color.GREEN);
    				g.fillOval(i*20+2, j*20+2, 16, 16);
    				g.setColor(Color.BLACK);
    			}
    			if(b[i][j] == 'F') {
    				g.setColor(Color.RED);
    				g.fillRect(i*20+2, j*20+2, 16, 16);
    				g.setColor(Color.BLACK);
    			}
    			if(b[i][j] == '*') {
    				g.setColor(new Color(32, 176, 6));
    				g.fillRect(i*20+2, j*20+2, 16, 16);
    				g.setColor(Color.BLACK);    		
    			}
    			if(b[0][0] == 'G') {
    				g.setColor(Color.LIGHT_GRAY);
    				g.fillRect(10, 10, 20*6, 20*2);
    				g.setColor(Color.BLACK);
    				g.setFont(new Font("default", Font.BOLD, 16));
    				g.drawString("GAME OVER!", 20, 35);
    			}
       		}
   		}
    }
    public void giveSize(int width, int height) {
    	this.width = width;
    	this.height = height;
    }
    public void setBoard(char b[][]) {
    	this.b = b;
    }
}