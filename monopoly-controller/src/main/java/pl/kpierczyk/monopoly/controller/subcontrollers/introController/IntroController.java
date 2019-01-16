package pl.kpierczyk.monopoly.controller.subcontrollers.introController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import pl.kpierczyk.monopoly.controller.Controller;


/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class IntroController implements KeyListener{

    private Controller controller;

    public IntroController(Controller controller) {
        this.controller = controller;
        controller.getView().addKeyListener(this);

        long targetTime = 
            controller.getModel().getIntroModel().getIntroTime();
        
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                if(controller.getIntroductionController() != null)
                    controller.finishIntro();
            }
        }, targetTime);
    }





    /*****************************************/
    /* Listener's methods */
    /*****************************************/

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keyEvent.consume();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            this.controller.finishIntro();
        } else
            keyEvent.consume();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        keyEvent.consume();
    }
}