
package com.mycompany.userinterface;

import com.mycompany.components.CustomScrollbar.ScrollBarCustom;
import com.mycompany.modules.WasteSorterIdentifier;
import com.mycompany.modules.tables.Accounts;
import com.mycompany.modules.tables.Materials;
import com.mycompany.modules.tables.RecyclingIdeas;
import com.mycompany.modules.tables.Steps;
import com.mycompany.modules.tables.WasteItems;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import wastemanagement.components.RoundedPanel;

public class IdeaDetailsPage extends javax.swing.JFrame {

    private WasteItems foundItem = null;
    private Accounts loggedAccount = null;
    private RecyclingIdeas specificIdea = null;
    private String fromWhere = null;
    private List<RecyclingIdeas> ideas = null;
    
    public IdeaDetailsPage() {
        initComponents();
    }

    public IdeaDetailsPage(List<RecyclingIdeas> ideasList, RecyclingIdeas idea, WasteItems item, Accounts user, String origin) {
        this.specificIdea = idea;
        this.foundItem = item;
        this.loggedAccount = user;
        this.fromWhere = origin;
        this.ideas = ideasList;
        initComponents();
        populateFields();
        ScrollBarCustom newScrollBar1 = new ScrollBarCustom();
        newScrollBar1.setForeground(new Color(85, 136, 59));
        ScrollBarCustom newScrollBar2 = new ScrollBarCustom();
        newScrollBar2.setForeground(new Color(85, 136, 59));
        jScrollPane3.setVerticalScrollBar(newScrollBar1);
        jScrollPane1.setVerticalScrollBar(newScrollBar2);
    }
    
    private void populateFields()
    {
        List<Materials> requirements = WasteSorterIdentifier.getMaterials(specificIdea.getIdeaID());
        List<JPanel> itemPanelCollection = new ArrayList<>();
        List<Steps> procedures = WasteSorterIdentifier.getSteps(specificIdea.getIdeaID());
        List<JPanel> stepPanelCollection = new ArrayList<>();
        
        itemPanelCollection.add(jPanel3);
        stepPanelCollection.add(jPanel6);
        
        jTextField1.setText(specificIdea.getTitle());
        jLabel1.setIcon(new ImageIcon(getClass().getResource(specificIdea.getImgURL())));
        
        System.out.println(requirements);
        boolean flag1 = true;
        
        for(Materials requirement : requirements)
        {
            if(flag1)
            {
                jTextField7.setText(requirement.getName());
                jTextField6.setText(requirement.getQuantity());
                flag1 = false;
                continue;
            }
            
            JPanel latestLine = itemPanelCollection.get(itemPanelCollection.size() - 1);
            JPanel newLine = cloneItemPanel(latestLine, requirement);

            jPanel5.add(newLine);

            if (newLine.getY() + newLine.getHeight() > jPanel5.getHeight())
            {
                int newHeight = newLine.getY() + newLine.getHeight();
                jPanel5.setPreferredSize(new Dimension(jPanel5.getPreferredSize().width, newHeight));
            }

            jPanel5.revalidate();
            jPanel5.repaint();

            itemPanelCollection.add(newLine);
        }
        System.out.println("mark1");
        
        boolean flag2 = true;
        
        for(Steps procedure : procedures)
        {
            if(flag2)
            {
                System.out.println("mark2");
                Greeting15.setText("Step " + procedure.getOrder() + ":");
                jTextField4.setText(procedure.getStepTitle());
                jTextArea2.setText(procedure.getStepDesc());
                flag2 = false;
                continue;
            }
            
            System.out.println("mark3");
            JPanel latestStep = stepPanelCollection.get(stepPanelCollection.size() - 1);
            JPanel newStep = cloneStepPanel(latestStep, procedure);

            jPanel1.add(newStep);

            if (newStep.getY() + newStep.getHeight() > jPanel1.getHeight())
            {
                int newHeight = newStep.getY() + newStep.getHeight() + 50;
                jPanel1.setPreferredSize(new Dimension(jPanel1.getPreferredSize().width, newHeight));
            }
            
            jPanel1.revalidate();
            jPanel1.repaint();

            stepPanelCollection.add(newStep);
            
        }
        
    }    
    
