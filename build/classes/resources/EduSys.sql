USE [master]
GO

CREATE DATABASE [DBDAM]
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DBDAM].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
USE [DBDAM]
GO
/****** Object:  StoredProcedure [dbo].[SP_BANGDIEM]    Script Date: 10/18/2021 2:23:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_BANGDIEM](@MaKH INT)
AS BEGIN
	SELECT
		nh.MaNH,
		nh.HoTen,
		hv.Diem
	FROM HocVien hv
		JOIN NguoiHoc nh ON nh.MaNH=hv.MaNH
	WHERE hv.MaKH = @MaKH
	ORDER BY hv.Diem DESC
END

GO
/****** Object:  StoredProcedure [dbo].[SP_THONGKE]    Script Date: 10/18/2021 2:23:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_THONGKE]
AS BEGIN
	SELECT
		TenCD ChuyenDe,
		COUNT(MaHV) SoHV,
		MIN(Diem) ThapNhat,
		MAX(Diem) CaoNhat,
		AVG(Diem) TrungBinh
	FROM KhoaHoc kh
		JOIN HocVien hv ON kh.MaKH=hv.MaKH
		JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD
	GROUP BY TenCD
END

GO
/****** Object:  StoredProcedure [dbo].[SP_THONGKEDOANHTHU]    Script Date: 10/18/2021 2:23:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_THONGKEDOANHTHU](@Year INT)
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
/****** Object:  StoredProcedure [dbo].[SP_THONGKENGUOIHOC]    Script Date: 10/18/2021 2:23:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_THONGKENGUOIHOC]
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
/****** Object:  Table [dbo].[ChuyenDe]    Script Date: 10/18/2021 2:23:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChuyenDe](
	[MaCD] [nchar](5) NOT NULL,
	[TenCD] [nvarchar](50) NOT NULL,
	[HocPhi] [float] NOT NULL CONSTRAINT [DF_ChuyenDe_HocPhi]  DEFAULT ((0)),
	[ThoiLuong] [int] NOT NULL CONSTRAINT [DF_ChuyenDe_ThoiLuong]  DEFAULT ((30)),
	[Hinh] [nvarchar](50) NOT NULL CONSTRAINT [DF_ChuyenDe_Hinh]  DEFAULT (N'chuyen-de.png'),
	[MoTa] [nvarchar](255) NOT NULL CONSTRAINT [DF_ChuyenDe_MoTa]  DEFAULT (''),
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_ChuyenDe] PRIMARY KEY CLUSTERED 
(
	[MaCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HocVien]    Script Date: 10/18/2021 2:23:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HocVien](
	[MaHV] [int] IDENTITY(1,1) NOT NULL,
	[MaKH] [int] NOT NULL,
	[MaNH] [nchar](7) NOT NULL,
	[Diem] [float] NOT NULL CONSTRAINT [DF_HocVien_Diem]  DEFAULT ((0)),
 CONSTRAINT [PK_HocVien] PRIMARY KEY CLUSTERED 
(
	[MaHV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhoaHoc]    Script Date: 10/18/2021 2:23:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhoaHoc](
	[MaKH] [int] IDENTITY(1,1) NOT NULL,
	[MaCD] [nchar](5) NOT NULL,
	[HocPhi] [float] NOT NULL CONSTRAINT [DF_KhoaHoc_HocPhi]  DEFAULT ((0)),
	[Thoigian] [int] NOT NULL CONSTRAINT [DF_KhoaHoc_Thoigian]  DEFAULT ((0)),
	[NgayKG] [date] NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
	[MaNV] [nvarchar](50) NOT NULL,
	[NgayTao] [date] NOT NULL CONSTRAINT [DF_KhoaHoc_NgayTao]  DEFAULT (getdate()),
 CONSTRAINT [PK_KhoaHoc] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NguoiHoc]    Script Date: 10/18/2021 2:23:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiHoc](
	[MaNH] [nchar](7) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL CONSTRAINT [DF_NguoiHoc_GioiTinh]  DEFAULT ((0)),
	[DienThoai] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](max) NULL,
	[MaNV] [nvarchar](50) NOT NULL,
	[NgayDK] [date] NOT NULL CONSTRAINT [DF_NguoiHoc_NgayDK]  DEFAULT (getdate()),
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_NguoiHoc] PRIMARY KEY CLUSTERED 
(
	[MaNH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/18/2021 2:23:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](50) NOT NULL,
	[MatKhau] [nvarchar](50) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[VaiTro] [bit] NOT NULL CONSTRAINT [DF_QuanTri_VaiTro]  DEFAULT ((0)),
	[Email] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_QuanTri] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'JAV02', N'Lập trình Java nâng cao', 300, 90, N'HTCS.jpg', N'JAV02 - Lập trình Java nâng cao', 0)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'JAV03', N'Lập trình mạng với Java', 200, 70, N'INMA.jpg', N'JAV03 - Lập trình mạng với Java', 0)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'JAV04', N'Lập trình desktop với Swing', 200, 100, N'LAYO.jpg', N'JAV04 - Lập trình desktop với Swing', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'PRO01', N'Dự án với công nghệ MS.NET MVC', 300, 90, N'MOWE.png', N'PRO01 - Dự án với công nghệ MS.NET MVC', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'PRO04', N'Dự án với AngularJS & WebAPI', 300, 90, N'HTCS.jpg', N'PRO04 - Dự án với AngularJS & WebAPI', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'PRO05', N'Dự án với Swing & JDBC', 300, 90, N'INMA.jpg', N'PRO05 - Dự án với Swing & JDBC', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'PRO06', N'Dự án với WindowForm', 300, 90, N'LAYO.jpg', N'PRO06 - Dự án với WindowForm', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'RDB01', N'Cơ sở dữ liệu SQL Server', 100, 50, N'MOWE.png', N'RDB01 - Cơ sở dữ liệu SQL Server', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'RDB02', N'Lập trình JDBC', 150, 60, N'Subject.png', N'RDB02 - Lập trình JDBC', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'RDB03', N'Lập trình cơ sở dữ liệu Hibernate', 250, 80, N'GAME.png', N'RDB03 - Lập trình cơ sở dữ liệu Hibernate', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'SER01', N'Lập trình web với Servlet/JSP', 350, 100, N'HTCS.jpg', N'SER01 - Lập trình web với Servlet/JSP', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'SER02', N'Lập trình Spring MVC', 400, 110, N'INMA.jpg', N'SER02 - Lập trình Spring MVC', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'SER03', N'Lập trình MS.NET MVC', 400, 110, N'LAYO.jpg', N'SER03 - Lập trình MS.NET MVC', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'SER04', N'Xây dựng Web API với Spring MVC & ASP.NET MVC', 200, 70, N'MOWE.png', N'SER04 - Xây dựng Web API với Spring MVC & ASP.NET MVC', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'THANH', N'Than', 111111, 100, N'67407534_465206764333003_5213630654238949376_n.jpg', N'', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'WEB01', N'Thiết kế web với HTML và CSS', 200, 70, N'Subject.png', N'WEB01 - Thiết kế web với HTML và CSS', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'WEB02', N'Thiết kế web với Bootstrap', 0, 40, N'GAME.png', N'WEB02 - Thiết kế web với Bootstrap', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'WEB03', N'Lập trình front-end với JavaScript và jQuery', 150, 60, N'HTCS.jpg', N'WEB03 - Lập trình front-end với JavaScript và jQuery', 1)
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa], [TrangThai]) VALUES (N'WEB04', N'Lập trình AngularJS', 250, 80, N'INMA.jpg', N'WEB04 - Lập trình AngularJS', 1)
SET IDENTITY_INSERT [dbo].[HocVien] ON 

INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (11, 3, N'PS01638', 0)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (12, 3, N'PS02037', 0)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (14, 3, N'PS02867', 0)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (15, 3, N'PS02930', 0)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (45, 6, N'PS01638', 9)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (46, 6, N'PS02037', 10)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (48, 7, N'PS02867', 9)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (49, 6, N'PS02867', 7)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (50, 7, N'PS02979', 10)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (51, 6, N'PS03046', 8)
SET IDENTITY_INSERT [dbo].[HocVien] OFF
SET IDENTITY_INSERT [dbo].[KhoaHoc] ON 

INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [Thoigian], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (3, N'RDB01', 100, 50, CAST(N'2021-01-10' AS Date), N'', N'Manh', CAST(N'2017-12-31' AS Date))
INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [Thoigian], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (6, N'JAV02', 300, 90, CAST(N'2021-11-10' AS Date), N'', N'Manh', CAST(N'2021-10-15' AS Date))
INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [Thoigian], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (7, N'JAV02', 300, 90, CAST(N'2021-11-15' AS Date), N'', N'Manh', CAST(N'2021-10-16' AS Date))
INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [Thoigian], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (8, N'THANH', 111111, 100, CAST(N'2022-11-15' AS Date), N'', N'Manh', CAST(N'2021-10-16' AS Date))
INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [Thoigian], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (9, N'THANH', 0, 0, CAST(N'2022-11-17' AS Date), N'', N'Manh', CAST(N'2021-10-18' AS Date))
SET IDENTITY_INSERT [dbo].[KhoaHoc] OFF
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS01638', N'LỮ HUY CƯỜNG', CAST(N'1991-05-08' AS Date), 1, N'0928768265', N'PS01638@fpt.edu.vn', N'0928768265 - LỮ HUY CƯỜNG', N'Manh', CAST(N'2021-10-12' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS02037', N'ĐỖ VĂN MINH', CAST(N'1992-10-24' AS Date), 0, N'0968095685', N'PS02037@fpt.edu.vn', N'0968095685 - ĐỖ VĂN MINH', N'Manh', CAST(N'2021-10-16' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS02867', N'NGUYỄN HỮU TRÍ', CAST(N'1997-10-10' AS Date), 1, N'0946984711', N'PS02867@fpt.edu.vn', N'0946984711 - NGUYỄN HỮU TRÍ', N'Manh', CAST(N'2021-10-16' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS02930', N'TRẦN VĂN NAM', CAST(N'2000-06-03' AS Date), 0, N'0924774498', N'PS02930@fpt.edu.vn', N'0924774498 - TRẦN VĂN NAM', N'Manh', CAST(N'2021-10-16' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS02979', N'ĐOÀN TRẦN NHẬT VŨ', CAST(N'1994-08-28' AS Date), 1, N'0912374818', N'PS02979@fpt.edu.vn', N'0912374818 - ĐOÀN TRẦN NHẬT VŨ', N'Thong', CAST(N'1994-08-28' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS02983', N'NGUYỄN HOÀNG THIÊN PHƯỚC', CAST(N'1993-04-04' AS Date), 1, N'0912499836', N'PS02983@fpt.edu.vn', N'0912499836 - NGUYỄN HOÀNG THIÊN PHƯỚC', N'Manh', CAST(N'1993-04-04' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS02988', N'HỒ HỮU HẬU', CAST(N'1993-02-08' AS Date), 1, N'0924984876', N'PS02988@fpt.edu.vn', N'0924984876 - HỒ HỮU HẬU', N'Manh', CAST(N'1993-02-08' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03031', N'PHAN TẤN VIỆT', CAST(N'1990-04-05' AS Date), 1, N'0924832716', N'PS03031@fpt.edu.vn', N'0924832716 - PHAN TẤN VIỆT', N'Manh', CAST(N'1990-04-05' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03046', N'NGUYỄN CAO PHƯỚC', CAST(N'1990-01-28' AS Date), 1, N'0977117727', N'PS03046@fpt.edu.vn', N'0977117727 - NGUYỄN CAO PHƯỚC', N'Manh', CAST(N'1990-01-28' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03080', N'HUỲNH THANH HUY', CAST(N'1994-09-06' AS Date), 1, N'0916436052', N'PS03080@fpt.edu.vn', N'0916436052 - HUỲNH THANH HUY', N'Manh', CAST(N'1994-09-06' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03088', N'NGUYỄN HOÀNG TRUNG', CAST(N'1991-09-02' AS Date), 1, N'0938101529', N'PS03088@fpt.edu.vn', N'0938101529 - NGUYỄN HOÀNG TRUNG', N'Manh', CAST(N'1991-09-02' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03096', N'ĐOÀN HỮU KHANG', CAST(N'1994-02-21' AS Date), 1, N'0945196719', N'PS03096@fpt.edu.vn', N'0945196719 - ĐOÀN HỮU KHANG', N'Duong', CAST(N'1994-02-21' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03104', N'LÊ THÀNH PHƯƠNG', CAST(N'1993-02-21' AS Date), 1, N'0922948096', N'PS03104@fpt.edu.vn', N'0922948096 - LÊ THÀNH PHƯƠNG', N'Duong', CAST(N'1993-02-21' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03120', N'PHẠM NGỌC NHẬT TRƯỜNG', CAST(N'1999-06-24' AS Date), 1, N'0994296169', N'PS03120@fpt.edu.vn', N'0994296169 - PHẠM NGỌC NHẬT TRƯỜNG', N'Duong', CAST(N'1999-06-24' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03130', N'ĐẶNG BẢO VIỆT', CAST(N'1990-02-14' AS Date), 1, N'0917749344', N'PS03130@fpt.edu.vn', N'0917749344 - ĐẶNG BẢO VIỆT', N'Manh', CAST(N'1990-02-14' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03134', N'LÊ DUY BẢO', CAST(N'1996-08-08' AS Date), 1, N'0926714368', N'PS03134@fpt.edu.vn', N'0926714368 - LÊ DUY BẢO', N'Manh', CAST(N'1996-08-08' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03172', N'NGUYỄN ANH TUẤN', CAST(N'1992-02-15' AS Date), 1, N'0920020472', N'PS03172@fpt.edu.vn', N'0920020472 - NGUYỄN ANH TUẤN', N'Manh', CAST(N'1992-02-15' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03202', N'PHAN QUỐC QUI', CAST(N'1996-02-04' AS Date), 1, N'0930649274', N'PS03202@fpt.edu.vn', N'0930649274 - PHAN QUỐC QUI', N'Thong', CAST(N'1996-02-04' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03203', N'ĐẶNG LÊ QUANG VINH', CAST(N'1990-01-02' AS Date), 1, N'0920197355', N'PS03203@fpt.edu.vn', N'0920197355 - ĐẶNG LÊ QUANG VINH', N'Duong', CAST(N'1990-01-02' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03205', N'NGUYỄN MINH SANG', CAST(N'1995-05-02' AS Date), 1, N'0967006218', N'PS03205@fpt.edu.vn', N'0967006218 - NGUYỄN MINH SANG', N'Manh', CAST(N'1995-05-02' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03222', N'TRẦM MINH MẪN', CAST(N'1997-02-09' AS Date), 1, N'0911183649', N'PS03222@fpt.edu.vn', N'0911183649 - TRẦM MINH MẪN', N'Manh', CAST(N'1997-02-09' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03230', N'NGUYỄN PHẠM MINH HÂN', CAST(N'2000-10-14' AS Date), 1, N'0983469892', N'PS03230@fpt.edu.vn', N'0983469892 - NGUYỄN PHẠM MINH HÂN', N'Manh', CAST(N'2000-10-14' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03233', N'LƯU KIM HOÀNG DUY', CAST(N'1996-07-04' AS Date), 1, N'0938357735', N'PS03233@fpt.edu.vn', N'0938357735 - LƯU KIM HOÀNG DUY', N'Manh', CAST(N'1996-07-04' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03251', N'TRẦN QUANG VŨ', CAST(N'2000-03-10' AS Date), 1, N'0914531913', N'PS03251@fpt.edu.vn', N'0914531913 - TRẦN QUANG VŨ', N'Duong', CAST(N'2000-03-10' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03304', N'BÙI NGỌC THUẬN', CAST(N'1995-01-26' AS Date), 1, N'0999794115', N'PS03304@fpt.edu.vn', N'0999794115 - BÙI NGỌC THUẬN', N'Thong', CAST(N'1995-01-26' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03306', N'HỒ VĂN HÀNH', CAST(N'1992-04-15' AS Date), 1, N'0912277868', N'PS03306@fpt.edu.vn', N'0912277868 - HỒ VĂN HÀNH', N'Manh', CAST(N'1992-04-15' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03308', N'TRẦN VIẾT HÙNG', CAST(N'1999-02-24' AS Date), 1, N'0916050164', N'PS03308@fpt.edu.vn', N'0916050164 - TRẦN VIẾT HÙNG', N'Duong', CAST(N'1999-02-24' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03325', N'NGUYỄN HOÀNG MINH ĐỨC', CAST(N'1996-12-11' AS Date), 1, N'0912234437', N'PS03325@fpt.edu.vn', N'0912234437 - NGUYỄN HOÀNG MINH ĐỨC', N'Thong', CAST(N'1996-12-11' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03346', N'PHAN THANH PHONG', CAST(N'1990-01-21' AS Date), 1, N'0937891282', N'PS03346@fpt.edu.vn', N'0937891282 - PHAN THANH PHONG', N'Manh', CAST(N'1990-01-21' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03383', N'TRẦN VŨ LUÂN', CAST(N'1998-04-08' AS Date), 1, N'0962030316', N'PS03383@fpt.edu.vn', N'0962030316 - TRẦN VŨ LUÂN', N'Duong', CAST(N'1998-04-08' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03389', N'VŨ ĐỨC TUẤN', CAST(N'1993-02-24' AS Date), 1, N'0911637415', N'PS03389@fpt.edu.vn', N'0911637415 - VŨ ĐỨC TUẤN', N'Thong', CAST(N'1993-02-24' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03410', N'TRẦN  NHẠT', CAST(N'1992-06-08' AS Date), 1, N'0946219377', N'PS03410@fpt.edu.vn', N'0946219377 - TRẦN  NHẠT', N'Manh', CAST(N'1992-06-08' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03411', N'TRƯƠNG THÀNH ĐẠT', CAST(N'1993-11-05' AS Date), 1, N'0991509408', N'PS03411@fpt.edu.vn', N'0991509408 - TRƯƠNG THÀNH ĐẠT', N'Duong', CAST(N'1993-11-05' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03425', N'TÔ VĂN NĂNG', CAST(N'1992-07-28' AS Date), 1, N'0915134551', N'PS03425@fpt.edu.vn', N'0915134551 - TÔ VĂN NĂNG', N'Thong', CAST(N'1992-07-28' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03454', N'NGUYỄN NHẬT VĨNH', CAST(N'1999-07-09' AS Date), 1, N'0917886371', N'PS03454@fpt.edu.vn', N'0917886371 - NGUYỄN NHẬT VĨNH', N'Manh', CAST(N'1999-07-09' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03472', N'NGUYỄN VĂN HUY', CAST(N'1990-01-22' AS Date), 1, N'0960620997', N'PS03472@fpt.edu.vn', N'0960620997 - NGUYỄN VĂN HUY', N'Duong', CAST(N'1990-01-22' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03488', N'NGUYỄN NHƯ NGỌC', CAST(N'1995-05-09' AS Date), 0, N'0912880267', N'PS03488@fpt.edu.vn', N'0912880267 - NGUYỄN NHƯ NGỌC', N'Thong', CAST(N'1995-05-09' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03530', N'PHẠM THÀNH TÂM', CAST(N'2000-03-11' AS Date), 1, N'0918161783', N'PS03530@fpt.edu.vn', N'0918161783 - PHẠM THÀNH TÂM', N'Manh', CAST(N'2000-03-11' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03553', N'ĐINH TẤN CÔNG', CAST(N'2000-08-15' AS Date), 1, N'0918182551', N'PS03553@fpt.edu.vn', N'0918182551 - ĐINH TẤN CÔNG', N'Duong', CAST(N'2000-08-15' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03561', N'LÊ MINH ĐIỀN', CAST(N'1995-01-05' AS Date), 1, N'0948199564', N'PS03561@fpt.edu.vn', N'0948199564 - LÊ MINH ĐIỀN', N'Thong', CAST(N'1995-01-05' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03596', N'NGUYỄN THANH HIỀN', CAST(N'1991-07-09' AS Date), 1, N'0910545901', N'PS03596@fpt.edu.vn', N'0910545901 - NGUYỄN THANH HIỀN', N'Manh', CAST(N'1991-07-09' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03603', N'LÊ PHẠM KIM THANH', CAST(N'1994-08-05' AS Date), 0, N'0924696779', N'PS03603@fpt.edu.vn', N'0924696779 - LÊ PHẠM KIM THANH', N'Duong', CAST(N'1994-08-05' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03610', N'TRẦN ĐÌNH TRƯỜNG', CAST(N'1995-01-16' AS Date), 1, N'0941528106', N'PS03610@fpt.edu.vn', N'0941528106 - TRẦN ĐÌNH TRƯỜNG', N'Thong', CAST(N'1995-01-16' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03614', N'NGUYỄN VĂN SÁU', CAST(N'1990-04-27' AS Date), 1, N'0940711328', N'PS03614@fpt.edu.vn', N'0940711328 - NGUYỄN VĂN SÁU', N'Manh', CAST(N'1990-04-27' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03618', N'PHÍ ĐÌNH VIỆT HÙNG', CAST(N'1996-12-09' AS Date), 1, N'0939020097', N'PS03618@fpt.edu.vn', N'0939020097 - PHÍ ĐÌNH VIỆT HÙNG', N'Duong', CAST(N'1996-12-09' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03638', N'PHẠM NHẬT MINH', CAST(N'1997-07-18' AS Date), 1, N'0927771672', N'PS03638@fpt.edu.vn', N'0927771672 - PHẠM NHẬT MINH', N'Thong', CAST(N'1997-07-18' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03640', N'LƯU THANH NGỌC', CAST(N'1993-12-01' AS Date), 0, N'0918358164', N'PS03640@fpt.edu.vn', N'0918358164 - LƯU THANH NGỌC', N'Manh', CAST(N'1993-12-01' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03662', N'NGUYỄN CAO NGỌC LỢI', CAST(N'1990-04-24' AS Date), 1, N'0930260679', N'PS03662@fpt.edu.vn', N'0930260679 - NGUYỄN CAO NGỌC LỢI', N'Duong', CAST(N'1990-04-24' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS03674', N'TRẦN TUẤN ANH', CAST(N'1996-06-11' AS Date), 1, N'0914082094', N'PS03674@fpt.edu.vn', N'0914082094 - TRẦN TUẤN ANH', N'Thong', CAST(N'1996-06-11' AS Date), 1)
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK], [TrangThai]) VALUES (N'PS12   ', N'Mạnh', CAST(N'2002-02-10' AS Date), 0, N'0988307480', N'manh@gmail.com', N'', N'Manh', CAST(N'2021-10-18' AS Date), 0)
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [HoTen], [VaiTro], [Email], [TrangThai]) VALUES (N'Duong', N'c4ca4238a0b923820dcc509a6f75849b', N'Đỗ Văn Dương', 1, N'duongdv14918@fpt.edu.vn', 1)
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [HoTen], [VaiTro], [Email], [TrangThai]) VALUES (N'Manh', N'c81e728d9d4c2f636f067f89cc14862c', N'Phạm  Mạnh', 1, N'manh1qn@gmail.com', 1)
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [HoTen], [VaiTro], [Email], [TrangThai]) VALUES (N'Manh2', N'c81e728d9d4c2f636f067f89cc14862c', N'Mạnh', 1, N'manh@gmail.com', 0)
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [HoTen], [VaiTro], [Email], [TrangThai]) VALUES (N'Thong', N'202cb962ac59075b964b07152d234b70', N'Hoàng Trung Thông', 0, N'anhthong645@gmail.com', 1)
ALTER TABLE [dbo].[HocVien]  WITH CHECK ADD  CONSTRAINT [FK_HocVien_KhoaHoc] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhoaHoc] ([MaKH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HocVien] CHECK CONSTRAINT [FK_HocVien_KhoaHoc]
GO
ALTER TABLE [dbo].[HocVien]  WITH CHECK ADD  CONSTRAINT [FK_HocVien_NguoiHoc] FOREIGN KEY([MaNH])
REFERENCES [dbo].[NguoiHoc] ([MaNH])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HocVien] CHECK CONSTRAINT [FK_HocVien_NguoiHoc]
GO
ALTER TABLE [dbo].[KhoaHoc]  WITH CHECK ADD  CONSTRAINT [FK_KhoaHoc_ChuyenDe] FOREIGN KEY([MaCD])
REFERENCES [dbo].[ChuyenDe] ([MaCD])
GO
ALTER TABLE [dbo].[KhoaHoc] CHECK CONSTRAINT [FK_KhoaHoc_ChuyenDe]
GO
ALTER TABLE [dbo].[KhoaHoc]  WITH CHECK ADD  CONSTRAINT [FK_KhoaHoc_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[KhoaHoc] CHECK CONSTRAINT [FK_KhoaHoc_NhanVien]
GO
ALTER TABLE [dbo].[NguoiHoc]  WITH CHECK ADD  CONSTRAINT [FK_NguoiHoc_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[NguoiHoc] CHECK CONSTRAINT [FK_NguoiHoc_NhanVien]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mã chuyên đề, PK' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ChuyenDe', @level2type=N'COLUMN',@level2name=N'MaCD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tên chuyên đề, Unique' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ChuyenDe', @level2type=N'COLUMN',@level2name=N'TenCD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Học phí' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ChuyenDe', @level2type=N'COLUMN',@level2name=N'HocPhi'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Thời lượng (ngày)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ChuyenDe', @level2type=N'COLUMN',@level2name=N'ThoiLuong'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Hình logo' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ChuyenDe', @level2type=N'COLUMN',@level2name=N'Hinh'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mô tả chuyên đề' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ChuyenDe', @level2type=N'COLUMN',@level2name=N'MoTa'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mã học viên, PK' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'HocVien', @level2type=N'COLUMN',@level2name=N'MaHV'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mã khóa học, FK' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'HocVien', @level2type=N'COLUMN',@level2name=N'MaKH'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mã người học, FK' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'HocVien', @level2type=N'COLUMN',@level2name=N'MaNH'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Điểm' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'HocVien', @level2type=N'COLUMN',@level2name=N'Diem'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mã khách hàng, PK' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'KhoaHoc', @level2type=N'COLUMN',@level2name=N'MaKH'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mã chuyên đề, FK' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'KhoaHoc', @level2type=N'COLUMN',@level2name=N'MaCD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Học phí' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'KhoaHoc', @level2type=N'COLUMN',@level2name=N'HocPhi'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Thời lượng (ngày)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'KhoaHoc', @level2type=N'COLUMN',@level2name=N'Thoigian'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Ngày khai giảng' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'KhoaHoc', @level2type=N'COLUMN',@level2name=N'NgayKG'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Ghi chú' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'KhoaHoc', @level2type=N'COLUMN',@level2name=N'GhiChu'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mã người tạo, FK' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'KhoaHoc', @level2type=N'COLUMN',@level2name=N'MaNV'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Ngày tạo' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'KhoaHoc', @level2type=N'COLUMN',@level2name=N'NgayTao'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mã người học, PK' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NguoiHoc', @level2type=N'COLUMN',@level2name=N'MaNH'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Họ và tên' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NguoiHoc', @level2type=N'COLUMN',@level2name=N'HoTen'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Ngày sinh' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NguoiHoc', @level2type=N'COLUMN',@level2name=N'NgaySinh'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Giới tính' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NguoiHoc', @level2type=N'COLUMN',@level2name=N'GioiTinh'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Điện thoại' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NguoiHoc', @level2type=N'COLUMN',@level2name=N'DienThoai'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Địa chỉ email' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NguoiHoc', @level2type=N'COLUMN',@level2name=N'Email'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Ghi chú' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NguoiHoc', @level2type=N'COLUMN',@level2name=N'GhiChu'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mã người tạo, FK' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NguoiHoc', @level2type=N'COLUMN',@level2name=N'MaNV'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Ngày tạo' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NguoiHoc', @level2type=N'COLUMN',@level2name=N'NgayDK'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mã nhân viên, PK' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NhanVien', @level2type=N'COLUMN',@level2name=N'MaNV'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mật khẩu' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NhanVien', @level2type=N'COLUMN',@level2name=N'MatKhau'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Họ và tên' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NhanVien', @level2type=N'COLUMN',@level2name=N'HoTen'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Vai trò, 1-trưởng phòng' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NhanVien', @level2type=N'COLUMN',@level2name=N'VaiTro'
GO
