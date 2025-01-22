package com.atguigu.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
public class User {
    /**
     * 1. name 不为null和空字符串
     * 2. password 长度大于6
     * 3. age 必须 >= 1
     * 4. email 邮箱格式的字符串
     * 5. birthday 过去时间
     */
    @NotBlank
    // @Length(min = 3,max = 10)   // name 3 <= name.length <= 6
    private String name;

    @Length(min = 6)    // password >= 6
    private String password;

    @Min(1)    // age >= 1
    private int age;

    @Email  // email 邮箱格式
    private String email;

    @Past   // birthday 过去时间
    private Date birthday;
}
