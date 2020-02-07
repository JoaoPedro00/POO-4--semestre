import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Jogo extends JFrame  {
	
	
	private int x=300;
	private int y=200;
	private int dx=0;
	private int dy=0;
	MyDrawPanel drawPanel = new MyDrawPanel();
	
	public static void main(String[] args) {
		new Jogo();
	
	}

	public Jogo()  {
		JFrame janela = new JFrame();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawPanel.setFocusable(true);
		drawPanel.requestFocus();
		janela.setContentPane(drawPanel);
		janela.setSize(640, 480);
		janela.setVisible(true);
	
	
}
	
	
	class MyDrawPanel extends JPanel implements KeyListener {
	
	public void paint(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 40, 40);
		
		addKeyListener(this);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(x==0) {
				dx = 0;
			} else {
				dx = -1;
			}
	    }

	    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	if(x==580) {
	    		dx = 0;
			} else {
				dx = 1;
			}
	    }

	    if (e.getKeyCode() == KeyEvent.VK_UP) {
	    	if(y==0) {
	    		dy = 0;
			} else {
				dy = -1;
			}
	    }

	    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	if(y==400) {
	    		dy = 0;
			} else {
				dy = 1;
			}
	    }
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(x==0) {
				dx = 0;
			} else {
				dx = -1;
			}
	    }

	    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	if(x==580) {
	    		dx = 0;
			} else {
				dx = 1;
			}
	    }

	    if (e.getKeyCode() == KeyEvent.VK_UP) {
	    	if(y==0) {
	    		dy = 0;
			} else {
				dy = -1;
			}
	    }

	    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	if(y==400) {
	    		dy = 0;
			} else {
				dy = 1;
			}
	    }
	    move();
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        move();
    }
	
	private void move() {
		 x += dx;
	     y += dy;
	     drawPanel.repaint();
	}
	}
}







