insert into  product ( product_name,  product_price, product_quantity) values('chocolates', 1.23, 10)
insert into  product ( product_name,  product_price, product_quantity) values('chiclets', 1.1, 11)
insert into  product ( product_name,  product_price, product_quantity) values('wafers', 1.1, 12)

insert into customer([customer_name],[address],[dob]) values ('dimitris', 'athina', '1970-02-01')
insert into customer([customer_name],[address],[dob]) values ('thomas', 'lamia', '1980-02-06')
insert into customer([customer_name],[address],[dob]) values ('nikos', 'patra', '1985-03-04')



insert into customer_order ([date]  ,[customer_id]) values(getdate() , 1)
