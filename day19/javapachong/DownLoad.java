package banban.javapachong;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName DownLoad
 * @Author zhang-peng-zhan
 * @Date 2018/11/27 9:21
 */
public class DownLoad {
    /**
     * 下载图片
     * @param imageURL 图片地址
     * @param savePrefix 存储目录
     */
    public static void download(String imageURL, String savePrefix) {
        try {
            URLConnection conn = new URL(imageURL).openConnection();
            String path = savePrefix + imageURL.substring(imageURL.lastIndexOf("/") + 1);
            try (
                    InputStream in = conn.getInputStream();
                    FileOutputStream out = new FileOutputStream(path)
            ) {
                byte[] buf = new byte[1024 * 1024];
                while (true) {
                    int len = in.read(buf);
                    if (len == -1) {
                        break;
                    }
                    out.write(buf, 0, len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
