package pl.kpierczyk.monopoly.view.subviews.mainMenuView.partialViews;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import pl.kpierczyk.monopoly.view.View;












public class SettingsView extends JPanel{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    private View view;

    private Image backgroundImage;

    private final Font font = new Font("Arial", Font.BOLD, 18);
    private final Border border = BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED);
    private final int bottomButtonsHeight = 30;

    private final JLabel languageTitleLabel;
    private JLabel languageLabel;
    private JButton previousLanguageButton;
    private JButton nextLanguageButton;
    
    private final JLabel resolutionTitleLabel;
    private JLabel resolutionLabel;
    private JButton previousResolutionButton;
    private JButton nextResolutionButton;
    
    private final JLabel fullscreenTitleLabel;
    private JLabel fullscreenLabel;
    private JButton previousfullscreenButton;
    private JButton nextfullscreenButton;
    
    private final JLabel soundLevelLabel;
    private JSlider soundLevelSlider;
    
    private final JButton backButton;
    private final JButton okButton;

    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public SettingsView(View view){super();
        this.view = view;

        /* Settings bacground image initialization */
        try {
            this.backgroundImage = ImageIO
                    .read(new File(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsbackgroundImagePath()));
        } catch (IOException ex) {
            System.out.println("Couldn't open settings background from "
                    + this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsbackgroundImagePath());
        }

        /* Main menu's size and layout initialization */
        this.setPreferredSize(new Dimension((
            this.backgroundImage.getWidth(new ImageObserver(){
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            })),
            this.backgroundImage.getHeight(new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
        })));

        this.setLayout(new BorderLayout());
        this.setBorder(border);

        /* Buttons and labels initialization */

        this.languageTitleLabel = new JLabel(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsTexts(0));
        this.languageTitleLabel.setFont(font);
        this.languageLabel = new JLabel(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsValues(0));
        this.languageLabel.setFont(font);
        this.previousLanguageButton = new JButton("<-");
        this.previousLanguageButton.setFont(font);
        this.nextLanguageButton = new JButton("->");
        this.nextLanguageButton.setFont(font);

        this.resolutionTitleLabel = new JLabel(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsTexts(1));
        this.resolutionTitleLabel.setFont(font);
        this.resolutionLabel = new JLabel(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsValues(1));
        this.resolutionLabel.setFont(font);
        this.previousResolutionButton = new JButton("<-");
        this.previousResolutionButton.setFont(font);
        this.nextResolutionButton = new JButton("->");
        this.nextResolutionButton.setFont(font);

        this.fullscreenTitleLabel = new JLabel(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsTexts(2));
        this.fullscreenTitleLabel.setFont(font);
        this.fullscreenLabel = new JLabel(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsValues(2));
        this.fullscreenLabel.setFont(font);
        this.previousfullscreenButton = new JButton("<-");
        this.previousfullscreenButton.setFont(font);
        this.nextfullscreenButton = new JButton("->");
        this.nextfullscreenButton.setFont(font);

        this.soundLevelLabel = new JLabel(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsTexts(3));
        this.soundLevelLabel.setFont(font);
        this.soundLevelSlider = new JSlider(0, 100);
        this.soundLevelSlider.setValue(Integer.parseInt(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsValues(3)));
        
        this.backButton = new JButton(this.view.getModel().getMainMenuModel().getSettingsModel().getBackButtonText());
        this.backButton.setFont(font);
        this.okButton = new JButton(this.view.getModel().getMainMenuModel().getSettingsModel().getOkButtonText());
        this.okButton.setFont(font);





        /*JPanel for back and ok buttons*/
        JPanel backOkButtonsContainer = new JPanel(new BorderLayout()); 

        backOkButtonsContainer.add(this.backButton, BorderLayout.WEST);
        backOkButtonsContainer.add(this.okButton, BorderLayout.EAST);
                                                  
        this.backButton.setPreferredSize(new Dimension(this.getPreferredSize().width / 2,
                                                       this.bottomButtonsHeight));
        this.okButton.setPreferredSize(new Dimension(this.getPreferredSize().width / 2,
                                                        this.bottomButtonsHeight));                                                            
        backOkButtonsContainer.setPreferredSize(new Dimension(this.getPreferredSize().width,
                                                           this.bottomButtonsHeight));
        this.add(backOkButtonsContainer, BorderLayout.SOUTH);




        /*JPanel for settings*/
        JPanel allGatherPanel = new JPanel();

        allGatherPanel.setLayout(new BoxLayout(allGatherPanel, BoxLayout.Y_AXIS));
        allGatherPanel.setBorder(BorderFactory.createEmptyBorder(80, 160, 80, 240));

        this.add(allGatherPanel, BorderLayout.CENTER);
        



        /*Settings row*/
        JPanel languageRow = new JPanel();
        FlowLayout languageRowLayout = new FlowLayout(FlowLayout.LEFT);
        languageRow.setLayout(languageRowLayout);
        allGatherPanel.add(languageRow);

        allGatherPanel.add(Box.createVerticalStrut(50));

        JPanel resolutionRow = new JPanel();
        FlowLayout resolutoinRowLayout = new FlowLayout(FlowLayout.LEFT);
        resolutionRow.setLayout(resolutoinRowLayout);
        allGatherPanel.add(resolutionRow);

        allGatherPanel.add(Box.createVerticalStrut(50));

        JPanel fullscreenRow = new JPanel();
        FlowLayout fullscreenRowLayout = new FlowLayout(FlowLayout.LEFT);
        fullscreenRow.setLayout(fullscreenRowLayout);
        allGatherPanel.add(fullscreenRow);

        allGatherPanel.add(Box.createVerticalStrut(50));

        JPanel soundLevelRow = new JPanel();
        FlowLayout soundLevelRowLayout = new FlowLayout(FlowLayout.LEFT);
        soundLevelRow.setLayout(soundLevelRowLayout);
        allGatherPanel.add(soundLevelRow);





        /*JPanel for langueage*/
        languageRow.add(this.languageTitleLabel);
        this.languageTitleLabel.setPreferredSize(new Dimension(250, 40));
        this.languageTitleLabel.setHorizontalAlignment( SwingConstants.CENTER );

        JPanel languageValuePanel = new JPanel();
        FlowLayout languageValuePanelLayout = new FlowLayout(FlowLayout.LEFT);
        languageValuePanel.setLayout(languageValuePanelLayout);
        languageRow.add(languageValuePanel);

        languageValuePanel.add(this.previousLanguageButton);
        this.previousLanguageButton.setPreferredSize(new Dimension(60, 30));

        languageValuePanel.add(this.languageLabel);
        this.languageLabel.setPreferredSize(new Dimension(140, 40));
        this.languageLabel.setHorizontalAlignment( SwingConstants.CENTER );

        languageValuePanel.add(this.nextLanguageButton);
        this.nextLanguageButton.setPreferredSize(new Dimension(60, 30));

        

        

        /*JPanel for resolution*/
        resolutionRow.add(this.resolutionTitleLabel);
        this.resolutionTitleLabel.setPreferredSize(new Dimension(250, 40));
        this.resolutionTitleLabel.setHorizontalAlignment( SwingConstants.CENTER );
        
        JPanel resolutionValuePanel = new JPanel();
        FlowLayout resolutionValuePanelLayout = new FlowLayout(FlowLayout.LEFT);
        resolutionValuePanel.setLayout(resolutionValuePanelLayout);
        resolutionRow.add(resolutionValuePanel);

        resolutionValuePanel.add(this.previousResolutionButton);
        this.previousResolutionButton.setPreferredSize(new Dimension(60, 30));

        resolutionValuePanel.add(this.resolutionLabel);
        this.resolutionLabel.setPreferredSize(new Dimension(140, 20));
        this.resolutionLabel.setHorizontalAlignment( SwingConstants.CENTER );

        resolutionValuePanel.add(this.nextResolutionButton);
        this.nextResolutionButton.setPreferredSize(new Dimension(60, 30));




        /*JPanel for fullscreen*/
        fullscreenRow.add(this.fullscreenTitleLabel);
        this.fullscreenTitleLabel.setPreferredSize(new Dimension(250, 40));
        this.fullscreenTitleLabel.setHorizontalAlignment( SwingConstants.CENTER );

        JPanel fullscreenValuePanel = new JPanel();
        FlowLayout fullscreenValuePanelLayout = new FlowLayout(FlowLayout.LEFT);
        resolutionValuePanel.setLayout(fullscreenValuePanelLayout);
        fullscreenRow.add(fullscreenValuePanel);

        fullscreenValuePanel.add(this.previousfullscreenButton);
        this.previousfullscreenButton.setPreferredSize(new Dimension(60, 30));

        fullscreenValuePanel.add(this.fullscreenLabel);
        this.fullscreenLabel.setPreferredSize(new Dimension(140, 20));
        this.fullscreenLabel.setHorizontalAlignment( SwingConstants.CENTER );

        fullscreenValuePanel.add(this.nextfullscreenButton);
        this.nextfullscreenButton.setPreferredSize(new Dimension(60, 30));


        /*JPanel for soundLevel*/
        soundLevelRow.add(this.soundLevelLabel);
        this.soundLevelLabel.setPreferredSize(new Dimension(250, 20));
        this.soundLevelLabel.setHorizontalAlignment( SwingConstants.CENTER );

        soundLevelRow.add(this.soundLevelSlider);
        this.soundLevelSlider.setPreferredSize(new Dimension(280, 40));
    }





    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/
    
    /**
     * @return the languageTitleLabel
     */
    public JLabel getLanguageTitleLabel() {
        return languageTitleLabel;
    }
    /**
     * @return the languageLabel
     */
    public JLabel getLanguageLabel() {
        return languageLabel;
    }
    /**
     * @return the previousLanguage
     */
    public JButton getPreviousLanguageButton() {
        return previousLanguageButton;
    }
    /**
     * @return the nextLanguage
     */
    public JButton getNextLanguageButton() {
        return nextLanguageButton;
    }


    /**
     * @return the resolutionTitleLabel
     */
    public JLabel getResolutionTitleLabel() {
        return resolutionTitleLabel;
    }
    /**
     * @return the resolutionLabel
     */
    public JLabel getResolutionLabel() {
        return resolutionLabel;
    }
    /**
     * @return the previousResolution
     */
    public JButton getPreviousResolutionButton() {
        return previousResolutionButton;
    }
    /**
     * @return the nextResolutionButton
     */
    public JButton getNextResolutionButton() {
        return nextResolutionButton;
    }


    /**
     * @return the fullscreenTitleLabel
     */
    public JLabel getFullscreenTitleLabel() {
        return fullscreenTitleLabel;
    }
    /**
     * @return the fullscreenLabel
     */
    public JLabel getFullscreenLabel() {
        return fullscreenLabel;
    }
    /**
     * @return the previousfullscreenButton
     */
    public JButton getPreviousfullscreenButton() {
        return previousfullscreenButton;
    }
    /**
     * @return the nextfullscreenButton
     */
    public JButton getNextfullscreenButton() {
        return nextfullscreenButton;
    }

    /**
     * @return the soundLevelSlider
     */
    public JSlider getSoundLevelSlider() {
        return soundLevelSlider;
    }

    /**
     * @return the backButton
     */
    public JButton getBackButton() {
        return backButton;
    }
    /**
     * @return the okButton
     */
    public JButton getOkButton() {
        return okButton;
    }


    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    /* Graphical utilities */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }

    /*Logical utilities*/


    public void previousLanguage(){
        this.languageLabel.setText(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsValues(0));

        this.view.revalidate();
        this.view.repaint();
    }


    public void nextLanguage(){
        this.languageLabel.setText(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsValues(0));

        this.view.revalidate();
        this.view.repaint();
    }


    public void previousResolution(){
        this.resolutionLabel.setText(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsValues(1));
        this.view.revalidate();
        this.view.repaint();
    }


    public void nextResolution(){
        this.resolutionLabel.setText(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsValues(1));

        this.view.revalidate();
        this.view.repaint();
    }


    public void switchFullscreen(){
        this.fullscreenLabel.setText(this.view.getModel().getMainMenuModel().getSettingsModel().getSettingsValues(2));

        this.view.revalidate();
        this.view.repaint();
    }



    public void setVolume(int volumeValue){
        
    }


    public void backToMainMenu(){
        this.view.getMainMenuView().closeChild();
    }

    public void saveChanges(){
        this.view.update();
        backToMainMenu();
    }
}