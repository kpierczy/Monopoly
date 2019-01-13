package pl.kpierczyk.monopoly.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

    private Model model;
    private View view;

    private CLoseIntroController closeIntroController;
    private SkipIntroController skipIntroController;

    /*****************************************/
    /* Constructor */
    /*****************************************/

    public IntroController(Model model, View view) {
        this.model = model;
        this.view = view;
        this.closeIntroController = new CLoseIntroController(this.model, this.view);
        this.skipIntroController = new SkipIntroController(this.model, this.view);

        view.addKeyListener(skipIntroController);
    }
}

class CLoseIntroController {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    Model model;
    View view;



    /*****************************************/
    /* Constructor */
    /*****************************************/

    public CLoseIntroController(Model model, View view) {
        this.model = model;
        this.view = view;

        long targetTime = model.getIntroTime();
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                finishIntro();
            }
        }, targetTime);

    }


    /*****************************************/
    /* Utilities */
    /*****************************************/

    private synchronized void finishIntro() {
        model.finishIntro();
        view.finishIntro();
    }

}














class SkipIntroController implements KeyListener {

    private Model model;
    private View view;

    SkipIntroController(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keyEvent.consume();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            model.finishIntro();
            view.finishIntro();
        } else
            keyEvent.consume();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        keyEvent.consume();
    }

}