/**
 * Created by tarekray on 31/12/15.
 */
public class Evaluator {
    public static Evaluation evaluate(int[] suggested, int[] solution) {
        assert(suggested.length==solution.length) ;
        Evaluation evaluation = new Evaluation() ;

        boolean[] counted = new boolean[suggested.length] ;



        for(int i = 0 ; i < solution.length ; i++)
        {
            if(suggested[i]==solution[i])
            {
                counted[i] = true ;
                evaluation.incrementCorrectColorInCorrectPosition();
            }
        }


        boolean[] counted2 = new boolean[suggested.length] ;
        for(int i = 0 ; i < solution.length ; i++)
        {
            if(!counted[i])
            {

                int indexContains = contains(solution, suggested[i],counted, counted2) ;
                if(indexContains!=-1)
                {
                counted2[indexContains] = true ;
                evaluation.incrementCorrectColorInWrongPosition();
                }
            }
        }



        return  evaluation ;
    }

    private static int getMaxNumberUsed(int[] suggested, int[] solution) {
        int max = 0 ;
        for(int index = 0 ; index < suggested.length ; index++)
        {
            if(suggested[index]>max)
            {
                max = suggested[index] ;
            }
            if(solution[index]>max)

                max = solution[index] ;
            }

        return  max ;
    }

    private static int contains(int[] solution, int key,   boolean[] counted,  boolean[] counted2) {
        int position = -1 ;
        for(int index = 0 ; index < solution.length ; index++)
        {
            if(solution[index]==key && !counted2[index] && !counted[index])
            {
               position = index ;
                return  position ;
            }
        }
        return  position ;
    }
}
