package Windows_FL_LAII;

import Archive_File.Option_File;
import Archive_File.Script_File;
import Codes_FL_LAII.Analyzer_FL_LAII;
import Codes_FL_LAII.Generation_Code.Generation_Code_FL_LAII;
import Codes_FL_LAII.Phase_LexicalAnalyzer.Lexical_Analyzer_FL_LAII;
import Codes_FL_LAII.Phase_SemanticAnalyzer.Semantic_Analyzer_FL_LAII;
import Codes_FL_LAII.Phase_SintacticAnalyzer.Sintactic_Analyzer_LAII;
import Source_File.Open_File;
import Source_File.Operation_File;
import Source_File.Save_File;
import Colours_Console.colour;
import Sources_Author.Author_Description;
import Windows_File.File_Chooser;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author FL-AndruAnnohomy
 */
public class Beginning_Window_FL_LAII extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(Beginning_Window_FL_LAII.class.getName());
    private static final long serialVersionUID = 2012201552509952L;

    private final NumberLine_FL_LAII object1;
    private final File_Chooser object2;
    private final Option_File object3;
    private Analyzer_FL_LAII object;

    private static String nameFile = "";
    private static String results;

    /**
     *
     */
    @SuppressWarnings({"static-access", "OverridableMethodCallInConstructor"})
    public Beginning_Window_FL_LAII() {

        initComponents();

        this.setIconImage(new ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (2).png")).getImage());
        this.object1 = new NumberLine_FL_LAII(this.panelEdition);
        this.object2 = new File_Chooser();
        this.object3 = new Option_File();
        this.object = null;
        this.object3.setPath("default", "fl");
        this.nameFile = object3.getPath("default", "fl");
        this.jScrollPane1.setRowHeaderView(object1);
        this.setTitle("Compilador FL ... " + nameFile);
        jsyntaxpane.DefaultSyntaxKit.initKit();

        LOG.info("Final de la Construccion del JFrame");

        this.resultsEdition.setContentType("text/html");
        setResults("<font color=\"white\">Resultados: </font><br>");
        this.resultsEdition.setText(getResults());

        this.panelEdition.setContentType("text/java");

        Operation_File operation = new Open_File(nameFile.replace("Files", "src\\Others_FL_LAII"));
        this.panelEdition.setText(operation.toString());

    }

    /**
     *
     * @param text
     */
    public Beginning_Window_FL_LAII(String text) {

        this.object1 = null;
        this.object2 = null;
        this.object3 = null;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        new2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        open2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        save2 = new javax.swing.JButton();
        saveas2 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        copy2 = new javax.swing.JButton();
        paste2 = new javax.swing.JButton();
        cut2 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        undo = new javax.swing.JButton();
        redo = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        search = new javax.swing.JButton();
        replace = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        compiler = new javax.swing.JButton();
        run = new javax.swing.JButton();
        tokens = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultsEdition = new javax.swing.JEditorPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelEdition = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu13 = new javax.swing.JMenu();
        new1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        open1 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        save1 = new javax.swing.JMenuItem();
        saveas1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exit = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        copy1 = new javax.swing.JMenuItem();
        paste1 = new javax.swing.JMenuItem();
        cut1 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        author = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        new2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (19).png"))); // NOI18N
        new2.setToolTipText("Nuevo");
        new2.setFocusable(false);
        new2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        new2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        new2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                New(evt);
            }
        });
        jToolBar1.add(new2);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (24).png"))); // NOI18N
        jButton2.setToolTipText("Nuevo Proyecto");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrir(evt);
            }
        });
        jToolBar1.add(jButton2);

        open2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (26).png"))); // NOI18N
        open2.setToolTipText("Abrir");
        open2.setFocusable(false);
        open2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        open2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        open2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Open(evt);
            }
        });
        jToolBar1.add(open2);
        jToolBar1.add(jSeparator1);

        save2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (27).png"))); // NOI18N
        save2.setToolTipText("Guardar");
        save2.setFocusable(false);
        save2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        save2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save(evt);
            }
        });
        jToolBar1.add(save2);

        saveas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (28).png"))); // NOI18N
        saveas2.setToolTipText("Guardar Como");
        saveas2.setFocusable(false);
        saveas2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveas2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAs(evt);
            }
        });
        jToolBar1.add(saveas2);
        jToolBar1.add(jSeparator4);

        copy2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (16).png"))); // NOI18N
        copy2.setToolTipText("Copiar");
        copy2.setFocusable(false);
        copy2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copy2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        copy2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Copy(evt);
            }
        });
        jToolBar1.add(copy2);

        paste2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (17).png"))); // NOI18N
        paste2.setToolTipText("Pegar");
        paste2.setFocusable(false);
        paste2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paste2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        paste2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Paste(evt);
            }
        });
        jToolBar1.add(paste2);

        cut2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (42).png"))); // NOI18N
        cut2.setToolTipText("Cortar");
        cut2.setFocusable(false);
        cut2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cut2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cut(evt);
            }
        });
        jToolBar1.add(cut2);
        jToolBar1.add(jSeparator5);

        undo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (44).png"))); // NOI18N
        undo.setToolTipText("Deshacer");
        undo.setFocusable(false);
        undo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        undo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoCut(evt);
            }
        });
        jToolBar1.add(undo);

        redo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (43).png"))); // NOI18N
        redo.setToolTipText("Rehacer");
        redo.setFocusable(false);
        redo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        redo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoCut(evt);
            }
        });
        jToolBar1.add(redo);
        jToolBar1.add(jSeparator6);

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (39).png"))); // NOI18N
        search.setToolTipText("Buscar");
        search.setFocusable(false);
        search.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        search.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCut(evt);
            }
        });
        jToolBar1.add(search);

        replace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (40).png"))); // NOI18N
        replace.setToolTipText("Remplazar");
        replace.setFocusable(false);
        replace.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        replace.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        replace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceCut(evt);
            }
        });
        jToolBar1.add(replace);
        jToolBar1.add(jSeparator7);

        compiler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (32).png"))); // NOI18N
        compiler.setToolTipText("Compilar");
        compiler.setFocusable(false);
        compiler.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        compiler.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        compiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compilerActionPerformed(evt);
            }
        });
        jToolBar1.add(compiler);

        run.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (36).png"))); // NOI18N
        run.setToolTipText("Ejecutar");
        run.setFocusable(false);
        run.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        run.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                run(evt);
            }
        });
        jToolBar1.add(run);

        tokens.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tokens.setText("Tokens");
        tokens.setFocusable(false);
        tokens.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tokens.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tokensActionPerformed(evt);
            }
        });
        jToolBar1.add(tokens);

        jScrollPane3.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        resultsEdition.setBackground(new java.awt.Color(0, 0, 0));
        resultsEdition.setBorder(null);
        resultsEdition.setForeground(new java.awt.Color(255, 255, 255));
        resultsEdition.setCaretColor(new java.awt.Color(255, 255, 255));
        resultsEdition.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(resultsEdition);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelEdition.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(panelEdition);

        jMenu13.setText("Archivo");
        jMenu13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        new1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        new1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        new1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (19).png"))); // NOI18N
        new1.setText("Nuevo");
        new1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                New(evt);
            }
        });
        jMenu13.add(new1);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (24).png"))); // NOI18N
        jMenuItem6.setText("Nuevo Proyecto");
        jMenu13.add(jMenuItem6);

        open1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        open1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        open1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (26).png"))); // NOI18N
        open1.setText("Abrir");
        open1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Open(evt);
            }
        });
        jMenu13.add(open1);
        jMenu13.add(jSeparator3);

        save1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        save1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        save1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (27).png"))); // NOI18N
        save1.setText("Guardar");
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save(evt);
            }
        });
        jMenu13.add(save1);

        saveas1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveas1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saveas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (28).png"))); // NOI18N
        saveas1.setText("Guardar Como ...");
        saveas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAs(evt);
            }
        });
        jMenu13.add(saveas1);
        jMenu13.add(jSeparator2);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (13).png"))); // NOI18N
        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit(evt);
            }
        });
        jMenu13.add(exit);

        jMenuBar1.add(jMenu13);

        jMenu14.setText("Edicición");
        jMenu14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        copy1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copy1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        copy1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (16).png"))); // NOI18N
        copy1.setText("Copiar");
        copy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Copy(evt);
            }
        });
        jMenu14.add(copy1);

        paste1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        paste1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        paste1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (17).png"))); // NOI18N
        paste1.setText("Pegar");
        paste1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Paste(evt);
            }
        });
        jMenu14.add(paste1);

        cut1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cut1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (42).png"))); // NOI18N
        cut1.setText("Cortar");
        cut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cut(evt);
            }
        });
        jMenu14.add(cut1);

        jMenuBar1.add(jMenu14);

        jMenu15.setText("Ayuda");
        jMenu15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (33).png"))); // NOI18N
        jMenuItem1.setText("Ayuda");
        jMenu15.add(jMenuItem1);

        author.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        author.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        author.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (38).png"))); // NOI18N
        author.setText("Autor");
        author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorActionPerformed(evt);
            }
        });
        jMenu15.add(author);

        jMenuBar1.add(jMenu15);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void run(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_run

        this.object = new Generation_Code_FL_LAII("suma");
        boolean x = this.object.sintacticAnalyzer(object.getText(panelEdition.getText()));
        object.Run();

    }//GEN-LAST:event_run

    private void abrir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrir

    }//GEN-LAST:event_abrir

    private void Copy(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Copy

        panelEdition.copy();

    }//GEN-LAST:event_Copy

    private void Paste(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Paste

        panelEdition.paste();

    }//GEN-LAST:event_Paste

    private void Cut(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cut

        panelEdition.cut();

    }//GEN-LAST:event_Cut

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        programExit();

    }//GEN-LAST:event_formWindowClosing

    private void Open(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Open

        if (object2.chooserOpen()) {

            Operation_File operation = new Open_File(object2.getPathFile());
            this.panelEdition.setText(operation.toString());
            nameFile = object2.getPathFile();
            this.setTitle("Compilador FL ... " + object2.getPathFile());

        }

    }//GEN-LAST:event_Open

    private void Exit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit

        programExit();

    }//GEN-LAST:event_Exit

    private void New(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_New

        clearResults();
        setResults("<font color=\"white\">Resultados: </font><br>");
        resultsEdition.setText(getResults());

        object3.setPath("default", "fl");
        nameFile = object3.getPath("default", "fl");
        this.setTitle("Compilador FL ... " + nameFile);
        Operation_File operation = new Open_File(nameFile.replace("Files", "src\\Others_FL_LAII"));
        this.panelEdition.setText(operation.toString());

    }//GEN-LAST:event_New

    private void Save(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save

        if (this.getTitle().indexOf("default.fl") == -1) {

            @SuppressWarnings("LocalVariableHidesMemberVariable")
            Script_File object = new Script_File();
            object.scriptFile(nameFile, panelEdition.getText());

        } else {

            if (object2.chooserSave()) {

                Operation_File operation = new Save_File(object2.getPathFile() + ".fl", panelEdition.getText());
                nameFile = object2.getPathFile() + ".fl";
                this.setTitle("Compilador FL ... " + object2.getPathFile());

            }

        }

    }//GEN-LAST:event_Save

    private void SaveAs(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveAs

        if (object2.chooserSave()) {

            Operation_File operation = new Save_File(object2.getPathFile() + ".fl", panelEdition.getText());
            nameFile = object2.getPathFile() + ".fl";
            this.setTitle("Compilador FL ... " + object2.getPathFile());

        }

    }//GEN-LAST:event_SaveAs

    private void authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorActionPerformed

        System.out.println(Author_Description.getAuthor_Description(colour._RED));

    }//GEN-LAST:event_authorActionPerformed

    private void compilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compilerActionPerformed

        clearResults();
        setResults("<font color=\"white\">Resultados: </font><br>");

        if (!panelEdition.getText().equals("")) {

            this.object = new Lexical_Analyzer_FL_LAII();
            System.out.println(object.getText(panelEdition.getText()));

            if (object.lexicalAnalyzer(object.getText(panelEdition.getText()))) {

                this.object = new Sintactic_Analyzer_LAII();
                System.out.println(object.getText(panelEdition.getText()));

                if (this.object.sintacticAnalyzer(object.getText(panelEdition.getText()))) {

                    this.object = new Semantic_Analyzer_FL_LAII();
                    this.object.semanticAnalyzer(object.getText(panelEdition.getText()));
                    System.out.println(object.getText(panelEdition.getText()));

                }

            }

            resultsEdition.setText(getResults());

        } else {

            JOptionPane.showMessageDialog(null, "Necesitas abrir un archivo nuevo o crea un programa desde cero.", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_compilerActionPerformed

    private void tokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tokensActionPerformed

        new Results_Window_FL_LAII(Lexical_Analyzer_FL_LAII.getAnalyzerLexico() + "\n" + Sintactic_Analyzer_LAII.getSintacticLexico()).setVisible(true);

    }//GEN-LAST:event_tokensActionPerformed

    private void redoCut(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoCut

        jsyntaxpane.actions.ActionUtils.sendKeyPress(panelEdition, KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK);

    }//GEN-LAST:event_redoCut

    private void undoCut(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoCut

        jsyntaxpane.actions.ActionUtils.sendKeyPress(panelEdition, KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);

    }//GEN-LAST:event_undoCut

    private void searchCut(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCut

        jsyntaxpane.actions.ActionUtils.sendKeyPress(panelEdition, KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);

    }//GEN-LAST:event_searchCut

    private void replaceCut(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replaceCut

        jsyntaxpane.actions.ActionUtils.sendKeyPress(panelEdition, KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK);

    }//GEN-LAST:event_replaceCut

    @SuppressWarnings({"BroadCatchBlock", "TooBroadCatch"})
    private void programExit() {

        try {

            if (JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION) == 0) {

                LOG.info("Final de la Ejecucion del Programa");
                System.exit(0);

            }

        } catch (Throwable ex) {

            Logger.getLogger(Beginning_Window_FL_LAII.class.getName()).log(Level.SEVERE, "Error de Confirmacion para Salir del Programa");

        }

    }

    /**
     *
     * @param title
     */
    public void setTitleBeginning_Window(String title) {

        this.setTitle(title);

    }

    /**
     *
     * @param results
     */
    @SuppressWarnings("static-access")
    public void setResults(String results) {

        this.results += results;

    }

    /**
     *
     * @return
     */
    public String getResults() {

        return results;

    }

    /**
     *
     */
    @SuppressWarnings("static-access")
    public void clearResults() {

        this.results = "";

    }

    @Override
    public String toString() {

        return "Created by FL- AndruAnnohomy smart pataforma: Beginning_Window_FL_LAII{" + '}';

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem author;
    private javax.swing.JButton compiler;
    private javax.swing.JMenuItem copy1;
    private javax.swing.JButton copy2;
    private javax.swing.JMenuItem cut1;
    private javax.swing.JButton cut2;
    private javax.swing.JMenuItem exit;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem new1;
    private javax.swing.JButton new2;
    private javax.swing.JMenuItem open1;
    private javax.swing.JButton open2;
    private javax.swing.JEditorPane panelEdition;
    private javax.swing.JMenuItem paste1;
    private javax.swing.JButton paste2;
    private javax.swing.JButton redo;
    private javax.swing.JButton replace;
    private javax.swing.JEditorPane resultsEdition;
    private javax.swing.JButton run;
    private javax.swing.JMenuItem save1;
    private javax.swing.JButton save2;
    private javax.swing.JMenuItem saveas1;
    private javax.swing.JButton saveas2;
    private javax.swing.JButton search;
    private javax.swing.JButton tokens;
    private javax.swing.JButton undo;
    // End of variables declaration//GEN-END:variables

}
