﻿Create database EduSys
go
Use EduSys
go

CREATE TABLE NHANVIEN
(
MANV NVARCHAR(50) NOT NULL,
MATKHAU NVARCHAR(50) NOT NULL,
HOTEN NVARCHAR(50) NOT NULL,
VAITRO BIT NOT NULL,
PRIMARY KEY(MANV)
)
GO
CREATE TABLE CHUYENDE
(
MACD NCHAR(5) NOT NULL,
TENCD NVARCHAR(50) NOT NULL,
HOCPHI FLOAT NOT NULL,
THOILUONG INT NOT NULL,
HINH NVARCHAR(50) NOT NULL,
MOTA NVARCHAR(255) NOT NULL,
PRIMARY KEY(MACD)
)
GO
Create table KHOAHOC
(
MAKH INT IDENTITY(1,1) NOT NULL,
MACD NCHAR(5) NOT NULL,
HOCPHI FLOAT NOT NULL,
THOIGIAN INT NOT NULL,
NGAYKG DATE NOT NULL,
GHICHU NVARCHAR(50) NULL,
MANV NVARCHAR(50) NOT NULL,
NGAYTAO DATE NOT NULL,
PRIMARY KEY(MAKH),
FOREIGN KEY(MACD) REFERENCES CHUYENDE(MACD) ON DELETE NO ACTION ON UPDATE CASCADE,
FOREIGN KEY(MANV) REFERENCES NHANVIEN(MANV) ON DELETE NO ACTION ON UPDATE CASCADE,
)
GO

CREATE TABLE NGUOIHOC
(
MANH NCHAR(7) NOT NULL,
HOTEN NVARCHAR(50) NOT NULL,
NGAYSINH DATE NOT NULL,
GIOITINH BIT NOT NULL,
DIENTHOAI NVARCHAR(50) NOT NULL,
EMAIL NVARCHAR(50) NOT NULL,
GHICHU NVARCHAR(MAX) NULL,
MANV NVARCHAR(50) NOT NULL,
NGAYDK DATE NOT NULL,
PRIMARY KEY(MANH),
FOREIGN KEY(MANV) REFERENCES NHANVIEN(MANV) ON DELETE NO ACTION ON UPDATE CASCADE
)
GO
CREATE TABLE HOCVIEN
(
MAHV INT IDENTITY(1,1) NOT NULL,
MAKH INT NOT NULL,
MANH NCHAR(7) NOT NULL,
DIEM FLOAT NOT NULL,
PRIMARY KEY(MAHV),
FOREIGN KEY(MANH) REFERENCES NGUOIHOC(MANH) ON DELETE NO ACTION ON UPDATE CASCADE,
FOREIGN KEY (MaKH) REFERENCES KhoaHoc(MaKH) ON DELETE CASCADE
)
GO


-------------
DROP TABLE HOCVIEN


ALTER TABLE HOCVIEN
ADD CONSTRAINT FK_HOCV
  FOREIGN KEY (MAKH)
  REFERENCES KHOAHOC (MAKH);



  --------------------------------------Thủ tục-------------------------------------------
  --Report: MANH - HOTEN -DIEM
  CREATE PROC SP_BANGDIEM(@MAKH INT)
  AS BEGIN
	SELECT NH.MANH,NH.HOTEN,HV.DIEM FROM HOCVIEN HV JOIN NGUOIHOC NH ON NH.MANH=HV.MANH
	WHERE HV.MAKH = @MAKH
	ORDER BY HV.DIEM DESC
END


--REPORT :TENCD - SOHV - THAPNHAT - CAONHAT - TRUNGBINH
CREATE PROC SP_THONGKE
AS BEGIN
	SELECT TENCD CHUYENDE,COUNT(MAHV) SOHV,
	MIN(DIEM) THAPNHAT,
	MAX(DIEM) CAONHAT,
	AVG(DIEM) TRUNGBINH
	FROM KHOAHOC KH JOIN HOCVIEN HV ON KH.MAKH=HV.MAKH
	JOIN CHUYENDE CD ON CD.MACD=KH.MACD
	GROUP BY TENCD
END


--REPORT :TENCD - SOHV - DOANH THU - THAPNHAT - CAONHAT - TRUNGBINH
CREATE PROC SP_THONGKEDOANHTHU(@Year INT)
AS BEGIN
	SELECT
		TenCD ChuyenDe,
		COUNT(DISTINCT kh.MaKH) SoKH,
		COUNT(hv.MaHV) SoHV,
		SUM(kh.HocPhi) DoanhThu,
		MIN(kh.HocPhi) ThapNhat,
		MAX(kh.HocPhi) CaoNhat,
		AVG(kh.HocPhi) TrungBinh
	FROM KhoaHoc kh
		JOIN HocVien hv ON kh.MaKH=hv.MaKH
		JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD
	WHERE YEAR(NgayKG) = @Year
	GROUP BY TenCD
END
GO

--REPORT: NAM - SOLUONG - DAUTIEN - CUOICUNG
CREATE PROC SP_THONGKENGUOIHOC
AS BEGIN
	SELECT
		YEAR(NgayDK) Nam,
		COUNT(*) SoLuong,
		MIN(NgayDK) DauTien,
		MAX(NgayDK) CuoiCung
	FROM NguoiHoc
	GROUP BY YEAR(NgayDK)
END
GO