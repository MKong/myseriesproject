/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StatSeries.java
 *
 * Created on 28 Μαϊ 2010, 3:51:43 μμ
 */
package myseries.statistics;

import database.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import myComponents.myTableCellRenderers.MyDecimalFormatRenderer;

/**
 *
 * @author ssoldatos
 */
public class StatSeries extends javax.swing.JPanel {

  private DefaultTableModel model;

  /** Creates new form StatSeries */
  public StatSeries() {
    super();
    initComponents();
    model = (DefaultTableModel) table_stat_series.getModel();
    table_stat_series.getColumnModel().getColumn(2).setCellRenderer(new MyDecimalFormatRenderer());
    setTableModel();
    validate();
    setVisible(true);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    table_stat_series = new javax.swing.JTable();
    jLabel1 = new javax.swing.JLabel();

    table_stat_series.setAutoCreateRowSorter(true);
    table_stat_series.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Series", "Episodes", "Rate"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(table_stat_series);

    jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+2));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Series Statistics");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(7, 7, 7)
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable table_stat_series;
  // End of variables declaration//GEN-END:variables

  public void setTableModel() {
    clearModel();
    try {
      Statement stmt = DBConnection.stmt;
      String sql = "SELECT  series.title AS series, sum(episodes.rate)/count(1) as rate, count(1) as episodes "
              + "FROM series join episodes on series.series_ID = episodes.series_ID "
              + "where episodes.rate > 0 group by series.series_ID order by rate desc";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        String series = rs.getString("series");
        int episodes = rs.getInt("episodes");
        double rate = rs.getDouble("rate");

        Object[] data = {series, episodes, rate};
        model.addRow(data);
      }
    } catch (SQLException ex) {
      Logger.getLogger(StatSeries.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void clearModel() {
    for (int i = 0; i < model.getRowCount(); i++) {
      model.removeRow(i);
    }
  }
}