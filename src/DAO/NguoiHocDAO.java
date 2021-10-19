/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.XDate;
import Utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.NguoiHoc;

/**
 *
 * @author phamd
 */
public class NguoiHocDAO extends EduSysDAO<NguoiHoc, String> {

    String INSERT_SQL = "INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV,NGAYDK,TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
    String UPDATE_SQL = "UPDATE NguoiHoc SET HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?, Email=?, GhiChu=?,MaNV=?,NgayDK=? WHERE MaNH=?";
//    String DELETE_SQL = "DELETE FROM NguoiHoc WHERE MANH=?";
      String DELETE_SQL = "UPDATE NguoiHoc SET TrangThai=0 WHere MaNH=?";
    
    String SELECT_ALL_SQL = "SELECT * FROM NguoiHoc WHERE TrangThai=1";
    String SELECT_BY_ID_SQL = "SELECT * FROM NguoiHoc WHERE MaNH =?";

    @Override
    public void insert(NguoiHoc entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaNH(),
                    entity.getHoTen(),
                    entity.getNgaySinh(),
                    entity.isGioiTinh(),
                    entity.getDiemThoai(),
                    entity.getEmail(),
                    entity.getGhiChu(),
                    entity.getMaNV(),
                    XDate.now(),
                    true
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(NguoiHoc entity) {
        try {
            jdbcHelper.update(UPDATE_SQL,
                    entity.getHoTen(),
                    entity.getNgaySinh(),
                    entity.isGioiTinh(),
                    entity.getDiemThoai(),
                    entity.getEmail(),
                    entity.getGhiChu(),
                    entity.getMaNV(),
                    XDate.now(),
                    entity.getMaNH()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String key) {
        try {
            jdbcHelper.update(DELETE_SQL, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public NguoiHoc selectByID(String key) {
        List<NguoiHoc> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NguoiHoc> selectBySQL(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                NguoiHoc nh = new NguoiHoc();
                nh.setMaNH(rs.getString("MaNH"));
                nh.setHoTen(rs.getString("HoTen"));
                nh.setNgaySinh(rs.getDate("NgaySinh"));
                nh.setGioiTinh(rs.getBoolean("GioiTinh"));
                nh.setDiemThoai(rs.getString("DienThoai"));
                nh.setEmail(rs.getString("Email"));
                nh.setGhiChu(rs.getString("GhiChu"));
                nh.setMaNV(rs.getString("MaNV"));
                nh.setNgayDK(rs.getDate("NgayDK"));
                list.add(nh);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<NguoiHoc> selectNotInCourse(int makh, String keyword) {
        String sql = "SELECT * FROM NguoiHoc"
                + " WHERE HoTen LIKE ? AND "
                + "MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH=?) AND TrangThai =1";
        return this.selectBySQL(sql, "%" + keyword + "%", makh);
    }

    public List<NguoiHoc> selectByKeyword(String keyword) {
        String sql = "SELECT *FROM NguoiHoc WHERE HoTen LIKE ? AND TrangThai=1";
        return this.selectBySQL(sql, "%" + keyword + "%");
    }
}
