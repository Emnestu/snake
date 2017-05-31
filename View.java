import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class View extends JPanel {
    private JLabel b[][];
    private JPanel upPanel;
    private JPanel downPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private ImageDraw alexPanel;
    public View (char board[][], Control control) {
        super(new BorderLayout());
        /*upPanel = new JPanel(new GridLayout(board[0].length, board.length));
        b = new JLabel [board.length][board[0].length];
        for(int y = 0; y < board[0].length; y++) {
            for(int x = 0; x < board.length; x++) {
                b[x][y] = new JLabel(Character.toString(board[x][y]));
                upPanel.add(b[x][y]);
            }
        }
        add(upPanel, BorderLayout.NORTH);*/
        alexPanel = new ImageDraw();
        alexPanel.setBoard(board);
        alexPanel.giveSize(board.length, board[0].length);  
        Dimension panelD = new Dimension(board.length*20-9, board[0].length*20-9);
        alexPanel.setPreferredSize(panelD); 
        add(alexPanel, BorderLayout.CENTER);
        downPanel = new JPanel();
        add(downPanel, BorderLayout.PAGE_END);
        leftPanel = new JPanel();
        add(leftPanel, BorderLayout.WEST);
        rightPanel = new JPanel();
        add(rightPanel, BorderLayout.EAST);
        
        JButton button;
        
        button = new JButton("Down");
        button.addKeyListener(control);
        downPanel.add(button);
        button.addActionListener(control);
        button.setActionCommand("down");
        button.setVisible(false);
        
        button = new JButton("Up");
        button.addKeyListener(control);
        downPanel.add(button);
        button.addActionListener(control);
        button.setActionCommand("up");
        button.setVisible(false); 
        
        button = new JButton("Left");
        button.addKeyListener(control);
        leftPanel.add(button);
        button.addActionListener(control);
        button.setActionCommand("left");
        button.setVisible(false); 
        
        button = new JButton("Right");
        button.addKeyListener(control);     
        rightPanel.add(button);
        button.addActionListener(control);
        button.setActionCommand("right");
        button.setVisible(false); 
        
        button = new JButton("Restart");
        button.addKeyListener(control);     
        downPanel.add(button);
        button.addActionListener(control);
        button.setActionCommand("restart"); 
        button.setFocusPainted(false);
    }
    public void setLabels(char grid[][]) {
        for (int y = 0; y < b[0].length; y++) {
            for (int x = 0; x < b.length; x++) {
                b[x][y].setText(Character.toString(grid[x][y]));
            }
        }
    }
    public void giveBoard(char b[][]) {
        alexPanel.setBoard(b);
        alexPanel.repaint();
    }
}