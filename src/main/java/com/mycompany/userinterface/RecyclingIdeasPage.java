
package com.mycompany.userinterface;

import com.mycompany.modules.WasteSorterIdentifier;
import com.mycompany.modules.tables.Accounts;
import com.mycompany.modules.tables.WasteItems;
import com.mycompany.modules.tables.RecyclingIdeas;
import com.mycompany.modules.tables.Steps;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RecyclingIdeasPage extends javax.swing.JFrame {

    private List<RecyclingIdeas> ideas;
    private WasteItems foundItem;
    private Accounts loggedAccount;
    private RecyclingIdeas selectedIdea;
    
    public RecyclingIdeasPage() {
        initComponents();
    }
    
    public RecyclingIdeasPage(List<RecyclingIdeas> ideasList, WasteItems selectedItem, Accounts user) {
        this.ideas = ideasList;
        this.foundItem = selectedItem;
        this.loggedAccount = user;
        
        initComponents();
        populateFields();
    }

    private void populateFields()
    {
        boolean flag1 = true;
        
        List<JPanel> rowCollection = new ArrayList<>();
        
        for(RecyclingIdeas idea : ideas)
        {
            if(flag1)
            {
                
                rowCollection.add(jPanel4);
                
                jLabel4.setText(WasteSorterIdentifier.getAuthor(idea.getAccID()));
                jLabel5.setText(Integer.toString(idea.getIdeaID()));
                jLabel6.setText(idea.getTitle());
                jLabel1.setIcon(new ImageIcon(getClass().getResource(idea.getImgURL())));
                flag1 = false;
                continue;
            }
            
            JPanel latestRow = rowCollection.get(rowCollection.size() - 1);
            JPanel newRow = cloneRowPanel(latestRow, idea);

            jPanel1.add(newRow);

            if (newRow.getY() + newRow.getHeight() > jPanel1.getHeight())
            {
                int newHeight = newRow.getY() + newRow.getHeight() + 50;
                jPanel1.setPreferredSize(new Dimension(jPanel1.getPreferredSize().width, newHeight));
            }
            
            jPanel1.revalidate();
            jPanel1.repaint();

            rowCollection.add(newRow);
            
        }
    }

    
    private void clearRows()
    {
        boolean flag = true;
        for (Component comp : jPanel1.getComponents())
        {
            if (flag)
            {
                flag = false;
                continue;
            }
            jPanel1.remove(comp);
        }


    }
    
    private JPanel cloneRowPanel(JPanel latestRow, RecyclingIdeas idea)
    {
        JPanel copy = new JPanel();
        copy.setLayout(latestRow.getLayout());
        copy.setBorder(latestRow.getBorder());
        copy.setBounds(latestRow.getX(), latestRow.getY() + 150, latestRow.getWidth(), latestRow.getHeight());
        copy.setBackground(latestRow.getBackground());
        for (Component comp : latestRow.getComponents())
        {
            if (comp instanceof JPanel)
            {
                JPanel originalPanel = (JPanel) comp;
                JPanel copyPanel = new JPanel();
                
                copyPanel.setBounds(200, 0, 240, 141);
                
                for (Component innerComp : originalPanel.getComponents())
                {
                    
                    if (innerComp instanceof JLabel)
                    {
                        JLabel originalLabel = (JLabel) innerComp;
                        JLabel copyInnerLabel = new JLabel();

                        copyInnerLabel.setText(originalLabel.getText());
                        copyInnerLabel.setBounds(0, 0, 240, 140);
                        copyInnerLabel.setIcon(new ImageIcon(getClass().getResource(idea.getImgURL())));
                        copyPanel.add(copyInnerLabel);
                    }
                    
                }
                copy.add(copyPanel);
            }
            else if (comp instanceof JLabel)
            {
                JLabel originalLabel = (JLabel) comp;
                JLabel copyLabel = new JLabel();
                
                if (originalLabel.getX() == 20)
                {
                    copyLabel.setText(Integer.toString(idea.getIdeaID()));
                    copyLabel.setBounds(20, 60, 140, 25);
                }
                else if (originalLabel.getX() == 0)
                {
                    copyLabel.setText(originalLabel.getText());
                    copyLabel.setBounds(0, 0, 1140, 140);
                    copyLabel.addMouseListener(new java.awt.event.MouseAdapter()
                    {
                        public void mouseClicked(java.awt.event.MouseEvent evt)
                        {
                            seeDetails(evt);
                        }
                    }
                );
                }
                else if (originalLabel.getX() == 620)
                {
                    copyLabel.setText(idea.getTitle());
                    copyLabel.setBounds(620, 60, 140, 25);
                }
                else if (originalLabel.getX() == 910)
                {
                    copyLabel.setText(WasteSorterIdentifier.getAuthor(idea.getAccID()));
                    copyLabel.setBounds(910, 60, 140, 25);
                }
                
                copyLabel.setCursor(originalLabel.getCursor());
                copyLabel.setFont(originalLabel.getFont());
                copyLabel.setForeground(originalLabel.getForeground());
                copyLabel.setHorizontalAlignment(originalLabel.getHorizontalAlignment());
                copy.add(copyLabel);
                
            }
        }
        return copy;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPane = new javax.swing.JLayeredPane();
        ContentSection = new wastemanagement.components.RoundedPanel();
        ContributeBtn = new wastemanagement.components.RoundedPanel();
        Greeting2 = new javax.swing.JLabel();
        HomeIcon2 = new javax.swing.JLabel();
        ContributeBtn1 = new wastemanagement.components.RoundedPanel();
        SearchBarShape = new wastemanagement.components.RoundedPanel();
        SearchIcon = new javax.swing.JLabel();
        EnterIcon = new javax.swing.JLabel();
        SearchBar = new javax.swing.JTextField();
        GoBackBtn = new wastemanagement.components.RoundedPanel();
        Greeting1 = new javax.swing.JLabel();
        HomeIcon1 = new javax.swing.JLabel();
        GoBackBtn1 = new wastemanagement.components.RoundedPanel();
        IdeasTableShape = new wastemanagement.components.RoundedPanel();
        ItemNoColLbl = new javax.swing.JLabel();
        ImageColLbl = new javax.swing.JLabel();
        ItemNameColLbl1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        row = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ItemNameColLbl2 = new javax.swing.JLabel();
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

        ContributeBtn.setBackground(new java.awt.Color(193, 232, 153));
        ContributeBtn.setRoundBottomLeft(60);
        ContributeBtn.setRoundBottomRight(60);
        ContributeBtn.setRoundTopLeft(60);
        ContributeBtn.setRoundTopRight(60);
        ContributeBtn.setLayout(null);

        Greeting2.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        Greeting2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Greeting2.setText("Contribute Recycling Idea");
        Greeting2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewIdea(evt);
            }
        });
        ContributeBtn.add(Greeting2);
        Greeting2.setBounds(30, 0, 280, 60);

        HomeIcon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ContributeBtn.add(HomeIcon2);
        HomeIcon2.setBounds(30, 0, 40, 60);

        ContentSection.add(ContributeBtn);
        ContributeBtn.setBounds(960, 30, 340, 60);

        ContributeBtn1.setBackground(new java.awt.Color(153, 153, 153));
        ContributeBtn1.setPreferredSize(new java.awt.Dimension(340, 65));
        ContributeBtn1.setRoundBottomLeft(60);
        ContributeBtn1.setRoundBottomRight(60);
        ContributeBtn1.setRoundTopLeft(60);
        ContributeBtn1.setRoundTopRight(60);
        ContributeBtn1.setLayout(null);
        ContentSection.add(ContributeBtn1);
        ContributeBtn1.setBounds(960, 30, 340, 65);

        SearchBarShape.setBackground(new java.awt.Color(217, 217, 217));
        SearchBarShape.setRoundBottomLeft(80);
        SearchBarShape.setRoundBottomRight(80);
        SearchBarShape.setRoundTopLeft(80);
        SearchBarShape.setRoundTopRight(80);
        SearchBarShape.setLayout(null);

        SearchIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Search-Small.png"))); // NOI18N
        SearchIcon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        SearchBarShape.add(SearchIcon);
        SearchIcon.setBounds(20, 10, 30, 30);

        EnterIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EnterIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Right Arrow-Small.png"))); // NOI18N
        EnterIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EnterIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchIdea(evt);
            }
        });
        SearchBarShape.add(EnterIcon);
        EnterIcon.setBounds(610, 10, 30, 30);

        SearchBar.setBackground(new java.awt.Color(217, 217, 217));
        SearchBar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SearchBar.setBorder(null);
        SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBarActionPerformed(evt);
            }
        });
        SearchBarShape.add(SearchBar);
        SearchBar.setBounds(60, 0, 540, 50);

        ContentSection.add(SearchBarShape);
        SearchBarShape.setBounds(250, 40, 660, 50);

        GoBackBtn.setRoundBottomLeft(30);
        GoBackBtn.setRoundBottomRight(30);
        GoBackBtn.setRoundTopLeft(30);
        GoBackBtn.setRoundTopRight(30);
        GoBackBtn.setLayout(null);

        Greeting1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Greeting1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Greeting1.setText("Go Back");
        Greeting1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Greeting1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnToTrashPage(evt);
            }
        });
        GoBackBtn.add(Greeting1);
        Greeting1.setBounds(40, 0, 70, 30);

        HomeIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/go back.png"))); // NOI18N
        HomeIcon1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GoBackBtn.add(HomeIcon1);
        HomeIcon1.setBounds(10, 0, 20, 30);

        ContentSection.add(GoBackBtn);
        GoBackBtn.setBounds(80, 50, 130, 30);

        GoBackBtn1.setBackground(new java.awt.Color(153, 153, 153));
        GoBackBtn1.setRoundBottomLeft(30);
        GoBackBtn1.setRoundBottomRight(30);
        GoBackBtn1.setRoundTopLeft(30);
        GoBackBtn1.setRoundTopRight(30);
        GoBackBtn1.setLayout(null);
        ContentSection.add(GoBackBtn1);
        GoBackBtn1.setBounds(80, 50, 130, 33);

        IdeasTableShape.setBackground(new java.awt.Color(193, 232, 153));
        IdeasTableShape.setRoundTopLeft(80);
        IdeasTableShape.setRoundTopRight(80);
        IdeasTableShape.setLayout(null);

        ItemNoColLbl.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ItemNoColLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemNoColLbl.setText("Idea No.");
        IdeasTableShape.add(ItemNoColLbl);
        ItemNoColLbl.setBounds(50, 0, 124, 30);

        ImageColLbl.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ImageColLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageColLbl.setText("Image");
        IdeasTableShape.add(ImageColLbl);
        ImageColLbl.setBounds(290, 0, 124, 30);

        ItemNameColLbl1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ItemNameColLbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemNameColLbl1.setText("Author");
        IdeasTableShape.add(ItemNameColLbl1);
        ItemNameColLbl1.setBounds(960, 0, 124, 30);

        jScrollPane1.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(159, 201, 102));
        jPanel1.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(183, 222, 137));
        jPanel4.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Author");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(910, 60, 140, 25);

        row.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        row.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seeDetails(evt);
            }
        });
        jPanel4.add(row);
        row.setBounds(0, 0, 1140, 140);

        jPanel5.setLayout(null);
        jPanel5.add(jLabel1);
        jLabel1.setBounds(0, 0, 240, 140);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(200, 0, 240, 141);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Idea No.");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(20, 60, 140, 25);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Idea Name");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(620, 60, 140, 25);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 0, 1140, 140);

        jScrollPane1.setViewportView(jPanel1);

        IdeasTableShape.add(jScrollPane1);
        jScrollPane1.setBounds(30, 30, 1150, 520);

        ItemNameColLbl2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ItemNameColLbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemNameColLbl2.setText("Idea Name");
        IdeasTableShape.add(ItemNameColLbl2);
        ItemNameColLbl2.setBounds(660, 0, 124, 30);

        ContentSection.add(IdeasTableShape);
        IdeasTableShape.setBounds(80, 130, 1210, 550);

        BackgroundPane.setLayer(ContentSection, javax.swing.JLayeredPane.POPUP_LAYER);
        BackgroundPane.add(ContentSection);
        ContentSection.setBounds(0, 120, 1340, 680);

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
        HomeTabShape.setBounds(70, 30, 260, 100);

        InfoTabShape.setBackground(new java.awt.Color(193, 232, 153));
        InfoTabShape.setRoundTopLeft(60);
        InfoTabShape.setRoundTopRight(60);
        InfoTabShape.setLayout(null);
        InfoTabShape.add(InfoTab);
        InfoTab.setBounds(0, 0, 260, 75);

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
        InfoTabShape.setBounds(380, 45, 260, 90);

        MapTabShape.setBackground(new java.awt.Color(193, 232, 153));
        MapTabShape.setRoundTopLeft(60);
        MapTabShape.setRoundTopRight(60);
        MapTabShape.setLayout(null);
        MapTabShape.add(MapTab);
        MapTab.setBounds(0, 0, 260, 75);

        MapLabel.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        MapLabel.setText("Map");
        MapTabShape.add(MapLabel);
        MapLabel.setBounds(130, 20, 60, 40);

        MapIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/location.png"))); // NOI18N
        MapTabShape.add(MapIcon);
        MapIcon.setBounds(70, 20, 40, 40);

        BackgroundPane.setLayer(MapTabShape, javax.swing.JLayeredPane.PALETTE_LAYER);
        BackgroundPane.add(MapTabShape);
        MapTabShape.setBounds(690, 45, 260, 90);

        AccountTabShape.setBackground(new java.awt.Color(193, 232, 153));
        AccountTabShape.setRoundTopLeft(60);
        AccountTabShape.setRoundTopRight(60);
        AccountTabShape.setLayout(null);
        AccountTabShape.add(AccountTab);
        AccountTab.setBounds(0, 0, 260, 75);

        AccountLabel.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        AccountLabel.setText("Account");
        AccountTabShape.add(AccountLabel);
        AccountLabel.setBounds(100, 20, 110, 40);

        AccountIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/person.png"))); // NOI18N
        AccountTabShape.add(AccountIcon);
        AccountIcon.setBounds(50, 20, 40, 40);

        BackgroundPane.setLayer(AccountTabShape, javax.swing.JLayeredPane.PALETTE_LAYER);
        BackgroundPane.add(AccountTabShape);
        AccountTabShape.setBounds(1000, 45, 260, 90);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackgroundPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackgroundPane, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBarActionPerformed

    private void returnToTrashPage(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnToTrashPage
        try {
            TrashPage goBack = new TrashPage(ideas, foundItem, loggedAccount);
            goBack.setLocationRelativeTo(null);
            goBack.setVisible(true);
            dispose(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_returnToTrashPage

    private void seeDetails(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seeDetails
        JLabel source = (JLabel) evt.getSource();
        JPanel parentPanel = (JPanel) source.getParent();
        JLabel ideaIDCol = null;
        for (Component comp : parentPanel.getComponents())
        {
            if(comp instanceof JLabel)
            {
                JLabel label = (JLabel) comp;
                if(label.getX() == 20 && label.getY() == 60)
                {
                    ideaIDCol = label;
                }
                
            }
        }
        
        int ideaID = Integer.parseInt(ideaIDCol.getText());
        for (RecyclingIdeas idea : ideas)
        {
            if(idea.getIdeaID() == ideaID)
            {
                selectedIdea = idea;
                break;
            }
        }
        
        IdeaDetailsPage seeDetails = new IdeaDetailsPage(ideas, selectedIdea, foundItem, loggedAccount, "RecyclingIdeasPage");
        seeDetails.setLocationRelativeTo(null);
        seeDetails.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_seeDetails

    private void searchIdea(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchIdea
        if (SearchBar.getText().trim().isEmpty())
        {
            populateFields();
            return;
        }

        List<RecyclingIdeas> result = WasteSorterIdentifier.getIdeas(foundItem.getID(), SearchBar.getText().toLowerCase().trim());
        
        if(result.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Idea with that name is non-existent.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
        clearRows();
        
        boolean flag1 = true;
        
        List<JPanel> rowCollection = new ArrayList<>();
        
        for(RecyclingIdeas idea : result)
        {
            if(flag1)
            {
                
                rowCollection.add(jPanel4);
                
                jLabel4.setText(WasteSorterIdentifier.getAuthor(idea.getAccID()));
                jLabel5.setText(Integer.toString(idea.getIdeaID()));
                jLabel6.setText(idea.getTitle());
                jLabel1.setIcon(new ImageIcon(getClass().getResource(idea.getImgURL())));
                flag1 = false;
                continue;
            }
            
            JPanel latestRow = rowCollection.get(rowCollection.size() - 1);
            JPanel newRow = cloneRowPanel(latestRow, idea);

            jPanel1.add(newRow);

            if (newRow.getY() + newRow.getHeight() > jPanel1.getHeight())
            {
                int newHeight = newRow.getY() + newRow.getHeight() + 50;
                jPanel1.setPreferredSize(new Dimension(jPanel1.getPreferredSize().width, newHeight));
            }
            
            jPanel1.revalidate();
            jPanel1.repaint();

            rowCollection.add(newRow);
            
        }
   
    }//GEN-LAST:event_searchIdea

    private void addNewIdea(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewIdea
        // TODO add your handling code here:
    }//GEN-LAST:event_addNewIdea

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecyclingIdeasPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecyclingIdeasPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecyclingIdeasPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecyclingIdeasPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecyclingIdeasPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountIcon;
    private javax.swing.JLabel AccountLabel;
    private javax.swing.JLabel AccountTab;
    private wastemanagement.components.RoundedPanel AccountTabShape;
    private javax.swing.JLayeredPane BackgroundPane;
    private wastemanagement.components.RoundedPanel ContentSection;
    private wastemanagement.components.RoundedPanel ContributeBtn;
    private wastemanagement.components.RoundedPanel ContributeBtn1;
    private javax.swing.JLabel EnterIcon;
    private wastemanagement.components.RoundedPanel GoBackBtn;
    private wastemanagement.components.RoundedPanel GoBackBtn1;
    private javax.swing.JLabel Greeting1;
    private javax.swing.JLabel Greeting2;
    private javax.swing.JLabel HomeIcon;
    private javax.swing.JLabel HomeIcon1;
    private javax.swing.JLabel HomeIcon2;
    private javax.swing.JLabel HomeLabel;
    private wastemanagement.components.RoundedPanel HomeTabShape;
    private wastemanagement.components.RoundedPanel IdeasTableShape;
    private javax.swing.JLabel ImageColLbl;
    private javax.swing.JLabel InfoIcon;
    private javax.swing.JLabel InfoLabel;
    private javax.swing.JLabel InfoTab;
    private wastemanagement.components.RoundedPanel InfoTabShape;
    private javax.swing.JLabel ItemNameColLbl1;
    private javax.swing.JLabel ItemNameColLbl2;
    private javax.swing.JLabel ItemNoColLbl;
    private javax.swing.JLabel MapIcon;
    private javax.swing.JLabel MapLabel;
    private javax.swing.JLabel MapTab;
    private wastemanagement.components.RoundedPanel MapTabShape;
    private javax.swing.JTextField SearchBar;
    private wastemanagement.components.RoundedPanel SearchBarShape;
    private javax.swing.JLabel SearchIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel row;
    // End of variables declaration//GEN-END:variables
}
