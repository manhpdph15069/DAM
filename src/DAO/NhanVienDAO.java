/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.jdbcHelper;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;

/**
 *
 * @author phamd
 */
public class NhanVienDAO extends EduSysDAO<NhanVien, String> {

    String check = "UPDATE NhanVien SET MatKhau=? ,HoTen=?, VaiTro=?,Email=?,TrangThai=1 WHERE MaNV=? And TrangThai=0";
    String INSERT_SQL = "INSERT INTO NhanVien(MaNV,HoTen , MatKhau, VaiTro,Email,TrangThai) VALUES(?, ?, ?, ?,?,?)";
    String UPDATE_SQL = "UPDATE NhanVien SET HoTen=?, VaiTro=?,Email=? WHERE MaNV=?";
    String DELETE_MEM = "UPDATE NhanVien SET TrangThai=0 WHERE MaNV=?";
    // String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV = ?";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien Where TrangThai=1";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV = ? and TrangThai=1";
    String SELECT_BY_ID = "SELECT * FROM NhanVien WHERE MaNV = ? and TrangThai=0";

   public void checkTrung(NhanVien entity) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
           jdbcHelper.update(check,
                maHoa(entity.getMatKhau()),
                entity.getHoTen(),
                entity.isVaiTro(),
                entity.getEmail(),
                entity.getMaNV());
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public void insert(NhanVien entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaNV(),
                    entity.getHoTen(),
                    maHoa(entity.getMatKhau()),
                    entity.isVaiTro(),
                    entity.getEmail(),
                    true);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhanVien entity) {
        jdbcHelper.update(UPDATE_SQL,
                //                    maHoa(entity.getMatKhau()),
                entity.getHoTen(),
                entity.isVaiTro(),
                entity.getEmail(),
                entity.getMaNV());
    }

    public void updateMKM(NhanVien entity) {
        try {
            String updateMK = "UPDATE NhanVien SET MatKhau=? WHERE MaNV=?";
            jdbcHelper.update(updateMK,
                    maHoa(entity.getMatKhau()),
                    entity.getMaNV()
            );
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_MEM, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectByID(String id) {
        List<NhanVien> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public NhanVien trung(String id) {
        List<NhanVien> list = this.selectBySQL(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySQL(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MANV"));
                nv.setHoTen(rs.getString("HOTEN"));
                nv.setMatKhau(rs.getString("MATKHAU"));
                nv.setVaiTro(rs.getBoolean("VAITRO"));
                nv.setEmail(rs.getString("Email"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String maHoa(String srcText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String enrText;

        MessageDigest mh = MessageDigest.getInstance("MD5");//Lớp thực hiện mã hóa
        byte[] srcTextBytes = srcText.getBytes("UTF-8");
        byte[] enrTextBytes = mh.digest(srcTextBytes);

        BigInteger bigInt = new BigInteger(1, enrTextBytes);//byte mã hóa đc chuyển sang chuổi số hệ 16 nhờ lớp
        enrText = bigInt.toString(16);

        return enrText;
    }
}
