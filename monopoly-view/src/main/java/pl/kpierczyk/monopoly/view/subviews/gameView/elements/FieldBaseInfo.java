package pl.kpierczyk.monopoly.view.subviews.gameView.elements;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import pl.kpierczyk.monopoly.view.View;

/**
 * 
 */
abstract class FieldBaseInfo extends JPanel{
    
    protected View view;
    
    protected final Font font = new Font("Arial", Font.BOLD, 18);
    protected final int backButtonHeight = 30;
    
    private Image backgroundFieldInfoImage;
    private JButton backButton;

    public FieldBaseInfo(View view){


        /** Loading background for Fields info panels.*/
        try{
            backgroundFieldInfoImage = 
                ImageIO.read(getClass().getResourceAsStream(
                    "/img/" + view.getModel().getSettings().getResolution() +
                    "/fieldsPanelsBackground/fieldBackground.png" 
            ));
        }
        catch(Exception ex){
            System.out.println("Couldn't open field info background image from " + 
                                "/img/" + view.getModel().getSettings().getResolution() +
                                "/fieldsPanelsBackground/fieldBackground.png");
        }

        
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(
            this.backgroundFieldInfoImage.getWidth(new ImageObserver () {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            }),
            this.backgroundFieldInfoImage.getHeight(new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
        }) + backButtonHeight));
        
        this.setPreferredSize(new Dimension(
            this.getWidth(),
            this.getHeight()
        ));



        this.backButton = new JButton();
        if(view.getModel().getSettings().getLanguage() == "en")
            backButton.setText("Back");
        else if(view.getModel().getSettings().getLanguage() == "pl")
            backButton.setText("Wróć");
        this.backButton.setFont(font);
        this.setPreferredSize(new Dimension(0, backButtonHeight));

        this.add(backButton, BorderLayout.SOUTH);        
    }



    /** 
     * 
     * 
     * @param g
    */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundFieldInfoImage, 0, 0, this);
    }

    /**
     * @return the backButton
     */
    public JButton getBackButton() {
        return backButton;
    }
}