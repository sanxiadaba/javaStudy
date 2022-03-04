import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

// 编码与解码

public class CodingAndDecoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name="张三";
        String encode = URLEncoder.encode(name, "utf-8");
        String decode = URLDecoder.decode(encode, "utf-8");
        System.out.println(decode);
    }
}
