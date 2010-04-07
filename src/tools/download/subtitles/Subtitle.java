/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tools.download.subtitles;

import java.net.URL;
import myComponents.MyUsefulFunctions;

/**
 *
 * @author lordovol
 */
public class Subtitle {

  public String title;
  public URL url;

  public Subtitle(String title, URL url) {
    this.title = MyUsefulFunctions.deleteDoubleSpaces(title);
    this.url = url;
  }



  @Override
  public String toString() {
    return title;
  }



}