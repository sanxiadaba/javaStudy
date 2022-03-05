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
"jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSl=true"
```


