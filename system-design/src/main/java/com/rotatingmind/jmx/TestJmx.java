package com.rotatingmind.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class TestJmx {

    private ObjectName objectName;

    private void init() {
        try {
            objectName = new ObjectName("com.rotating.jmx:type=demo");
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            server.registerMBean(this, objectName);



            //add shutdown hooks
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    try {
                        server.unregisterMBean(objectName);
                    } catch (InstanceNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (MBeanRegistrationException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (MalformedObjectNameException e) {
            throw new RuntimeException(e);
        } catch (NotCompliantMBeanException e) {
            throw new RuntimeException(e);
        } catch (InstanceAlreadyExistsException e) {
            throw new RuntimeException(e);
        } catch (MBeanRegistrationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TestJmx jmx = new TestJmx();
        jmx.init();
    }
}
