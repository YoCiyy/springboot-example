# SpringBoot+Mybatis 四步整合

## **第一步** 添加依赖

**springBoot+Mybatis相关依赖**

```xml
	<!--springBoot相关-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.9.RELEASE</version>
    </parent>

    <!--约定版本-->
    <properties>
        <mybatis-spring-boot>1.2.0</mybatis-spring-boot>
        <mysql-connector>5.1.39</mysql-connector>
    </properties>

    <dependencies>
        <!--springBoot相关-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!--mybatis相关-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>${mybatis-spring-boot}</version>
        </dependency>

        <!--mysql驱动相关-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
        </dependency>

        <!--pojo实用小插件-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <!--依赖不传递-->
            <optional>true</optional>
        </dependency>
    </dependencies>
```


## **第二步** 配置文件 （src/main/resources/application.yml）

```yml
server:
  # 服务端口
  port: 8081

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/springcloud-mybatis
    username: root
    password: 123456
    driver-class-name: com.mysql.jdbc.Driver

# Mybatis 配置
mybatis:
  typeAliasesPackage: com.fame.entity
  mapperLocations: classpath:mapper/*.xml

# 打印sql
logging:
  level:
     # 配置mapper接口的包路径
     com.fame.mapper : debug
```

## 第三步 创建Mybatis Mapper接口、Mapper.xml 以及 Entity

**Mapper接口**

```java
public interface UserMapper {

	/**
	 * 用户列表查询
	 * 
	 * @return 用户信息列表
	 */
	List<User> findAll();

	/**
	 * 新增用户信息
	 * 
	 * @param user 用户信息
	 */
	void add(User user);

	/**
	 * 通过ID获取用户信息
	 * 
	 * @param id 用户ID
	 * @return 用户信息
	 */
	User get(Long id);

	/**
	 * 修改用户信息
	 *
	 * @param user 用户信息
	 */
	void update(User user);

	/**
	 * 删除用户信息
	 * 
	 * @param id 用户ID
	 */
	void delete(long id);
}
```

**UserMapper.xml（src/main/resources/mapper/UserMapper.xml）**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.fame.mapper.UserMapper">
    <resultMap id="BaseResultMap" type="com.fame.entity.User">
        <id column="id" property="id" jdbcType="BIGINT"/>
        <result column="age" property="age" jdbcType="INTEGER"/>
        <result column="password" property="password" jdbcType="VARCHAR"/>
        <result column="username" property="username" jdbcType="VARCHAR"/>
    </resultMap>

    <sql id="Base_Column_List">
    id, age, password, username
  </sql>
    <insert id="add" parameterType="com.fame.entity.User">
        INSERT INTO sys_user(
            <if test="id != null and id != '' ">id,</if>
            <if test="age != null and age != ''">age,</if>
            <if test="password != null and password != ''">password,</if>
            <if test="username != null and username != ''">username</if>
        )VALUES (
            <if test="id != null and id != '' ">#{id},</if>
            <if test="age != null and age != ''">#{age},</if>
            <if test="password != null and password != ''">#{password},</if>
            <if test="username != null and username != ''">#{username}</if>
        )
    </insert>

    <update id="update" parameterType="com.fame.entity.User">
        UPDATE sys_user
        <set>
            <if test="age != null and age != '' ">age = #{age},</if>
            <if test="password != null and password != ''">password = #{password},</if>
            <if test="username != null and username != ''">username = #{username}</if>
        </set>
        WHERE id = #{id}
    </update>

    <delete id="delete" parameterType="java.lang.Long">
        DELETE FROM sys_user WHERE id = #{id}
    </delete>

    <select id="findAll" resultMap="BaseResultMap" parameterType="com.fame.entity.User">
        SELECT
        <include refid="Base_Column_List"/>
        FROM sys_user
    </select>

    <select id="get" parameterType="java.lang.Long" resultMap="BaseResultMap">
        SELECT
        <include refid="Base_Column_List"/>
        FROM sys_user
        WHERE id = #{id}
    </select>

</mapper>
```



**Entity**

```java
@Data
// 开启链式编程
@Accessors(chain = true)
public class User implements Serializable {
	private static final long serialVersionUID = -6510879035056033993L;

	private Long id;
	private Integer age;
	private String password;
	private String username;
}
```

## 第四步 创建Application启动类

如果是直接创建springboot项目可忽略这一步，我是直接创建的一个Maven项目进行整合。

`注意`:加入注解**@MapperScan**进行mapper接口扫描

```java
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("com.fame.mapper")
public class MybatisApplication {
	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}
}
```



这样就整合完成，可以创建接口进行单元测试了

**UserController**

```java
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 查询用户列表
	 */
	@GetMapping("/list")
	public List<User> list() {
		List<User> userList = userMapper.findAll();
		System.out.println(userList);
		return userList;
	}

	/**
	 * 通过ID获取用户信息
	 */
	@GetMapping("/get")
	public User get() {
		return userMapper.get(8L);
	}

	/**
	 * 新增用户信息
	 */
	@PostMapping("/add")
	public void add() {
		User user = new User().setUsername("大白一号").setPassword("dabaiyihao").setAge(22);
		userMapper.add(user);
	}

	/**
	 * 修改用户信息
	 */
	@PutMapping("/update")
	public void update() {
		User user = userMapper.get(1L);
		user.setUsername("大白修改操作");
		userMapper.update(user);
	}

    /**
     * 删除用户信息
     */
    @DeleteMapping("/delete")
	public void delete() {
	    userMapper.delete(9L);
	}

}
```

