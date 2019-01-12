package pl.kpierczyk.monopoly.model;



//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class IntroController{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    final String introMoviePath;
    final String ommitButtonText;

    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public IntroController(String introMoviePath, String ommitButtonText){
        this.introMoviePath = introMoviePath;
        this.ommitButtonText = ommitButtonText;
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public String getIntroMoviePath() {
        return introMoviePath;
    }
    public String getOmmitButtonText() {
        return ommitButtonText;
    }

    /*****************************************/
    /*              Utilities                */
    /*****************************************/
}