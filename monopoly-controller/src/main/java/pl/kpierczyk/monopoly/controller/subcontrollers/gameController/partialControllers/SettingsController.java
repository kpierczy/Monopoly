package pl.kpierczyk.monopoly.controller.subcontrollers.gameController.partialControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import pl.kpierczyk.monopoly.controller.Controller;



/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class SettingsController implements ActionListener, ChangeListener {//ActionListener{

    Controller controller;

    public SettingsController(Controller controller){
        this.controller = controller;

        this.controller.getView().getGameView().getSettingsView().getPreviousLanguageButton().addActionListener(this);
        this.controller.getView().getGameView().getSettingsView().getNextLanguageButton().addActionListener(this);
        
        this.controller.getView().getGameView().getSettingsView().getPreviousResolutionButton().addActionListener(this);
        this.controller.getView().getGameView().getSettingsView().getNextResolutionButton().addActionListener(this);

        this.controller.getView().getGameView().getSettingsView().getPreviousfullscreenButton().addActionListener(this);
        this.controller.getView().getGameView().getSettingsView().getNextfullscreenButton().addActionListener(this);

        this.controller.getView().getGameView().getSettingsView().getSoundLevelSlider().addChangeListener(this);

        this.controller.getView().getGameView().getSettingsView().getBackButton().addActionListener(this);
        this.controller.getView().getGameView().getSettingsView().getOkButton().addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonSource = (JButton) e.getSource();

        if(buttonSource == this.controller.getView().getGameView().getSettingsView().getPreviousLanguageButton()){
            if(this.controller.getModel().getMainMenuModel().getSettingsModel().previousLanguage()){
                this.controller.getView().getGameView().getSettingsView().previousLanguage();
            }
        }
        else if(buttonSource == this.controller.getView().getGameView().getSettingsView().getNextLanguageButton()){
            if(this.controller.getModel().getMainMenuModel().getSettingsModel().nextLanguage()){
                this.controller.getView().getGameView().getSettingsView().nextLanguage();
            }
        }
        else if(buttonSource == this.controller.getView().getGameView().getSettingsView().getPreviousResolutionButton()){
            if(this.controller.getModel().getMainMenuModel().getSettingsModel().previousResolution()){
                this.controller.getView().getGameView().getSettingsView().previousResolution();
            }
        }
        else if(buttonSource == this.controller.getView().getGameView().getSettingsView().getNextResolutionButton()){
            if(this.controller.getModel().getMainMenuModel().getSettingsModel().nextResolution()){
                this.controller.getView().getGameView().getSettingsView().nextResolution();
            }
        }
        else if(buttonSource == this.controller.getView().getGameView().getSettingsView().getPreviousfullscreenButton()){
            this.controller.getModel().getMainMenuModel().getSettingsModel().switchFullscreen();
            this.controller.getView().getGameView().getSettingsView().switchFullscreen();
        }
        else if(buttonSource == this.controller.getView().getGameView().getSettingsView().getNextfullscreenButton()){
            this.controller.getModel().getMainMenuModel().getSettingsModel().switchFullscreen();
            this.controller.getView().getGameView().getSettingsView().switchFullscreen();
        }
        else if(buttonSource == this.controller.getView().getGameView().getSettingsView().getBackButton()){
            if(this.controller.getModel().getMainMenuModel().getSettingsModel().backToMainMenu()){
                this.controller.getView().getGameView().getSettingsView().backToMainMenu();
                this.controller.getGameController().getGameMenuController().closeChild();
            }
        }
        else if(buttonSource == this.controller.getView().getGameView().getSettingsView().getOkButton()){

            boolean answer[] = this.controller.getModel().getMainMenuModel().getSettingsModel().saveChanges();

            if(answer[0]){
                this.controller.getView().getGameView().getSettingsView().saveChanges(
                    answer[1], this.controller.getModel().getSettings());
                this.controller.getGameController().getGameMenuController().closeChild();
            }
        }   
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        this.controller.getModel().getMainMenuModel().getSettingsModel().setVolume(slider.getValue());
    }
}