package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：renpeng
 * @date：2019/3/15
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String[]> paraMap = new HashMap<String, String[]>();
        for( Map.Entry<String, String[]> entry : paraMap.entrySet() )
        {
            String appFieldDefId = entry.getKey();
            String[] values = entry.getValue();
        }


    }
}
