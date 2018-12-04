package banban.study12.JiHe.流式api;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeFiles {
    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("D:\\学习笔记\\day19\\heroes.txt"), Charset.forName("utf-8"));
        List<Hero> list = new ArrayList<>();


        lines.forEach((String s) -> {
            String[] split = s.split("\t");
            int id = Integer.parseInt(split[0]);
            String name = split[1];
            String address = split[2];
            String sex = split[3];
            int birth = Integer.parseInt(split[4]);
            int die = Integer.parseInt(split[5]);
            int wuli = Integer.parseInt(split[6]);
            list.add(new Hero(id,name,address,sex,birth,die,wuli));
        });
        //System.out.println(list.toString());

        // 1. 找到武将中武力前三的hero对象, 提示流也可以排序
        // 2. 按出生地分组
        // 3. 找出寿命前三的武将
        // 4. 女性寿命最高的
        // 5. 找出武力排名前三  100, 99, 97 97 ==> 4个人 吕布", "张飞", "关羽", "马超

        Stream<Hero> stream1 = list.stream();
        Stream<Hero> stream2 = list.stream();
        Stream<Hero> stream3 = list.stream();
        Stream<Hero> stream4 = list.stream();
//1找到武将中武力前三的hero对象, 提示流也可以排序
        wuli(stream1);
        System.out.println("------------------");
// 2按出生地分组
        dizhi(stream2);
        System.out.println("------------------");
// 3找出寿命前三的武将
        shoumingsan(stream3);
        System.out.println("------------------");
//4女性寿命最高的
        nvshouming(stream4);
        System.out.println("------------------");

    }

    private static void wuli(Stream<Hero> stream) {

        Stream<Hero> sorted = stream.sorted((o1, o2) -> {
            int x1 = o2.getWuli() - o1.getWuli();
            return x1;
        });
        Stream<Hero> limit = sorted.limit(3);
        limit.forEach(System.out::println);
    }

    private static void dizhi(Stream<Hero> stream) {
        Map<String, List<Hero>> collect = stream.collect(Collectors.groupingBy(s -> s.getAddress()));
        collect.forEach((k,v)-> System.out.println(k+"--"+v));
    }

    private static void shoumingsan(Stream<Hero> stream) {
        Stream<Hero> sorted1 = stream.sorted((o1, o2) -> (o2.getDie() - o2.getBirth()) - (o1.getDie() - o1.getBirth()));
        Stream<Hero> limit1 = sorted1.limit(3);
        limit1.forEach(System.out::println);
    }

    private static void nvshouming(Stream<Hero> stream) {
        Stream<Hero> heroStream = stream.filter(hero -> hero.getSex().equals("女"));
        Stream<Hero> sorted2 = heroStream.sorted((o1, o2) -> (o2.getDie() - o2.getBirth()) - (o1.getDie() - o1.getBirth()));
        sorted2.limit(1).forEach(System.out::println);
    }

}
