/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author phamd
 */
public class MsgBox {
    public static  void alert(Component parent,String message){
        JOptionPane.showMessageDialog(parent, message, "Hệ Thống Quản Lý Đào Tạo", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static  boolean comfirm(Component parent,String message){
       int result = JOptionPane.showConfirmDialog(parent, message, "Hệ Thống Quản Lý Đào Tạo", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
     return result==JOptionPane.YES_NO_OPTION;
    }
    
    public static  void prompt(Component parent,String message){
        JOptionPane.showMessageDialog(parent, message, "Hệ Thống Quản Lý Đào Tạo", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}
