package io.github.wuwei01.socket;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {

        try {

            //定义服务器的ip，端口号，数据
            InetAddress inetAddress = InetAddress.getByName("localhost");
            int port = 8800;
            byte[] data = "用户名：admin；密码：123".getBytes();
            //创建数据包，包含要发送的信息
            DatagramPacket packet = new DatagramPacket(data,data.length,inetAddress,port);
            //创建datagramsocket
            DatagramSocket socket = new DatagramSocket();
            //使用socket向服务器端发送数据包
            socket.send(packet);
            //socket.close();


            //接收服务器端的响应，基本与Server的接收相同
            byte[] dataR = new byte[1024]; //创建数据包用于接收服务器端的响应
            DatagramPacket packet1 = new DatagramPacket(dataR,dataR.length);
            socket.receive(packet1); //接收响应的数据
            String info = new String(dataR,0,packet1.getLength());  //读取数据
            System.out.println("I am Client,Sever reply:"+info);

            socket.close();//关闭资源
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
