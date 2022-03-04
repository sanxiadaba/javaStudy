import java.util.Date;

// 输出时间

public class OutputTime {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        System.out.println(date.toLocaleString());

    }
}
