package Game;

import java.util.HashSet;
import javax.swing.JButton;
import Pieces.ChessPiece;
import Pieces.CoordinatePair;

//Stores information about the chessboard. Which pieces are at which coordinates
public class ChessBoard {
	private int width;
	private int height;
	private ChessPiece[][] chessSquares;
	private CoordinatePair[][] coordinates;
	private JButton selectedPiece = null;
	
	private static ChessBoard chessBoard = null;
	
	public ChessBoard(int width, int height) {
		this.width= width;
		this.height = height;
		this.chessSquares = new ChessPiece[height][width];
		this.coordinates = new CoordinatePair[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				this.coordinates[row][col] = new CoordinatePair(row, col);
			}
		}	
	}	
	public static ChessBoard initInstance(int width, int height) {
		chessBoard = new ChessBoard(width, height);
		return chessBoard;
	}
	public static ChessBoard getInstance() {
		if (chessBoard == null) {
			chessBoard = new ChessBoard(8, 8);	
		}
		return chessBoard;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public CoordinatePair getCoordinates(int x, int y) {
		return coordinates[x][y];
	}
	public ChessPiece getSquare(CoordinatePair CoordP) {
		return chessSquares[CoordP.getX()][CoordP.getY()];
	}
	
	public JButton getSelectedPiece() {
		return selectedPiece;
	}
	public void setSelectedPiece(JButton piece) {
		selectedPiece = piece;
	}
	
	//Adds a chessPiece to the list of pieces. Returns false if a spot is occupied.
	public boolean addPiece(ChessPiece piece, CoordinatePair CoordP) {
		if(chessSquares[CoordP.getX()][CoordP.getY()] == null) {
			chessSquares[CoordP.getX()][CoordP.getY()] = piece;
			return true;
		}
		return false;
	}
	/**
	 * Removes a piece at the Coordinates
	 * @param CoordP
	 * @return true is a piece was removed, false if there is no piece at the Coordinates
	 */
	public boolean removePiece(CoordinatePair CoordP) {
		
		int x = CoordP.getX();
		int y = CoordP.getY();
		if(chessSquares[x][y] != null) {
			chessSquares[x][y] = null;
			return true;
		}
		return false;
	}

	/**
	 * Move a piece to the target coordinates.
	 * @param piece
	 * @param targetCoord
	 * @return true if a piece is moved, false if not
	 */
	public boolean movePiece(ChessPiece piece, CoordinatePair targetCoord) {

		//Try to remove the piece at the current location
		if(!removePiece(piece.getPosition())) {
			return false;
		}
		//Try to add it to the new one
		if(!addPiece(piece, targetCoord)) {
			addPiece(piece, piece.getPosition());
			return false;
		}
		return true;
	}
	public void colorSelectedPiece() {
	//TODO implement to color selected pieces	
		
	}
	
	public HashSet<CoordinatePair> getAllPaths(CoordinatePair Coordp, Player currentPlayer){
		HashSet<CoordinatePair> paths = new HashSet<CoordinatePair>();
		
		HashSet<CoordinatePair> straightPaths = getStraightPaths(Coordp, currentPlayer);
		HashSet<CoordinatePair> diagonalPaths = getDiagPaths(Coordp, currentPlayer);
		
		paths.addAll(straightPaths);
		paths.addAll(diagonalPaths);
		return paths;
	}
	
	
	public HashSet<CoordinatePair> getStraightPaths(CoordinatePair Coordp, Player currentPlayer){
		int x = Coordp.getX();
		int y = Coordp.getY();
		boolean pathBlocked = false;
		HashSet<CoordinatePair> paths = new HashSet<CoordinatePair>();
		
		//TODO investiaget whether this actually does anything useful
		if(x > getWidth() || y > getHeight() || x < 0 || y < 0) {
			System.out.println("Outside bounds");
			return null;
		}
		//For each direction chek if there is a piece on the tile. If not add the tile to possiblemoves
		
		HashSet<CoordinatePair> horizontalPaths = getHorizontalPath(x, y, currentPlayer, pathBlocked);	
		HashSet<CoordinatePair> verticalPaths = getVertialPath(x, y, currentPlayer, pathBlocked);

		paths.addAll(horizontalPaths);
		paths.addAll(verticalPaths);
		return paths;
	}
	
	//TODO check if we an refactor more from these methods. For example the checking if path blocked and adding piece
	private HashSet<CoordinatePair> getHorizontalPath(int x, int y, Player currentPlayer, boolean pathBlocked) {
		HashSet<CoordinatePair> paths = new HashSet<CoordinatePair>();
		
		for(int i = y-1; i >= 0; i--) {
		CoordinatePair tmpCoordP = new CoordinatePair(x,i);
		ChessPiece tmpPiece = this.getSquare(tmpCoordP);
		
		if(tmpPiece != null && tmpPiece.getPlayer() == currentPlayer) {
			pathBlocked = true;
			}
		if(tmpPiece != null && tmpPiece.getPlayer() != currentPlayer) {
			paths.add(tmpCoordP);
			pathBlocked = true;
			}
		//If path is not blocked add the coordinates to the path
		if(!pathBlocked) {
			paths.add(tmpCoordP);
			}
		} 
		pathBlocked = false;
		for(int i = y+1; i < getWidth(); i++) {
			CoordinatePair tmpCoordP = new CoordinatePair(x,i);
			ChessPiece tmpPiece = this.getSquare(tmpCoordP);
			
			if(tmpPiece != null && tmpPiece.getPlayer() == currentPlayer) {
				pathBlocked = true;
				}
			if(tmpPiece != null && tmpPiece.getPlayer() != currentPlayer) {
				paths.add(tmpCoordP);
				pathBlocked = true;
				}
			//If path is not blocked add the coordinates to the path
			if(!pathBlocked) {
				paths.add(tmpCoordP);
				}
			}
		return paths;
	}
	private HashSet<CoordinatePair> getVertialPath(int x, int y, Player currentPlayer, boolean pathBlocked) {
		HashSet<CoordinatePair> paths = new HashSet<CoordinatePair>();
		
			for(int i = x-1; i >= 0; i--) {
			CoordinatePair tmpCoordP = new CoordinatePair(i,y);
			ChessPiece tmpPiece = this.getSquare(tmpCoordP);
			
			if(tmpPiece != null && tmpPiece.getPlayer() == currentPlayer) {
				pathBlocked = true;
				}
			if(tmpPiece != null && tmpPiece.getPlayer() != currentPlayer) {
				paths.add(tmpCoordP);
				pathBlocked = true;
				}
			//If path is not blocked add the coordinates to the path
			if(!pathBlocked) {
				paths.add(tmpCoordP);
				}
			} 
			pathBlocked = false;
			for(int i = x+1; i < getWidth(); i++) {
				CoordinatePair tmpCoordP = new CoordinatePair(i,y);
				ChessPiece tmpPiece = this.getSquare(tmpCoordP);
				
				if(tmpPiece != null && tmpPiece.getPlayer() == currentPlayer) {
					pathBlocked = true;
					}
				if(tmpPiece != null && tmpPiece.getPlayer() != currentPlayer) {
					paths.add(tmpCoordP);
					pathBlocked = true;
					}
				//If path is not blocked add the coordinates to the path
				if(!pathBlocked) {
					paths.add(tmpCoordP);
					}
				}
			return paths;
		}
	
	public HashSet<CoordinatePair> getDiagPaths(CoordinatePair Coordp, Player currentPlayer){
		int x = Coordp.getX();
		int y = Coordp.getY();
		boolean pathBlocked = false;
		HashSet<CoordinatePair> paths = new HashSet<CoordinatePair>();
		
		HashSet<CoordinatePair> rightToLeftUpPaths = getRightToLeftUpPath(x, y, currentPlayer, pathBlocked);
		HashSet<CoordinatePair> rightToLeftDownPaths = getRightToLeftDownPath(x, y, currentPlayer, pathBlocked);
		HashSet<CoordinatePair> leftToRightDownPath = getLeftToRightDownPath(x, y, currentPlayer, pathBlocked);
		HashSet<CoordinatePair> leftToRightPaths = getleftToRightUpPath(x, y, currentPlayer, pathBlocked);

		
		paths.addAll(rightToLeftUpPaths);
		paths.addAll(rightToLeftDownPaths);
		paths.addAll(leftToRightDownPath);
		paths.addAll(leftToRightPaths);
		return paths;
	}
	private HashSet<CoordinatePair> getRightToLeftUpPath(int x, int y, Player currentPlayer, boolean pathBlocked) {
		HashSet<CoordinatePair> paths = new HashSet<CoordinatePair>();
		//Set the comparison variable to be the lower one of x ad y
		//This is to prevent going of the board.
		int k = Math.min(x, y);
		for(int i = 1; i <= k; i++) {
			//TODO refactor this into a method, for code reuse
			CoordinatePair tmpCoordP = new CoordinatePair(x-i,y-i);
			ChessPiece tmpPiece = this.getSquare(tmpCoordP);
			
			if(tmpPiece != null && tmpPiece.getPlayer() == currentPlayer) {
				pathBlocked = true;
				}
			if(tmpPiece != null && tmpPiece.getPlayer() != currentPlayer) {
				paths.add(tmpCoordP);
				pathBlocked = true;
				}
			//If path is not blocked add the coordinates to the path
			if(!pathBlocked) {
				paths.add(tmpCoordP);
				}
			
		}

			return paths;
	}
	
	private HashSet<CoordinatePair> getRightToLeftDownPath(int x, int y, Player currentPlayer, boolean pathBlocked){
		HashSet<CoordinatePair> paths = new HashSet<CoordinatePair>();
		
		int k = Math.max(x, getWidth()-y);
		//TODO syso height
		for(int i = 1;i+k < getWidth() ;i++) {
			
			//TODO refactor this into a method, for code reuse
			CoordinatePair tmpCoordP = new CoordinatePair(x+i,y-i);
			ChessPiece tmpPiece = this.getSquare(tmpCoordP);
			
			if(tmpPiece != null && tmpPiece.getPlayer() == currentPlayer) {
				pathBlocked = true;
				}
			if(tmpPiece != null && tmpPiece.getPlayer() != currentPlayer) {
				paths.add(tmpCoordP);
				pathBlocked = true;
				}
			//If path is not blocked add the coordinates to the path
			if(!pathBlocked) {
				paths.add(tmpCoordP);
				}
		}
		
		return paths;
	}
	
	private HashSet<CoordinatePair> getLeftToRightDownPath(int x, int y, Player currentPlayer, boolean pathBlocked){
		HashSet<CoordinatePair> paths = new HashSet<CoordinatePair>();
		int k = Math.max(x, y);
		//TODO syso height
		for(int i = 1;i+k < getHeight() ;i++) {
			//TODO refactor this into a method, for code reuse
			CoordinatePair tmpCoordP = new CoordinatePair(x+i,y+i);
			ChessPiece tmpPiece = this.getSquare(tmpCoordP);
			
			if(tmpPiece != null && tmpPiece.getPlayer() == currentPlayer) {
				pathBlocked = true;
				}
			if(tmpPiece != null && tmpPiece.getPlayer() != currentPlayer) {
				paths.add(tmpCoordP);
				pathBlocked = true;
				}
			//If path is not blocked add the coordinates to the path
			if(!pathBlocked) {
				paths.add(tmpCoordP);
				}
		}
		
		
		return paths;
	}
	
	private HashSet<CoordinatePair> getleftToRightUpPath(int x, int y, Player currentPlayer, boolean pathBlocked) {
		HashSet<CoordinatePair> paths = new HashSet<CoordinatePair>();
		
		int k = Math.max(getHeight()-x, y);
		//TODO syso height
		for(int i = 1;i+k < getHeight() ;i++) {
			
			//TODO refactor this into a method, for code reuse
			CoordinatePair tmpCoordP = new CoordinatePair(x-i,y+i);
			ChessPiece tmpPiece = this.getSquare(tmpCoordP);
			
			if(tmpPiece != null && tmpPiece.getPlayer() == currentPlayer) {
				pathBlocked = true;
				}
			if(tmpPiece != null && tmpPiece.getPlayer() != currentPlayer) {
				paths.add(tmpCoordP);
				pathBlocked = true;
				}
			//If path is not blocked add the coordinates to the path
			if(!pathBlocked) {
				paths.add(tmpCoordP);
				}
		}
		
		
		return paths;
	}
		
	//TODO finish refatoring and start using this in all getpath methods
	private void addCoordPairToPath(int x, int y, Player currentPlayer, HashSet<CoordinatePair> paths, boolean pathBlocked) {
		CoordinatePair tmpCoordP = new CoordinatePair(x,y);
		ChessPiece tmpPiece = this.getSquare(tmpCoordP);
		
		if(tmpPiece != null && tmpPiece.getPlayer() == currentPlayer) {
			pathBlocked = true;
			}
		if(tmpPiece != null && tmpPiece.getPlayer() != currentPlayer) {
			paths.add(tmpCoordP);
			pathBlocked = true;
			}
		//If path is not blocked add the coordinates to the path
		if(!pathBlocked) {
			paths.add(tmpCoordP);
			}
	}
	
	//TODO Implement to get steps for farmers and possibly kings
	public HashSet<CoordinatePair> getForwardStep(CoordinatePair Coordp, Player currentPlayer){
		HashSet<CoordinatePair> paths = new HashSet<CoordinatePair>();
		return paths;
	}
	
	
}
