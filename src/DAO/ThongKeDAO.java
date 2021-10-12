/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phamd
 */
public class ThongKeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = jdbcHelper.query(sql, args);
            while(rs.next()){
                Object[]vals = new Object[cols.length];
                for(int i=0;i<cols.length;i++){
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getBangDiem(Integer makh) {
        String sql = "{CALL SP_BANGDIEM(?)}";
        String[] cols ={"MANH","HOTEN","DIEM"};
        return this.getListOfArray(sql, cols, makh);
    }

    public List<Object[]> getLuongNguoiHoc() {
        String sql ="{CALL SP_THONGKENGUOIHOC}";
        String[] cols = {"Nam","SoLuong","DauTien","CuoiCung"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getDiemChuyenDe() {
        String sql = "{CALL [SP_THONGKE]}";
        String[] cols = {"ChuyenDe","SoHV","ThapNhat","CaoNhat","TrungBinh"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getDOanhTHu(int nam) {
        String sql = "{CALL SP_THONGKEDOANHTHU(?)}";
        String[] cols = {"ChuyenDe","SoKH","SoHV","DoanhThu","ThapNhat","CaoNhat","TrungBinh"};
        return this.getListOfArray(sql, cols,nam);
    }
}
