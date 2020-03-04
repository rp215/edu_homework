package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

/**
 * @author：renpeng
 * @date：2019/3/8
 */
public class ReadDemo {

    public static void main(String[] args) {
//        String result = new ReadDemo().clobToString((Clob) );
    }

    public String clobToString(Clob clob){
        StringBuffer sb = new StringBuffer();
        try {
            Reader reader = clob.getCharacterStream();
            BufferedReader br = new BufferedReader(reader);
            String s = br.readLine();
            while (s != null){
                sb.append(s);
                s = br.readLine();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
