import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

//Jeff Makoroff
//Program retrieves the time and stores into a String for later use


public class Clock
{
    String line = "";
    public String ClockAsString() {
        try {
            Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13);
            try {
                InputStream inStream = s.getInputStream();
                Scanner in = new Scanner(inStream);

                while (in.hasNextLine()) {
                    line += in.nextLine();
                }
            } finally {
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

}