import static org.fest.assertions.api.Assertions.assertThat;


import org.junit.Test;

/**
 * Created by tarekray on 31/12/15.
 */
public class CorrectorTest {

    @Test
    public void zero_correct_color_should_return_evaluation_with_zero_correctPosition_and_zero_incorrectPosition()
    {
        int[] solution = {1,2,3,4} ;
        int[] suggested = {5,6,7,8} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(0) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(0) ;
    }

    @Test
    public void only_one_correct_color_in_correct_position_should_return_evaluation_with_one_correctPosition_and_zero_incorrectPosition()
    {
        int[] solution = {1,2,3,4} ;
        int[] suggested = {1,6,7,8} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(1) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(0) ;
    }

    @Test
    public void only_one_correct_color_in_wrong_position_should_return_evaluation_with_zero_correctPosition_and_one_incorrectPosition()
    {
        int[] solution = {1,2,3,4} ;
        int[] suggested = {5,1,7,8} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(0) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(1) ;
    }

    @Test
    public void duplicate_in_both_correct_and_incorrect_position()
    {
        int[] solution = {1,1,3,4} ;
        int[] suggested = {5,1,1,8} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(1) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(1) ;
    }


    @Test
    public void duplicate_in_incorrect_position()
    {
        int[] solution = {1,1,3,4} ;
        int[] suggested = {5,6,1,1} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(0) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(2) ;
    }

    @Test
    public void duplicate_in_suggested_and_only_one_in_solution()
    {
        int[] solution = {1,2,3,6} ;
        int[] suggested = {5,6,6,8} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(0) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(1) ;
    }

    @Test
    public void duplicate_in_solution_and_only_one_in_suggested()
    {
        int[] solution = {1,1,3,4} ;
        int[] suggested = {5,6,1,8} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(0) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(1) ;
    }

    @Test
    public void duplicate_in_solution_and_only_one_in_suggested_correct()
    {
        int[] solution = {1,1,3,4} ;
        int[] suggested = {5,1,7,8} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(1) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(0) ;
    }
    @Test
    public void duplicate_in_suggested_and_one_correct_in_solution()
    {
        int[] solution = {1,2,3,4} ;
        int[] suggested = {1,1,7,8} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(1) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(0) ;
    }
    @Test
    public void duplicate_in_solution_and_one_correct_in_suggested()
    {
        int[] solution = {1,1,3,4} ;
        int[] suggested = {1,6,7,8} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(1) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(0) ;
    }

    @Test
    public void triplet_in_solution_and_one_correct_in_suggested()
    {
        int[] solution = {1,1,1,4} ;
        int[] suggested = {1,6,7,8} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(1) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(0) ;
    }

    @Test
    public void triplet_in_suggested_and_one_correct_in_solution()
    {
        int[] solution = {2,3,1,1} ;
        int[] suggested = {1,1,1,8} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(1) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(1) ;
    }

    @Test
    public void three_numbers_in_incorrect_position_and_one_correct()
    {
        int[] solution = {1,2,3,4} ;
        int[] suggested = {2,3,1,4} ;
        Evaluation evaluation = Evaluator.evaluate(suggested, solution) ;

        assertThat(evaluation.getCorrectColorInCorrectPosition()).isEqualTo(1) ;
        assertThat(evaluation.getCorrectColorInWrongPosition()).isEqualTo(3) ;
    }


}
