create table salary(
 name varchar2(10) primary key,
 pay number not null
);

INSERT INTO salary (name, pay) VALUES ('SMITH', 1000);
INSERT INTO salary (name, pay) VALUES ('PETER', 2000);
INSERT INTO salary (name, pay) VALUES ('JOHN', 3000);
COMMIT;

create or replace procedure adjust(n in varchar2,
                                   rate in float)
is
 newpay float;
begin
	SELECT pay
	INTO newpay
	FROM salary
	WHERE name = n;
	
	-- 인상된 급여
	newpay := newpay + newpay * rate;
	
	UPDATE salary SET pay = newpay WHERE name = n;
	COMMIT;
	
	exception when others then
	dbms_output.put_line('error occured');
	ROLLBACK;
end;