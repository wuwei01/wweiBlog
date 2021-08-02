package io.github.wuwei01.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) {

        try {
            //服务器端接收来自客户端的数据
            //创建服务器端的DatagramSocket，指定端口
            DatagramSocket socket = new DatagramSocket(8800);
            //创建数据报，用于接收客户端发送的信息
            byte[] data = new byte[1024];//创建字节数组，指定接收的数据包的大小
            DatagramPacket packet = new DatagramPacket(data, data.length);
            //接收客户端发送的数据
            socket.receive(packet); //接收到数据包之前会一直阻塞，会把数据存入packet的data
            //读取数据
            String info = new String(data, 0, packet.getLength());  //读取数据
            System.out.println("I am Server,Client say:" + info);


            //接收到数据后，服务器端响应给客户端，基本与client的发送相同
            //定义客户端的ip地址，端口号，数据
            InetAddress address = packet.getAddress();
            int port = packet.getPort(); //port难道不应该肯定是8800？？？
            byte[] data2 = "Welcome".getBytes();
            DatagramPacket packet1 = new DatagramPacket(data2, data2.length, address, port);
            socket.send(packet1);

            socket.close();//关闭资源

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
