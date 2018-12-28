package pl.kpierczyk.monopoly.model;

public class Model 
{
    AppState state;
    MainMenuController mainMenuController;
    GameController gameController;

    /*****************************************/
    /*                                       */
    /*****************************************/

    Model()
    {
        state = AppState.mainMenu;
        mainMenuController = new MainMenuController();
        gameController = new GameController();
    }

    AppState getAppState() {return state;}
    void setAppState(AppState t_state) {state = t_state;}

    MainMenuController getMainMenuController() {return mainMenuController;}
    void setMainMenuController(MainMenuController t_controller) {mainMenuController = t_controller;}

    GameController getGameController() {return gameController;}
    void setGameController(GameController t_controller) {gameController = t_controller;}
}


enum AppState{
    beggining,
    inGame,
    mainMenu,
    quitting
}