import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by tarekray on 01/01/16.
 */
public class Dictionary {

    Set<int[]> allPossibilities ;
    Set<Evaluation> allEvaluations ;

    Set<int[]> possibilities ;
    Set<Integer> colors = new HashSet<>() ;
    public int size ;

    public Dictionary() {
        this(4, 8);
    }

    public Dictionary(int size, int colorsNumber)
    {
        for(int i = 0 ; i < colorsNumber ; i++){
            colors.add(i) ;
        }
        this.size = size ;

        generateAllPossibilities() ;
        generateAllEvaluations() ;
        possibilities = new HashSet<>(allPossibilities) ;
    }

    private void generateAllEvaluations() {
        allEvaluations = new HashSet<Evaluation>() ;

       for(int i = 0 ; i <= 4 ; i++)
       {
           for(int j = 0 ; j <= 4-i ; j++)
           {
               if(valid(i,j)) {
                   Evaluation e = new Evaluation();
                   e.setCorrectColorInCorrectPosition(i);
                   e.setCorrectColorInWrongPosition(j);
                   allEvaluations.add(e);
               }
           }
       }

    }

    private boolean valid(int i, int j) {
        if(i==3 && j ==1)
        {
            return  false ;
        }
        return  true ;
    }

    private void generateAllPossibilities() {
        allPossibilities = new HashSet<int[]>() ;

        int index = 0 ;
        int[] possibility = new int[size] ;
        generateAllPossibilities(possibility,index);
    }

    private void generateAllPossibilities(int[] possibility, int index) {
        if(index==size)
        {
            allPossibilities.add(possibility) ;
        }
        else
        {
            for(Integer i : colors)
            {
               int[] copy = ArrayHelper.clone(possibility) ;
                copy[index] = i ;
                generateAllPossibilities(copy,index+1);
            }
        }
    }

    public void processEvaluation(Guess g) {
        processEvaluation(g.combination, g.evaluation);
    }

    public void processEvaluation(int[] guess, Evaluation evaluation) {

        Iterator possibilitiesItr = possibilities.iterator();
        while(possibilitiesItr.hasNext())
        {
            int[] a = (int[])possibilitiesItr.next() ;
            Evaluation e = Evaluator.evaluate(a, guess) ;
            if(!e.same(evaluation))
            {
                possibilitiesItr.remove() ;
            }
        }

    }

    public int simulateCountProcessEvaluation(Guess g) {
       return  simulateCountProcessEvaluation(g.combination, g.evaluation);
    }

    public int simulateCountProcessEvaluation(int[] guess, Evaluation evaluation) {

        Iterator possibilitiesItr = possibilities.iterator();
        int count = 0 ;
        while(possibilitiesItr.hasNext())
        {
            int[] a = (int[])possibilitiesItr.next() ;
            Evaluation e = Evaluator.evaluate(a, guess) ;
            if(!e.same(evaluation))
            {
            count++ ;
            }
        }
        return  count ;
    }




    public boolean dictionaryContains(int key)
    {
        for(int[] a : possibilities)
        {
            if(ArrayHelper.contains(a,key))
            {
                return  true ;
            }
        }
        return  false ;
    }

    public  int[] generateRandomCode() {
        int[] code = new int[size] ;

        for(int i = 0 ; i < code.length ; i++)
        {
            code[i] = randomColor();
        }
        return code ;
    }

    public int randomColor() {
        return (int)(Math.random() * ((colors.size()) ));
    }

    public  int[] firstGuess() {
        int[] guess = new int[size] ;
        int tempColor = 0 ;
        for(int i = 0 ; i < guess.length-1; i = i + 2)
        {
            guess[i] =  tempColor;
            guess[i+1] = tempColor ;
            tempColor++ ;
        }
        return guess ;
    }


}
