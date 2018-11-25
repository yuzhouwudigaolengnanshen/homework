package banban.ChatSever;

/**
 * @ClassName ChatSever
 * @Author zhang-peng-zhan
 * @Date 2018/11/21 20:23
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    private static final int PORT = 8888; // 端口号
    private static List<Socket> list = new ArrayList<Socket>(); // 保存连接对象
    private static ConcurrentHashMap<Socket,String>  concurrentHashMap = new ConcurrentHashMap<>(); //保存链接对象
    private ExecutorService exec;
    private ServerSocket server;

    public static void main(String[] args) {
        new ChatServer();
    }

    public ChatServer() {
        try {
            server = new ServerSocket(PORT);
            exec = Executors.newCachedThreadPool();
            System.out.println("服务器已启动！");

            Socket client = null;
            while (true) {
                client = server.accept(); // 接收客户连接
                list.add(client);
                exec.execute(new ChatTask(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ChatTask implements Runnable {
        private Socket socket;
        private BufferedReader br;
        private PrintWriter pw;
        private String msg;

        public ChatTask(Socket socket) throws IOException {
            this.socket = socket;
            br = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            msg = "【" + this.socket.getInetAddress() + "】进入聊天室！当前聊天室有【"
                    + list.size() + "】人";

            sendMessage();
        }

        public void run() {
            handle();
        }

        private void handle() {
            try {
                while ((msg = br.readLine()) != null) {
                    if (msg.trim().equals("bye")) {
                        list.remove(socket);
                        br.close();
                        pw.close();
                        msg = "【" + socket.getInetAddress() + "】离开聊天室！当前聊天室有【"
                                + list.size() + "】人";
                        socket.close();

                        sendMessage();
                        break;
                    } else {
                        msg = "【" + socket.getInetAddress() + "】说：" + msg;
                        sendMessage();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 群发消息给聊天室的所有人
         */
        private void sendMessage() throws IOException {
            System.out.println(msg);
            for (Socket client : list) {
                pw = new PrintWriter(client.getOutputStream(), true);
                pw.println(msg);
            }
        }
    }
}

