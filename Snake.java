import java.util.*;


public class Snake {
	int width;
	int height;
	char newDir;
	char[][] board;
	Elem head;
	Elem tail;
	char dir;
	String gameState;
	public Snake(int w, int h) {
		width = w;
		height = h;
		board = new char[w][h];
		for(int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
			 	board[i][j] = '.';
			}
		}
		int midWidth = width/2;
		board[midWidth][0] = 'O';
		board[midWidth-1][0] = '*';
		board[midWidth-2][0] = '*';
		head = new Elem (midWidth, 0, null);
		tail = new Elem (midWidth-1, 0, head);
		tail = new Elem (midWidth-2, 0, tail);
		dir = 'R';
		newDir = dir;
		placeFood();
		gameState = new String("play");
	}
	public void printMe() {
		for(int i = 0; i < board[0].length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(board[j][i]);
			}
		System.out.println();
		}
		System.out.println();
	}

	public void giveDir(char d) {
		if (dir == 'R') {
			if (d == 'L') {
				return;
			} else {
				newDir = d;
			}
		}
		if (dir == 'L') {
			if (d == 'R') {
				return;
			} else {
				newDir = d;
			}
		}
		if (dir == 'U') {
			if (d == 'D') {
				return;
			} else {
				newDir = d;
			}
		}
		if (dir == 'D') {
			if (d == 'U') {
				return;
			} else {
				newDir = d;
			} 	
		}
	}	
	public boolean clearCheck(int[] isthisclear) {
		if ((board[isthisclear[0]][isthisclear[1]] == '*') || (board[isthisclear[0]][isthisclear[1]] == 'O')) {
			return false;
		} else {
			return true;
		}
	}		
	public int[] randomFoodGen () {
		Random generatorX = new Random();
		int foodX = generatorX.nextInt(width);
		Random generatorY = new Random();
		int foodY = generatorY.nextInt(height); 
		int[] foodplace;
		foodplace = new int[2];
		foodplace[0] = foodX;
		foodplace[1] = foodY;
		return foodplace;
	}	
	public void placeFood() {
		int[] isthisclear;
		do {
			isthisclear = randomFoodGen();
		} while (!clearCheck(isthisclear));
		board[isthisclear[0]][isthisclear[1]] = 'F';
	} 	
			
	public void tick() {
		if(!gameState.equals("play")) {
			return;
		}			
		int cupX;
		int cupY;
		dir = newDir;
		cupX = head.getX();
		cupY = head.getY();
		if (dir == 'U') {
			if (cupY == 0) {
				cupY = board[0].length-1;
			} else {
				cupY = cupY-1;
			}
		}
		if(dir == 'D') {
			if (cupY == board[0].length-1) {
				cupY = 0;
			} else {
		 		cupY = cupY+1;
			}
		}
		if(dir == 'R') {
			if (cupX == board.length-1) {
				cupX= 0;
			} else {
		 		cupX = cupX+1;
			}      
		}
		if(dir == 'L') {
			if (cupX == 0) {
				cupX = board.length-1;
			} else {
		 		cupX = cupX-1;
			}
		}
		if (board[cupX][cupY] == '*') {
			if ((cupX != tail.getX()) || (cupY != tail.getY())) {
					gameState = new String ("over");
					board[0][0] = 'G';
					board[1][0] = 'a'; 
					board[2][0] = 'm';
					board[3][0] = 'e';
					board[4][0] = ' ';
					board[5][0] = 'o';
					board[6][0] = 'v';
					board[7][0] = 'e';
					board[8][0] = 'r';
					return;
				
			}
		}
        if (board[cupX][cupY] == 'F') {
			board[cupX][cupY] = 'O';
			board[head.getX()][head.getY()] = '*';
			head.setPrev(new Elem(cupX, cupY, null));
			head = head.getPrev();
			placeFood();					
		} else {                                                                             
			board[tail.getX()][tail.getY()] = '.';
			tail = tail.getPrev();
			board[head.getX()][head.getY()] = '*';
			head.setPrev(new Elem(cupX, cupY, null));
			head = head.getPrev();
			board[cupX][cupY] = 'O';
		}
	}
	public char[][] getBoard(){
		return (board);
	}
}