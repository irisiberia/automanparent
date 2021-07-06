package com.automan.siberia.adapterTest;

/**
 * @Author: he.zhou
 * @Date: 2018-12-13
 */
public class Test {
    public static void main(String[] args) {
        Chat chat=new Chat();
        Service service=new Service();

        chat.FTP();
        chat.SSH();

        service.Mysql();
        service.Oracle();
    }
}
