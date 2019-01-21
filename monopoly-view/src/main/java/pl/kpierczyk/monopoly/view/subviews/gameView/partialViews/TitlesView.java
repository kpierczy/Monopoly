package pl.kpierczyk.monopoly.view.subviews.gameView.partialViews;

import java.awt.BorderLayout;
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
import javax.swing.border.Border;

import pl.kpierczyk.monopoly.view.View;




/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class TitlesView extends JPanel{

    private View view;

    private final Font font = new Font("Arial", Font.BOLD, 18);
    private final Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
    
    private Image titlesImage;
    
    private JButton backButton;

    public TitlesView(View view){
        super();
        this.view = view;

        /*Main menu's bacground image initialization*/
        try {
            titlesImage = 
                ImageIO.read(new File(this.view.getModel().getMainMenuModel().getTitlesModel().getTitlesPath()));
        }
        catch (IOException ex) {
            System.out.println("Couldn't open mainMenu's background image from " + 
                                this.view.getModel().getMainMenuModel().getTitlesModel().getTitlesPath());
        }


        /*Main menu's size and layout initialization*/
        this.setPreferredSize(new Dimension(
            this.titlesImage.getWidth(new ImageObserver(){
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            } ),
            this.titlesImage.getHeight(new ImageObserver(){
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            }
            )
            )
        );
        
        this.setSize(new Dimension(this.getPreferredSize().width,
                                   this.getPreferredSize().height));
        


        this.setLayout(new BorderLayout());
        this.setBorder(border);

        /*Main menu buttons panel adding*/
        this.backButton = 
            new JButton(this.view.getModel().getMainMenuModel().getTitlesModel().getBackButtonText());
        this.backButton.setFont(this.font);
        this.add(this.backButton, BorderLayout.PAGE_END);
    }


    public JButton getBackButton() {
        return backButton;
    }

    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    /*Graphical utilities*/
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(titlesImage, 0, 0, this);
    }

    /*Logical utilities*/
    public void backToMainMenu(){
        this.view.getGameView().closeChild();
    }
}