package Windows_FL_LAII;

import java.util.logging.Logger;

/**
 *
 * @author FL-AndruAnnohomy
 */
public class Results_Window_FL_LAII extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(Results_Window_FL_LAII.class.getName());
    private static final long serialVersionUID = 2012201552509954L;

    private static String results;

    /**
     *
     */
    public Results_Window_FL_LAII() {

        super("Resultados");
        initComponents();

    }

    /**
     *
     * @param text
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Results_Window_FL_LAII(String text) {

        super("Resultados");
        initComponents();
        clearResults();
        panelResults.setText(text);

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelResults = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelResults.setBackground(new java.awt.Color(0, 0, 0));
        panelResults.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        panelResults.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(panelResults);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane panelResults;
    // End of variables declaration//GEN-END:variables
}
