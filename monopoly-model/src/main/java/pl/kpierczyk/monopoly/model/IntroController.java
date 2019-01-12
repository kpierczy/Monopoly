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

    final String introPosterPath;

    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public IntroController(String introPosterPath){
        this.introPosterPath = introPosterPath;
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public String getIntroPosterPath() {
        return introPosterPath;
    }

    /*****************************************/
    /*              Utilities                */
    /*****************************************/
}