    private JPanel cloneStepPanel(JPanel original, Steps procedure) {
        JPanel copy = new JPanel();
        copy.setLayout(original.getLayout());
        copy.setBorder(original.getBorder());
        copy.setBounds(original.getX(), original.getY() + 250, original.getWidth(), original.getHeight());
        copy.setBackground(original.getBackground());

        for (Component comp : original.getComponents()) {
            System.out.println("mark4");
            if (comp instanceof JLabel) 
            {

                JLabel originallabels = (JLabel) comp;
                JLabel copylabels = new JLabel();
                
                if (!originallabels.getText().equals("Details:"))
                {
                    copylabels.setText("Step " + procedure.getOrder() + ":");
                }
                else
                {
                    copylabels.setText("Details:"); 
                }
                
                
                copylabels.setFont(originallabels.getFont());
                copylabels.setForeground(originallabels.getForeground());
                copylabels.setHorizontalAlignment(originallabels.getHorizontalAlignment());
                copylabels.setBounds(originallabels.getX(), originallabels.getY(), originallabels.getWidth(), originallabels.getHeight());
                copy.add(copylabels);
            }
            else if(comp instanceof RoundedPanel)
            {
                RoundedPanel originalPanel = (RoundedPanel) comp;
                RoundedPanel copyPanel = new RoundedPanel();
                
                copyPanel.setLayout(original.getLayout());
                copyPanel.setRoundTopLeft(originalPanel.getRoundTopLeft());
                copyPanel.setRoundTopRight(originalPanel.getRoundTopRight());
                copyPanel.setRoundBottomLeft(originalPanel.getRoundBottomLeft());
                copyPanel.setRoundBottomRight(originalPanel.getRoundBottomRight());
                copyPanel.setBackground(originalPanel.getBackground());

                for (Component innerComp : originalPanel.getComponents()) {
                    if (innerComp instanceof JTextField)
                    {
                        JTextField originalField = (JTextField) innerComp;
                        JTextField copyField = new JTextField(procedure.getStepTitle(), originalField.getColumns()); // Set default text
                        
                        copyField.setEnabled(false);
                        copyField.setDisabledTextColor(originalField.getDisabledTextColor());
                        copyField.setFont(originalField.getFont());
                        copyField.setBackground(originalField.getBackground());
                        copyField.setForeground(originalField.getForeground());
                        copyField.setBounds(20, 0, 600 - 30, 40);
                        copyField.setBorder(originalField.getBorder());
                        copyField.setHorizontalAlignment(originalField.getHorizontalAlignment());
                        copyField.setCaretPosition(0);  // Set caret position to the beginning for default text
                        Dimension originalSize = originalField.getPreferredSize();
                        copyField.setPreferredSize(originalSize);
                        
                        copyPanel.add(copyField);
                    }
                    else if (innerComp instanceof JScrollPane) {
                        JScrollPane originalScrollPane = (JScrollPane) innerComp;
                        Component view = originalScrollPane.getViewport().getView();
                        
                        if (view instanceof JTextArea) {
                            JTextArea originalArea = (JTextArea) view;
                            JTextArea copyArea = new JTextArea(originalArea.getText(), originalArea.getRows(), originalArea.getColumns());
                            
                            copyArea.setEnabled(false);
                            copyArea.setDisabledTextColor(originalArea.getDisabledTextColor());
                            copyArea.setFont(originalArea.getFont());
                            copyArea.setBackground(originalArea.getBackground());
                            copyArea.setForeground(originalArea.getForeground());
                            copyArea.setBorder(originalArea.getBorder());
                            copyArea.setCaretPosition(0);
                            copyArea.setPreferredSize(originalArea.getPreferredSize());
                            copyArea.setLineWrap(true);
                            copyArea.setWrapStyleWord(true);

                            JScrollPane copyScrollPane = new JScrollPane(copyArea);
                            copyScrollPane.setBounds(originalScrollPane.getBounds());
                            copyScrollPane.setBorder(originalScrollPane.getBorder());
                            copyPanel.add(copyScrollPane);
                            System.out.println("Copied JTextArea inside JScrollPane");
                        }
                    }
                }

                copyPanel.setBounds(originalPanel.getX(), originalPanel.getY(), originalPanel.getWidth(), originalPanel.getHeight());
                copy.add(copyPanel);
            }

            
        }
        return copy;
    }
    
