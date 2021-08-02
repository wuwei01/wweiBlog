package io.github.wuwei01.socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        //创建客户端socket建立连接，指定服务器地址和端口
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            //获取输出流，向服务器端发送信息
            OutputStream outputStream = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter(outputStream); //将输出流包装为打印流
            pw.write("用户名：admin;密码：123");
            pw.flush();
            socket.shutdownOutput();

            //获取输入流，读取服务器端的响应
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String info = null;
            while((info = br.readLine())!=null){
                System.out.println("我是客户端，服务器说："+info);

            }
            socket.shutdownInput();

            //关闭资源
            br.close();
            inputStream.close();
            pw.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
