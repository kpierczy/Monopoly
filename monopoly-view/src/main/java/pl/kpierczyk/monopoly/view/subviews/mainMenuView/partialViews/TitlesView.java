package pl.kpierczyk.monopoly.view.subviews.mainMenuView.partialViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import pl.kpierczyk.monopoly.view.View;











//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class TitlesView extends JPanel{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    private View view;

    private final Font font = new Font("Arial", Font.BOLD, 18);
    private Image backgroundImage;
    private JButton backButton;

    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public TitlesView(View view){
        super();
        this.view = view;

        /*Main menu's bacground image initialization*/
        try {
            backgroundImage = 
                ImageIO.read(new File(this.view.getModel().getMainMenuModel().getTitlesModel().getTitlesPath()));
        }
        catch (IOException ex) {
            System.out.println("Couldn't open mainMenu's background image from " + 
                                this.view.getModel().getMainMenuModel().getBackgroundImagePath());
        }


        /*Main menu's size and layout initialization*/
        this.setPreferredSize(new Dimension(
            this.backgroundImage.getWidth(new ImageObserver(){
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            } ),
            this.backgroundImage.getHeight(new ImageObserver(){
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            })));
        


        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        /*Main menu buttons panel adding*/
        this.backButton = 
            new JButton(this.view.getModel().getMainMenuModel().getTitlesModel().getBackButtonText());
        this.backButton.setFont(this.font);
        this.add(this.backButton, BorderLayout.PAGE_END);
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public JButton getBackButton() {
        return backButton;
    }

    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    /*Graphical utilities*/
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }

    /*Logical utilities*/
    public void backToMainMenu(){
        this.view.getMainMenuView().closeChild();
    }
}