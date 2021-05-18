package io.github.wuwei01.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author wuwei
 * @date 2021年05月18日 15:12
 */
@Data
public class LoginDto {
    @NotBlank(message = "昵称不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String passWord;
}
