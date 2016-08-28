package gamecode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoard extends JPanel implements KeyListener {

	
	Spaceship ship;
	Enemy[] enemies = new Enemy[15];
	Bullet[] bullets = new Bullet[10];
	int bulletCount = 0; 
	static int score = 0;
	
	public GameBoard(){
		super();
		
		super.addKeyListener(this);
		super.setFocusable(true);
		
		ship = new Spaceship(300,550,"images//spaceship.png");
		
		int xEnemyPos = 0, yEnemyPos = -100;
		
		for(int i = 0;  i < bullets.length; i++){
			
			bullets[i] = new Bullet(-100,-100, "images//bullet.png");
		}
		
		
		
		for(int i = 0; i < enemies.length; i++){
			
			String path = (i % 2 == 0)?"ghost.png":"spike.png";
			
			enemies[i] = new Enemy(xEnemyPos, yEnemyPos,"images//" + path ,true);
			xEnemyPos += 40;
			MoveEnemy me = new MoveEnemy(enemies[i],this,(int)(10 + Math.random() * 50));
			me.start();
		}
		
		
		
	}
	
	public void paint(Graphics g){
		
		ImageIcon background = new ImageIcon("images//background.png");
		g.drawImage(background.getImage(),0,0,null);
		
		ship.draw(g);
		
		g.setColor(Color.GREEN);
		g.drawString("Score = " + score, 400,400);
		
		for(int i = 0; i < bullets.length; i++)
			bullets[i].draw(g);
		
		for(int i = 0; i < enemies.length; i++){
			if(enemies[i].isAlive() == true)
				enemies[i].draw(g);
		}
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == e.VK_LEFT){
			
			if(ship.getX() > 0)
				ship.setX(ship.getX() - 5);
			
			bullets[bulletCount].setX(ship.getX() + 25);
		}
		
		else if(e.getKeyCode() == e.VK_RIGHT){
			
			if(ship.getX() < 550)
				ship.setX(ship.getX() + 5);
			
			bullets[bulletCount].setX(ship.getX() + 25);
		}
		
		else if(e.getKeyCode() == e.VK_SPACE){
			
			bullets[bulletCount].setX(ship.getX() + 25);
			bullets[bulletCount].setY(ship.getY());
		
			
			BulletFiring bf = new BulletFiring(this,enemies,bullets[bulletCount]);
			bf.start();
					
			
			bulletCount++;
			if(bulletCount == 10)
				bulletCount = 0;
			
		}
		
		
		
		super.repaint();
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
