
public class GameThread extends Thread {
	
	private Board gameBoard;
	
	//Thread that checks for a winner and stops the game when one if found.
	public GameThread(Board gameBoard){
		this.gameBoard = gameBoard;
	}
	
	public void run() {
		
		while(!isWinner(gameBoard)) {

			
		}
		Main.displayWinner(gameBoard);
		gameBoard.lockBoard();
		
	}
	
	public static boolean isWinner(Board GB){
		return GB.isWinner();
	}

}
