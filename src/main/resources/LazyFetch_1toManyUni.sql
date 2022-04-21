Hibernate: 
    select
        employee0_.id as id1_2_0_,
        employee0_.name as name2_2_0_,
        employee0_.passport_id as passport3_2_0_ 
    from
        employee employee0_ 
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
        addresslis0_.employee_id as employee1_3_0_,
        addresslis0_.address_list_id as address_2_3_0_,
        address1_.id as id1_0_1_,
        address1_.address_line as address_2_0_1_,
        address1_.address_type as address_3_0_1_ 
    from
        employee_address_list addresslis0_ 
    inner join
        address address1_ 
            on addresslis0_.address_list_id=address1_.id 
    where
        addresslis0_.employee_id=?
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
2022-04-21 12:24:55.081  INFO 23480 --- [nio-8080-exec-2] com.service.EmployeeService              : Employee Employee [id=216, name=Y, passport=Passport[197], addressList=[], certification=[com.entity.Certification@6589ff7d, com.entity.Certification@21540ed8]]
