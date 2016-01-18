import java.util.Comparator;

/**
 * Created by tarekray on 01/01/16.
 */
public class Guess implements Comparable<Guess>{
    public int[] combination ;
    public Evaluation evaluation ;

 public boolean same(Guess g) {
     boolean same = g.combination.length == this.combination.length;

     if (same) {
         for (int i = 0; i < this.combination.length; i++) {
             if (g.combination[i] != this.combination[i]) {
                 same = false;
             }
         }
     }
     return same;
 }

    public void print() {

        ArrayHelper.print(combination) ;
        System.out.println("") ;
        System.out.println("Colored "+evaluation.getCorrectColorInCorrectPosition()) ;
        System.out.println("white "+evaluation.getCorrectColorInWrongPosition()) ;
        System.out.println("-----------------------------------") ;

    }

    @Override
    public int compareTo(Guess o) {
        EvaluationComparator ec = new EvaluationComparator();
        return ec.compare(this,o) ;
    }
}
