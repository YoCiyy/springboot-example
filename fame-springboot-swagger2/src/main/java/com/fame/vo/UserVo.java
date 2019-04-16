package com.fame.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息 视图对象 VO（View Object）
 * 
 * @author Y.yang
 * @date 2019/4/1
 */
@Data
@ApiModel(description = "用户信息响应对象")
public class UserVo implements Serializable {

	private static final long serialVersionUID = -4261370744237064755L;

	@ApiModelProperty(value = "姓名", notes = "姓名")
	private String username;

	@ApiModelProperty(value = "性别", notes = "性别")
	private String sex;

	@ApiModelProperty(value = "年龄", notes = "年龄")
	private Integer age;

	@ApiModelProperty(value = "手机号码", notes = "手机号码")
	private String phone;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	private Date applyBeginTime;

}
