package banban.ChatSever;

/**
 * @ClassName ChatClient
 * @Author zhang-peng-zhan
 * @Date 2018/11/21 20:24
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatClient {
    private static final int PORT = 8888;
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        new ChatClient();
    }

    public ChatClient() {
        try {
            Socket socket = new Socket("192.168.3.113", PORT);
            exec.execute(new Sender(socket));
            System.out
                    .println("【" + socket.getInetAddress() + "】您好，欢迎来到--真香--聊天室！");

            BufferedReader br = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (Exception e) {
          //System.out.println("lalala");
        }
    }

    /**
     *设置用户
     */

    /**
     * 客户端线程获取控制台输入消息
     */
    static class Sender implements Runnable {
        private Socket socket;

        public Sender(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        System.in));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                String msg;

                while (true) {
                    msg = br.readLine();
                    pw.println(msg);

                    if (msg.trim().equals("bye")) {
                        pw.close();
                        br.close();
                        exec.shutdownNow();
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
