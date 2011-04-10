/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GridPanel.java
 *
 * Created on 2 Σεπ 2010, 6:13:48 μμ
 */
package tools.feeds;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.Iterator;
import java.util.logging.Level;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import myComponents.myGUI.MyScrollableFlowPanel;
import tools.MySeriesLogger;


/**
 *
 * @author lordovol
 */
public class FeedPreviewPanel extends javax.swing.JPanel {

  public static final long serialVersionUID = 23534634654764L;
  public MyScrollableFlowPanel feedPanel = new MyScrollableFlowPanel();;
  private Feed feed;

  /** Creates new form GridPanel */
  public FeedPreviewPanel() {
      initComponents();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 590, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 406, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents

  public void setFeed(Feed feed) {
      MySeriesLogger.logger.log(Level.INFO, "Setting feed to {0}",feed);
    this.feed = feed;
    removeAll();
    feedPanel = new MyScrollableFlowPanel();
    JScrollPane panel = new JScrollPane(feedPanel);
    panel.getViewport().setOpaque(false);
    panel.setOpaque(false);
    feedPanel.setOpaque(false);
    panel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    add(panel, BorderLayout.CENTER);
    feedPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    int count = 0;
      MySeriesLogger.logger.log(Level.INFO, "Creating {0} feed entries",feed.getEntries().size());
    for (Iterator<SyndEntryImpl> it = feed.getEntries().iterator(); it.hasNext();) {
      SyndEntryImpl entry = it.next();
      FeedPanel p = new FeedPanel(feedPanel, entry);
      p.run();
      count++;
    }
    revalidate();
    repaint();
  }

  public void resize(){
    Component[] comps = feedPanel.getComponents();
    for (int i = 0; i < comps.length; i++) {
      Component component = comps[i];
      if(component instanceof FeedPanel){
        FeedPanel fp = (FeedPanel) component;
        fp.resize(FeedPanel.MINIMIZED);
      }
    }
  }

  public Feed getFeed(){
    return feed;
  }

  public void removeFeeds(){
    removeAll();
    revalidate();
    repaint();
  }


  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
