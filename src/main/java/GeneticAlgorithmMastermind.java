import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by tarekray on 16/01/16.
 */
public class GeneticAlgorithmMastermind extends  Mastermind {


    public GeneticAlgorithmMastermind()
    {
        super(200) ;
    }


    public boolean geneticAlgorithmSolve() {
        int initialPopulationSize = 6 ;
        initializePopulation(initialPopulationSize);

        if(!solved) {
            evolution() ;
        }
        return solved ;
    }

    private void evolution() {
        Guess guess = new Guess();
        HashMap<Integer, Guess> fittest = fittest() ;
        int[] crossover = crossover(fittest) ;
        int[] mutation = mutation(crossover) ;
        guess.combination = mutation;
        guess.evaluation = Evaluator.evaluate(guess.combination, code) ;
        guesses[guessCount] = guess;
        guessCount++;
        guess.print();
        if(!finishGeneticEvolution(guess.evaluation))
        {
            evolution();
        }
        else
        {
            System.out.println("Solved");
        }

    }

    private int[] mutation(int[] crossover) {
        double mutationProbability = 0.40 ;
        double reverseProbability = 0.05 ;

        for(int i = 0 ; i  < crossover.length ; i++)
        {
            double random = Math.random() ;
            if(random<mutationProbability)
            {
                crossover[i] = dictionary.randomColor() ;
            }


        }

        double random = Math.random() ;
        if(random<reverseProbability)
        {
            ArrayHelper.revert(crossover);
        }
        return  crossover ;
    }

    private int[] crossover(HashMap<Integer,Guess> fittest) {
        int[] guess1 = fittest.get(0).combination ;
        int[] guess2 = fittest.get(1).combination ;
        int[] guess3 = fittest.get(2).combination ;

        int[] crossover = new int[guess1.length] ;

        for(int i = 0 ; i < guess1.length ; i++)
        {
            int random = (int)(Math.random() * ((fittest.size()) )) ;
            crossover[i] = fittest.get(random).combination[i] ;
        }
        return  crossover ;
    }

    private HashMap<Integer,Guess> fittest() {

        Guess[] top = new Guess[guessCount] ;
        for(int j = 0 ; j < guessCount ; j++)
        {
            top[j] = guesses[j] ;
        }

        Arrays.sort(top);

        HashMap<Integer,Guess> fittest = new HashMap<Integer,Guess>() ;
        fittest.put(0, top[top.length-1]) ;
        fittest.put(1, top[top.length-2]) ;
        fittest.put(2, top[top.length-3]) ;

        return fittest ;

    }

    private boolean finishGeneticEvolution(Evaluation evaluation) {
        if (evaluation.getCorrectColorInCorrectPosition() == 4) {
            solved = true;
            return  true ;
        }
        return  false ;
    }


    public void initializePopulation(int initialPopulationSize)
    {
        for(int i = 0 ; i < initialPopulationSize ; i++)
        {
            Guess g = new Guess() ;
            g.combination = dictionary.generateRandomCode() ;
            g.evaluation = Evaluator.evaluate(g.combination, code);
            if(g.evaluation.getCorrectColorInCorrectPosition()==4)
            {
                solved = true ;
            }
            guesses[i] = g ;
            System.out.println("INITIAL POPULATION ") ;
            ArrayHelper.print(guesses[i].combination);
            guessCount++ ;
        }
    }
}
