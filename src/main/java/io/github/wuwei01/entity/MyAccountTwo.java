package io.github.wuwei01.entity;

import io.github.wuwei01.service.AccountGroup;
import io.github.wuwei01.utils.DateValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyAccountTwo {

    private String id;

    @NotNull
    @Length(max = 20)
    private String userName;

    @NotNull
    @Pattern(regexp = "[A-Z][a-z][0-9]")
    private String passWord;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date createTime;

    //  @Pattern(regexp = "[A-Z][a-z][0-9]")
    @Min(2)
    private String alias;

    @Max(10)
    @Min(1)
    private Integer level;

    private Integer vip;

    @DateValidator(dateFormat = "yyyy-MM-dd", groups = {AccountGroup.class})
    private String birthday;
}

