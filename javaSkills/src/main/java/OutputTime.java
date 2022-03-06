import java.util.Date;

// 输出时间

public class OutputTime {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        System.out.println(date.toLocaleString());
        // 或者
        System.out.println(new java.sql.Date(new java.util.Date().getTime()));

    }
}
