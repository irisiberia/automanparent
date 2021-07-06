package com.automan.siberia.atInterfaceTest;

/**
 * @Author: he.zhou
 * @Date: 2019-02-11
 */
public class PasswordUtils {
    @UseCase(id = "49", description = "ceshi")
    private String ss;

    @UseCase(id = "47", description = "我是测试")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = "48")
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
