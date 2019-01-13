package pl.kpierczyk.monopoly.controller.subcontrollers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import pl.kpierczyk.monopoly.controller.Controller;
import pl.kpierczyk.monopoly.model.*;
import pl.kpierczyk.monopoly.view.*;

//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class IntroController {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    private Controller controller;

    private CLoseIntroController closeIntroController;
    private SkipIntroController skipIntroController;

    /*****************************************/
    /* Constructor */
    /*****************************************/

    public IntroController(Controller controller) {
        this.controller = controller;
        this.closeIntroController = new CLoseIntroController(controller);
        this.skipIntroController = new SkipIntroController(controller);

        controller.getView().addKeyListener(skipIntroController);
    }
}





class CLoseIntroController {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    Controller controller;

    /*****************************************/
    /* Constructor */
    /*****************************************/

    public CLoseIntroController(Controller controller) {
        this.controller = controller;

        long targetTime = controller.getModel().getIntroTime();
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                controller.finishIntro();
            }
        }, targetTime);

    }
}

class SkipIntroController implements KeyListener {
    
    
    /*****************************************/
    /* Class Fields */
    /*****************************************/

    private Controller controller;



    /*****************************************/
    /* Constructor */
    /*****************************************/
    
    
    SkipIntroController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keyEvent.consume();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            controller.finishIntro();
        } else
            keyEvent.consume();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        keyEvent.consume();
    }

}