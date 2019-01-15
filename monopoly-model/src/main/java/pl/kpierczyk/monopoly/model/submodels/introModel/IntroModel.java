package pl.kpierczyk.monopoly.model.submodels.introModel;



//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class IntroModel{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    private final long introTime = 4000; //intro time in ms
    private final String introPosterPath;



    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public IntroModel(String introPosterPath){
        this.introPosterPath = introPosterPath;
    }




    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public long getIntroTime() {
        return introTime;
    }
    public String getIntroPosterPath() {
        return introPosterPath;
    }
}