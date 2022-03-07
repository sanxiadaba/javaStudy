#### web.xml 配置
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0"
         metadata-complete="true">
    
</web-app>

```

#### 解决资源导出问题
```xml
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>

        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>

        </resource>
    </resources>
</build>
```

#### 设置传输格式
```text
resp.setCharacterEncoding("utf-8");
resp.setContentType("text/html");
resp.setContentType("text/html; charset=utf-8");
```

#### 基本引用httpservlet
```java
extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
```

#### 解决中文乱码
```java
req.setCharacterEncoding("utf-8");
resp.setCharacterEncoding("utf-8");
```

#### Lombok

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
```

#### 连接jdbc设置

```java
"jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSl=true&serverTimezone=GMT%2B8"
```

#### 设置java虚拟机编码格式

```java
-Dfile.encoding=UTF-8
```

#### log4j的配置

```java
#将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
        log4j.rootLogger=DEBUG,console,file

        #控制台输出的相关设置
        log4j.appender.console=org.apache.log4j.ConsoleAppender
        log4j.appender.console.Target=System.out
        log4j.appender.console.Threshold=DEBUG
        log4j.appender.console.layout=org.apache.log4j.PatternLayout
        log4j.appender.console.layout.ConversionPattern=[%c]-%m%n

        #文件输出的相关设置
        log4j.appender.file=org.apache.log4j.RollingFileAppender
        log4j.appender.file.File=./log/zhang.log
        log4j.appender.file.MaxFileSize=10mb
        log4j.appender.file.Threshold=DEBUG
        log4j.appender.file.layout=org.apache.log4j.PatternLayout
        log4j.appender.file.layout.ConversionPattern=[%p][%d{yy-MM-dd HH:mm:ss,SSS}][%c]%m%n

        #日志输出级别
        log4j.logger.org.mybatis=DEBUG
        log4j.logger.java.sql=DEBUG
        log4j.logger.java.sql.Statement=DEBUG
        log4j.logger.java.sql.ResultSet=DEBUG
        log4j.logger.java.sq1.PreparedStatement=DEBUG
```