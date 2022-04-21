Hibernate: 
    select
        employee0_.id as id1_2_0_,
        employee0_.name as name2_2_0_,
        employee0_.passport_id as passport3_2_0_,
        addresslis1_.employee_id as employee1_3_1_,
        address2_.id as address_2_3_1_,
        address2_.id as id1_0_2_,
        address2_.address_line as address_2_0_2_,
        address2_.address_type as address_3_0_2_ 
    from
        employee employee0_ 
    left outer join
        employee_address_list addresslis1_ 
            on employee0_.id=addresslis1_.employee_id 
    left outer join
        address address2_ 
            on addresslis1_.address_list_id=address2_.id 
    where
        employee0_.id=?
Hibernate: 
    select
        passport0_.id as id1_5_0_,
        passport0_.number as number2_5_0_ 
    from
        passport passport0_ 
    where
        passport0_.id=?
Hibernate: 
    select
        certificat0_.emp_id as emp_id1_4_0_,
        certificat0_.certification_id as certific2_4_0_,
        certificat1_.id as id1_1_1_,
        certificat1_.cert_number as cert_num2_1_1_ 
    from
        employee_certification certificat0_ 
    inner join
        certification certificat1_ 
            on certificat0_.certification_id=certificat1_.id 
    where
        certificat0_.emp_id=?
2022-04-21 12:23:40.187  INFO 23300 --- [nio-8080-exec-2] com.service.EmployeeService              : Employee Employee [id=216, name=Y, passport=Passport[197], addressList=[], certification=[com.entity.Certification@73f3fe36, com.entity.Certification@565180b7]]
