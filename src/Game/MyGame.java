package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MyGame {
	
	static final ArrayList<Integer> firstplayer = new ArrayList<Integer>();
	static final ArrayList<Integer> Computerplayer = new ArrayList<Integer>();
	
	public static void board(char[][]gameboard) {
		
		
		for(char[]r: gameboard) {
			for(char c : r) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}
	public static void Printpos(char [][] gameboard,int pos,String user) {
		char symbol = 'X';
		
		if(user.equals("Player")) {
			symbol='X';
			firstplayer.add(pos);
		} else if(user.equals("Computer")) {
			symbol = 'O';
			Computerplayer.add(pos);
		}
		switch(pos) {
		case 1:
			gameboard[0][0] = symbol;
			break;
		case 2:
			gameboard[0][2] = symbol;
			break;
		case 3:
			gameboard[0][4] = symbol;
			break;
		case 4:
			gameboard[2][0] = symbol;
			break;
		case 5:
			gameboard[2][2] = symbol;
			break;
		case 6:
			gameboard[2][4] = symbol;
			break;
		case 7:
			gameboard[4][0] = symbol;
			break;
		case 8:
			gameboard[4][2] = symbol;
			break;
		case 9:
			gameboard[4][4] = symbol;
			break;
		}
	}
	public static String check() {
		List toprow = Arrays.asList(1, 2, 3);
		List midrow = Arrays.asList(4, 5, 6);
		List bottomrow = Arrays.asList(7, 8, 9);
		List leftcol = Arrays.asList(1, 4, 7);
		List midcol = Arrays.asList(2, 5, 8);
		List rightcol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);
		
		List<List> winner = new ArrayList<List>();
		winner.add(toprow);
		winner.add(midrow);
		winner.add(bottomrow);
		winner.add(leftcol);
		winner.add(midcol);
		winner.add(rightcol);
		winner.add(cross1);
		winner.add(cross2);
		
		for(List l : winner) {
			if(firstplayer.containsAll(l)) {
				return "Congrats You Won!";
			} else if(Computerplayer.containsAll(l)) {
				return "Computer Won!";
			} else if(firstplayer.size()+Computerplayer.size()==9) {
				return "TIE!";
			}
		}
		return "";
	}
	public static void main(String[] args) {
		char[][] gameboard = {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}
				};
		board(gameboard);
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the number from 1-9:");
			int pos = sc.nextInt();
			while(firstplayer.contains(pos)||Computerplayer.contains(pos)) {
				System.out.println("Position already taken!");
				pos = sc.nextInt();
			}
			
		
			Printpos(gameboard,pos,"Player");
			String result = check();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			
			Random rand = new Random();
			int cpu = rand.nextInt(9)+1;
			while(firstplayer.contains(cpu)||Computerplayer.contains(cpu)) {
				cpu = sc.nextInt();
			}
			Printpos(gameboard,cpu,"Computer");
			board(gameboard);
			 result = check();
			 if(result.length()>0) {
					System.out.println(result);
					break;
				}
			System.out.println(result);
		}
		
	
	}

}
