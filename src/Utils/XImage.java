/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author phamd
 */
public class XImage {
    
    //* Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
    public static final Image APP_ICON;
    public static final ImageIcon APP_ICON1;
    //khi chạy thì chạy static đầu tiên

    static {
        // Tải biểu tượng ứng dụng 
        //CÁCH TẢI ẢNH TỪ TRONG PROJECT
        //icon là thư mục con của src
        //Logo cho ứng dụng
        String file = "/icon/logo.png";      //icon là thư mục con của src
        APP_ICON = new ImageIcon(XImage.class.getResource(file)).getImage();
        APP_ICON1 = new ImageIcon(XImage.class.getResource(file));//getResource(file) Tìm 1 tài nguyên với 1 tên nhất định Trả về 1 đối tượng URL hoặc null
    }
    //Lấy ảnh làm icon 
    public static Image getAppIcon(){
        URL url =  XImage.class.getResource("/icon/fpt.png");
       return new ImageIcon(url).getImage();
    }
    public static void save(File src){
        File dst = new File("logos",src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from,to,StandardCopyOption.REPLACE_EXISTING);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static ImageIcon read(String fileName){
        File path = new File("logos",fileName);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(180,180 , Image.SCALE_DEFAULT));
    }
}
