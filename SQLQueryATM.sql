create database ATM
go
use ATM
go
create table khachhang(
	makh int identity(100,1) primary key,
	ho nvarchar(50) not null,
	ten nvarchar(50) not null,
	cmnd int not null,
	ngaysinh varchar(10) not null,
	trangthai varchar(15)	
)
go
INSERT INTO khachhang VALUES (N'Hồ', N'Văn Nhân',236589748,'06-01-1998','active'); 
INSERT INTO khachhang VALUES (N'Hồ', N'Văn Hậu',236589748,'06-01-1998','active'); 
INSERT INTO khachhang VALUES (N'Hồ', N'Văn Phúc',236589748,'06-01-1998','active'); 
INSERT INTO khachhang VALUES (N'Hồ', N'Văn Lộc',236589748,'06-01-1998','active'); 
INSERT INTO khachhang VALUES (N'Hồ', N'Văn Thọ',236589748,'06-01-1998','active'); 
go
create table Taikhoan(
	matk int identity(100,1) primary key,
	makh int  FOREIGN KEY (makh) REFERENCES khachhang(makh),
	sodu decimal(18,2) not null,
	matkhau varchar(6) check (matkhau like ('[0-9][0-9][0-9][0-9][0-9][0-9]')) not null,
	lastaccess varchar(10) not null,
	trangthai varchar(15)
)
go
INSERT INTO Taikhoan VALUES (101, 290000000,'123456','27-08-18','active');
INSERT INTO Taikhoan VALUES (102, 23000,'654789','27-08-18','active'); 
go
create table giaodich(
	magd int identity(100,1) primary key,
	matk int FOREIGN KEY REFERENCES Taikhoan(matk),
	ngaygio varchar(10) not null,
	tacvu nvarchar(50) not null,
	mota nvarchar(225) ,
	sotiensaugd decimal(18,2),
	sotiengd decimal(18,2)
)
go
create table giaodichtd(
	matk int FOREIGN KEY (matk) REFERENCES taikhoan(matk),
	matknhan int FOREIGN KEY (matknhan) REFERENCES taikhoan(matk),
	loaigd nvarchar(50) not null,
	mota nvarchar(255),
	hanmuc decimal(18,2),
	primary key(matk,matknhan)
)
go






