package com.fame.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Y.yang
 */
@Data
// 开启链式编程
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = -6510879035056033991L;

    private Integer id;

    private String sex;

    private String username;

}