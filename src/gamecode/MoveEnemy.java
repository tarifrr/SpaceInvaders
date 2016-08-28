package gamecode;

public class MoveEnemy extends Thread {
	
	private Enemy enemy;
	private GameBoard board;
	private int deltaTime;
	
	
	
	
	
	public MoveEnemy(Enemy enemy, GameBoard board, int deltaTime) {
		super();
		this.enemy = enemy;
		this.board = board;
		this.deltaTime = deltaTime;
	}





	public void run(){
		
		while(enemy.isAlive()){
			
			enemy.setY(enemy.getY() + 5);
			
			if(enemy.getY() > 600)
				enemy.setY(-100);
			
			try{
				Thread.sleep(deltaTime);
			}
			catch(Exception e){
				System.out.println(e);
			}
			board.repaint();
			
		}
		
	}
	
	

}
