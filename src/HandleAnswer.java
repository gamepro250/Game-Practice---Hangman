import java.util.Arrays;

public class HandleAnswer
{
	public Boolean correct = false ;
	public int incorrectGuess = 0 ;
	public int numguesses = 0 ;
	public String[] guessed= new String[26] ;
	String[] answerBlanks;
	public boolean guessCorrect = false ;

	public HandleAnswer(String answer)
	{
		answerBlanks= new String[answer.length()] ;
		Arrays.fill(answerBlanks, "_") ;
	}

	public void checkLetter(String answer, String guess)
	{
		for(int i=0;i<guessed.length;i++)
		{
			if(guess.equals(guessed[i]))
			{
				System.out.println("\n" + guess + " has already been guessed. Please try something else.\n") ;
				return ;
			}
			else if(guessed[i]==null)
			{
				guessed[i] = guess ;
				numguesses++ ;
				break ;
			}
		}

		for(int j=0;j<answer.length();j++)
		{
			if(guess.charAt(0) == answer.charAt(j))
			{
				answerBlanks[j] = guess ;
				guessCorrect = true ;
			}
		}

		System.out.println("\n") ;

		for(int k=0;k<answerBlanks.length;k++)
		{
			if(answer.charAt(k)==' ')
			{
				System.out.print(" ") ;
			}
			else if(answerBlanks[k].matches("[A-Za-z]"))
			{
				System.out.print(answerBlanks[k]) ;
			}
			else
			{
				System.out.print(answerBlanks[k] + " ") ;
			}
		}
		System.out.println("\n") ;

		if(!guessCorrect)
		{
			incorrectGuess++ ;
			System.out.println("Incorrect guess.\nNumber of incorrect guesses " + incorrectGuess + "/5") ;
		}
		guessCorrect = false ;
	}

	public void checkGuess(String answer, String guess)
	{
		if(answer.equals(guess))
		correct = true ;

		System.out.println("You are corret!\nCongratulations!") ;
	}

	public Boolean isCorrect()
	{
		return correct ;
	}

	public int incorrectGuesses()
	{
		return incorrectGuess ;
	}
}