    private JPanel cloneItemPanel(JPanel original, Materials requirement) {
        JPanel copy = new JPanel();
        copy.setLayout(original.getLayout());
        copy.setBorder(original.getBorder());
        copy.setBounds(original.getX(), original.getY() + 50, original.getWidth(), original.getHeight());
        copy.setBackground(original.getBackground());

        System.out.println("Are you even running");
        
        
        for (Component comp : original.getComponents()) {
            if(comp instanceof RoundedPanel)
            {
                RoundedPanel originalPanel = (RoundedPanel) comp;
                RoundedPanel copyPanel = new RoundedPanel();
                copyPanel.setLayout(original.getLayout());
                copyPanel.setRoundTopLeft(originalPanel.getRoundTopLeft());
                copyPanel.setRoundTopRight(originalPanel.getRoundTopRight());
                copyPanel.setRoundBottomLeft(originalPanel.getRoundBottomLeft());
                copyPanel.setRoundBottomRight(originalPanel.getRoundBottomRight());
                copyPanel.setBackground(originalPanel.getBackground());

                for (Component innerComp : originalPanel.getComponents()) {
                    if (innerComp instanceof JTextField) {
                        JTextField originalField = (JTextField) innerComp;
                        JTextField copyField = new JTextField("", originalField.getColumns()); // Set default text
                        
                        if (originalField.getWidth() == 90 || originalField.getWidth() == 90 - 35)
                        {
                            copyField.setText(requirement.getQuantity());
                            copyField.setBounds(20, 0, 90 - 35, 40);
                        }
                        else if (originalField.getWidth() == 270 || originalField.getWidth() == 270 - 35)
                        {
                            copyField.setText(requirement.getName());
                            copyField.setBounds(20, 0, 270 - 35, 40);
                        }
                        
                        copyField.setEnabled(false);
                        copyField.setDisabledTextColor(originalField.getDisabledTextColor());
                        copyField.setFont(originalField.getFont());
                        copyField.setBackground(originalField.getBackground());
                        copyField.setForeground(originalField.getForeground());
                        
                        copyField.setBorder(originalField.getBorder());
                        copyField.setHorizontalAlignment(originalField.getHorizontalAlignment());
                        copyField.setCaretPosition(0);
                        Dimension originalSize = originalField.getPreferredSize();
                        copyField.setPreferredSize(originalSize);
                        copyPanel.add(copyField);
                    }
                }

                copyPanel.setBounds(originalPanel.getX(), originalPanel.getY(), originalPanel.getWidth(), originalPanel.getHeight());
                copy.add(copyPanel);
            }

            
        }
        return copy;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPane = new javax.swing.JLayeredPane();
        ContentSection = new wastemanagement.components.RoundedPanel();
        roundedPanel5 = new wastemanagement.components.RoundedPanel();
        Greeting4 = new javax.swing.JLabel();
        HomeIcon3 = new javax.swing.JLabel();
        roundedPanel7 = new wastemanagement.components.RoundedPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        Greeting2 = new javax.swing.JLabel();
        roundedPanel3 = new wastemanagement.components.RoundedPanel();
        jTextField1 = new javax.swing.JTextField();
        roundedPanel9 = new wastemanagement.components.RoundedPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        roundedPanel10 = new wastemanagement.components.RoundedPanel();
        Greeting7 = new javax.swing.JLabel();
        Greeting8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        roundedPanel17 = new wastemanagement.components.RoundedPanel();
        jTextField6 = new javax.swing.JTextField();
        roundedPanel18 = new wastemanagement.components.RoundedPanel();
        jTextField7 = new javax.swing.JTextField();
        Greeting6 = new javax.swing.JLabel();
        Greeting = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Greeting15 = new javax.swing.JLabel();
        Greeting16 = new javax.swing.JLabel();
        roundedPanel20 = new wastemanagement.components.RoundedPanel();
        jTextField4 = new javax.swing.JTextField();
        roundedPanel13 = new wastemanagement.components.RoundedPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
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
        setMaximumSize(new java.awt.Dimension(1340, 800));
        setMinimumSize(new java.awt.Dimension(1355, 840));
        setResizable(false);
        setSize(new java.awt.Dimension(1340, 800));

        BackgroundPane.setBackground(new java.awt.Color(85, 136, 59));
        BackgroundPane.setOpaque(true);

        ContentSection.setBackground(new java.awt.Color(230, 240, 220));
        ContentSection.setRoundTopLeft(60);
        ContentSection.setRoundTopRight(60);
        ContentSection.setLayout(null);

        roundedPanel5.setRoundBottomLeft(30);
        roundedPanel5.setRoundBottomRight(30);
        roundedPanel5.setRoundTopLeft(30);
        roundedPanel5.setRoundTopRight(30);
        roundedPanel5.setLayout(null);

        Greeting4.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Greeting4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Greeting4.setText("Go Back");
        Greeting4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roundedPanel5.add(Greeting4);
        Greeting4.setBounds(40, 0, 70, 30);

        HomeIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/go back.png"))); // NOI18N
        HomeIcon3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HomeIcon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goBack(evt);
            }
        });
        roundedPanel5.add(HomeIcon3);
        HomeIcon3.setBounds(10, 0, 20, 30);

        ContentSection.add(roundedPanel5);
        roundedPanel5.setBounds(30, 20, 130, 30);

        roundedPanel7.setBackground(new java.awt.Color(153, 153, 153));
        roundedPanel7.setRoundBottomLeft(30);
        roundedPanel7.setRoundBottomRight(30);
        roundedPanel7.setRoundTopLeft(30);
        roundedPanel7.setRoundTopRight(30);

        javax.swing.GroupLayout roundedPanel7Layout = new javax.swing.GroupLayout(roundedPanel7);
        roundedPanel7.setLayout(roundedPanel7Layout);
        roundedPanel7Layout.setHorizontalGroup(
            roundedPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        roundedPanel7Layout.setVerticalGroup(
            roundedPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        ContentSection.add(roundedPanel7);
        roundedPanel7.setBounds(30, 23, 130, 30);

        jScrollPane1.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(230, 240, 220));
        jPanel1.setLayout(null);

        Greeting2.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        Greeting2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Greeting2.setText("Other Materials:");
        Greeting2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Greeting2);
        Greeting2.setBounds(0, 60, 590, 40);

        roundedPanel3.setBackground(new java.awt.Color(245, 245, 245));
        roundedPanel3.setRoundBottomLeft(40);
        roundedPanel3.setRoundBottomRight(40);
        roundedPanel3.setRoundTopLeft(40);
        roundedPanel3.setRoundTopRight(40);
        roundedPanel3.setLayout(null);

        jTextField1.setBackground(new java.awt.Color(245, 245, 245));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setBorder(null);
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField1.setEnabled(false);
        roundedPanel3.add(jTextField1);
        jTextField1.setBounds(20, 0, 400, 40);

        jPanel1.add(roundedPanel3);
        roundedPanel3.setBounds(150, 0, 440, 40);

        roundedPanel9.setBackground(new java.awt.Color(183, 222, 137));
        roundedPanel9.setRoundBottomLeft(50);
        roundedPanel9.setRoundBottomRight(50);
        roundedPanel9.setRoundTopLeft(50);
        roundedPanel9.setRoundTopRight(50);
        roundedPanel9.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(217, 217, 217));
        jPanel4.setLayout(null);
        jPanel4.add(jLabel1);
        jLabel1.setBounds(0, 0, 550, 250);

        roundedPanel9.add(jPanel4);
        jPanel4.setBounds(20, 20, 550, 250);

        jPanel1.add(roundedPanel9);
        roundedPanel9.setBounds(650, 60, 590, 290);

        roundedPanel10.setBackground(new java.awt.Color(193, 232, 153));
        roundedPanel10.setRoundBottomLeft(50);
        roundedPanel10.setRoundBottomRight(50);
        roundedPanel10.setRoundTopLeft(50);
        roundedPanel10.setRoundTopRight(50);
        roundedPanel10.setLayout(null);

        Greeting7.setFont(new java.awt.Font("Nirmala UI", 3, 14)); // NOI18N
        Greeting7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Greeting7.setText("Q u a n t i t y");
        Greeting7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        roundedPanel10.add(Greeting7);
        Greeting7.setBounds(30, 10, 130, 20);

        Greeting8.setFont(new java.awt.Font("Nirmala UI", 3, 14)); // NOI18N
        Greeting8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Greeting8.setText("I t e m  N a m e");
        Greeting8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        roundedPanel10.add(Greeting8);
        Greeting8.setBounds(170, 10, 330, 20);

        jPanel2.setBackground(new java.awt.Color(183, 222, 137));
        jPanel2.setLayout(null);

        jScrollPane3.setBorder(null);

        jPanel5.setBackground(new java.awt.Color(183, 222, 137));
        jPanel5.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(183, 222, 137));
        jPanel3.setLayout(null);

        roundedPanel17.setBackground(new java.awt.Color(245, 245, 245));
        roundedPanel17.setRoundBottomLeft(40);
        roundedPanel17.setRoundBottomRight(40);
        roundedPanel17.setRoundTopLeft(40);
        roundedPanel17.setRoundTopRight(40);
        roundedPanel17.setLayout(null);

        jTextField6.setBackground(new java.awt.Color(245, 245, 245));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField6.setBorder(null);
        jTextField6.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField6.setEnabled(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        roundedPanel17.add(jTextField6);
        jTextField6.setBounds(20, 0, 90, 40);

        jPanel3.add(roundedPanel17);
        roundedPanel17.setBounds(10, 10, 130, 40);

        roundedPanel18.setBackground(new java.awt.Color(245, 245, 245));
        roundedPanel18.setRoundBottomLeft(40);
        roundedPanel18.setRoundBottomRight(40);
        roundedPanel18.setRoundTopLeft(40);
        roundedPanel18.setRoundTopRight(40);
        roundedPanel18.setLayout(null);

        jTextField7.setBackground(new java.awt.Color(245, 245, 245));
        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField7.setBorder(null);
        jTextField7.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField7.setEnabled(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        roundedPanel18.add(jTextField7);
        jTextField7.setBounds(20, 0, 270, 40);

        jPanel3.add(roundedPanel18);
        roundedPanel18.setBounds(150, 10, 310, 40);

        jPanel5.add(jPanel3);
        jPanel3.setBounds(0, 10, 490, 60);

        jScrollPane3.setViewportView(jPanel5);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(0, 0, 490, 200);

        roundedPanel10.add(jPanel2);
        jPanel2.setBounds(20, 30, 490, 200);

        jPanel1.add(roundedPanel10);
        roundedPanel10.setBounds(0, 100, 530, 250);

        Greeting6.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        Greeting6.setForeground(new java.awt.Color(85, 136, 59));
        Greeting6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Greeting6.setText("Idea Name:");
        jPanel1.add(Greeting6);
        Greeting6.setBounds(0, 0, 150, 40);

        Greeting.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        Greeting.setForeground(new java.awt.Color(85, 136, 59));
        Greeting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Greeting.setText("Step-by-Step Tutorial");
        jPanel1.add(Greeting);
        Greeting.setBounds(0, 360, 1250, 50);

        jPanel6.setBackground(new java.awt.Color(230, 240, 220));
        jPanel6.setLayout(null);

        Greeting15.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        Greeting15.setForeground(new java.awt.Color(85, 136, 59));
        Greeting15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Greeting15.setText("Step:");
        jPanel6.add(Greeting15);
        Greeting15.setBounds(6, 0, 87, 40);

        Greeting16.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        Greeting16.setForeground(new java.awt.Color(85, 136, 59));
        Greeting16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Greeting16.setText("Details:");
        jPanel6.add(Greeting16);
        Greeting16.setBounds(6, 50, 87, 40);

        roundedPanel20.setBackground(new java.awt.Color(245, 245, 245));
        roundedPanel20.setRoundBottomLeft(40);
        roundedPanel20.setRoundBottomRight(40);
        roundedPanel20.setRoundTopLeft(40);
        roundedPanel20.setRoundTopRight(40);
        roundedPanel20.setLayout(null);

        jTextField4.setBackground(new java.awt.Color(245, 245, 245));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(153, 153, 153));
        jTextField4.setBorder(null);
        jTextField4.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField4.setEnabled(false);
        roundedPanel20.add(jTextField4);
        jTextField4.setBounds(20, 0, 600, 40);

        jPanel6.add(roundedPanel20);
        roundedPanel20.setBounds(99, 0, 640, 40);

        roundedPanel13.setBackground(new java.awt.Color(245, 245, 245));
        roundedPanel13.setRoundBottomLeft(40);
        roundedPanel13.setRoundBottomRight(40);
        roundedPanel13.setRoundTopLeft(40);
        roundedPanel13.setRoundTopRight(40);
        roundedPanel13.setLayout(null);

        jScrollPane5.setBorder(null);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(null);
        jTextArea2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea2.setEnabled(false);
        jScrollPane5.setViewportView(jTextArea2);

        roundedPanel13.add(jScrollPane5);
        jScrollPane5.setBounds(10, 10, 1140, 140);

        jPanel6.add(roundedPanel13);
        roundedPanel13.setBounds(99, 50, 1161, 160);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(-10, 410, 1260, 220);

        jScrollPane1.setViewportView(jPanel1);

        ContentSection.add(jScrollPane1);
        jScrollPane1.setBounds(30, 60, 1290, 720);

        BackgroundPane.setLayer(ContentSection, javax.swing.JLayeredPane.POPUP_LAYER);
        BackgroundPane.add(ContentSection);
        ContentSection.setBounds(0, 112, 1350, 730);

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
            .addComponent(BackgroundPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1347, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPane, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void goBack(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack
        if (fromWhere.equals("TrashPage"))
        {
            try {
                TrashPage goBack = new TrashPage(ideas, foundItem, loggedAccount);
                goBack.setLocationRelativeTo(null);
                goBack.setVisible(true);
                dispose(); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else if (fromWhere.equals("RecyclingIdeasPage"))
        {
            RecyclingIdeasPage goBack = new RecyclingIdeasPage(ideas, foundItem, loggedAccount);
            goBack.setLocationRelativeTo(null);
            goBack.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_goBack

    
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
            java.util.logging.Logger.getLogger(IdeaDetailsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IdeaDetailsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IdeaDetailsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IdeaDetailsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IdeaDetailsPage().setVisible(true);
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
    private javax.swing.JLabel Greeting;
    private javax.swing.JLabel Greeting15;
    private javax.swing.JLabel Greeting16;
    private javax.swing.JLabel Greeting2;
    private javax.swing.JLabel Greeting4;
    private javax.swing.JLabel Greeting6;
    private javax.swing.JLabel Greeting7;
    private javax.swing.JLabel Greeting8;
    private javax.swing.JLabel HomeIcon;
    private javax.swing.JLabel HomeIcon3;
    private javax.swing.JLabel HomeLabel;
    private wastemanagement.components.RoundedPanel HomeTabShape;
    private javax.swing.JLabel InfoIcon;
    private javax.swing.JLabel InfoLabel;
    private javax.swing.JLabel InfoTab;
    private wastemanagement.components.RoundedPanel InfoTabShape;
    private javax.swing.JLabel MapIcon;
    private javax.swing.JLabel MapLabel;
    private javax.swing.JLabel MapTab;
    private wastemanagement.components.RoundedPanel MapTabShape;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private wastemanagement.components.RoundedPanel roundedPanel10;
    private wastemanagement.components.RoundedPanel roundedPanel13;
    private wastemanagement.components.RoundedPanel roundedPanel17;
    private wastemanagement.components.RoundedPanel roundedPanel18;
    private wastemanagement.components.RoundedPanel roundedPanel20;
    private wastemanagement.components.RoundedPanel roundedPanel3;
    private wastemanagement.components.RoundedPanel roundedPanel5;
    private wastemanagement.components.RoundedPanel roundedPanel7;
    private wastemanagement.components.RoundedPanel roundedPanel9;
    // End of variables declaration//GEN-END:variables
}
