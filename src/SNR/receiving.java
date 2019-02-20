package SNR;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class receiving {
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
