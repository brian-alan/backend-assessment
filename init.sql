create table Tbl_Profiles (
    IdProfile int primary key auto_increment,
    Profile varchar(40) not null
);

create table Tbl_Users(
    IdUser int primary key auto_increment,
    UserName varchar(50) not null,
    password varchar(30) not null,
    IdProfile int not null,
    foreign key(IdProfile) references Tbl_Profiles(IdProfile),
    IdEmployee int not null,
    Status int not null,
    CreatedDate date not null,
    UpdateDate date not null,
    Login int not null
);

INSERT INTO Tbl_Profiles VALUES(1, "Alan");
INSERT INTO Tbl_Profiles VALUES(2, "Brian");
INSERT INTO Tbl_Profiles VALUES(3, "Luis");

INSERT INTO Tbl_Users values(1,"Test","pass123",1,1,0,"2021-12-21","2021-12-21",0);
INSERT INTO Tbl_Users values(2,"Test2","pass123",2,1,0,"2021-12-21","2021-12-21",0);