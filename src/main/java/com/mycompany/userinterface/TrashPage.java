
package com.mycompany.userinterface;

import com.mycompany.components.CustomScrollbar.ScrollBarCustom;
import com.mycompany.modules.WasteSorterIdentifier;
import com.mycompany.modules.tables.Accounts;
import com.mycompany.modules.tables.RecyclingIdeas;
import com.mycompany.modules.tables.WasteItems;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

public class TrashPage extends javax.swing.JFrame {

    private WasteItems foundItem = null;
    private Accounts loggedAccount = null;
    private List<RecyclingIdeas> ideas = null;
    
    public TrashPage(WasteItems result, Accounts user) throws SQLException {
        
        this.foundItem = result;
        this.loggedAccount = user;
        
        initComponents();
        ContentPanel.setPreferredSize(new Dimension(ContentPanel.getWidth(), 1500));
        ScrollBarCustom newScrollBar = new ScrollBarCustom();
        newScrollBar.setForeground(new Color(85, 136, 59));
        Contents.setVerticalScrollBar(newScrollBar);
        Contents.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        showResults();
        
        Contents.revalidate();
        Contents.repaint();
    }
    
    public TrashPage(List<RecyclingIdeas> ideasList, WasteItems result, Accounts user) throws SQLException {
        
        this.foundItem = result;
        this.loggedAccount = user;
        this.ideas = ideasList;
        
        initComponents();
        ContentPanel.setPreferredSize(new Dimension(ContentPanel.getWidth(), 1500));
        ScrollBarCustom newScrollBar = new ScrollBarCustom();
        newScrollBar.setForeground(new Color(85, 136, 59));
        Contents.setVerticalScrollBar(newScrollBar);
        Contents.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        showResults();
        
        Contents.revalidate();
        Contents.repaint();
    }

    private TrashPage() throws SQLException {
        initComponents();
        
        ContentPanel.setPreferredSize(new Dimension(ContentPanel.getWidth(), 1500));
        ScrollBarCustom newScrollBar = new ScrollBarCustom();
        newScrollBar.setForeground(new Color(85, 136, 59));
        Contents.setVerticalScrollBar(newScrollBar);
        Contents.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        showResults();
        
        Contents.revalidate();
        Contents.repaint();
    }

    
    private void showResults() throws SQLException
    {
        if (this.foundItem == null)
        {
            showInvalid();
        }
        else
        {
            showValid();
        }
    }
    
    private void showValid() throws SQLException
    {
        if (this.foundItem.getCategory().equals("Recyclable"))
        {
            ideas  = WasteSorterIdentifier.getIdeas(this.foundItem.getID());
            
            ItemPicture.setIcon(new ImageIcon(getClass().getResource("/Not Sign.png")));
            jLabel1.setText(this.foundItem.getName() + " is recyclable." );
            jLabel6.setText(ideas.get(0).getTitle());
            RePic3.setIcon(new ImageIcon(getClass().getResource(ideas.get(0).getImgURL())));
            
            if(ideas.size() == 1)
            {
                ContentPanel.remove(RePic2);
                ContentPanel.remove(RecycleIdea2);
                ContentPanel.remove(RecycleIdea5);
                RePic3.setBounds(RePic3.getX() + 294, RePic3.getY(), RePic3.getWidth(), RePic3.getHeight());
                RecycleIdea6.setBounds(RecycleIdea6.getX() + 294, RecycleIdea6.getY(), RecycleIdea6.getWidth(), RecycleIdea6.getHeight());
                RecycleIdea3.setBounds(RecycleIdea3.getX() + 294, RecycleIdea3.getY(), RecycleIdea3.getWidth(), RecycleIdea3.getHeight());
            }
            else
            {
                jLabel10.setText(ideas.get(1).getTitle());
                RePic2.setIcon(new ImageIcon(getClass().getResource(ideas.get(0).getImgURL())));
            }
        }
        else
        {
            ItemPanel.setBackground(new Color(255, 150, 150));
            ItemPicture.setIcon(new ImageIcon(getClass().getResource("/Not Sign.png")));
            jLabel1.setText(this.foundItem.getName() + " is NOT recyclable as of the moment." );
            ContentPanel.remove(RecycleIdea1);
            ContentPanel.remove(RecycleIdea8);
            ContentPanel.remove(RecycleIdea3);
            ContentPanel.remove(RecycleIdea6);
            ContentPanel.remove(RecycleIdea4);
            ContentPanel.remove(RecycleIdea7);
            ContentPanel.remove(RecycleIdea5);
            ContentPanel.remove(RecycleIdea2);
            ContentPanel.remove(RePic3);
            ContentPanel.remove(RePic2);
            ContentPanel.remove(Title2);
            Title3.setBounds(Title3.getX(), Title3.getY()-632, Title3.getWidth(), Title3.getHeight());
            Title1.setBounds(Title1.getX(), Title1.getY()-632, Title1.getWidth(), Title1.getHeight());
            jScrollPane1.setBounds(jScrollPane1.getX(), jScrollPane1.getY()-632, jScrollPane1.getWidth(), jScrollPane1.getHeight());
            RePic1.setBounds(RePic1.getX(), RePic1.getY()-632, RePic1.getWidth(), RePic1.getHeight());
            ContentPanel.setPreferredSize(new Dimension(ContentPanel.getWidth(), 850));
        }
    }
    
