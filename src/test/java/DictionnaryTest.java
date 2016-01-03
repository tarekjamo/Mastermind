import org.junit.Test;

import java.util.Set;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by tarekray on 01/01/16.
 */
public class DictionnaryTest {

    @Test
    public void six_colors_and_four_slots_should_generate_1296_possibilities()
    {
        Dictionary d = new Dictionary(4,6) ;
        int answer = (int) Math.pow(6,4) ; // 1296
        assertThat(d.allPossibilities.size()).isEqualTo(answer) ;

    }
    @Test
    public void eight_colors_and_four_slots_should_generate_1296_possibilities()
    {
        Dictionary d = new Dictionary(4,8) ;
        int answer = (int) Math.pow(8,4) ; // 4096
        assertThat(d.allPossibilities.size()).isEqualTo(answer) ;

    }

    @Test
    public void all_evaluation_should_be_of_size_14()
    {
        Dictionary d = new Dictionary(4,8) ;

        assertThat(d.allEvaluations.size()).isEqualTo(14) ;

    }


    @Test
    public void zero_evaluation_should_remove_all_possibilities_with_colors_used_in_guess()
    {
        Evaluation evaluation = new Evaluation() ;
        int[] guess = {1, 2, 3, 3} ;
        Dictionary d = new Dictionary() ;
        d.processEvaluation(guess , evaluation) ;
        assertThat(d.dictionaryContains(0)).isEqualTo(true) ;
        assertThat(d.dictionaryContains(1)).isEqualTo(false) ;
        assertThat(d.dictionaryContains(2)).isEqualTo(false) ;
        assertThat(d.dictionaryContains(3)).isEqualTo(false) ;
        assertThat(d.dictionaryContains(4)).isEqualTo(true) ;
        assertThat(d.dictionaryContains(5)).isEqualTo(true) ;
        assertThat(d.dictionaryContains(6)).isEqualTo(true) ;
        assertThat(d.dictionaryContains(7)).isEqualTo(true) ;
        assertThat(d.possibilities.size()).isEqualTo((int)Math.pow(5, 4)) ;
        // 5 as in the number of colors left
        // other than the used ones: 1, 2 and 3.

    }



    @Test
    public void acceptance()
    {
        Evaluation evaluation = new Evaluation() ;
        evaluation.incrementCorrectColorInWrongPosition();
        evaluation.incrementCorrectColorInWrongPosition();

        evaluation.incrementCorrectColorInCorrectPosition();

        int[] guess = {1, 2, 3, 4} ;
        Dictionary d = new Dictionary(4, 5) ;
        d.processEvaluation(guess , evaluation) ;



    }





}
