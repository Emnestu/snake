import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.Timer;


public class Control extends JFrame implements ActionListener, KeyListener {
    private Snake s;
	private View v;
	private int width;
	private int height;		                     	
	public Control (String title) {
		super(title);
		width = 11;
		height = 11;
		setDefaultCloseOperation(3);
		s = new Snake(width, height);
		v = new View(s.getBoard(), this);
		add (v);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	public void actionPerformed (ActionEvent e) {
		if("down".equals(e.getActionCommand())) {
			s.giveDir('D');
		} else if("up".equals(e.getActionCommand())) {
			s.giveDir('U');
		} else if("left".equals(e.getActionCommand())) {
			s.giveDir('L');
		} else if("right".equals(e.getActionCommand())) {
			s.giveDir('R');
		} else if("restart".equals(e.getActionCommand())) {
			s = new Snake(width, height);
		} else {
			s.tick();
			//v.setLabels(s.getBoard());
			v.giveBoard(s.getBoard());
		}
	}
	public static void main (String args[]) {
		Control cl;
		cl = new Control("Snake");
		Timer t;
		t = new Timer(500, cl);
		t.start();
	}
    public void keyTyped(KeyEvent e) {
    	
    }
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
    	if(key == KeyEvent.VK_DOWN) {
    		s.giveDir('D');
    	} else if(key == KeyEvent.VK_UP) {
    		s.giveDir('U');
    	} else if(key == KeyEvent.VK_LEFT) {
    		s.giveDir('L');
    	} else if(key == KeyEvent.VK_RIGHT) {
    		s.giveDir('R');
    	} else if(key == KeyEvent.VK_R) {
    		s = new Snake(width, height);
      	}
    }
    public void keyReleased(KeyEvent e) {
        
    }
}