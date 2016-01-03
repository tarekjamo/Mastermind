/**
 * Created by tarekray on 31/12/15.
 */
public class Evaluation {
    private int correctColorInCorrectPosition ;
    private int correctColorInWrongPosition ;

    public Evaluation()
    {
        correctColorInCorrectPosition = 0 ;
        correctColorInWrongPosition = 0 ;
    }

    public void incrementCorrectColorInCorrectPosition(){
        this.correctColorInCorrectPosition = this.correctColorInCorrectPosition + 1 ;
    }


    public void incrementCorrectColorInWrongPosition(){
        this.correctColorInWrongPosition = this.correctColorInWrongPosition + 1 ;
    }


    public int getCorrectColorInCorrectPosition() {
        return correctColorInCorrectPosition;
    }

    public void setCorrectColorInCorrectPosition(int correctColorInCorrectPosition) {
        this.correctColorInCorrectPosition = correctColorInCorrectPosition;
    }

    public int getCorrectColorInWrongPosition() {
        return correctColorInWrongPosition;
    }

    public void setCorrectColorInWrongPosition(int correctColorInWrongPosition) {
        this.correctColorInWrongPosition = correctColorInWrongPosition;
    }

    public boolean same(Evaluation evaluation) {
        return this.getCorrectColorInCorrectPosition() == evaluation.getCorrectColorInCorrectPosition()
                && this.getCorrectColorInWrongPosition() == evaluation.getCorrectColorInWrongPosition() ;
    }
}
