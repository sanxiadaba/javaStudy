import java.util.Arrays;
import java.util.HashMap;

public class EX_03 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2);
        System.out.println(hashMap.get(2));
        System.out.println(Arrays.toString(new int[]{1, 2}));
    }
}
