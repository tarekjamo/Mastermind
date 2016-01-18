import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by tarekray on 01/01/16.
 */
public class Mastermind {
    public int[] code ;
    public Guess[] guesses ;
    int guessCount = 0 ;
    public Dictionary dictionary ;
    boolean solved = false ;
    public Mastermind()
    {
        this(20) ;
    }

    public Mastermind(int size)
    {
        guesses = new Guess[size] ;
        dictionary = new Dictionary(4,6) ;
        code = dictionary.generateRandomCode() ;
    }


    public boolean solve() {


        boolean solved = false ;
        Guess guess = new Guess();
        guess.combination =   dictionary.firstGuess();
        guess.evaluation = Evaluator.evaluate(guess.combination, code);
        if(guess.evaluation.getCorrectColorInCorrectPosition()==4)
        {
        solved=true ;
        }
        guesses[guessCount] = guess;
        guessCount++;
        dictionary.processEvaluation(guess);
        guess.print() ;
        System.out.println("Remaining possibilities : "+dictionary.possibilities.size());

        while (!solved && guessCount<guesses.length) {
            guess = new Guess();
            if(dictionary.possibilities.size()==1)
            {
                guess.combination = dictionary.possibilities.iterator().next() ;
            }
            else
            {
                guess.combination = minMaxNextStep();
            }

            guess.evaluation = Evaluator.evaluate(guess.combination, code);
            guess.print() ;
            System.out.println("Remaining possibilities : " + dictionary.possibilities.size());
            if(guess.evaluation.getCorrectColorInCorrectPosition()==4)
            {
                solved=true ;
            }
            guesses[guessCount] = guess;
            dictionary.processEvaluation(guess);
            guessCount++;

        }
        return solved ;
    }

    public int[] minMaxNextStep() {
        int[] min = new int[dictionary.allPossibilities.size()] ;
        int[] max = new int[dictionary.allPossibilities.size()] ;
        Guess[] guess = new Guess[dictionary.allPossibilities.size()] ;
        for(int i = 0 ; i < dictionary.allPossibilities.size() ; i++)
        {
            min[i] = Integer.MAX_VALUE ;
            max[i] = Integer.MIN_VALUE ;
        }
        int index = 0 ;
            for (int[] combination : dictionary.allPossibilities) {
                for (Evaluation evaluation : dictionary.allEvaluations) {
                        Guess g = new Guess();
                        g.combination = combination;
                        g.evaluation = evaluation;
                        if (!guessUsed(g)) {
                            int count = dictionary.simulateCountProcessEvaluation(g);
                            if (count < min[index]) {
                                min[index] = count;
                            }
                            if (count > max[index]) {
                                max[index] = count;
                            }
                            guess[index] = g;
                        }
                    }
        }
        int myMin = Integer.MIN_VALUE ;
        int myMax = Integer.MIN_VALUE ;
        int myIndex = -1 ;
        for(int i = 0 ; i < dictionary.allPossibilities.size(); i++)
        {
                  if(min[index]>myMin)
                  {
                      myMin = min[index] ;
                      myMax = max[index] ;
                      myIndex = index ;
                  }
                 else if(min[index]==myMin){
                      if(max[index]>myMax)
                      {
                          myMax = max[index] ;
                          myIndex = index ;
                      }
                  }
        }
        return  guess[myIndex].combination ;
    }
    private boolean guessUsed(Guess g) {
        for(int i = 0 ; i < guessCount ; i++)
        {
            Guess temp = guesses[i] ;
            if(temp.same(g))
            {
                return  true ;
            }
        }
        return  false ;
    }


}
