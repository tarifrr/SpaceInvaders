package gamecode;

import java.awt.*;

public class BulletFiring extends Thread {
	
	private GameBoard board;
	private Enemy[] enemies;
	private Bullet bullet;
	
	
	
	public BulletFiring(GameBoard board, Enemy[] enemies, Bullet bullet) {
		super();
		this.board = board;
		this.enemies = enemies;
		this.bullet = bullet;
	}



	public void run(){
		
		while(bullet.getY() > -10){
			
			bullet.setY(bullet.getY() - 5);
			checkCollision();
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			
			board.repaint();
		}
		
	}
	
	public void checkCollision(){
		
		Rectangle bulletRect = new Rectangle(bullet.getX(),bullet.getY(),8,8);
		
		for(int i = 0; i < enemies.length; i++){
			
			Rectangle ghostRect = new Rectangle(enemies[i].getX(),enemies[i].getY(),32,32);
			
			if(bulletRect.intersects(ghostRect) == true){
				Sound.bulletHitSound();
				board.score++;
				enemies[i].setAlive(false);
				enemies[i].setX(-500);
				bullet.setX(5000);
				
			}
			
			
		}
		
		
		
		
	}

	
	
	
	
	
	
}
