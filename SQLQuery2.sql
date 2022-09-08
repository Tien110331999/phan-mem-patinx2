
CREATE DATABASE PATIN


/*==============================================================*/
/* Table: TAI_KHOAN                                             */
/*==============================================================*/
create table TAI_KHOAN 
(
   TENTK                VARCHAR(50)         not null,
   MATKHAU              VARCHAR(25),
   ISADMIN              SMALLINT             not null,
   constraint PK_TAI_KHOAN primary key (TENTK)
);

Insert into TAI_KHOAN VALUES('hoangduc','duc123',0);
Insert into TAI_KHOAN VALUES('thanhngan','ngan123',0);
Insert into TAI_KHOAN VALUES('minhnhat','nhat123',0);
Insert into TAI_KHOAN VALUES('tramy','my123',1);

/*==============================================================*/
/* Table: NHAN_VIEN                                             */
/*==============================================================*/
create table NHAN_VIEN 
(
   MANV                 Char (2)          not null,
   TENTK                VARCHAR(50),
   HOTEN                VARCHAR(50),
   CHUCVU               VARCHAR(15),
   constraint PK_NHAN_VIEN primary key (MANV)
);

Insert into NHAN_VIEN VALUES('01','hoangduc',N'Trần Hoàng Đức','THUNGAN');
Insert into NHAN_VIEN VALUES('02','thanhngan',N'Nguyễn Thanh Ngân','THUNGAN');
Insert into NHAN_VIEN VALUES('03','minhnhat',N'Phạm Minh Nhật','THUNGAN');
Insert into NHAN_VIEN VALUES('04','tramy',N'Đỗ Trà My','QUANLY');

/*==============================================================*/
/* Table: GIAY	                                                */
/*==============================================================*/

create table GIAY 
(
   STTGIAY             char(3)          not null,
   SODAY                VARCHAR(50) ,
   TIENTHUE				BIGINT,
   TIENCOC				BIGINT,
   TINHTRANG            INT,
   constraint PK_PHONG primary key (STTGIAY)
);


