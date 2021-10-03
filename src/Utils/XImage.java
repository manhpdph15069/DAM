/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author phamd
 */
public class XImage {
    //Lấy ảnh làm icon 
    public static Image getAppIcon(){
        URL url =  XImage.class.getResource("/icon/fpt.png");
       return new ImageIcon(url).getImage();
    }
}
