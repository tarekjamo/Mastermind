import java.util.Comparator;

/**
 * Created by tarekray on 16/01/16.
 */
public class EvaluationComparator implements Comparator<Guess> {
    @Override
    public int compare(Guess lhs, Guess rhs) {
        int average1 = lhs.evaluation.getCorrectColorInCorrectPosition()*2 + lhs.evaluation.getCorrectColorInWrongPosition() ;
        int averager = rhs.evaluation.getCorrectColorInCorrectPosition()*2 + rhs.evaluation.getCorrectColorInWrongPosition() ;

        return Integer.compare(average1,averager);
    }
}
