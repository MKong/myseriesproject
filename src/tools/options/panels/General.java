/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * general.java
 *
 * Created on 19 Μαϊ 2011, 6:56:14 μμ
 */

package tools.options.panels;

import com.googlecode.svalidators.validators.FileValidator;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import tools.MySeriesLogger;
import tools.options.DateFormatHelp;
import tools.options.Options;

/**
 *
 * @author lordovol
 */
public class General extends javax.swing.JPanel {

    /** Creates new form general */
    public General() {
        initComponents();
         tf_videoApp.addValidator(new FileValidator("", FileValidator.Type.FILE, true));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel3 = new javax.swing.JLabel();
    combobox_debugMode = new javax.swing.JComboBox();
    jLabel4 = new javax.swing.JLabel();
    combobox_dateFormat = new javax.swing.JComboBox();
    jLabel11 = new javax.swing.JLabel();
    tf_videoApp = new com.googlecode.svalidators.formcomponents.STextField();
    jLabel14 = new javax.swing.JLabel();
    bt_videoViewer = new myComponents.myGUI.buttons.MyButtonDir();
    jLabel7 = new javax.swing.JLabel();
    tf_mainDir = new com.googlecode.svalidators.formcomponents.STextField(new FileValidator("",FileValidator.Type.DIR ,true));
    bt_mainDirectory = new myComponents.myGUI.buttons.MyButtonDir();
    jLabel22 = new javax.swing.JLabel();
    bt_dfhelp = new myComponents.myGUI.buttons.MyButtonHelp();
    cb_showPopups = new javax.swing.JCheckBox();

    setName("General"); // NOI18N

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel3.setText("Logging level :");
    jLabel3.setToolTipText("<html>\nThe level of Debuging info that's written in the log file<br />\nFATAL : Only fatal errors are written<br />\nWARNING : Warnings and fatal errors are written<br />\nINFO : Everything is written<br />\nNO LOGGING: Nothing is written<br />");
    jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    jLabel3.setName("noname"); // NOI18N

    combobox_debugMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OFF", "SEVERE", "WARNING", "ALL" }));
    combobox_debugMode.setSelectedItem(Options.toString(Options.DEBUG_MODE));
    combobox_debugMode.setToolTipText("<html>\nThe level of Debuging info that's written in the log file<br />\nSEVERE : Only fatal errors are written<br />\nWARNING : Warnings and fatal errors are written<br />\nALL : Everything is written<br />\nOFF: Nothing is written<br />");
    combobox_debugMode.setName(Options.DEBUG_MODE);
    combobox_debugMode.setOpaque(false);

    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel4.setText("Date Format :");
    jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    jLabel4.setName("noname"); // NOI18N

    combobox_dateFormat.setEditable(true);
    combobox_dateFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dd/MM/yyyy", "dd-MM-yyyy", "dd/MM/yy", "dd-MM-yy", "d/M/yyyy", "d/M/yy" }));
    combobox_dateFormat.setSelectedItem(Options.toString(Options.DATE_FORMAT));
    combobox_dateFormat.setName(Options.DATE_FORMAT);

    jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel11.setText("Video Viewer :");
    jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

    tf_videoApp.setText(Options.toString(Options.VIDEO_APP));
    tf_videoApp.setName(Options.VIDEO_APP);

    jLabel14.setFont(jLabel14.getFont().deriveFont((jLabel14.getFont().getStyle() | java.awt.Font.ITALIC), jLabel14.getFont().getSize()-1));
    jLabel14.setText("(Leave it blank to use your OS default video viewer)");

    bt_videoViewer.setToolTipText("Browse for video viewer");
    bt_videoViewer.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_videoViewerActionPerformed(evt);
      }
    });

    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel7.setText("Main Series Directory:");
    jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

    tf_mainDir.setText(Options.toString(Options.MAIN_DIRECTORY));
    tf_mainDir.setToolTipText("<html>A directory where subtitle (zipped or not) files should be saved. Then the application will move them to the series directory if possible");
    tf_mainDir.setName(Options.MAIN_DIRECTORY);

    bt_mainDirectory.setToolTipText("Browse for main directory");
    bt_mainDirectory.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_mainDirectoryActionPerformed(evt);
      }
    });

    jLabel22.setFont(jLabel22.getFont().deriveFont((jLabel22.getFont().getStyle() | java.awt.Font.ITALIC), jLabel22.getFont().getSize()-1));
    jLabel22.setText("Setting logging level to ALL will slow down the application");

    bt_dfhelp.setToolTipText("Date format help");
    bt_dfhelp.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_dfhelpActionPerformed(evt);
      }
    });

    cb_showPopups.setSelected(Options.toBoolean(Options.SHOW_POPUPS));
    cb_showPopups.setText("Show popup messages");
    cb_showPopups.setName(Options.SHOW_POPUPS);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(cb_showPopups)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
              .addComponent(combobox_debugMode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGap(271, 271, 271))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
            .addGap(262, 262, 262))
          .addGroup(layout.createSequentialGroup()
            .addComponent(combobox_dateFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_dfhelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
            .addGap(298, 298, 298))
          .addGroup(layout.createSequentialGroup()
            .addComponent(tf_mainDir, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_mainDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
            .addGap(78, 78, 78))
          .addGroup(layout.createSequentialGroup()
            .addComponent(tf_videoApp, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_videoViewer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(combobox_debugMode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel22))
        .addGap(7, 7, 7)
        .addComponent(cb_showPopups)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(bt_dfhelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(combobox_dateFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(jLabel11)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(tf_videoApp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bt_videoViewer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel14)
        .addGap(18, 18, 18)
        .addComponent(jLabel7)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(bt_mainDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tf_mainDir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(27, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

    private void bt_videoViewerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_videoViewerActionPerformed
      File folder;
      MySeriesLogger.logger.log(Level.INFO, "Selecting video viewer");
      String os = System.getProperty("os.name");
      if (os.toLowerCase().indexOf("windows") > -1) {
        folder = new File("C:\\Program Files");
      } else {
        folder = new File(System.getProperty("user.home"));
      }
      JFileChooser f = new JFileChooser();
      f.setDialogTitle("Choose the application to open video files");
      f.setDialogType(JFileChooser.OPEN_DIALOG);
      f.setFileSelectionMode(JFileChooser.FILES_ONLY);
      f.setMultiSelectionEnabled(false);
      if (folder.isDirectory()) {
        f.setCurrentDirectory(folder);
      }
      f.showOpenDialog(this);
      File sel = f.getSelectedFile();
      if (sel != null) {
        String app = sel.getAbsolutePath();
        tf_videoApp.setText(app);
        MySeriesLogger.logger.log(Level.INFO, "Video viewer set to {0}", app);
      }
}//GEN-LAST:event_bt_videoViewerActionPerformed

    private void bt_mainDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_mainDirectoryActionPerformed
      File folder;
      MySeriesLogger.logger.log(Level.INFO, "Selecting series main directory");
      String os = System.getProperty("os.name");
      folder = new File(Options.toString(Options.MAIN_DIRECTORY));
      JFileChooser f = new JFileChooser();
      f.setDialogTitle("Choose your series main directory");
      f.setDialogType(JFileChooser.OPEN_DIALOG);
      f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      f.setMultiSelectionEnabled(false);
      if (folder.isDirectory()) {
        f.setCurrentDirectory(folder);
      }
      f.showOpenDialog(this);
      File sel = f.getSelectedFile();
      if (sel != null) {
        String md = sel.getAbsolutePath();
        tf_mainDir.setText(md);
        MySeriesLogger.logger.log(Level.INFO, "Main directory set to {0}", md);
      }
}//GEN-LAST:event_bt_mainDirectoryActionPerformed

    private void bt_dfhelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_dfhelpActionPerformed
      try {
        DateFormatHelp dfh = new DateFormatHelp();
      } catch (IOException ex) {
        MySeriesLogger.logger.log(Level.SEVERE, "Could not find date format help file", ex);
      }
}//GEN-LAST:event_bt_dfhelpActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private myComponents.myGUI.buttons.MyButtonHelp bt_dfhelp;
  private myComponents.myGUI.buttons.MyButtonDir bt_mainDirectory;
  private myComponents.myGUI.buttons.MyButtonDir bt_videoViewer;
  private javax.swing.JCheckBox cb_showPopups;
  public javax.swing.JComboBox combobox_dateFormat;
  public javax.swing.JComboBox combobox_debugMode;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel22;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel7;
  public com.googlecode.svalidators.formcomponents.STextField tf_mainDir;
  public com.googlecode.svalidators.formcomponents.STextField tf_videoApp;
  // End of variables declaration//GEN-END:variables

}