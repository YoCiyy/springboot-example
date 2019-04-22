# Swagger2基本使用-常用注解

## 接口/方法常用注解

```java
/**
 * Swagger接口测试
 * 
 * @author Y.yang
 * @date 2019/3/12
 */
@Api(value = "用户信息", tags = { "用户信息" })
@RestController
public class UserController {

	@ApiOperation(value = "用户信息分页查询")
	@GetMapping("/page")
	public String page(User user) {
		return "Hello Swagger2";
	}

	@ApiOperation(value = "用户信息查询")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "file", value = "文件导入", required = true, dataType = "MultipartFile")
	})
	@GetMapping("/id")
	public UserVo getUser(Long id, MultipartFile file) {
		return new UserVo();
	}
}
```

### @Api: 描述类/接口的主要用途

用于类；表示标识这个类是swagger的资源 
tags–表示说明 
value–也是说明，不会显示在接口文档上，可以使用tags替代 

**但是tags如果有多个值，会生成多个list**

```java
@Api(value = "用户信息", tags = { "用户信息" })
```

### @ApiOperation: 描述方法用途

```java
@ApiOperation(value = "用户信息分页查询")
```

### @ApiImplicitParam: 描述方法的参数

### @ApiImplicitParams: 描述方法的参数(Multi-Params)

```java
@ApiImplicitParams({
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
	@ApiImplicitParam(name = "file", value = "文件导入", dataType = "MultipartFile")
})
```

## 实体类常用注解

```java
/**
 * 用户信息 数据传输对象 Dto（Data Transfer Object）
 * 
 * @author Y.yang
 * @date 2019/3/29
 */
@ApiModel(description = "用户信息请求对象")
@Data
public class User implements Serializable {

	private static final long serialVersionUID = -6986638131456347054L;

	@ApiModelProperty(value = "姓名")
	private String username;

	@ApiModelProperty(value = "性别")
	private String sex;

	@ApiModelProperty(value = "年龄")
	private Integer age;

}
```



### @ApiModel:描述实体类（Dto、Vo、Do等）

```java
@ApiModel(description = "用户信息请求对象")
```

### @ApiModelProperty：描述实体类的字段

```java
@ApiModelProperty(value = "姓名")
```





