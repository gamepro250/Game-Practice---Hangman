import java.util.Scanner ;


public class Hangman
{

	static Scanner in = new Scanner(System.in) ;
	static Boolean quit = false ;
	static String guess = "" ;
	static String choice = "1" ;
	
	public static void main(String args[])
	{
		System.out.println("Enter your word/phrase") ;
		String answer = in.nextLine() ;

		HandleAnswer game = new HandleAnswer(answer.toUpperCase()) ;
		
		System.out.print("\n\n\n\n\n\n") ;

		game.setPunct() ;
		game.displayBlanks() ;
		
		System.out.print("\n\n\n");
		while(!game.isCorrect() && !quit)
		{			
			Hangman.gameLoop(answer, game) ;
		}

		in.close();
	}
	
	private static void gameLoop(String answer, HandleAnswer game) 
	{
		System.out.println("Do you want to:\n1.Guess a letter.\n2.Guess answer.\n3.Quit") ;
		choice = in.nextLine() ;

		if(choice.equals("1"))
		{
			System.out.println("What letter do you guess?") ;
			guess = in.nextLine() ;

			game.checkLetter(answer.toUpperCase(), guess.toUpperCase());
		}
		else if(choice.equals("2"))
		{
			System.out.println("What do you think the phrase is?") ;
			guess = in.nextLine() ;

			game.checkGuess(answer.toUpperCase(), guess.toUpperCase());
		}
		else if(choice.equals("3"))
		{
			quit = true ;
		}

		if(game.incorrectGuesses()==5)
		{
			System.out.println("Maximum number of incorrect guesses reached.\n Correct answer: " + answer.toUpperCase()) ;
			return ;
		}
	}
}
