package aula03;
import java.util.Scanner;

public class tictactoe {
	
	static double turn = 2;
	static 	String game[] = {"[ ]","[ ]","[ ]",
            				"[ ]","[ ]","[ ]",
            				"[ ]","[ ]","[ ]"};
	static double help = 0;
	static String winner;
	
	static void printBoard() {
		
		System.out.println(game[0] + game[1] + game[2]);
		System.out.println(game[3] + game[4] + game[5]);
		System.out.println(game[6] + game[7] + game[8]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printBoard();
		while (help == 0) {
			mainAction();
			checkTie();
			checkWin();
			Win();
		}
		
		
	}
	
	static void mainAction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("place the thing\n");
		int userinput = sc.nextInt();
		if (turn % 2 == 0) {
			if (userinput < 10 && userinput >= 1 && game[userinput - 1] == "[ ]") {
				game[userinput - 1] = "[X]";
				printBoard();
				turn += 1;
			} else {
				System.out.println("There's somebody here, my guy....");
			}
		} else if (turn % 2 != 0) {
			if (userinput < 10 && userinput >= 1 && game[userinput - 1] == "[ ]") {
				game[userinput - 1] = "[O]";
				printBoard();
				turn += 1;
			} else {
				System.out.println("There's somebody here, my guy....");
			}
		}
	
	}
	
	static boolean checkWin() {
		if (game[0].equals(game[1]) && game[1].equals(game[2]) && !game[1].equals("[ ]")) { // horizontal 1
	        winner = game[0];
	        return true;
	    } 
	    else if (game[0].equals(game[3]) && game[3].equals(game[6]) && !game[3].equals("[ ]")) { // vertical 1
	        winner = game[3];
	        return true;
	    } 
	    else if (game[0].equals(game[4]) && game[4].equals(game[8]) && !game[4].equals("[ ]")) { // diagonal 1
	        winner = game[4];
	        return true;
	    } 
	    else if (game[6].equals(game[4]) && game[4].equals(game[2]) && !game[4].equals("[ ]")) { // diagonal 2
	        winner = game[4];
	        return true;
	    } 
	    else if (game[1].equals(game[4]) && game[4].equals(game[7]) && !game[4].equals("[ ]")) { // vertical 2
	        winner = game[4];
	        return true;
	    } 
	    else if (game[2].equals(game[5]) && game[5].equals(game[8]) && !game[5].equals("[ ]")) { // vertical 3
	        winner = game[5];
	        return true;
	    } 
	    else if (game[3].equals(game[4]) && game[4].equals(game[5]) && !game[3].equals("[ ]")) { // horizontal 2
	        winner = game[4];
	        return true;
	    } 
	    else if (game[6].equals(game[7]) && game[7].equals(game[8]) && !game[6].equals("[ ]")) { // horizontal 3
	        winner = game[6];
	        return true;
	    }

	    return false;
	}
	
	static void checkTie() {
		boolean tieCheck = false;
		
		for (String cell : game) {
	        if (cell.equals("[ ]")) {
	            tieCheck = true;
	            break;
	        }
	    }

	    if (!tieCheck) {
	        System.out.println("it's a tie");
	        help = 1;
	    }
	}
	
	static void Win() {
		if (checkWin()) {
			System.out.println("The winner issss " + winner + "!!!!");
			help = 1;
		}
	}

}
