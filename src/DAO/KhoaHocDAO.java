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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhoaHocc;

/**
 *
 * @author phamd
 */
public class KhoaHocDAO extends EduSysDAO<KhoaHocc, String> {

    String INSERT_SQL = "INSERT INTO KHOAHOC(MACD, HOCPHI,THOIGIAN,NGAYKG,GHICHU,MANV,NGAYTAO) VALUES (?, ?, ?, ?,?,?,?)";
    String UPDATE_SQL = "UPDATE KHOAHOC SET MACD= ?, HOCPHI= ?, THOIGIAN= ?, NGAYKG=?, GHICHU=?, MANV=?, NGAYTAO=? WHERE MAKH= ?";
    String DELETE_SQL = "DELETE FROM KHOAHOC WHERE MAKH= ?";
    String SELECT_ALL_SQL = "SELECT * FROM KHOAHOC";
    String SELECT_BY_ID_SQL = "SELECT * FROM KHOAHOC WHERE MAKH= ?";

    @Override
    public void insert(KhoaHocc entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaCD(),
                    entity.getHocPhi(),
                    entity.getThoiLuong(),
                    entity.getNgayKG(),
                    entity.getGhiChu(),
                    entity.getMaNV(),
                    entity.getNgayTao());
        } catch (Exception e) {
            Logger.getLogger(KhoaHocDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(KhoaHocc entity) {
        try {
            jdbcHelper.update(UPDATE_SQL,
                    entity.getMaCD(),
                    entity.getHocPhi(),
                    entity.getThoiLuong(),
                    entity.getNgayKG(),
                    entity.getGhiChu(),
                    entity.getMaNV(),
                    entity.getNgayTao(),
                    entity.getMaKH());
        } catch (Exception e) {
            Logger.getLogger(KhoaHocDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            jdbcHelper.update(DELETE_SQL, id);
        } catch (Exception e) {
            Logger.getLogger(KhoaHocDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<KhoaHocc> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }


    public KhoaHocc selectByID(Integer id) {
        List<KhoaHocc> list = selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhoaHocc> selectBySQL(String sql, Object... args) {
        List<KhoaHocc> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                KhoaHocc kh = new KhoaHocc();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setHocPhi(rs.getDouble("HocPhi"));
                kh.setThoiLuong(rs.getInt("ThoiGian"));
                kh.setNgayKG(rs.getDate("NgayKG"));
                kh.setGhiChu(rs.getString("GhiChu"));
                kh.setMaNV(rs.getString("MaNV"));
                kh.setNgayTao(rs.getDate("NgayTao"));
                kh.setMaCD(rs.getString("MaCD"));
                list.add(kh);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    
    public List<KhoaHocc> selectByChuyenDe(String macd){
        String sql = "SELECT *FROM KhoaHoc WHERE MaCD=?";
        return this.selectBySQL(sql, macd);
    }
    
    public List<Integer> selectYears(){
        String sql ="SELECT DISTINCT year(NgayKG) as NAM FROM KhoaHoc ORDER BY Year(NgayKG) DESC";
        List<Integer>list =new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql);
            while(rs.next()){
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public KhoaHocc selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
