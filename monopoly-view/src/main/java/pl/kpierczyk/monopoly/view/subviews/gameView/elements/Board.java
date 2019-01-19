package pl.kpierczyk.monopoly.view.subviews.gameView.elements;

import javax.swing.*;

import pl.kpierczyk.monopoly.model.utilities.settings.Settings;

import java.awt.*;
import java.util.ArrayList;


public class Board extends JPanel {


    /** List of fields representing.*/
    private ArrayList<JButton> fields = new ArrayList<JButton>(40);
    /** Central part of the Board.*/
    private JLabel centralPart;


    public Board(Settings settings){
        super();
        this.setLayout(new GridBagLayout());
        this.setMaximumSize(new Dimension(1000, 1000));
        this.setMinimumSize(new Dimension(1000, 1000));
        this.setPreferredSize(new Dimension(1000, 1000));

        this.fields.set(11, new JButton());
        this.fields.get(11).setHideActionText(true);
        this.fields.get(11).setHorizontalTextPosition(0);
        this.fields.get(11).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/11.png")));
        this.fields.get(11).setIconTextGap(0);
        this.fields.get(11).setMaximumSize(new Dimension(134, 134));
        this.fields.get(11).setMinimumSize(new Dimension(134, 134));
        this.fields.get(11).setOpaque(false);
        this.fields.get(11).setPreferredSize(new Dimension(134, 134));
        this.fields.get(11).setText("");
        this.fields.get(11).setVerticalAlignment(0);
        this.fields.get(11).setVerticalTextPosition(0);
        this.fields.get(11).setVisible(true);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(11), gbc);



