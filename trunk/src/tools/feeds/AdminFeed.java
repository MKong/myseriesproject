/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdminFeed.java
 *
 * Created on 31 Οκτ 2010, 1:14:41 μμ
 */
package tools.feeds;

import com.googlecode.svalidators.formcomponents.ValidationGroup;
import com.googlecode.svalidators.validators.RequiredValidator;
import com.googlecode.svalidators.validators.SValidator;
import com.googlecode.svalidators.validators.UrlValidator;
import database.FeedsRecord;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import myComponents.MyMessages;
import myComponents.MyUsefulFunctions;
import myComponents.myGUI.MyDraggable;
import tools.Skin;

/**
 *
 * @author lordovol
 */
public class AdminFeed extends MyDraggable {

  public static final long serialVersionUID = 23525522525L;
  public boolean isFeedSaved = false;
  private FeedsRecord feed;

  /** Creates new form AdminFeed */
  public AdminFeed() {
    this(null);
  }

  public AdminFeed(FeedsRecord f) {
    initComponents();
    if (f == null) {
      this.feed = new FeedsRecord();
      label_title.setText("Add a new rss feed");
      tf_title.setEnabled(false);
      tf_title.setVisible(false);
      label_feedtitle.setVisible(false);
      tf_title.removeValidator(SValidator.REQUIRED);
    } else {
      this.feed = f;
      label_title.setText("Edit " + f.getTitle());
      tf_url.setText(f.getUrl());
      tf_title.setText(f.getTitle());
    }
    setLocationRelativeTo(null);
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

    outerPanel = new javax.swing.JPanel();
    innerPanel = new javax.swing.JPanel();
    label_url = new javax.swing.JLabel();
    tf_url = new com.googlecode.svalidators.formcomponents.STextField(new UrlValidator());
    label_feedtitle = new javax.swing.JLabel();
    tf_title = new com.googlecode.svalidators.formcomponents.STextField(new RequiredValidator());
    label_title = new javax.swing.JLabel();
    bt_cancel = new myComponents.myGUI.buttons.MyButtonCancel();
    bt_ok = new myComponents.myGUI.buttons.MyButtonOk();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    outerPanel.setBackground(Skin.getOuterColor());
    outerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    innerPanel.setBackground(Skin.getInnerColor());
    innerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    label_url.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_url.setText("Feed URL :");

    tf_url.setName("Feed url"); // NOI18N

    label_feedtitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_feedtitle.setText("Feed Title :");

    tf_title.setName("Feed url"); // NOI18N

    javax.swing.GroupLayout innerPanelLayout = new javax.swing.GroupLayout(innerPanel);
    innerPanel.setLayout(innerPanelLayout);
    innerPanelLayout.setHorizontalGroup(
      innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(innerPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, innerPanelLayout.createSequentialGroup()
            .addComponent(label_feedtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tf_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, innerPanelLayout.createSequentialGroup()
            .addComponent(label_url, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tf_url, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(16, Short.MAX_VALUE))
    );
    innerPanelLayout.setVerticalGroup(
      innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(innerPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(innerPanelLayout.createSequentialGroup()
            .addComponent(tf_url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(tf_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(label_feedtitle)))
          .addComponent(label_url))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    label_title.setFont(label_title.getFont().deriveFont(label_title.getFont().getStyle() | java.awt.Font.BOLD, label_title.getFont().getSize()+2));
    label_title.setForeground(Skin.getTitleColor());
    label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    label_title.setText("title");

    bt_cancel.setText("");
    bt_cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_cancelActionPerformed(evt);
      }
    });

    bt_ok.setText("");
    bt_ok.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_okActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout outerPanelLayout = new javax.swing.GroupLayout(outerPanel);
    outerPanel.setLayout(outerPanelLayout);
    outerPanelLayout.setHorizontalGroup(
      outerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outerPanelLayout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(outerPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(innerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outerPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(bt_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    outerPanelLayout.setVerticalGroup(
      outerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(outerPanelLayout.createSequentialGroup()
        .addGroup(outerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(innerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bt_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(outerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(outerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void bt_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_okActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_bt_okActionPerformed

  private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
     dispose();
  }//GEN-LAST:event_bt_cancelActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private myComponents.myGUI.buttons.MyButtonCancel bt_cancel;
  private myComponents.myGUI.buttons.MyButtonOk bt_ok;
  private javax.swing.JPanel innerPanel;
  private javax.swing.JLabel label_feedtitle;
  private javax.swing.JLabel label_title;
  private javax.swing.JLabel label_url;
  private javax.swing.JPanel outerPanel;
  private com.googlecode.svalidators.formcomponents.STextField tf_title;
  private com.googlecode.svalidators.formcomponents.STextField tf_url;
  // End of variables declaration//GEN-END:variables
}
