/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ImportEpisodes.java
 *
 * Created on 21 Δεκ 2008, 12:15:05 μμ
 */
package tools.importExport;

import Exceptions.EpisodeImportFormatException;
import database.EpisodesRecord;
import database.SeriesRecord;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import myComponents.MyMessages;
import myComponents.MyUsefulFunctions;
import myComponents.myFileFilters.EpisodesExportFilter;
import myComponents.myGUI.MyDraggable;
import myseries.MySeries;
import myseries.series.Series;
import com.googlecode.svalidators.formcomponents.ValidationGroup;
import com.googlecode.svalidators.validators.FileValidator;
import com.googlecode.svalidators.validators.NullValidator;
import com.googlecode.svalidators.validators.RequiredValidator;

/**
 * Imports previous exported episodes
 * @author lordovol
 */
public class ImportEpisodes extends MyDraggable {

  private static final long serialVersionUID = 45756856856876L;
  DefaultComboBoxModel comboboxModel_allSeries = new DefaultComboBoxModel();
  MySeries m;
  //private Dimension small;
  //private Dimension big;
  private File file;
  private ArrayList<SeriesRecord> series;
  ArrayList<EpisodesRecord> newEpisodes;
  private int series_ID = 0;
  boolean update = false;
  FileValidator fileValidator;

  /** Creates new form ImportEpisodes
   * @param m MySeries
   * @throws SQLException 
   */
  public ImportEpisodes(MySeries m) throws SQLException {
    //small = new Dimension(485, 175);
    //big = new Dimension(485, 244);
    this.m = m;
    createSeries();
    fileValidator = new FileValidator("", FileValidator.Type.FILE, false);
    initComponents();
    //panel_newSeries.setEnabled(false);
    textfield_newSeriesTitle.setEnabled(false);
    spinner_newSeriesSeason.setEnabled(false);
    //this.setSize(small);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  /**
   * Get all series
   * @throws java.sql.SQLException
   */
  private void createSeries() throws SQLException {
    series = Series.updateSeriesTable(false);
    for (int i = 0; i < series.size(); i++) {
      comboboxModel_allSeries.addElement(series.get(i).getFullTitle());
    }
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panel = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    combobox_series = new javax.swing.JComboBox();
    button_import = new javax.swing.JButton();
    button_cancel = new javax.swing.JButton();
    panel_newSeries = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    spinner_newSeriesSeason = new javax.swing.JSpinner();
    jLabel4 = new javax.swing.JLabel();
    textfield_newSeriesTitle = new com.googlecode.svalidators.formcomponents.STextField(new NullValidator());
    button_browse = new javax.swing.JButton();
    checkBox_newSeries = new javax.swing.JCheckBox();
    textfield_file = new com.googlecode.svalidators.formcomponents.STextField(fileValidator);
    progress_import = new javax.swing.JProgressBar();
    jLabel5 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    panel.setBackground(new java.awt.Color(255, 255, 255));
    panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    panel.setOpaque(false);
    panel.setPreferredSize(new java.awt.Dimension(485, 204));

    jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+2));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Import Episodes");

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel2.setText("Series :");

    combobox_series.setModel(comboboxModel_allSeries);
    combobox_series.setOpaque(false);

