package banban.javapachong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CatchHtml
 * @Author zhang-peng-zhan
 * @Date 2018/11/27 8:55
 *
 *      List<> list = 记录所有地址
 *
 */
public class CatchHtml {
    public static List<String> Catch(String TIEBA_URL)  {
        try {
            StringBuilder stringBuilder = new StringBuilder(1024*1024);
            URL url = new URL(TIEBA_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"))
            ) {

                while (true) {
                    String line = null;
                    if ((line = reader.readLine()) == null) {
                        break;
                    }
                    stringBuilder.append(line);
                }
            }
            List<String> list = new ArrayList<>();
            list.add(stringBuilder.toString());
            return list;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
