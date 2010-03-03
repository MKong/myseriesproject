/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tools;

import java.awt.Desktop;
import java.util.logging.Level;
import myseries.*;

/**
 *
 * @author lordovol
 */
public class DesktopSupport {
  private static Desktop desktop;
  private static boolean browseSupport;
  private static boolean desktopSupport;
  private static boolean mailSupport;

  

  public DesktopSupport(){
    try {
        desktop = Desktop.getDesktop();
        desktopSupport = Desktop.isDesktopSupported();
        browseSupport = desktop.isSupported(Desktop.Action.BROWSE);
        mailSupport = desktop.isSupported(Desktop.Action.MAIL);
      } catch (UnsupportedOperationException ex) {
        MySeries.logger.log(Level.WARNING, "Desktop is not supported in the current OS");
      }
  }

  /**
   * @return the desktop
   */
  public static Desktop getDesktop() {
    return desktop;
  }
  
  /**
   * @return the browseSupport
   */
  public static boolean isBrowseSupport() {
    return browseSupport;
  }

 
  /**
   * @return the desktopSupport
   */
  public static boolean isDesktopSupport() {
    return desktopSupport;
  }

 
  /**
   * @return the mailSupport
   */
  public static boolean isMailSupport() {
    return mailSupport;
  }

 
}
