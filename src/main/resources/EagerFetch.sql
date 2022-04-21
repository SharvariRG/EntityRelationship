Hibernate: 
    select
        employee0_.id as id1_2_0_,
        employee0_.name as name2_2_0_,
        employee0_.passport_id as passport3_2_0_,
        passport1_.id as id1_4_1_,
        passport1_.number as number2_4_1_ 
    from
        employee employee0_ 
    left outer join
        passport passport1_ 
            on employee0_.passport_id=passport1_.id 
    where
        employee0_.id=?
Hibernate: 
    select
        addresslis0_.employee_id as employee4_0_0_,
        addresslis0_.id as id1_0_0_,
        addresslis0_.id as id1_0_1_,
        addresslis0_.address_line as address_2_0_1_,
        addresslis0_.address_type as address_3_0_1_,
        addresslis0_.employee_id as employee4_0_1_ 
    from
        address addresslis0_ 
    where
        addresslis0_.employee_id=?
Hibernate: 
    select
        certificat0_.emp_id as emp_id1_3_0_,
        certificat0_.certification_id as certific2_3_0_,
        certificat1_.id as id1_1_1_,
        certificat1_.cert_number as cert_num2_1_1_ 
    from
        employee_certification certificat0_ 
    inner join
        certification certificat1_ 
            on certificat0_.certification_id=certificat1_.id 
    where
        certificat0_.emp_id=?