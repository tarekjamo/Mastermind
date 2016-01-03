import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by tarekray on 01/01/16.
 */
public class SolverTest {

    @Test
    public void test() {
        for(int i = 0 ; i < 10 ; i++) {
        Mastermind m = new Mastermind();
        System.out.println("The code : ") ;

        ArrayHelper.print(m.code);
        System.out.println() ;
        assertThat(m.solve()).isEqualTo(true);
      }
    }

    @Test
    public void code_generated_test()
    {
        for(int i = 0 ; i < 30 ; i++) {
            Mastermind m = new Mastermind();
            ArrayHelper.print(m.code);
            assertThat(isValidCode(m)).isEqualTo(true);
        }
    }

    private boolean isValidCode(Mastermind m) {
        return ArrayHelper.getMax(m.code)<m.dictionary.colors.size() ;
    }


}
