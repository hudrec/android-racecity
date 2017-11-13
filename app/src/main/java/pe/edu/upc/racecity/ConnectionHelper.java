package pe.edu.upc.racecity;
import com.connectsdk.device.ConnectableDevice;
import com.connectsdk.discovery.DiscoveryManager;
import com.connectsdk.service.WebOSTVService;
import com.connectsdk.service.sessions.WebAppSession;

/**
 * Created by Daniela on 30/09/2015.
 */
public class ConnectionHelper {

    public static DiscoveryManager discoveryManager;
    public static ConnectableDevice connectableDevice;
    public static WebOSTVService webOSTVService;
    public static WebAppSession webAppSession;
    public static DemoListener demoListener;
}