    private void showInvalid()
    {
        ItemPanel.setBackground(new Color(200, 200, 200));
        ItemPicture.setIcon(new ImageIcon(getClass().getResource("/Not Found Sign.png")));
        jLabel1.setText("Sorry! We did not recognize any waste with that name.");
        ContentPanel.remove(Title1);
        ContentPanel.remove(RePic1);
        ContentPanel.remove(RePic2);
        ContentPanel.remove(RecycleIdea1);
        ContentPanel.remove(RecycleIdea8);
        ContentPanel.remove(RecycleIdea3);
        ContentPanel.remove(RecycleIdea6);
        ContentPanel.remove(RecycleIdea4);
        ContentPanel.remove(RecycleIdea7);
        ContentPanel.remove(Title2);
        ContentPanel.remove(Title3);
        ContentPanel.remove(RecycleIdea5);
        ContentPanel.remove(RecycleIdea2);
        ContentPanel.remove(RePic3);
        ContentPanel.remove(jScrollPane1);
        ContentPanel.setPreferredSize(new Dimension(ContentPanel.getWidth(), 400));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPane = new javax.swing.JLayeredPane();
        ContentSection = new wastemanagement.components.RoundedPanel();
        Logo = new javax.swing.JLabel();
        Contents = new javax.swing.JScrollPane();
        ContentPanel = new javax.swing.JPanel();
        ItemPanel = new wastemanagement.components.RoundedPanel();
        ItemPicture = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Title1 = new javax.swing.JLabel();
        RePic1 = new javax.swing.JLabel();
        RePic2 = new javax.swing.JLabel();
        RecycleIdea1 = new wastemanagement.components.RoundedPanel();
        jLabel2 = new javax.swing.JLabel();
        RecycleIdea8 = new wastemanagement.components.RoundedPanel();
        RecycleIdea3 = new wastemanagement.components.RoundedPanel();
        jLabel6 = new javax.swing.JLabel();
        RecycleIdea6 = new wastemanagement.components.RoundedPanel();
        RecycleIdea4 = new wastemanagement.components.RoundedPanel();
        jLabel8 = new javax.swing.JLabel();
        RecycleIdea7 = new wastemanagement.components.RoundedPanel();
        Title2 = new javax.swing.JLabel();
        Title3 = new javax.swing.JLabel();
        RecycleIdea5 = new wastemanagement.components.RoundedPanel();
        jLabel10 = new javax.swing.JLabel();
        RecycleIdea2 = new wastemanagement.components.RoundedPanel();
        RePic3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        GoBackBtn = new wastemanagement.components.RoundedPanel();
        Greeting1 = new javax.swing.JLabel();
        HomeIcon1 = new javax.swing.JLabel();
        GoBackBtn1 = new wastemanagement.components.RoundedPanel();
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
        setMaximumSize(new java.awt.Dimension(1355, 840));
        setMinimumSize(new java.awt.Dimension(1355, 840));
        setPreferredSize(new java.awt.Dimension(1355, 840));
        setResizable(false);
        setSize(new java.awt.Dimension(1340, 800));

        BackgroundPane.setBackground(new java.awt.Color(85, 136, 59));
        BackgroundPane.setAlignmentX(0.0F);
        BackgroundPane.setAlignmentY(0.0F);
        BackgroundPane.setMinimumSize(null);
        BackgroundPane.setOpaque(true);

        ContentSection.setBackground(new java.awt.Color(230, 240, 220));
        ContentSection.setAlignmentX(0.0F);
        ContentSection.setAlignmentY(0.0F);
        ContentSection.setMinimumSize(new java.awt.Dimension(1340, 800));
        ContentSection.setRoundTopLeft(120);
        ContentSection.setRoundTopRight(120);
        ContentSection.setLayout(null);

        Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ContentSection.add(Logo);
        Logo.setBounds(540, 30, 240, 80);

        Contents.setBackground(new java.awt.Color(230, 240, 220));
        Contents.setBorder(null);

        ContentPanel.setBackground(new java.awt.Color(230, 240, 220));
        ContentPanel.setLayout(null);

        ItemPanel.setBackground(new java.awt.Color(193, 232, 153));
        ItemPanel.setRoundBottomLeft(60);
        ItemPanel.setRoundBottomRight(60);
        ItemPanel.setRoundTopLeft(60);
        ItemPanel.setRoundTopRight(60);

        ItemPicture.setBackground(new java.awt.Color(255, 255, 255));
        ItemPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPicture.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("[garbage item] is [recyclable].");

        javax.swing.GroupLayout ItemPanelLayout = new javax.swing.GroupLayout(ItemPanel);
        ItemPanel.setLayout(ItemPanelLayout);
        ItemPanelLayout.setHorizontalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ItemPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
        );
        ItemPanelLayout.setVerticalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(ItemPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        ContentPanel.add(ItemPanel);
        ItemPanel.setBounds(220, 0, 845, 324);

        Title1.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        Title1.setForeground(new java.awt.Color(85, 136, 59));
        Title1.setText("Metro Manila Area");
        ContentPanel.add(Title1);
        Title1.setBounds(40, 1030, 639, 30);

        RePic1.setBackground(new java.awt.Color(255, 255, 255));
        RePic1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ContentPanel.add(RePic1);
        RePic1.setBounds(620, 1080, 520, 350);

        RePic2.setBackground(new java.awt.Color(255, 255, 255));
        RePic2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ContentPanel.add(RePic2);
        RePic2.setBounds(684, 414, 420, 300);

        RecycleIdea1.setBackground(new java.awt.Color(225, 225, 225));
        RecycleIdea1.setRoundBottomLeft(75);
        RecycleIdea1.setRoundBottomRight(75);
        RecycleIdea1.setRoundTopLeft(75);
        RecycleIdea1.setRoundTopRight(75);

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("See more ideas");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seeMoreIdeas(evt);
            }
        });

        javax.swing.GroupLayout RecycleIdea1Layout = new javax.swing.GroupLayout(RecycleIdea1);
        RecycleIdea1.setLayout(RecycleIdea1Layout);
        RecycleIdea1Layout.setHorizontalGroup(
            RecycleIdea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RecycleIdea1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        RecycleIdea1Layout.setVerticalGroup(
            RecycleIdea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecycleIdea1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        ContentPanel.add(RecycleIdea1);
        RecycleIdea1.setBounds(690, 870, 409, 61);

        RecycleIdea8.setBackground(new java.awt.Color(153, 153, 153));
        RecycleIdea8.setRoundBottomLeft(75);
        RecycleIdea8.setRoundBottomRight(75);
        RecycleIdea8.setRoundTopLeft(75);
        RecycleIdea8.setRoundTopRight(75);
        RecycleIdea8.setLayout(null);
        ContentPanel.add(RecycleIdea8);
        RecycleIdea8.setBounds(690, 875, 409, 61);

        RecycleIdea3.setBackground(new java.awt.Color(95, 195, 74));
        RecycleIdea3.setRoundBottomLeft(75);
        RecycleIdea3.setRoundBottomRight(75);
        RecycleIdea3.setRoundTopLeft(75);
        RecycleIdea3.setRoundTopRight(75);

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Recycle Idea #1");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showFirstRecord(evt);
            }
        });

        javax.swing.GroupLayout RecycleIdea3Layout = new javax.swing.GroupLayout(RecycleIdea3);
        RecycleIdea3.setLayout(RecycleIdea3Layout);
        RecycleIdea3Layout.setHorizontalGroup(
            RecycleIdea3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RecycleIdea3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        RecycleIdea3Layout.setVerticalGroup(
            RecycleIdea3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecycleIdea3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        ContentPanel.add(RecycleIdea3);
        RecycleIdea3.setBounds(150, 760, 409, 61);

        RecycleIdea6.setBackground(new java.awt.Color(153, 153, 153));
        RecycleIdea6.setRoundBottomLeft(75);
        RecycleIdea6.setRoundBottomRight(75);
        RecycleIdea6.setRoundTopLeft(75);
        RecycleIdea6.setRoundTopRight(75);
        RecycleIdea6.setLayout(null);
        ContentPanel.add(RecycleIdea6);
        RecycleIdea6.setBounds(150, 765, 409, 61);

        RecycleIdea4.setBackground(new java.awt.Color(193, 232, 153));
        RecycleIdea4.setRoundBottomLeft(75);
        RecycleIdea4.setRoundBottomRight(75);
        RecycleIdea4.setRoundTopLeft(75);
        RecycleIdea4.setRoundTopRight(75);

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Contribute an Idea");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewIdea(evt);
            }
        });

        javax.swing.GroupLayout RecycleIdea4Layout = new javax.swing.GroupLayout(RecycleIdea4);
        RecycleIdea4.setLayout(RecycleIdea4Layout);
        RecycleIdea4Layout.setHorizontalGroup(
            RecycleIdea4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RecycleIdea4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        RecycleIdea4Layout.setVerticalGroup(
            RecycleIdea4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecycleIdea4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        ContentPanel.add(RecycleIdea4);
        RecycleIdea4.setBounds(150, 870, 409, 61);

        RecycleIdea7.setBackground(new java.awt.Color(153, 153, 153));
        RecycleIdea7.setRoundBottomLeft(75);
        RecycleIdea7.setRoundBottomRight(75);
        RecycleIdea7.setRoundTopLeft(75);
        RecycleIdea7.setRoundTopRight(75);
        RecycleIdea7.setLayout(null);
        ContentPanel.add(RecycleIdea7);
        RecycleIdea7.setBounds(150, 875, 409, 61);

        Title2.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        Title2.setForeground(new java.awt.Color(85, 136, 59));
        Title2.setText("Suggested Recycling Methods:");
        ContentPanel.add(Title2);
        Title2.setBounds(44, 348, 639, 48);

        Title3.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        Title3.setForeground(new java.awt.Color(85, 136, 59));
        Title3.setText("RECYCLING CENTERS:");
        ContentPanel.add(Title3);
        Title3.setBounds(40, 980, 639, 48);

        RecycleIdea5.setBackground(new java.awt.Color(95, 195, 74));
        RecycleIdea5.setRoundBottomLeft(75);
        RecycleIdea5.setRoundBottomRight(75);
        RecycleIdea5.setRoundTopLeft(75);
        RecycleIdea5.setRoundTopRight(75);
        RecycleIdea5.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Recycle Idea #2");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showSecondRecord(evt);
            }
        });
        RecycleIdea5.add(jLabel10);
        jLabel10.setBounds(17, 6, 370, 49);

        ContentPanel.add(RecycleIdea5);
        RecycleIdea5.setBounds(690, 760, 409, 61);

        RecycleIdea2.setBackground(new java.awt.Color(153, 153, 153));
        RecycleIdea2.setRoundBottomLeft(75);
        RecycleIdea2.setRoundBottomRight(75);
        RecycleIdea2.setRoundTopLeft(75);
        RecycleIdea2.setRoundTopRight(75);
        RecycleIdea2.setLayout(null);
        ContentPanel.add(RecycleIdea2);
        RecycleIdea2.setBounds(690, 765, 409, 61);

        RePic3.setBackground(new java.awt.Color(255, 255, 255));
        RePic3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ContentPanel.add(RePic3);
        RePic3.setBounds(144, 414, 420, 300);

        jScrollPane1.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(230, 240, 220));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(230, 240, 220));
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("[Contact Information]");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 90, 510, 32);

        jLabel15.setBackground(new java.awt.Color(95, 195, 74));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(85, 136, 59));
        jLabel15.setText("[Recycling Center]");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(10, 10, 510, 32);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setText("[Address]");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(10, 50, 510, 32);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(-10, 10, 520, 130);

        jScrollPane1.setViewportView(jPanel1);

        ContentPanel.add(jScrollPane1);
        jScrollPane1.setBounds(40, 1080, 540, 350);

        Contents.setViewportView(ContentPanel);

        ContentSection.add(Contents);
        Contents.setBounds(30, 130, 1280, 540);

        GoBackBtn.setRoundBottomLeft(30);
        GoBackBtn.setRoundBottomRight(30);
        GoBackBtn.setRoundTopLeft(30);
        GoBackBtn.setRoundTopRight(30);
        GoBackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnToHomePage(evt);
            }
        });
        GoBackBtn.setLayout(null);

        Greeting1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Greeting1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Greeting1.setText("Go Back");
        Greeting1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        BackgroundPane.setLayer(ContentSection, javax.swing.JLayeredPane.POPUP_LAYER);
        BackgroundPane.add(ContentSection);
        ContentSection.setBounds(0, 120, 1340, 770);

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

        InfoTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        MapTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        AccountTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addComponent(BackgroundPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPane, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnToHomePage(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnToHomePage
        HomePage returnToHome = new HomePage(loggedAccount);
        returnToHome.setLocationRelativeTo(null);
        returnToHome.setVisible(true);
        dispose();
    }//GEN-LAST:event_returnToHomePage

    private void showFirstRecord(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showFirstRecord
        IdeaDetailsPage firstIdea = new IdeaDetailsPage(ideas, ideas.get(0), foundItem, loggedAccount, "TrashPage");
        firstIdea.setLocationRelativeTo(null);
        firstIdea.setVisible(true);
        dispose();
    }//GEN-LAST:event_showFirstRecord

    private void showSecondRecord(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showSecondRecord
        IdeaDetailsPage firstIdea = new IdeaDetailsPage(ideas, ideas.get(1), foundItem, loggedAccount, "TrashPage");
        firstIdea.setLocationRelativeTo(null);
        firstIdea.setVisible(true);
        dispose();
    }//GEN-LAST:event_showSecondRecord

    private void addNewIdea(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewIdea

    }//GEN-LAST:event_addNewIdea

    private void seeMoreIdeas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seeMoreIdeas
        RecyclingIdeasPage seeMore = new RecyclingIdeasPage(ideas, foundItem, loggedAccount);
        seeMore.setLocationRelativeTo(null);
        seeMore.setVisible(true);
        dispose();
    }//GEN-LAST:event_seeMoreIdeas

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
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TrashPage().setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountIcon;
    private javax.swing.JLabel AccountLabel;
    private javax.swing.JLabel AccountTab;
    private wastemanagement.components.RoundedPanel AccountTabShape;
    private javax.swing.JLayeredPane BackgroundPane;
    private javax.swing.JPanel ContentPanel;
    private wastemanagement.components.RoundedPanel ContentSection;
    private javax.swing.JScrollPane Contents;
    private wastemanagement.components.RoundedPanel GoBackBtn;
    private wastemanagement.components.RoundedPanel GoBackBtn1;
    private javax.swing.JLabel Greeting1;
    private javax.swing.JLabel HomeIcon;
    private javax.swing.JLabel HomeIcon1;
    private javax.swing.JLabel HomeLabel;
    private wastemanagement.components.RoundedPanel HomeTabShape;
    private javax.swing.JLabel InfoIcon;
    private javax.swing.JLabel InfoLabel;
    private javax.swing.JLabel InfoTab;
    private wastemanagement.components.RoundedPanel InfoTabShape;
    private wastemanagement.components.RoundedPanel ItemPanel;
    private javax.swing.JLabel ItemPicture;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel MapIcon;
    private javax.swing.JLabel MapLabel;
    private javax.swing.JLabel MapTab;
    private wastemanagement.components.RoundedPanel MapTabShape;
    private javax.swing.JLabel RePic1;
    private javax.swing.JLabel RePic2;
    private javax.swing.JLabel RePic3;
    private wastemanagement.components.RoundedPanel RecycleIdea1;
    private wastemanagement.components.RoundedPanel RecycleIdea2;
    private wastemanagement.components.RoundedPanel RecycleIdea3;
    private wastemanagement.components.RoundedPanel RecycleIdea4;
    private wastemanagement.components.RoundedPanel RecycleIdea5;
    private wastemanagement.components.RoundedPanel RecycleIdea6;
    private wastemanagement.components.RoundedPanel RecycleIdea7;
    private wastemanagement.components.RoundedPanel RecycleIdea8;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel Title2;
    private javax.swing.JLabel Title3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
