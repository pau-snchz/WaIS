
package com.mycompany.userinterface;

import com.mycompany.modules.WasteSorterIdentifier;
import com.mycompany.modules.tables.Accounts;
import com.mycompany.modules.tables.WasteItems;
import java.util.List;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePage extends javax.swing.JFrame {
    private Accounts loggedAccount;

    public HomePage() {
        initComponents();
    }
    
    public HomePage(Accounts account) {
        initComponents();
        this.loggedAccount = account;
        addMouseListener();
        updateGreeting();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPane = new javax.swing.JLayeredPane();
        ContentSection = new wastemanagement.components.RoundedPanel();
        Logo = new javax.swing.JLabel();
        Prompt = new javax.swing.JLabel();
        Greeting = new javax.swing.JLabel();
        SearchBarShape = new wastemanagement.components.RoundedPanel();
        SearchBar = new javax.swing.JTextField();
        SearchIcon = new javax.swing.JLabel();
        EnterIcon = new javax.swing.JLabel();
        HomeTabShape = new wastemanagement.components.RoundedPanel();
        HomeLabel = new javax.swing.JLabel();
        HomeIcon = new javax.swing.JLabel();
        InfoTabShape = new wastemanagement.components.RoundedPanel();
        InfoTab = new javax.swing.JLabel();
        InfoLabel = new javax.swing.JLabel();
        InfoIcon = new javax.swing.JLabel();
        MapTabShape = new wastemanagement.components.RoundedPanel();
        MapTab = new javax.swing.JLabel();
        MapLabel = new javax.swing.JLabel();
        MapIcon = new javax.swing.JLabel();
        AccountTabShape = new wastemanagement.components.RoundedPanel();
        AccountTab = new javax.swing.JLabel();
        AccountLabel = new javax.swing.JLabel();
        AccountIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WaIS: HOMEPAGE");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1340, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1340, 800));

        BackgroundPane.setBackground(new java.awt.Color(85, 136, 59));
        BackgroundPane.setMaximumSize(new java.awt.Dimension(1340, 800));
        BackgroundPane.setMinimumSize(new java.awt.Dimension(1340, 800));
        BackgroundPane.setOpaque(true);

        ContentSection.setBackground(new java.awt.Color(230, 240, 220));
        ContentSection.setMinimumSize(new java.awt.Dimension(1340, 880));
        ContentSection.setRoundTopLeft(120);
        ContentSection.setRoundTopRight(120);
        ContentSection.setLayout(null);

        Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WaIS-Logo-01.png"))); // NOI18N
        Logo.setMaximumSize(new java.awt.Dimension(100, 100));
        Logo.setMinimumSize(new java.awt.Dimension(100, 100));
        Logo.setPreferredSize(new java.awt.Dimension(100, 100));
        ContentSection.add(Logo);
        Logo.setBounds(560, 30, 220, 200);

        Prompt.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        Prompt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Prompt.setText("What do you want to recycle today? ");
        ContentSection.add(Prompt);
        Prompt.setBounds(0, 330, 1360, 80);

        Greeting.setFont(new java.awt.Font("Nirmala UI", 1, 64)); // NOI18N
        Greeting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Greeting.setText("Hi, [User Name]!");
        ContentSection.add(Greeting);
        Greeting.setBounds(0, 240, 1360, 80);

        SearchBarShape.setBackground(new java.awt.Color(217, 217, 217));
        SearchBarShape.setRoundBottomLeft(80);
        SearchBarShape.setRoundBottomRight(80);
        SearchBarShape.setRoundTopLeft(80);
        SearchBarShape.setRoundTopRight(80);
        SearchBarShape.setLayout(null);

        SearchBar.setBackground(new java.awt.Color(217, 217, 217));
        SearchBar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SearchBar.setBorder(null);
        SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBarActionPerformed(evt);
            }
        });
        SearchBarShape.add(SearchBar);
        SearchBar.setBounds(100, 0, 684, 70);

        SearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Search.png"))); // NOI18N
        SearchBarShape.add(SearchIcon);
        SearchIcon.setBounds(20, 10, 50, 50);

        EnterIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Right Arrow.png"))); // NOI18N
        EnterIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EnterIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchItem(evt);
            }
        });
        SearchBarShape.add(EnterIcon);
        EnterIcon.setBounds(800, 0, 50, 70);

        ContentSection.add(SearchBarShape);
        SearchBarShape.setBounds(230, 420, 880, 70);

        BackgroundPane.setLayer(ContentSection, javax.swing.JLayeredPane.POPUP_LAYER);
        BackgroundPane.add(ContentSection);
        ContentSection.setBounds(0, 120, 1360, 720);

        HomeTabShape.setBackground(new java.awt.Color(230, 240, 220));
        HomeTabShape.setRoundTopLeft(60);
        HomeTabShape.setRoundTopRight(60);
        HomeTabShape.setLayout(null);

        HomeLabel.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        HomeLabel.setText("Home");
        HomeTabShape.add(HomeLabel);
        HomeLabel.setBounds(120, 20, 80, 40);

        HomeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home.png"))); // NOI18N
        HomeTabShape.add(HomeIcon);
        HomeIcon.setBounds(60, 20, 40, 40);

        BackgroundPane.setLayer(HomeTabShape, javax.swing.JLayeredPane.PALETTE_LAYER);
        BackgroundPane.add(HomeTabShape);
        HomeTabShape.setBounds(90, 30, 260, 100);

        InfoTabShape.setBackground(new java.awt.Color(193, 232, 153));
        InfoTabShape.setRoundTopLeft(60);
        InfoTabShape.setRoundTopRight(60);
        InfoTabShape.setLayout(null);
        InfoTabShape.add(InfoTab);
        InfoTab.setBounds(0, 0, 260, 70);

        InfoLabel.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        InfoLabel.setText("Info");
        InfoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InfoTabShape.add(InfoLabel);
        InfoLabel.setBounds(130, 20, 62, 40);

        InfoIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Info.png"))); // NOI18N
        InfoIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InfoTabShape.add(InfoIcon);
        InfoIcon.setBounds(70, 20, 40, 40);

        BackgroundPane.setLayer(InfoTabShape, javax.swing.JLayeredPane.PALETTE_LAYER);
        BackgroundPane.add(InfoTabShape);
        InfoTabShape.setBounds(400, 50, 260, 90);

        MapTabShape.setBackground(new java.awt.Color(193, 232, 153));
        MapTabShape.setRoundTopLeft(60);
        MapTabShape.setRoundTopRight(60);
        MapTabShape.setLayout(null);
        MapTabShape.add(MapTab);
        MapTab.setBounds(0, 0, 260, 70);

        MapLabel.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        MapLabel.setText("Map");
        MapTabShape.add(MapLabel);
        MapLabel.setBounds(130, 20, 60, 40);

        MapIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/location.png"))); // NOI18N
        MapTabShape.add(MapIcon);
        MapIcon.setBounds(70, 20, 40, 40);

        BackgroundPane.setLayer(MapTabShape, javax.swing.JLayeredPane.PALETTE_LAYER);
        BackgroundPane.add(MapTabShape);
        MapTabShape.setBounds(710, 50, 260, 90);

        AccountTabShape.setBackground(new java.awt.Color(193, 232, 153));
        AccountTabShape.setRoundTopLeft(60);
        AccountTabShape.setRoundTopRight(60);
        AccountTabShape.setLayout(null);
        AccountTabShape.add(AccountTab);
        AccountTab.setBounds(0, 0, 260, 70);

        AccountLabel.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        AccountLabel.setText("Account");
        AccountTabShape.add(AccountLabel);
        AccountLabel.setBounds(100, 20, 110, 40);

        AccountIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/person.png"))); // NOI18N
        AccountTabShape.add(AccountIcon);
        AccountIcon.setBounds(50, 20, 40, 40);

        BackgroundPane.setLayer(AccountTabShape, javax.swing.JLayeredPane.PALETTE_LAYER);
        BackgroundPane.add(AccountTabShape);
        AccountTabShape.setBounds(1020, 50, 260, 90);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1355, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPane, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBarActionPerformed

    private void searchItem(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchItem
        try {
            if (SearchBar.getText().trim().isEmpty())
            {
                return;
            }
            WasteItems foundItem = null;

            System.out.println("Search term: " + SearchBar.getText()); // Debugging

            List<WasteItems> result = WasteSorterIdentifier.searchItems(SearchBar.getText().toLowerCase().trim());
            System.out.println("Number of results: " + result.size()); // Debugging
            System.out.println(result);
            
            if (!result.isEmpty()) {
                foundItem = result.get(0);
                System.out.println(foundItem);
            } 

            TrashPage searchResult = new TrashPage(foundItem, loggedAccount);
            searchResult.setVisible(true);
            dispose();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchItem
    
    private void addMouseListener() {        
        InfoTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GeneralInformationPage genInfoPage = new GeneralInformationPage();
                genInfoPage.setVisible(true);
                dispose();
            }
        });

        MapTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MapPage mapPage = new MapPage();
                mapPage.setVisible(true);
                dispose();
            }
        });

        AccountTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AccountInformationPage accountPage = new AccountInformationPage(loggedAccount);
                accountPage.setLocationRelativeTo(null);
                accountPage.setVisible(true);
                dispose();
            }
        });
    }
    
    private void updateGreeting() 
    {
        Greeting.setText("Hi, " + loggedAccount.getFullName() + "!");
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountIcon;
    private javax.swing.JLabel AccountLabel;
    private javax.swing.JLabel AccountTab;
    private wastemanagement.components.RoundedPanel AccountTabShape;
    private javax.swing.JLayeredPane BackgroundPane;
    private wastemanagement.components.RoundedPanel ContentSection;
    private javax.swing.JLabel EnterIcon;
    private javax.swing.JLabel Greeting;
    private javax.swing.JLabel HomeIcon;
    private javax.swing.JLabel HomeLabel;
    private wastemanagement.components.RoundedPanel HomeTabShape;
    private javax.swing.JLabel InfoIcon;
    private javax.swing.JLabel InfoLabel;
    private javax.swing.JLabel InfoTab;
    private wastemanagement.components.RoundedPanel InfoTabShape;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel MapIcon;
    private javax.swing.JLabel MapLabel;
    private javax.swing.JLabel MapTab;
    private wastemanagement.components.RoundedPanel MapTabShape;
    private javax.swing.JLabel Prompt;
    private javax.swing.JTextField SearchBar;
    private wastemanagement.components.RoundedPanel SearchBarShape;
    private javax.swing.JLabel SearchIcon;
    // End of variables declaration//GEN-END:variables
}
