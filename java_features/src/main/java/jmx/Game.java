package jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Game implements GameBean {
    private String playerName;

    @Override
    public void playFootball(String clubName) {
        System.out.println(
                this.playerName + "Playing football for " + clubName
        );
    }

    @Override
    public String getPlayerName() {
        System.out.println("Return playerName " + this.playerName);
        return playerName;
    }

    @Override
    public void setPLayerName(String playerName) {
        System.out.println("Set playerName to value " + playerName);
        this.playerName = playerName;
    }

    public static void main(String[] args) {
        try {
            ObjectName objectName = new ObjectName("jmx:type=basic,name=game");
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            server.registerMBean(new Game(), objectName);
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException |
                MBeanRegistrationException | NotCompliantMBeanException e) {
            // handle exceptions
        }

        while (true) {
        }
    }

}
