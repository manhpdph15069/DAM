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
import model.ChuyenDe;

/**
 *
 * @author phamd
 */
public class ChuyenDeDAO extends EduSysDAO<ChuyenDe, String> {

    String INSERT_SQL = "INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa,TrangThai) VALUES (?, ?, ?, ?, ?, ?,?)";
    String UPDATE_SQL = "UPDATE ChuyenDe SET TenCD=?, HocPhi=?, ThoiLuong=?, Hinh=?, MoTa=? WHERE MaCD=?";
    String DELETE_SQL = "UPDATE ChuyenDe SET TrangThai=0 WHERE MaCD=?";
    String SELECT_ALL_SQL = "SELECT * FROM ChuyenDe WHERE TrangThai=1";
    String SELECT_BY_ID_SQL = "SELECT * FROM ChuyenDe WHERE MaCD=? AND TrangThai=1";

    @Override
    public void insert(ChuyenDe entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaCD(),
                    entity.getTenCD(),
                    entity.getHocPhi(),
                    entity.getThoiLuong(),
                    entity.getHinh(),
                    entity.getMoTa()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ChuyenDe entity) {
        try {
            jdbcHelper.update(UPDATE_SQL,
                    entity.getTenCD(),
                    entity.getHocPhi(),
                    entity.getThoiLuong(),
                    entity.getHinh(),
                    entity.getMoTa(),
                    entity.getMaCD());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            jdbcHelper.update(DELETE_SQL, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public ChuyenDe selectByID(String key) {
        List<ChuyenDe> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<ChuyenDe> selectBySQL(String sql, Object... args) {
        List<ChuyenDe> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                ChuyenDe cd = new ChuyenDe();
                cd.setMaCD(rs.getString("MaCD"));
                cd.setHinh(rs.getString("Hinh"));
                cd.setHocPhi(rs.getDouble("HocPhi"));
                cd.setMoTa(rs.getString("MoTa"));
                cd.setTenCD(rs.getString("TenCD"));
                cd.setThoiLuong(rs.getInt("ThoiLuong"));
                list.add(cd);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