    button_import.setText("Import");
    button_import.setOpaque(false);
    button_import.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_importActionPerformed(evt);
      }
    });

    button_cancel.setText("Cancel");
    button_cancel.setOpaque(false);
    button_cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_cancelActionPerformed(evt);
      }
    });

    panel_newSeries.setBackground(new java.awt.Color(255, 255, 255));
    panel_newSeries.setMaximumSize(new java.awt.Dimension(334, 74));
    panel_newSeries.setOpaque(false);
    panel_newSeries.setPreferredSize(new java.awt.Dimension(334, 74));

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel3.setText("Title:");

    spinner_newSeriesSeason.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

    jLabel4.setText("Season :");

    textfield_newSeriesTitle.setName("Series title"); // NOI18N

    javax.swing.GroupLayout panel_newSeriesLayout = new javax.swing.GroupLayout(panel_newSeries);
    panel_newSeries.setLayout(panel_newSeriesLayout);
    panel_newSeriesLayout.setHorizontalGroup(
      panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_newSeriesLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(panel_newSeriesLayout.createSequentialGroup()
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(spinner_newSeriesSeason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(panel_newSeriesLayout.createSequentialGroup()
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(textfield_newSeriesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(40, 40, 40))
    );
    panel_newSeriesLayout.setVerticalGroup(
      panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_newSeriesLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(textfield_newSeriesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(spinner_newSeriesSeason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    button_browse.setText("Browse");
    button_browse.setOpaque(false);
    button_browse.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_browseActionPerformed(evt);
      }
    });

    checkBox_newSeries.setText("New Series :");
    checkBox_newSeries.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    checkBox_newSeries.setOpaque(false);
    checkBox_newSeries.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        checkBox_newSeriesActionPerformed(evt);
      }
    });

    textfield_file.setEditable(false);
    textfield_file.setName("Import file"); // NOI18N

    progress_import.setStringPainted(true);

    jLabel5.setText("Progress :");

    javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
    panel.setLayout(panelLayout);
    panelLayout.setHorizontalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
          .addGroup(panelLayout.createSequentialGroup()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(combobox_series, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(checkBox_newSeries)))
        .addGap(60, 60, 60))
      .addGroup(panelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(panel_newSeries, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        .addGap(90, 90, 90))
      .addGroup(panelLayout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addComponent(button_import)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(button_cancel)
        .addContainerGap(349, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel5)
        .addGap(10, 10, 10)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(textfield_file, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
          .addComponent(progress_import, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(18, 18, 18)
        .addComponent(button_browse)
        .addGap(42, 42, 42))
    );
    panelLayout.setVerticalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(combobox_series, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(checkBox_newSeries))
        .addGap(2, 2, 2)
        .addComponent(panel_newSeries, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(button_browse)
          .addComponent(textfield_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(progress_import, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(button_import)
          .addComponent(button_cancel))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
      dispose();
      MySeries.glassPane.deactivate();
}//GEN-LAST:event_button_cancelActionPerformed

    private void checkBox_newSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox_newSeriesActionPerformed
      combobox_series.setEnabled(!combobox_series.isEnabled());
      //panel_newSeries.setEnabled(!panel_newSeries.isVisible());
      textfield_newSeriesTitle.setEnabled(!textfield_newSeriesTitle.isEnabled());
      spinner_newSeriesSeason.setEnabled(!spinner_newSeriesSeason.isEnabled());
      if (checkBox_newSeries.isSelected()) {
        textfield_newSeriesTitle.addValidator(new RequiredValidator());
        textfield_newSeriesTitle.validateValue();
      } else {
        textfield_newSeriesTitle.clearValidatorsList();
        textfield_newSeriesTitle.validateValue();
      }
      if (!panel_newSeries.isVisible()) {
        //this.setSize(small);
      } else {
        //this.setSize(big);
      }
}//GEN-LAST:event_checkBox_newSeriesActionPerformed

    private void button_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_browseActionPerformed
      try {
        browse();
      } catch (IOException ex) {
        MySeries.logger.log(Level.SEVERE, "Could not open file", ex);
      }
}//GEN-LAST:event_button_browseActionPerformed

    private void button_importActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_importActionPerformed
      ValidationGroup group = new ValidationGroup();
      group.addComponent(textfield_file);
      group.addComponent(textfield_newSeriesTitle);
      if(!group.validate()){
        group.errorMessage(true);
        return;
      }
      try {
        importEpisodes();
      } catch (FileNotFoundException ex) {
        MyMessages.error("Error!!!", "Could not find episodes file");
        MySeries.logger.log(Level.SEVERE, "Could not find episodes file", ex);
      } catch (EpisodeImportFormatException ex) {
        MyMessages.error("Error!!!", ex.getMessage());
        MySeries.logger.log(Level.SEVERE, ex.getMessage(), ex);
      } catch (SQLException ex) {
        MyMessages.error("Error!!!", "Could not insert episodes in Database");
        MySeries.logger.log(Level.SEVERE, "Could not insert episodes in Database", ex);
      } catch (IOException ex) {
        MyMessages.error("Error!!!", "Could not read from file");
        MySeries.logger.log(Level.SEVERE, "Could not read from file", ex);
      }

    }//GEN-LAST:event_button_importActionPerformed

  private void importEpisodes() throws FileNotFoundException, SQLException, IOException, EpisodeImportFormatException {
    String newSeriesTitle;
    if (combobox_series.isEnabled()) {
      series_ID = series.get(combobox_series.getSelectedIndex()).getSeries_ID();
      update = true;
    } else {
      //Create new series
      if (!textfield_newSeriesTitle.getText().trim().equals("")) {
        newSeriesTitle = textfield_newSeriesTitle.getText().trim();
        SeriesRecord ser = new SeriesRecord();
        ser.setTitle(newSeriesTitle);
        ser.setSeason(Integer.parseInt(String.valueOf(spinner_newSeriesSeason.getValue())));
        series_ID = ser.save();
      }
    }
    if (series_ID > 0) {
      if (file != null) {
        newEpisodes = readFile();
        insertEpisodesInDB i = new insertEpisodesInDB(this);
        Thread t = new Thread(i);
        t.start();
      } else {
        MySeries.logger.log(Level.WARNING, "No file selected");
        MyMessages.error("No file!!!", "No File selected!!!");
      }
    } else {
      throw new EpisodeImportFormatException("No Series ID for importing the episodes.");
    }
  }

  /**
   * Reads the file with the episodes
   * @return An Arraylist of the episodes records
   * @throws java.io.FileNotFoundException
   * @throws java.io.IOException
   * @throws Exceptions.EpisodeImportFormatException
   */
  private ArrayList<EpisodesRecord> readFile() throws FileNotFoundException, IOException, EpisodeImportFormatException {
    ArrayList<EpisodesRecord> eps = new ArrayList<EpisodesRecord>();
    BufferedReader in = MyUsefulFunctions.createInputStream(file);
    String line;
    String[] fields;
    int numOfLine = 0;
    while ((line = in.readLine()) != null) {
      numOfLine++;
      fields = line.split("\t", -1);
      if (fields.length != 3) {
        throw new EpisodeImportFormatException("Episode in line " + numOfLine + " is not in the right format");
      }
      EpisodesRecord e = new EpisodesRecord();
      try {
        e.setEpisode(Integer.parseInt(fields[0].trim()));
      } catch (NumberFormatException ex) {
        throw new EpisodeImportFormatException("Episode number in line " + numOfLine + " is not an integer");
      }
      e.setTitle(fields[1].trim());
      if (!MyUsefulFunctions.isValidDate(fields[2]) && !fields[2].trim().equals("")) {
        throw new EpisodeImportFormatException("Date in line " + numOfLine + " is not in the right format");
      }
      e.setAired(fields[2].trim());
      e.setSeries_ID(series_ID);
      eps.add(e);
    }
    in.close();
    return eps;
  }

  /**
   * Opens the browser to look for the file to import
   * @throws java.io.IOException
   */
  private void browse() throws IOException {
    JFileChooser f = new JFileChooser();
    f.setFileSelectionMode(JFileChooser.FILES_ONLY);
    f.setMultiSelectionEnabled(false);
    f.setApproveButtonText("Import");
    f.setDialogTitle("Import episodes");
    f.setFileFilter(new EpisodesExportFilter());

    int returnVal = f.showOpenDialog(null);
    if (returnVal == JFileChooser.CANCEL_OPTION) {
      MySeries.logger.log(Level.INFO, "Importing aborted");
    } else {
      file = f.getSelectedFile();
      textfield_file.setText(file.getCanonicalPath());
      textfield_file.validateValue();
      MySeries.logger.log(Level.INFO, "Importing episodes in file " + file.getName());
    }
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton button_browse;
  private javax.swing.JButton button_cancel;
  private javax.swing.JButton button_import;
  private javax.swing.JCheckBox checkBox_newSeries;
  private javax.swing.JComboBox combobox_series;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel panel;
  private javax.swing.JPanel panel_newSeries;
  public javax.swing.JProgressBar progress_import;
  private javax.swing.JSpinner spinner_newSeriesSeason;
  private com.googlecode.svalidators.formcomponents.STextField textfield_file;
  private com.googlecode.svalidators.formcomponents.STextField textfield_newSeriesTitle;
  // End of variables declaration//GEN-END:variables
}
