package pl.kpierczyk.monopoly.view.subviews.gameView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pl.kpierczyk.monopoly.model.utilities.Util;
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

    /** Fonts and dimensions.*/
    private final Font rollEndButtonfont = new Font("Arial", Font.BOLD, 22);
    private final int rollEndButtonHeight = 30;

    private final int panelsButtonsWidth = 250;
    private final int panelsButtonsHeight = 40;
    private final Font panelsButtonsFont = new Font("Arial", Font.BOLD, 19);

    /** Always Visible*/
    private Image backgroundImage;

    private Board board;
    private JButton rollEnd;

    private ArrayList<JButton> playersButtons;

    private JButton menuButton;

    /** Visible on action*/
    private JButton bankruptButton;
    private GameMenuPanel gameMenuPanel;
    


    /**
     * 
     * 
     * @param view
     */
    public GameView(View view){
        super();
        this.view = view;

        /*Game's size and layout initialization*/
        this.setPreferredSize(new Dimension(this.view.getModel().getSettings().getResolution()[0],
                                            this.view.getModel().getSettings().getResolution()[1]));
        this.setLayout(new BorderLayout());



        /** Loading backgrouynd gameplay image.*/
        String backgroundPath = "/img/" + this.view.getModel().getSettings().getResolutionSetting().getValue() +
                                "/gameBackground/background_1.png";
         

        try {
            String absoluteBackgroundPath = getClass().getResource(backgroundPath).getPath();
            backgroundImage = 
                ImageIO.read(new File(Util.convert(absoluteBackgroundPath)));
        }
        catch (Exception ex) {
            System.out.println("Couldn't open game's background image from " + 
                               "/img/" + this.view.getModel().getSettings().getResolutionSetting().getValue() +
                               "/gameBackground/background_1.png");
        }

        /** Board's initialization*/
        this.board = new Board(this.view.getModel().getSettings());
        this.board.setOpaque(false);
        this.add(this.board, BorderLayout.CENTER);


        
        /** Initializing roll/endTurn Button.*/
        this.rollEnd = new JButton();
        if(!view.getModel().getGameModel().isHasPlayerRolled()){
            if(view.getModel().getSettings().getLanguage() == "en")
                this.rollEnd.setText("Roll");
            else if(view.getModel().getSettings().getLanguage() == "pl")
                this.rollEnd.setText("Rzuć kostkami");
        }
        else{
            if(view.getModel().getSettings().getLanguage() == "en")
                    this.rollEnd.setText("End turn");
            else if(view.getModel().getSettings().getLanguage() == "pl")
                this.rollEnd.setText("Zakończ turę");
        }
        this.rollEnd.setPreferredSize(new Dimension(0, rollEndButtonHeight));
        this.rollEnd.setFont(rollEndButtonfont);
        this.add(rollEnd, BorderLayout.PAGE_END);



        /** Players Button initialization.*/
        playersButtons = new ArrayList<JButton>();
        for(int i = 0; i < view.getModel().getGameModel().getPlayers().size(); i++){

            playersButtons.add(new JButton());

            playersButtons.get(i).setPreferredSize(
                new Dimension(panelsButtonsWidth, panelsButtonsHeight)
            );

            playersButtons.get(i).setText(
                view.getModel().getGameModel().getPlayers().get(i).getName() + 
                "    " + 
                view.getModel().getGameModel().getPlayers().get(i).getCash() + 
                "$"
            );

            playersButtons.get(i).setFont(panelsButtonsFont);
        }



        /*********************************/
        /** Initializing left-side panel.*/
        /*********************************/

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(panelsButtonsWidth, 0));
        leftPanel.setOpaque(false);
        this.add(leftPanel, BorderLayout.LINE_START);


        //Left players panel//
        JPanel leftPlayersPanel = new JPanel(new FlowLayout());
        leftPlayersPanel.setOpaque(false);
        leftPlayersPanel.setPreferredSize(new Dimension(panelsButtonsWidth, panelsButtonsHeight * 3));
        FlowLayout leftPlayersLayout = 
            (FlowLayout) leftPlayersPanel.getLayout();
        leftPlayersLayout.setVgap(0);
        
        
        leftPlayersPanel.add(playersButtons.get(0));
        if(playersButtons.size() > 2)
            leftPlayersPanel.add(playersButtons.get(2));
        if(playersButtons.size() > 4)
            leftPlayersPanel.add(playersButtons.get(4));

        leftPanel.add(leftPlayersPanel, BorderLayout.PAGE_START);
        

        //Menu Button//
        menuButton = new JButton("Menu");
        menuButton.setPreferredSize(new Dimension(panelsButtonsWidth, panelsButtonsHeight));
        menuButton.setFont(panelsButtonsFont);
        leftPanel.add(menuButton, BorderLayout.PAGE_END);





        /*********************************/
        /** Initializing left-side panel.*/
        /*********************************/
        
        JPanel rightPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(panelsButtonsWidth, 0));
        rightPanel.setOpaque(false);
        this.add(rightPanel, BorderLayout.LINE_END);

        //Right players panel//
        JPanel rightPlayersPanel = new JPanel(new FlowLayout());
        rightPlayersPanel.setOpaque(false);
        rightPlayersPanel.setPreferredSize(new Dimension(panelsButtonsWidth, panelsButtonsHeight * 3));
        FlowLayout rightPlayersLayout = 
            (FlowLayout) rightPlayersPanel.getLayout();
        rightPlayersLayout.setVgap(0);
        
        
        rightPlayersPanel.add(playersButtons.get(1));
        if(playersButtons.size() > 3)
            rightPlayersPanel.add(playersButtons.get(3));
        if(playersButtons.size() > 5)
            rightPlayersPanel.add(playersButtons.get(5));

        rightPanel.add(rightPlayersPanel, BorderLayout.PAGE_START);
        

        //Bankrupt Button//
        bankruptButton = new JButton();

        if(view.getModel().getSettings().getLanguage() == "pl")
            bankruptButton.setText("Ogłoś upadłość");
        else if(view.getModel().getSettings().getLanguage() == "en")
            bankruptButton.setText("Bankrupt");

        bankruptButton.setPreferredSize(new Dimension(panelsButtonsWidth, panelsButtonsHeight));
        bankruptButton.setFont(panelsButtonsFont);
        //bankruptButton.setVisible(false);

        rightPanel.add(bankruptButton, BorderLayout.PAGE_END);
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















