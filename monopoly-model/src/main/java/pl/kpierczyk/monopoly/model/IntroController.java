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

    public IntroController(String introMoviePath, String ommitButtonPath){
        this.introMoviePath = introMoviePath;
        this.ommitButtonText = ommitButtonPath;
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