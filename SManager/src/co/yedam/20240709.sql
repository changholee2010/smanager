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
values('S2024-01', 'ȫ�浿', '010-1234-5678');
insert into tbl_student (std_no, std_name, std_phone, address)
values('S2024-02', '��浿', '010-3333-4444', '���� 100����');
insert into tbl_student (std_no, std_name, std_phone)
values('S2024-03', '��âȣ', '010-5555-7777');

select *
from tbl_student;

update tbl_student
set address = '���� 100'
where std_no = 'S2024-01';

insert into tbl_student (std_no, std_name, std_phone)
values('S2024-04', '��α�', '010-2222-5678');

delete from tbl_student
where std_no = 'S2024-04';

--����, �ּ� ����.
update tbl_student
set    std_name = nvl('', std_name)
      ,std_phone = '���氪'
      ,birth_date = '2020-01-01'
where std_no = 'S2024-02';

select *
from tbl_student;

rollback;
commit;