class GameMenuPanel extends JPanel {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    View view;

    private final int buttonWidth = 300;
    private final int buttonHeight = 75;
    private final Font font = new Font("Arial", Font.BOLD, 18);

    private JButton buttons[];


    /*****************************************/
    /* Constructor */
    /*****************************************/

    public GameMenuPanel(View view) {
        this.view = view;

        /*Getting number of buttons to create*/
        int buttonsNumber =
            this.view.getModel().getMainMenuModel().getMainMenu().getMenuFields().length;
        
        this.setPreferredSize(new Dimension(this.buttonWidth,
                                            this.buttonHeight * buttonsNumber));
        
        /*Setting MaineMenu's buttons layout*/
        this.setLayout(new FlowLayout());
        FlowLayout layout = 
            (FlowLayout) this.getLayout();
        layout.setVgap(0);

        /*Initializing buttons*/
        this.buttons = new JButton[buttonsNumber];
        for (int i = 0; i < buttonsNumber; i++) {
            this.buttons[i] = new JButton(
                this.view.getModel().getGameModel().getGameMenu().getMenuField(i).getFieldText());
            this.buttons[i].setPreferredSize(new Dimension(this.buttonWidth,
                                                           this.buttonHeight));
            this.buttons[i].setFont(font);
            this.add(this.buttons[i]);
        }

    }


    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public JButton[] getButtons() {
        return this.buttons;
    }
}