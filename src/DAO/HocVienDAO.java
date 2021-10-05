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
import model.HocVien;

/**
 *
 * @author phamd
 */
public class HocVienDAO extends EduSysDAO<HocVien, String> {

    String INSERT_SQL = "INSERT INTO HocVien(MaKH, MaNH, Diem) VALUES(?, ?, ?)";
    String UPDATE_SQL = "UPDATE HocVien SET MaKH=?, MaNH=?, Diem=? WHERE MaHV=?";
    String DELETE_SQL = "DELETE FROM HocVien WHERE MaHV=?";
    String SELECT_ALL_SQL = "SELECT * FROM HocVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM HocVien WHERE MAHV = ?";

    @Override
    public void insert(HocVien entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaKH(),
                    entity.getMaNH(),
                    entity.getDiem());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HocVien entity) {
        try {
            jdbcHelper.update(UPDATE_SQL,
                    entity.getMaKH(),
                    entity.getMaNH(),
                    entity.getDiem(),
                    entity.getMaHV());
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
    public List<HocVien> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public HocVien selectByID(String key) {
        List<HocVien> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HocVien> selectBySQL(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                HocVien hv = new HocVien();
                hv.setMaHV(rs.getInt("MaHV"));
                hv.setMaKH(rs.getInt("KH"));
                hv.setMaNH(rs.getString("MaNH"));
                hv.setDiem(rs.getDouble("Diem"));
                list.add(hv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
