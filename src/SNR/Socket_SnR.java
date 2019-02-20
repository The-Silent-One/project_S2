

package SNR;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Socket_SnR {
    static String ip;
    public Socket_SnR(){
        try(final DatagramSocket socket = new DatagramSocket()){
        socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
        ip = socket.getLocalAddress().getHostAddress();
        }catch(Exception e){e.printStackTrace();}
    }
    public static void Soc_send(String ch) throws IOException, InterruptedException{
        int p=5000;
        Socket soc=new Socket(ip,p);
        DataOutputStream out = new DataOutputStream(soc.getOutputStream());
        out.writeUTF(ch);
        out.flush();
        out.close();
    }
    public static String Soc_rec() throws IOException, InterruptedException{
        String ip=""; // to change
        int p=0; //to change
        Socket soc=new Socket(ip,p);
        DataInputStream d=new DataInputStream(soc.getInputStream());
        Thread.sleep(100);
        String msg=d.readUTF();
        return msg;  
    }
}
class test{
    public static void main(String[] args) throws Exception{
        Socket_SnR s = new Socket_SnR();
        System.out.println(Socket_SnR.ip);
    }
}