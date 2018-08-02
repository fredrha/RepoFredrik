package Game;

import java.util.ArrayList;

import Pieces.Bishop;
import Pieces.ChessPiece;
import Pieces.CoordinatePair;
import Pieces.Farmer;
import Pieces.King;
import Pieces.Knight;
import Pieces.Queen;
import Pieces.Rook;

//Initiates the game and controls movement of piece and switching of players
public class GameController {
	
	private static GameController gameController = null;
	private Player whitePlayer;
	private Player blackPlayer;
	private Player currentPlayer;
	private String white = "White";
	private String black = "Black";
	
	public static final String CHECKMATE = "checkmate";
	public static final String STALEMATE = "stalemate";
	public static final String INPROGRESS = "in progress";
	
	private String status;
	
	public GameController() {
		
		whitePlayer = new Player(white);
		blackPlayer = new Player(black);
		currentPlayer = whitePlayer;
		ChessBoard.initInstance(8, 8);
		
	}
	
	public static GameController initInstance() {
		gameController = new GameController();
		return gameController;
	}
	
	public static GameController getInstance() {
		if(gameController == null)
		gameController = new GameController();
		return gameController;
	}
	
	public String getStatus() {
		return status;
	}
	//TODO add functionality for restarting players
	public void restart() {
		//check to see if we need restart method for players
		//whitePlayer.restart();
		
		status = INPROGRESS;
		ChessBoard.initInstance(8, 8);
		initPieces();
	}
	public void initPieces() {
		initPieceHelper(whitePlayer, 6,7);
		initPieceHelper(blackPlayer, 1,0);
	}
	
	private void initPieceHelper(Player player, int frontRow, int backRow) {
		ChessBoard chessBoard = ChessBoard.getInstance();
		
		for(int i = 0; i < chessBoard.getWidth(); i++) {
			CoordinatePair CoordP = chessBoard.getCoordinates(frontRow, i);
			new Farmer(CoordP, player);
		}	
		CoordinatePair CoordP = chessBoard.getCoordinates(backRow, 0);
		new Rook(CoordP, player);
		
		CoordP = chessBoard.getCoordinates(backRow, 1);
		new Knight(CoordP, player);
		
		CoordP = chessBoard.getCoordinates(backRow, 2);
		new Bishop(CoordP, player);
		
		CoordP = chessBoard.getCoordinates(backRow, 3);
		new King(CoordP, player);
		
		CoordP = chessBoard.getCoordinates(backRow, 4);
		new Queen(CoordP, player);
		
		CoordP = chessBoard.getCoordinates(backRow, 5);
		new Bishop(CoordP, player);
		
		CoordP = chessBoard.getCoordinates(backRow, 6);
		new Knight(CoordP, player);
		
		CoordP = chessBoard.getCoordinates(backRow, 7);
		new Rook(CoordP, player);
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	public Player getOpponent() {
		if(currentPlayer == whitePlayer) {
			return blackPlayer;
		}
		else {
			return whitePlayer;
		}
	}
	public void switchPlayer() {
		if(currentPlayer == whitePlayer) {
			currentPlayer = blackPlayer;
		}
		else if(currentPlayer == blackPlayer) {
			currentPlayer = whitePlayer;
		}
		Chess.switchPlayer();
	}
	
	public void updateGameState() {
		
		if(getCurrentPlayer().opponentIsChecked()) {
			Chess.updateGameState("checked");
			System.out.println("checked");
			
		}
		else if(getCurrentPlayer().opponentIsCheckMate()) {
			status = CHECKMATE;
			Chess.updateGameState("checkmate");
		}
		else if(getCurrentPlayer().isStaleMate()) {
			status = STALEMATE;
			Chess.updateGameState("stalemate");
		}
		else {
			Chess.updateGameState(null);
			System.out.println("null");
		}

	}

	public void updateLatestmove(ChessPiece piece, CoordinatePair targetCoord) {
		String playerColor = piece.getPlayer().getColor();
		String pieceName = piece.getClass().getSimpleName().toString();
		String move = playerColor + " " + pieceName +
				" to" + " " + targetCoord.getX() + " " + targetCoord.getY();	
	Chess.updateLatestMove(move);
		
	}
	


}
