package SNR;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Shipping {
    static String ip;
    public static void Soc_send(String ch) throws IOException, InterruptedException{
        if(ch.contains("192.168.")){
            ip=ch;
            ch="#c";
        }
        int p=5000; 
        System.out.println(ip+" "+ch);
        Socket soc=new Socket(ip,p);
        DataOutputStream out = new DataOutputStream(soc.getOutputStream());
        out.writeUTF(ch);
        out.flush();
        out.close();
    }
}
