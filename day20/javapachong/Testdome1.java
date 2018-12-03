package banban.javapachong;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Testdome1
 * @Author zhang-peng-zhan
 * @Date 2018/11/26 21:51
 *
 *
 *      爬虫
 * 		https://tieba.baidu.com/p/2256306796?red_tag=1781367364 贴吧地址
 *
 * 		URL 返回的是html网页
 * 		<img 任意 src="地址"
 *
 * 		List<> list = 记录所有地址
 *
 * 		写一个正则表达式。
 *       自己的  <img\b[^>]*?\bsrc[\s]*=[\s]*["']?[\s]*(?<imgUrl>[^"'>]*)[^>]*?/?[\s]*>
 *       老师的  <img class="BDE_Image" src="(.*?)"
 *
 *      多线程下载:线程池
 *
 *
 *
 */
public class Testdome1 {

    /**
     * 正文图片正则
     */
    static Pattern pattern = Pattern.compile("<img class=\"BDE_Image\" src=\"(.*?)\"");

    /**
     * 存储路径，文件夹需要事先存在
     */
    static final String SAVE_PREFIX = "F:\\day17\\protects最新\\img\\";
    /**
     * 贴吧网络地址
     */
    static String TIEBA_URL = "https://tieba.baidu.com/p/2256306796?red_tag=1781367364";


    public static void main(String[] args)  {
        // 创建线程池，并发下载图片
        ExecutorService es = Executors.newFixedThreadPool(10);
        //抓取到网页Html list存储
        List<String> aCatch = CatchHtml.Catch(TIEBA_URL);

        Matcher matcher = pattern.matcher(aCatch.get(0));
        // 找到每个匹配的图片
        while (matcher.find()) {
            String imageURL = matcher.group(1);
            // 提交给线程池进行下载
            es.submit(() -> DownLoad.download(imageURL,SAVE_PREFIX));
        }
        es.shutdown();
    }
}
