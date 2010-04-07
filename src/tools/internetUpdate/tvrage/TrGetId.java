/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GetTvRageID.java
 *
 * Created on 21 Φεβ 2010, 12:18:09 μμ
 */
package tools.internetUpdate.tvrage;

import database.SeriesRecord;
import java.awt.Dialog.ModalityType;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import myComponents.MyMessages;
import myComponents.MyUsefulFunctions;
import myComponents.myGUI.MyDraggable;
import myseries.MySeries;
import myseries.series.AdminSeries;
import myseries.series.Series;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tools.internetUpdate.InternetUpdate;
import tools.internetUpdate.tvrage.TrGetId.SearchSeries.TvRageSeries;

/**
 *
 * @author lordovol
 */
public class TrGetId extends MyDraggable {
  private MySeries myS;

  private int series_ID = 0;
  private AdminSeries adminSeries;
  String title;
  ComboBoxModel resultsModel = new DefaultComboBoxModel();
  public int tvRageID = 0;
  private boolean isConected;
  private static final long serialVersionUID = 345645747547L;

  {
    MyUsefulFunctions.initInternetConnection();
    isConected = MyUsefulFunctions.hasInternetConnection();
  }

  /** Creates new form GetTvRageID */
  public TrGetId() {
  }

  /**
   * 
   * @param myS 
   * @param series_ID
   * @param title
   */
  public TrGetId(MySeries myS, int series_ID, String title) {
    this.myS = myS;
    this.series_ID = series_ID;
    this.title = title;
    getID();

  }

  public TrGetId(AdminSeries adminSeries, String title) {
    this.adminSeries = adminSeries;
    this.title = title;
    getID();
  }

  private void getID() {
    if (!isConected) {
      MySeries.logger.log(Level.WARNING, "Could not connect to internet");
      MyMessages.internetError();
      button_cancelActionPerformed(null);
      return;
    }
    initComponents();
    label_title.setText("Select the right series from the results found for " + title);
    setLocationRelativeTo(null);
    setLocation(getX(), 200);
    setModalityType(ModalityType.MODELESS);
    pack();
    setVisible(true);
    MySeries.logger.log(Level.INFO, "Searching for series " + title);
    SearchSeries s = new SearchSeries(title);
    Thread t = new Thread(s);
    t.start();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    label_title = new javax.swing.JLabel();
    button_ok = new javax.swing.JButton();
    button_cancel = new javax.swing.JButton();
    progress = new javax.swing.JProgressBar();
    combo_results = new javax.swing.JComboBox();
    jLabel2 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

    jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+2));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Internet Update");

    label_title.setText("jLabel2");

    button_ok.setText("OK");
    button_ok.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_okActionPerformed(evt);
      }
    });

    button_cancel.setText("Cancel");
    button_cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_cancelActionPerformed(evt);
      }
    });

    progress.setString("");
    progress.setStringPainted(true);

    combo_results.setModel(resultsModel);

    jLabel2.setText("Results");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(button_ok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(button_cancel)
                .addGap(18, 18, 18)
                .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addGap(10, 10, 10))
              .addComponent(combo_results, 0, 323, Short.MAX_VALUE))))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(label_title)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(combo_results, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(button_ok)
            .addComponent(button_cancel))
          .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
    dispose();
    MySeries.glassPane.deactivate();
    if (adminSeries != null) {
      adminSeries.setModalityType(ModalityType.APPLICATION_MODAL);
      if (tvRageID > 0) {
        adminSeries.textfield_tvRageID.setText(String.valueOf(tvRageID));
      }
      adminSeries.setVisible(true);
    }else {
      InternetUpdate iu = new InternetUpdate(myS, Series.getCurrentSerial());
    }
    
  }//GEN-LAST:event_button_cancelActionPerformed

  private void button_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_okActionPerformed
    TvRageSeries sel = (TvRageSeries) combo_results.getSelectedItem();
    tvRageID = Integer.parseInt(sel.id);
    if (series_ID > 0) {
      try {
        SeriesRecord cSeries = SeriesRecord.getSeriesByID(series_ID);
        cSeries.setTvrage_ID(tvRageID);
        cSeries.save();
        Series.getCurrentSerial().setTvrage_ID(tvRageID);
      } catch (SQLException ex) {
        MySeries.logger.log(Level.SEVERE, null, ex);
        MyMessages.error("SQL Error", "TvRage ID could not be saved in database");
      }
    }
    button_cancelActionPerformed(evt);
    MySeries.glassPane.deactivate();
  }//GEN-LAST:event_button_okActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton button_cancel;
  private javax.swing.JButton button_ok;
  private javax.swing.JComboBox combo_results;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JLabel label_title;
  private javax.swing.JProgressBar progress;
  // End of variables declaration//GEN-END:variables

  class SearchSeries implements Runnable {

    private final String title;
    Vector<TvRageSeries> results = new Vector<TvRageSeries>();

    SearchSeries(String title) {
      MySeries.logger.log(Level.INFO, "Search");
      this.title = title;
      // run();
    }

    public void run() {
      try {
        progress.setString("Searching for " + this.title);
        progress.setIndeterminate(true);
        search();
        progress.setIndeterminate(false);
        progress.setString("Found  " + results.size() + " results");
      } catch (SAXException ex) {
        MySeries.logger.log(Level.WARNING, "Could not parse XML file", ex);
      } catch (ParserConfigurationException ex) {
        MySeries.logger.log(Level.WARNING, "Could not parse XML file", ex);
      } catch (IOException ex) {
        MySeries.logger.log(Level.WARNING, "Could not find the url for " + title, ex);
      }
    }

    private void search() throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
      InputStream in = null;
      MySeries.logger.log(Level.INFO, "Getting the url");
      String url = "http://services.tvrage.com/feeds/search.php?show=";
      url = url + URLEncoder.encode(title, "UTF-8");
      MySeries.logger.log(Level.INFO, "Reading URL: " + url);
      URL tvRage = new URL(url);
      in = tvRage.openStream();
      readXML(in);

    }

    private void readXML(InputStream in) throws ParserConfigurationException, SAXException, IOException {

      MySeries.logger.log(Level.INFO, "Parsing XML");
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(in);
      doc.getDocumentElement().normalize();
      NodeList nodeLst = doc.getElementsByTagName("show");
      if (nodeLst.getLength() == 0) {
        return;
      }
      for (int s = 0; s < nodeLst.getLength(); s++) {
        Node node = nodeLst.item(s);
        Element el = (Element) node;
        String id = el.getElementsByTagName("showid").item(0).getFirstChild().getNodeValue();
        String name = el.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
        String year = el.getElementsByTagName("started").item(0).getFirstChild().getNodeValue();
        results.add(new TvRageSeries(id, name, year));
      }
      if (results.size() > 0) {
        resultsModel = new DefaultComboBoxModel(results);
      }
      combo_results.setModel(resultsModel);
      validate();
    }

    class TvRageSeries {

      final String id;
      final String name;
      final String year;

      private TvRageSeries(String id, String name, String year) {
        this.id = id;
        this.name = name;
        this.year = year;

      }

      @Override
      public String toString() {
        return name + " (" + year + ")";
      }
    }
  }
}
