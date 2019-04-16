package com.fame.repository;

import com.fame.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 用户信息 Repo
 * 
 * @author Y.yang
 * @date 2019/4/9
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	/**
	 * 根据username来获取对应的user
	 */
	User getByUsername(String username);

	/**
	 * WHERE username LIKE %?
	 */
	List<User> findByUsernameStartingWith(String username);

	/**
	 * WHERE username LIKE ?%
	 */
	List<User> findByUsernameEndingWith(String username);

	/**
	 * WHERE username id < ?
	 */
	List<User> findByIdLessThan(Long id);

	/**
	 * 查询id 值最大的那个User 使用@Query 主键可以自定义JPQL语句以实现更灵活的查询
	 */
	@Query("SELECT u FROM User u WHERE u.id = (SELECT MAX(p.id) FROM User p)")
	User getMaxIdUser();

    /**
     * @Query 注解传递参数的方式一：占位符方式
     */
    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.age = ?2")
	List<User> testQueryAnnotationUser1(String username , Integer age);

    /**
     * @Query 注解传递参数的方式二：命名参数方式
     */
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.age = :age")
    List<User> testQueryAnnotationUser2(@Param("username") String username , @Param("age")Integer age);

    /**
     * 可以通过自定义的 JPQL 完成 UPDATE 和 DELETE 操作. 注意: JPQL 不支持使用 INSERT
     * 在 @Query 注解中编写 JPQL 语句, 但必须使用 @Modifying 进行修饰. 以通知 SpringData, 这是一个 UPDATE 或 DELETE 操作
     * UPDATE 或 DELETE 操作需要使用事务, 此时需要定义 Service 层. 在 Service 层的方法上添加事务操作.
     * 默认情况下, SpringData 的每个方法上有事务, 但都是一个只读事务. 他们不能完成修改操作!
     */
    @Modifying
    @Query("UPDATE User u SET u.age = :age")
    void updateUserAge(@Param("age") Integer age);

    /**
     * 设置 nativeQuery=true 即可以使用原生的 SQL 查询
     */
    @Query(value = "SELECT COUNT(id) FROM sys_user" , nativeQuery = true)
    long getTotalCount();
}
