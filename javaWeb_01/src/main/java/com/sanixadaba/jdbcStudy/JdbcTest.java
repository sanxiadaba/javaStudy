package com.sanixadaba.jdbcStudy;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.配置数据库信息
        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSl=true";
        String username = "root";
        String password = "123456";
        String sqlInsert = "insert into users(id, name, password, email, birthday) values (?,?,?,?,?);";
        // 2. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 3. 连接数据库,代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        // 4. 向数据库发送sql的对象Statement:CURD
        Statement statement = connection.createStatement();
        // connection.prepareCall(sql);(预编译,安全的操作sql的对象)
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        // 5. 编写sql
        String sqlQuery = "select * from users"; // 查询全部的语句

        String sqlUpdate = "UPDATE `users` set `password`=\"654321\" WHERE `id`=2;"; // 更新的语句

        // 6. 执行sql
        ResultSet resultSet = statement.executeQuery(sqlQuery); // 查询语句
        // 7. 输出结果
        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("password=" + resultSet.getObject("password"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birthday=" + resultSet.getObject("birthday"));
        }
        // 注意这里要等上一个查询后才能执行下一个sql语句,不然会报错 (Operation not allowed after ResultSet closed)
        int updateNum = statement.executeUpdate(sqlUpdate); // 返回的是受影响的行数 注意 增,删,改都是使用update
        System.out.println("修改成功\n受影响的行数为: " + updateNum);
        // 使用预编译来执行sql
        preparedStatement.setInt(1, 4); // 给第一个占位符赋值为1
        preparedStatement.setString(2, "小明");
        preparedStatement.setString(3, "1234567");
        preparedStatement.setString(4, "xm@qq.com");
        preparedStatement.setDate(5, new Date(new java.util.Date().getTime()));
        // 查看插入的数量
        int insertNum = preparedStatement.executeUpdate();
        if (insertNum > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
        // 8. 关闭连接,释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
