import java.util.Scanner ;


public class Hangman
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in) ;
		Boolean quit = false ;
		String guess = "" ;
		String choice = "1" ;

		System.out.println("Enter you word/phrase") ;
		String answer = in.nextLine() ;

		HandleAnswer game = new HandleAnswer(answer) ;

		System.out.print("\n\n\n\n\n\n") ;

		while(!game.isCorrect() && !quit)
		{
			System.out.println("Do you want to:\n1.Guess a letter.\n2.Guess answer.\n3.Quit") ;
			choice = in.nextLine() ;

			if(choice.equals("1"))
			{
				System.out.println("What letter do you guess?") ;
				guess = in.nextLine() ;

				game.checkLetter(answer, guess);
			}
			else if(choice.equals("2"))
			{
				System.out.println("What do you think the phrase is?") ;
				guess = in.nextLine() ;

				game.checkGuess(answer, guess);
			}
			else if(choice.equals("3"))
			{
				quit = true ;
			}

			if(game.incorrectGuesses()==5)
			{
				System.out.println("Maximum number of incorrect guesses reached.\n Correct answer: " + answer) ;
				break ;
			}
		}

		in.close();

	}
}
