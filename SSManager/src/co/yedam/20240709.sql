create table tbl_student (
  std_no varchar2(10) primary key,
  std_name varchar2(100) not null,
  std_phone varchar2(20), -- 010-1111-2222
  address varchar2(100),
  birth_date date,
  creation_date date default sysdate
);

-- sample data.
insert into tbl_student (std_no, std_name, std_phone)
values('S2024-01', '홍길동', '010-1234-5678');
insert into tbl_student (std_no, std_name, std_phone, address)
values('S2024-02', '김길동', '010-3333-4444', '서울 100번지');
insert into tbl_student (std_no, std_name, std_phone)
values('S2024-03', '이창호', '010-5555-7777');

select *
from tbl_student;

update tbl_student
set address = '대전 100'
where std_no = 'S2024-01';

insert into tbl_student (std_no, std_name, std_phone)
values('S2024-04', '김민규', '010-2222-5678');

delete from tbl_student
where std_no = 'S2024-04';

--생일, 주소 변경.
update tbl_student
set    std_name = nvl('', std_name)
      ,std_phone = '변경값'
      ,birth_date = '2020-01-01'
where std_no = 'S2024-02';

select *
from tbl_student;

rollback;
commit;
