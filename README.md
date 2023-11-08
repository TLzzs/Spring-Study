# Spring-Study

A path of learning Spring technology (Springboot)

So far covered
1. JPA Introduction
  - Data Access Object (DAO)
  - @Entity         Class
  - @Column         feature
  - @Table          table_name
  - @Autowired      inject bean
  - @Transactional  handle commit of ql query
  - EntityManager   CRUD DB
2. REST API + JPA (exception class)
  - Controller @RequestMapping
  - @Component (@RestController @Service @Repository)
  - @PostConstruct
  - Exception Class @ControllerAdvice @ExceptionHandler
3. REST API + JPA Employee Project (introduce Spring Data JPA)
  - JpaRepository<Entity, Id> replace DAO
  - Service Layer between Controller and DAO
  - CRUD process
  - @PathVariable @RequestBody
4. Aspect Oriented Programming ( different type of advice , Pointcut)

run docker using MySQL Image 

docker pull mysql
docker run --name JPADB -e MYSQL_ROOT_PASSWORD={your password} -p 3306:3306 -d mysql

Corresponding setup SQL file inside each modulus under SQL_File directory
Pls run the set up file in DB 

in application.properties
- spring.datasource.url=jdbc:mysql://localhost:3306/{db_name}
- spring.datasource.username={username}
- spring.datasource.password={password}