Insert into GIAY VALUES('111',"",5000,30000,0);
Insert into GIAY VALUES('112',"",5000,30000,0);
Insert into GIAY VALUES('113',"",5000,30000,0);
Insert into GIAY VALUES('114',"",5000,30000,0);
Insert into GIAY VALUES('115',"",5000,30000,0);
Insert into GIAY VALUES('116',"",5000,30000,0);
Insert into GIAY VALUES('117',"",5000,30000,0);
Insert into GIAY VALUES('118',"",5000,30000,0);
Insert into GIAY VALUES('121',"",5000,30000,0);
Insert into GIAY VALUES('122',"",5000,30000,0);
Insert into GIAY VALUES('123',"",5000,30000,0);
Insert into GIAY VALUES('124',"",5000,30000,0);
Insert into GIAY VALUES('125',"",5000,30000,0);
Insert into GIAY VALUES('126',"",5000,30000,0);
Insert into GIAY VALUES('127',"",5000,30000,0);
Insert into GIAY VALUES('128',"",5000,30000,0);
Insert into GIAY VALUES('131',"",5000,30000,0);
Insert into GIAY VALUES('132',"",5000,30000,0);
Insert into GIAY VALUES('133',"",5000,30000,0);
Insert into GIAY VALUES('134',"",5000,30000,0);
Insert into GIAY VALUES('135',"",5000,30000,0);
Insert into GIAY VALUES('136',"",5000,30000,0);
Insert into GIAY VALUES('137',"",5000,30000,0);
Insert into GIAY VALUES('138',"",5000,30000,0);
Insert into GIAY VALUES('141',"",5000,30000,0);
Insert into GIAY VALUES('142',"",5000,30000,0);
Insert into GIAY VALUES('143',"",5000,30000,0);
Insert into GIAY VALUES('144',"",5000,30000,0);
Insert into GIAY VALUES('145',"",5000,30000,0);
Insert into GIAY VALUES('146',"",5000,30000,0);
Insert into GIAY VALUES('147',"",5000,30000,0);
Insert into GIAY VALUES('148',"",5000,30000,0);
Insert into GIAY VALUES('151',"",5000,30000,0);
Insert into GIAY VALUES('152',"",5000,30000,0);
Insert into GIAY VALUES('153',"",5000,30000,0);
Insert into GIAY VALUES('154',"",5000,30000,0);
Insert into GIAY VALUES('155',"",5000,30000,0);
Insert into GIAY VALUES('156',"",5000,30000,0);
Insert into GIAY VALUES('157',"",5000,30000,0);
Insert into GIAY VALUES('158',"",5000,30000,0);
Insert into GIAY VALUES('211',"",5000,30000,0);
Insert into GIAY VALUES('212',"",5000,30000,0);
Insert into GIAY VALUES('213',"",5000,30000,0);
Insert into GIAY VALUES('214',"",5000,30000,0);
Insert into GIAY VALUES('215',"",5000,30000,0);
Insert into GIAY VALUES('216',"",5000,30000,0);
Insert into GIAY VALUES('217',"",5000,30000,0);
Insert into GIAY VALUES('218',"",5000,30000,0);
Insert into GIAY VALUES('221',"",5000,30000,0);
Insert into GIAY VALUES('222',"",5000,30000,0);
Insert into GIAY VALUES('223',"",5000,30000,0);
Insert into GIAY VALUES('224',"",5000,30000,0);
Insert into GIAY VALUES('225',"",5000,30000,0);
Insert into GIAY VALUES('226',"",5000,30000,0);
Insert into GIAY VALUES('227',"",5000,30000,0);
Insert into GIAY VALUES('228',"",5000,30000,0);
Insert into GIAY VALUES('231',"",5000,30000,0);
Insert into GIAY VALUES('232',"",5000,30000,0);
Insert into GIAY VALUES('233',"",5000,30000,0);
Insert into GIAY VALUES('234',"",5000,30000,0);
Insert into GIAY VALUES('235',"",5000,30000,0);
Insert into GIAY VALUES('236',"",5000,30000,0);
Insert into GIAY VALUES('237',"",5000,30000,0);
Insert into GIAY VALUES('238',"",5000,30000,0);
Insert into GIAY VALUES('241',"",5000,30000,0);
Insert into GIAY VALUES('242',"",5000,30000,0);
Insert into GIAY VALUES('243',"",5000,30000,0);
Insert into GIAY VALUES('244',"",5000,30000,0);
Insert into GIAY VALUES('245',"",5000,30000,0);
Insert into GIAY VALUES('246',"",5000,30000,0);
Insert into GIAY VALUES('247',"",5000,30000,0);
Insert into GIAY VALUES('248',"",5000,30000,0);
Insert into GIAY VALUES('251',"",5000,30000,0);
Insert into GIAY VALUES('252',"",5000,30000,0);
Insert into GIAY VALUES('253',"",5000,30000,0);
Insert into GIAY VALUES('254',"",5000,30000,0);
Insert into GIAY VALUES('255',"",5000,30000,0);
Insert into GIAY VALUES('256',"",5000,30000,0);
Insert into GIAY VALUES('257',"",5000,30000,0);
Insert into GIAY VALUES('258',"",5000,30000,0);
Insert into GIAY VALUES('311',"",5000,30000,0);
Insert into GIAY VALUES('312',"",5000,30000,0);
Insert into GIAY VALUES('313',"",5000,30000,0);
Insert into GIAY VALUES('314',"",5000,30000,0);
Insert into GIAY VALUES('315',"",5000,30000,0);
Insert into GIAY VALUES('316',"",5000,30000,0);
Insert into GIAY VALUES('317',"",5000,30000,0);
Insert into GIAY VALUES('318',"",5000,30000,0);
Insert into GIAY VALUES('321',"",5000,30000,0);
Insert into GIAY VALUES('322',"",5000,30000,0);
Insert into GIAY VALUES('323',"",5000,30000,0);
Insert into GIAY VALUES('324',"",5000,30000,0);
Insert into GIAY VALUES('325',"",5000,30000,0);
Insert into GIAY VALUES('326',"",5000,30000,0);
Insert into GIAY VALUES('327',"",5000,30000,0);
Insert into GIAY VALUES('328',"",5000,30000,0);
Insert into GIAY VALUES('331',"",5000,30000,0);
Insert into GIAY VALUES('332',"",5000,30000,0);
Insert into GIAY VALUES('333',"",5000,30000,0);
Insert into GIAY VALUES('334',"",5000,30000,0);
Insert into GIAY VALUES('335',"",5000,30000,0);
Insert into GIAY VALUES('336',"",5000,30000,0);
Insert into GIAY VALUES('337',"",5000,30000,0);
Insert into GIAY VALUES('338',"",5000,30000,0);
Insert into GIAY VALUES('341',"",5000,30000,0);
Insert into GIAY VALUES('342',"",5000,30000,0);
Insert into GIAY VALUES('343',"",5000,30000,0);
Insert into GIAY VALUES('344',"",5000,30000,0);
Insert into GIAY VALUES('345',"",5000,30000,0);
Insert into GIAY VALUES('346',"",5000,30000,0);
Insert into GIAY VALUES('347',"",5000,30000,0);
Insert into GIAY VALUES('348',"",5000,30000,0);
Insert into GIAY VALUES('351',"",5000,30000,0);
Insert into GIAY VALUES('352',"",5000,30000,0);
Insert into GIAY VALUES('353',"",5000,30000,0);
Insert into GIAY VALUES('354',"",5000,30000,0);
Insert into GIAY VALUES('355',"",5000,30000,0);
Insert into GIAY VALUES('356',"",5000,30000,0);
Insert into GIAY VALUES('357',"",5000,30000,0);
Insert into GIAY VALUES('358',"",5000,30000,0);






/*==============================================================*/
/* Table: DAT_DAY                                            */
/*==============================================================*/
create table DAT_GIAY
(
   MADAT                INT   AUTO_INCREMENT     not null ,
   STTGIAY              Char (3)          not null,
   NGAYDAT              DATE,
   GIOTHUE              INT,
   PHUTTHUE		INT,
   GIOTRA		INT,
   PHUTTRA		INT,
   TIENTHUE		BIGINT,
   MANV			Char (2),
   MANV1		Char (2),
   constraint PK_DAT_PHONG primary key (MADAT)
);


Insert into DAT_GIAY (STTGIAY,NGAYDAT,GIOTHUE,PHUTTHUE,GIOTRA,PHUTTRA,TIENTHUE,MANV) VALUES('111','20220416',9,0,11,0,40000,'01','01');


alter table NHAN_VIEN
   add constraint FK_NHAN_VIE_DANG_NHAP_TAI_KHOA foreign key (TENTK)
      references TAI_KHOAN (TENTK);

alter table DAT_GIAY
   add constraint FK_NHAN_VIEN_DAT_GIAY foreign key (MANV)
      references NHAN_VIEN (MANV);

alter table DAT_GIAY
   add constraint FK_NHAN_VIEN_DAT_GIAY_1 foreign key (MANV)
      references NHAN_VIEN (MANV1);

alter table DAT_GIAY
   add constraint FK_STT_GIAY_DAT foreign key (STTGIAY)
      references GIAY (STTGIAY);