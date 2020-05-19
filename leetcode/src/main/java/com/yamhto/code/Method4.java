package com.yamhto.code;

/**
 * @author yamhto
 * @className: Method4.java
 * @package com.yamhto.code
 * @description:
 * @date 2020/5/18 14:24
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现要求：
 * 1、根据代码片段实现一个简单的SOCKET ECHO程序；
 * 2、接受到客户端连接后，服务端返回一个欢迎消息;
 * 3、接受到"bye"消息后， 服务端返回一个结束消息，并结束当前连接;
 * 4、支持通过telnet连接本服务端，并且可正常运行；
 * 5、注意代码注释书写。
 */
public class Method4 {

    public static void main(String[] args) throws IOException, InterruptedException {

        final int listenPort = 12345;

        // 启动服务端
        new Thread(() -> {
            EchoServer server = new EchoServer(listenPort);
            server.startService();
        }).start();




        // 启动客户端
        new Thread(() -> {
            EchoClient client = new EchoClient(listenPort);
            client.startService();
        }).start();

        // 在控制台输入，服务端直接原文返回输入信息
        // 控制台结果示例：
        /**
         2020-03-31 16:58:44.049 - Welcome to My Echo Server.(from SERVER)

         Enter: hello!
         2020-03-31 16:58:55.452 - hello!(from SERVER)

         Enter: this is koal.
         2020-03-31 16:59:06.565 - this is koal.(from SERVER)

         Enter: what can i do for you?
         2020-03-31 16:59:12.828 - what can i do for you?(from SERVER)

         Enter: bye!
         2020-03-31 16:59:16.502 - Bye bye!(from SERVER)
         */
    }


}

class EchoServer {

    ServerSocket serverSocket = null;

    EchoServer(int port) {
        //启动socket 服务器
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("EchoServer启动异常");
            e.printStackTrace();
        }
    }

    public void startService() {

        try {
            // 接受客户端建立链接，生成Socket实例
            Socket clientSocket = serverSocket.accept();

            PrintWriter out = null;

            if(null != clientSocket){
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Welcome to My Echo Server.(from SERVER)");
            }

            BufferedReader in =
                    new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {

                // 发送信息给客户端
                out.println(inputLine);
            }

        } catch (IOException e) {

        }
    }


}

class EchoClient {

    Socket EchoClient = null;

    public final static String hostName = "127.0.0.1";

    EchoClient(int port) {
        try {
            EchoClient = new Socket(hostName, port);
        } catch (IOException e) {
            System.out.println("EchoClient启动异常");
            System.exit(1);
        }
    }

    public void startService() {
        try {
            BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in));


            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                BufferedReader in =
                        new BufferedReader(
                                new InputStreamReader(EchoClient.getInputStream()));
                System.out.println(in.readLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

