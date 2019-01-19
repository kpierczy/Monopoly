package pl.kpierczyk.monopoly.view.subviews.gameView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pl.kpierczyk.monopoly.view.View;
import pl.kpierczyk.monopoly.view.subviews.gameView.elements.Board;



/**
 * Class representing appearance of the app during the main 
 * part - gameplay. It updates its view basing on game phase
 * and player's movements.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class GameView extends JPanel{

    /** Reference to View.*/
    View view;

    /** Visible elements.*/
    private Image backgroundImage;
    private Board board;
    private JButton rollEnd;

    private JLabel firstPllayer;
    private JLabel secondPllayer;
    private JLabel thirdPllayer;
    private JLabel fourthPllayer;
    private JLabel fivethPllayer;
    private JLabel sixthtPllayer;


    public GameView(View view){
        super();
        this.view = view;

        /*Game's size and layout initialization*/
        this.setPreferredSize(new Dimension(this.view.getModel().getSettings().getResolution()[0],
                                            this.view.getModel().getSettings().getResolution()[1]));
        this.setLayout(new BorderLayout());

        /** Loading backgrouynd gameplay image.*/
        try {
            backgroundImage = 
                ImageIO.read(new File("/img/" + this.view.getModel().getSettings().getResolutionSetting().getValue() +
                                      "/gameBackground/background_1.png"));
        }
        catch (IOException ex) {
            System.out.println("Couldn't open game's background image from " + 
                               "/img/" + this.view.getModel().getSettings().getResolutionSetting().getValue() +
                               "/gameBackground/background_1.png");
        }

        /** Board's initialization*/
        this.board = new Board(this.view.getModel().getSettings());
        this.add(this.board, BorderLayout.CENTER);

        /** Initializing roll/endTurn Button.*/
        this.rollEnd = new JButton();
        if(!view.getModel().getGameModel().isHasPlayerRolled())
            if(view.getModel().getSettings().getLanguage() == "en")
                this.rollEnd.setText("Roll");
            if(view.getModel().getSettings().getLanguage() == "pl")
                this.rollEnd.setText("Rzuć kostkami");
        else
            if(view.getModel().getSettings().getLanguage() == "en")
                    this.rollEnd.setText("End turn");
            if(view.getModel().getSettings().getLanguage() == "pl")
                this.rollEnd.setText("Zakończ turę");
        this.rollEnd.setPreferredSize(new Dimension(20, 30));
        this.add(rollEnd, BorderLayout.PAGE_END);


        /** */
    }




    /*****************************************/
    /* Utilities */
    /*****************************************/

        /*Graphical utilities*/
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this);
        }
}