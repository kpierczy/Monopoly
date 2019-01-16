package pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers;

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

        this.controller.getView().getMainMenuView().getSettingsView().getPreviousLanguageButton().addActionListener(this);
        this.controller.getView().getMainMenuView().getSettingsView().getNextLanguageButton().addActionListener(this);
        
        this.controller.getView().getMainMenuView().getSettingsView().getPreviousResolutionButton().addActionListener(this);
        this.controller.getView().getMainMenuView().getSettingsView().getNextResolutionButton().addActionListener(this);

        this.controller.getView().getMainMenuView().getSettingsView().getPreviousfullscreenButton().addActionListener(this);
        this.controller.getView().getMainMenuView().getSettingsView().getNextfullscreenButton().addActionListener(this);

        this.controller.getView().getMainMenuView().getSettingsView().getSoundLevelSlider().addChangeListener(this);

        this.controller.getView().getMainMenuView().getSettingsView().getBackButton().addActionListener(this);
        this.controller.getView().getMainMenuView().getSettingsView().getOkButton().addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonSource = (JButton) e.getSource();

        if(buttonSource == this.controller.getView().getMainMenuView().getSettingsView().getPreviousLanguageButton()){
            if(this.controller.getModel().getMainMenuModel().getSettingsModel().previousLanguage()){
                this.controller.getView().getMainMenuView().getSettingsView().previousLanguage();
            }
        }
        else if(buttonSource == this.controller.getView().getMainMenuView().getSettingsView().getNextLanguageButton()){
            if(this.controller.getModel().getMainMenuModel().getSettingsModel().nextLanguage()){
                this.controller.getView().getMainMenuView().getSettingsView().nextLanguage();
            }
        }
        else if(buttonSource == this.controller.getView().getMainMenuView().getSettingsView().getPreviousResolutionButton()){
            if(this.controller.getModel().getMainMenuModel().getSettingsModel().previousResolution()){
                this.controller.getView().getMainMenuView().getSettingsView().previousResolution();
            }
        }
        else if(buttonSource == this.controller.getView().getMainMenuView().getSettingsView().getNextResolutionButton()){
            if(this.controller.getModel().getMainMenuModel().getSettingsModel().nextResolution()){
                this.controller.getView().getMainMenuView().getSettingsView().nextResolution();
            }
        }
        else if(buttonSource == this.controller.getView().getMainMenuView().getSettingsView().getPreviousfullscreenButton()){
            this.controller.getModel().getMainMenuModel().getSettingsModel().switchFullscreen();
            this.controller.getView().getMainMenuView().getSettingsView().switchFullscreen();
        }
        else if(buttonSource == this.controller.getView().getMainMenuView().getSettingsView().getNextfullscreenButton()){
            this.controller.getModel().getMainMenuModel().getSettingsModel().switchFullscreen();
            this.controller.getView().getMainMenuView().getSettingsView().switchFullscreen();
        }
        else if(buttonSource == this.controller.getView().getMainMenuView().getSettingsView().getBackButton()){
            if(this.controller.getModel().getMainMenuModel().getSettingsModel().backToMainMenu()){
                this.controller.getView().getMainMenuView().getSettingsView().backToMainMenu();
                this.controller.getMainMenuController().closeChild();
            }
        }
        else if(buttonSource == this.controller.getView().getMainMenuView().getSettingsView().getOkButton()){
            if(this.controller.getModel().getMainMenuModel().getSettingsModel().saveChanges()){
                this.controller.getView().getMainMenuView().getSettingsView().saveChanges();
                this.controller.getMainMenuController().closeChild();
            }
        }   
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        this.controller.getModel().getMainMenuModel().getSettingsModel().setVolume(slider.getValue());
    }
}