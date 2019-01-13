package pl.kpierczyk.monopoly.view.subviews.mainMenuView.partialViews;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

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

public class InstructionView extends JPanel {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    private View view;

    private final Font font = new Font("Arial", Font.BOLD, 18);
    private final Border border = BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED);

    private Image instructionImage;

    private JButton backButton;
    private JButton leftButton;
    private JButton rightButton;

    /*****************************************/
    /* Constructor */
    /*****************************************/

    public InstructionView(View view) {
        super();
        this.view = view;

        /* Main menu's bacground image initialization */
        try {
            instructionImage = ImageIO
                    .read(new File(this.view.getModel().getMainMenuModel().getInstructionModel().getActualPagePath()));
        } catch (IOException ex) {
            System.out.println("Couldn't open mainMenu's background image from "
                    + this.view.getModel().getMainMenuModel().getInstructionModel().getActualPagePath());
        }

        /* Main menu's size and layout initialization */
        this.setPreferredSize(new Dimension(this.instructionImage.getWidth(new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        }), this.instructionImage.getHeight(new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        })));

        this.setLayout(new BorderLayout());
        this.setBorder(border);

        /* Main menu buttons panel adding */
        this.backButton = new JButton(
                this.view.getModel().getMainMenuModel().getInstructionModel().getBackButtonText());
        this.backButton.setFont(this.font);

        this.leftButton = new JButton("<---");
        this.leftButton.setFont(this.font);

        this.rightButton = new JButton("--->");
        this.rightButton.setFont(this.font);


        /////// HERE I'VE ENDED //////////// ---- handle buttons arrangament in the instruction window

        /*JPanel for buttons*/
        JPanel allButtonsContainer = new JPanel();
        allButtonsContainer.setLayout(new BoxLayout(allButtonsContainer,
                                                    BoxLayout.Y_AXIS)); 

        JPanel arrowsButtonsContainer = new JPanel(new BorderLayout());

        arrowsButtonsContainer.add(this.leftButton, BorderLayout.LINE_START);
        arrowsButtonsContainer.add(this.leftButton, BorderLayout.LINE_END);

        allButtonsContainer.add(arrowsButtonsContainer);
        arrowsButtonsContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
        allButtonsContainer.add(backButton);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(allButtonsContainer, BorderLayout.PAGE_END);
    }

    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public JButton getLeftButton() {
        return leftButton;
    }
    public JButton getRightButton() {
        return rightButton;
    }
    public JButton getBackButton() {
        return backButton;
    }

    /*****************************************/
    /* Utilities */
    /*****************************************/

    /* Graphical utilities */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(instructionImage, 0, 0, this);
    }

    /* Logical utilities */

    public void nextPage() {
        updatePage();
    }

    public void previousPage() {
        updatePage();
    }

    public void updatePage(){
        try {
            instructionImage = ImageIO
                    .read(new File(this.view.getModel().getMainMenuModel().getInstructionModel().getActualPagePath()));
        } catch (IOException ex) {
            System.out.println("Couldn't open mainMenu's background image from "
                    + this.view.getModel().getMainMenuModel().getInstructionModel().getActualPagePath());
        }

        this.view.revalidate();
        this.view.repaint();
    }


    public void backToMainMenu() {
        this.view.getMainMenuView().closeChild();
    }
}