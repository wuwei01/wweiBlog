package io.github.wuwei01.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try  {
            //创建一个服务器socket，即serversocket,指定绑定的端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);
            //调用accept()方法开始监听，等待客户端的连接
            System.out.println("***服务器即将启动，等待客户端的连接***");
            Socket socket = serverSocket.accept();
            //获取输入流，并读入客户端的信息
            InputStream in = socket.getInputStream(); //字节输入流
            InputStreamReader inreader = new InputStreamReader(in); //把字节输入流转换为字符流
            BufferedReader br = new BufferedReader(inreader); //为输入流添加缓冲
            String info = null;
            while((info = br.readLine())!=null){
                System.out.println("我是服务器，客户端说："+info);

            }
            socket.shutdownInput();//关闭输入流

            //获取输出流，相应客户端的信息
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);//包装为打印流
            printWriter.write("欢迎您！");
            printWriter.flush(); //刷新缓冲
            socket.shutdownOutput();

            //关闭资源
            printWriter.close();
            outputStream.close();

            br.close();
            inreader.close();
            in.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