        this.fields.set(12, new JButton());
        this.fields.get(12).setHideActionText(true);
        this.fields.get(12).setHorizontalTextPosition(0);
        this.fields.get(12).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/12.png")));
        this.fields.get(12).setIconTextGap(0);
        this.fields.get(12).setMaximumSize(new Dimension(80, 134));
        this.fields.get(12).setMinimumSize(new Dimension(80, 134));
        this.fields.get(12).setPreferredSize(new Dimension(80, 134));
        this.fields.get(12).setText("");
        this.fields.get(12).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(12), gbc);



        this.fields.set(13, new JButton());
        this.fields.get(13).setHorizontalTextPosition(0);
        this.fields.get(13).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/13.png")));
        this.fields.get(13).setIconTextGap(0);
        this.fields.get(13).setMaximumSize(new Dimension(80, 134));
        this.fields.get(13).setMinimumSize(new Dimension(80, 134));
        this.fields.get(13).setPreferredSize(new Dimension(80, 134));
        this.fields.get(13).setText("");
        this.fields.get(13).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(13), gbc);



        this.fields.set(14, new JButton());
        this.fields.get(14).setHorizontalTextPosition(0);
        this.fields.get(14).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/14.png")));
        this.fields.get(14).setIconTextGap(0);
        this.fields.get(14).setMaximumSize(new Dimension(80, 134));
        this.fields.get(14).setMinimumSize(new Dimension(80, 134));
        this.fields.get(14).setPreferredSize(new Dimension(80, 134));
        this.fields.get(14).setText("");
        this.fields.get(14).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(14), gbc);



        this.fields.set(15, new JButton());
        this.fields.get(15).setHorizontalTextPosition(0);
        this.fields.get(15).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/15.png")));
        this.fields.get(15).setIconTextGap(0);
        this.fields.get(15).setMaximumSize(new Dimension(80, 134));
        this.fields.get(15).setMinimumSize(new Dimension(80, 134));
        this.fields.get(15).setPreferredSize(new Dimension(80, 134));
        this.fields.get(15).setText("");
        this.fields.get(15).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(15), gbc);



        this.fields.set(16, new JButton());
        this.fields.get(16).setHorizontalTextPosition(0);
        this.fields.get(16).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/16.png")));
        this.fields.get(16).setIconTextGap(0);
        this.fields.get(16).setMaximumSize(new Dimension(80, 134));
        this.fields.get(16).setMinimumSize(new Dimension(80, 134));
        this.fields.get(16).setPreferredSize(new Dimension(80, 134));
        this.fields.get(16).setText("");
        this.fields.get(16).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(16), gbc);



        this.fields.set(17, new JButton());
        this.fields.get(17).setHorizontalTextPosition(0);
        this.fields.get(17).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/17.png")));
        this.fields.get(17).setIconTextGap(0);
        this.fields.get(17).setMaximumSize(new Dimension(80, 134));
        this.fields.get(17).setMinimumSize(new Dimension(80, 134));
        this.fields.get(17).setPreferredSize(new Dimension(80, 134));
        this.fields.get(17).setText("");
        this.fields.get(17).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(17), gbc);



        this.fields.set(18, new JButton());
        this.fields.get(18).setHorizontalTextPosition(0);
        this.fields.get(18).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/18.png")));
        this.fields.get(18).setIconTextGap(0);
        this.fields.get(18).setMaximumSize(new Dimension(80, 134));
        this.fields.get(18).setMinimumSize(new Dimension(80, 134));
        this.fields.get(18).setPreferredSize(new Dimension(80, 134));
        this.fields.get(18).setText("");
        this.fields.get(18).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(18), gbc);



        this.fields.set(19, new JButton());
        this.fields.get(19).setHorizontalTextPosition(0);
        this.fields.get(19).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/19.png")));
        this.fields.get(19).setIconTextGap(0);
        this.fields.get(19).setMaximumSize(new Dimension(80, 134));
        this.fields.get(19).setMinimumSize(new Dimension(80, 134));
        this.fields.get(19).setPreferredSize(new Dimension(80, 134));
        this.fields.get(19).setText("");
        this.fields.get(19).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(19), gbc);



        this.fields.set(20, new JButton());
        this.fields.get(20).setHorizontalTextPosition(0);
        this.fields.get(20).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/20.png")));
        this.fields.get(20).setIconTextGap(0);
        this.fields.get(20).setMaximumSize(new Dimension(80, 134));
        this.fields.get(20).setMinimumSize(new Dimension(80, 134));
        this.fields.get(20).setPreferredSize(new Dimension(80, 134));
        this.fields.get(20).setText("");
        this.fields.get(20).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(20), gbc);



        this.fields.set(10, new JButton());
        this.fields.get(10).setHorizontalTextPosition(0);
        this.fields.get(10).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/10.png")));
        this.fields.get(10).setIconTextGap(0);
        this.fields.get(10).setMaximumSize(new Dimension(134, 80));
        this.fields.get(10).setMinimumSize(new Dimension(134, 80));
        this.fields.get(10).setPreferredSize(new Dimension(134, 80));
        this.fields.get(10).setText("");
        this.fields.get(10).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(10), gbc);



        this.fields.set(9, new JButton());
        this.fields.get(9).setHorizontalTextPosition(0);
        this.fields.get(9).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/9.png")));
        this.fields.get(9).setIconTextGap(0);
        this.fields.get(9).setMaximumSize(new Dimension(134, 80));
        this.fields.get(9).setMinimumSize(new Dimension(134, 80));
        this.fields.get(9).setPreferredSize(new Dimension(134, 80));
        this.fields.get(9).setText("");
        this.fields.get(9).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(9), gbc);



        this.fields.set(8, new JButton());
        this.fields.get(8).setHorizontalTextPosition(0);
        this.fields.get(8).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/8.png")));
        this.fields.get(8).setIconTextGap(0);
        this.fields.get(8).setMaximumSize(new Dimension(134, 80));
        this.fields.get(8).setMinimumSize(new Dimension(134, 80));
        this.fields.get(8).setPreferredSize(new Dimension(134, 80));
        this.fields.get(8).setText("");
        this.fields.get(8).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(8), gbc);



        this.fields.set(7, new JButton());
        this.fields.get(7).setHorizontalTextPosition(0);
        this.fields.get(7).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/7.png")));
        this.fields.get(7).setIconTextGap(0);
        this.fields.get(7).setMaximumSize(new Dimension(134, 80));
        this.fields.get(7).setMinimumSize(new Dimension(134, 80));
        this.fields.get(7).setPreferredSize(new Dimension(134, 80));
        this.fields.get(7).setText("");
        this.fields.get(7).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(7), gbc);



        this.fields.set(6, new JButton());
        this.fields.get(6).setHorizontalTextPosition(0);
        this.fields.get(6).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/6.png")));
        this.fields.get(6).setIconTextGap(0);
        this.fields.get(6).setMaximumSize(new Dimension(134, 80));
        this.fields.get(6).setMinimumSize(new Dimension(134, 80));
        this.fields.get(6).setPreferredSize(new Dimension(134, 80));
        this.fields.get(6).setText("");
        this.fields.get(6).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(6), gbc);


        
        this.fields.set(5, new JButton());
        this.fields.get(5).setHorizontalTextPosition(0);
        this.fields.get(5).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/5.png")));
        this.fields.get(5).setIconTextGap(0);
        this.fields.get(5).setMaximumSize(new Dimension(134, 80));
        this.fields.get(5).setMinimumSize(new Dimension(134, 80));
        this.fields.get(5).setPreferredSize(new Dimension(134, 80));
        this.fields.get(5).setText("");
        this.fields.get(5).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(5), gbc);



        this.fields.set(4, new JButton());
        this.fields.get(4).setHorizontalTextPosition(0);
        this.fields.get(4).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/4.png")));
        this.fields.get(4).setIconTextGap(0);
        this.fields.get(4).setMaximumSize(new Dimension(134, 80));
        this.fields.get(4).setMinimumSize(new Dimension(134, 80));
        this.fields.get(4).setPreferredSize(new Dimension(134, 80));
        this.fields.get(4).setText("");
        this.fields.get(4).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(4), gbc);



        this.fields.set(3, new JButton());
        this.fields.get(3).setHorizontalTextPosition(0);
        this.fields.get(3).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/3.png")));
        this.fields.get(3).setIconTextGap(0);
        this.fields.get(3).setMaximumSize(new Dimension(134, 80));
        this.fields.get(3).setMinimumSize(new Dimension(134, 80));
        this.fields.get(3).setPreferredSize(new Dimension(134, 80));
        this.fields.get(3).setText("");
        this.fields.get(3).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(3), gbc);



        this.fields.set(2, new JButton());
        this.fields.get(2).setHorizontalTextPosition(0);
        this.fields.get(2).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/2.png")));
        this.fields.get(2).setIconTextGap(0);
        this.fields.get(2).setMaximumSize(new Dimension(134, 80));
        this.fields.get(2).setMinimumSize(new Dimension(134, 80));
        this.fields.get(2).setPreferredSize(new Dimension(134, 80));
        this.fields.get(2).setText("");
        this.fields.get(2).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(2), gbc);



        this.fields.set(36, new JButton());
        this.fields.get(36).setHorizontalTextPosition(0);
        this.fields.get(36).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/36.png")));
        this.fields.get(36).setIconTextGap(0);
        this.fields.get(36).setMaximumSize(new Dimension(80, 134));
        this.fields.get(36).setMinimumSize(new Dimension(80, 134));
        this.fields.get(36).setPreferredSize(new Dimension(80, 134));
        this.fields.get(36).setText("");
        this.fields.get(36).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(36), gbc);



        this.fields.set(37, new JButton());
        this.fields.get(37).setHorizontalTextPosition(0);
        this.fields.get(37).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/37.png")));
        this.fields.get(37).setIconTextGap(0);
        this.fields.get(37).setMaximumSize(new Dimension(80, 134));
        this.fields.get(37).setMinimumSize(new Dimension(80, 134));
        this.fields.get(37).setPreferredSize(new Dimension(80, 134));
        this.fields.get(37).setText("");
        this.fields.get(37).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(37), gbc);



        this.fields.set(38, new JButton());
        this.fields.get(38).setHorizontalTextPosition(0);
        this.fields.get(38).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/38.png")));
        this.fields.get(38).setIconTextGap(0);
        this.fields.get(38).setMaximumSize(new Dimension(80, 134));
        this.fields.get(38).setMinimumSize(new Dimension(80, 134));
        this.fields.get(38).setPreferredSize(new Dimension(80, 134));
        this.fields.get(38).setText("");
        this.fields.get(38).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(38), gbc);



        this.fields.set(39, new JButton());
        this.fields.get(39).setHorizontalTextPosition(0);
        this.fields.get(39).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/39.png")));
        this.fields.get(39).setIconTextGap(0);
        this.fields.get(39).setMaximumSize(new Dimension(80, 134));
        this.fields.get(39).setMinimumSize(new Dimension(80, 134));
        this.fields.get(39).setPreferredSize(new Dimension(80, 134));
        this.fields.get(39).setText("");
        this.fields.get(39).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(39), gbc);



        this.fields.set(40, new JButton());
        this.fields.get(40).setHorizontalTextPosition(0);
        this.fields.get(40).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/40.png")));
        this.fields.get(40).setIconTextGap(0);
        this.fields.get(40).setMaximumSize(new Dimension(80, 134));
        this.fields.get(40).setMinimumSize(new Dimension(80, 134));
        this.fields.get(40).setPreferredSize(new Dimension(80, 134));
        this.fields.get(40).setText("");
        this.fields.get(40).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(40), gbc);



        this.fields.set(35, new JButton());
        this.fields.get(35).setHorizontalTextPosition(0);
        this.fields.get(35).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/35.png")));
        this.fields.get(35).setIconTextGap(0);
        this.fields.get(35).setMaximumSize(new Dimension(80, 134));
        this.fields.get(35).setMinimumSize(new Dimension(80, 134));
        this.fields.get(35).setPreferredSize(new Dimension(80, 134));
        this.fields.get(35).setText("");
        this.fields.get(35).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(35), gbc);



        this.fields.set(22, new JButton());
        this.fields.get(22).setHorizontalTextPosition(0);
        this.fields.get(22).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/22.png")));
        this.fields.get(22).setIconTextGap(0);
        this.fields.get(22).setMaximumSize(new Dimension(134, 80));
        this.fields.get(22).setMinimumSize(new Dimension(134, 80));
        this.fields.get(22).setPreferredSize(new Dimension(134, 80));
        this.fields.get(22).setText("");
        this.fields.get(22).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(22), gbc);



        this.fields.set(21, new JButton());
        this.fields.get(21).setHorizontalTextPosition(0);
        this.fields.get(21).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/21.png")));
        this.fields.get(21).setIconTextGap(0);
        this.fields.get(21).setMaximumSize(new Dimension(134, 134));
        this.fields.get(21).setMinimumSize(new Dimension(134, 134));
        this.fields.get(21).setOpaque(false);
        this.fields.get(21).setPreferredSize(new Dimension(134, 134));
        this.fields.get(21).setText("");
        this.fields.get(21).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(21), gbc);



        this.fields.set(24, new JButton());
        this.fields.get(24).setHorizontalTextPosition(0);
        this.fields.get(24).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/24.png")));
        this.fields.get(24).setIconTextGap(0);
        this.fields.get(24).setMaximumSize(new Dimension(134, 80));
        this.fields.get(24).setMinimumSize(new Dimension(134, 80));
        this.fields.get(24).setPreferredSize(new Dimension(134, 80));
        this.fields.get(24).setText("");
        this.fields.get(24).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(24), gbc);


        this.fields.set(25, new JButton());
        this.fields.get(25).setHorizontalTextPosition(0);
        this.fields.get(25).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/25.png")));
        this.fields.get(25).setIconTextGap(0);
        this.fields.get(25).setMaximumSize(new Dimension(134, 80));
        this.fields.get(25).setMinimumSize(new Dimension(134, 80));
        this.fields.get(25).setPreferredSize(new Dimension(134, 80));
        this.fields.get(25).setText("");
        this.fields.get(25).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(25), gbc);



        this.fields.set(26, new JButton());
        this.fields.get(26).setHorizontalTextPosition(0);
        this.fields.get(26).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/26.png")));
        this.fields.get(26).setIconTextGap(0);
        this.fields.get(26).setMaximumSize(new Dimension(134, 80));
        this.fields.get(26).setMinimumSize(new Dimension(134, 80));
        this.fields.get(26).setPreferredSize(new Dimension(134, 80));
        this.fields.get(26).setText("");
        this.fields.get(26).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(26), gbc);



        this.fields.set(27, new JButton());
        this.fields.get(27).setHorizontalTextPosition(0);
        this.fields.get(27).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/27.png")));
        this.fields.get(27).setIconTextGap(0);
        this.fields.get(27).setMaximumSize(new Dimension(134, 80));
        this.fields.get(27).setMinimumSize(new Dimension(134, 80));
        this.fields.get(27).setPreferredSize(new Dimension(134, 80));
        this.fields.get(27).setText("");
        this.fields.get(27).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(27), gbc);



        this.fields.set(28, new JButton());
        this.fields.get(28).setHorizontalTextPosition(0);
        this.fields.get(28).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/28.png")));
        this.fields.get(28).setIconTextGap(0);
        this.fields.get(28).setMaximumSize(new Dimension(134, 80));
        this.fields.get(28).setMinimumSize(new Dimension(134, 80));
        this.fields.get(28).setPreferredSize(new Dimension(134, 80));
        this.fields.get(28).setText("");
        this.fields.get(28).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(28), gbc);



        this.fields.set(29, new JButton());
        this.fields.get(29).setHorizontalTextPosition(0);
        this.fields.get(29).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/29.png")));
        this.fields.get(29).setIconTextGap(0);
        this.fields.get(29).setMaximumSize(new Dimension(134, 80));
        this.fields.get(29).setMinimumSize(new Dimension(134, 80));
        this.fields.get(29).setPreferredSize(new Dimension(134, 80));
        this.fields.get(29).setText("");
        this.fields.get(29).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(29), gbc);



        this.fields.set(30, new JButton());
        this.fields.get(30).setHorizontalTextPosition(0);
        this.fields.get(30).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/30.png")));
        this.fields.get(30).setIconTextGap(0);
        this.fields.get(30).setMaximumSize(new Dimension(134, 80));
        this.fields.get(30).setMinimumSize(new Dimension(134, 80));
        this.fields.get(30).setPreferredSize(new Dimension(134, 80));
        this.fields.get(30).setText("");
        this.fields.get(30).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(30), gbc);



        this.fields.set(23, new JButton());
        this.fields.get(23).setHorizontalTextPosition(0);
        this.fields.get(23).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/23.png")));
        this.fields.get(23).setIconTextGap(0);
        this.fields.get(23).setMaximumSize(new Dimension(134, 80));
        this.fields.get(23).setMinimumSize(new Dimension(134, 80));
        this.fields.get(23).setPreferredSize(new Dimension(134, 80));
        this.fields.get(23).setText("");
        this.fields.get(23).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(23), gbc);



        this.fields.set(34, new JButton());
        this.fields.get(34).setHorizontalTextPosition(0);
        this.fields.get(34).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/34.png")));
        this.fields.get(34).setIconTextGap(0);
        this.fields.get(34).setMaximumSize(new Dimension(80, 134));
        this.fields.get(34).setMinimumSize(new Dimension(80, 134));
        this.fields.get(34).setPreferredSize(new Dimension(80, 134));
        this.fields.get(34).setText("");
        this.fields.get(34).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(34), gbc);



        this.fields.set(33, new JButton());
        this.fields.get(33).setHorizontalTextPosition(0);
        this.fields.get(33).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/33.png")));
        this.fields.get(33).setIconTextGap(0);
        this.fields.get(33).setMaximumSize(new Dimension(80, 134));
        this.fields.get(33).setMinimumSize(new Dimension(80, 134));
        this.fields.get(33).setPreferredSize(new Dimension(80, 134));
        this.fields.get(33).setText("");
        this.fields.get(33).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(33), gbc);


        
        this.fields.set(32, new JButton());
        this.fields.get(32).setHorizontalTextPosition(0);
        this.fields.get(32).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/32.png")));
        this.fields.get(32).setIconTextGap(0);
        this.fields.get(32).setMaximumSize(new Dimension(80, 134));
        this.fields.get(32).setMinimumSize(new Dimension(80, 134));
        this.fields.get(32).setPreferredSize(new Dimension(80, 134));
        this.fields.get(32).setText("");
        this.fields.get(32).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(32), gbc);



        this.fields.set(1, new JButton());
        this.fields.get(1).setHorizontalTextPosition(0);
        this.fields.get(1).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/1.png")));
        this.fields.get(1).setIconTextGap(0);
        this.fields.get(1).setMaximumSize(new Dimension(134, 134));
        this.fields.get(1).setMinimumSize(new Dimension(134, 134));
        this.fields.get(1).setOpaque(false);
        this.fields.get(1).setPreferredSize(new Dimension(134, 134));
        this.fields.get(1).setText("");
        this.fields.get(1).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(1), gbc);



        this.fields.set(31, new JButton());
        this.fields.get(31).setHorizontalTextPosition(0);
        this.fields.get(31).setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/31.png")));
        this.fields.get(31).setIconTextGap(0);
        this.fields.get(31).setMaximumSize(new Dimension(134, 134));
        this.fields.get(31).setMinimumSize(new Dimension(134, 134));
        this.fields.get(31).setOpaque(false);
        this.fields.get(31).setPreferredSize(new Dimension(134, 134));
        this.fields.get(31).setText("");
        this.fields.get(31).setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.fields.get(31), gbc);



        this.centralPart = new JLabel();
        this.centralPart.setIcon(new ImageIcon(getClass().getResource("/lang/" + settings.getLanguage() + "/img/" + settings.getResolutionSetting().getValue() + "/gameGraphics/fields/interior.png")));
        this.centralPart.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 9;
        gbc.gridheight = 9;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(this.centralPart, gbc);
    }


    /**
     * Returns array of fields representation.
     * 
     * @return the fields
     */
    public ArrayList<JButton> getFields() {
        return fields;
    }

    /**
     * Returns field representation with specified index.
     * 
     * @return the fields
     */
    public JButton getFields(int i) {
        if(i <= 0)
            return fields.get(i);
        else if( i >= fields.size())
            return fields.get(fields.size() - 1);
        else
            return fields.get(i);
    }
}
