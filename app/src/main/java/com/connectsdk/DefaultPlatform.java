package com.connectsdk;

import java.util.HashMap;

public class DefaultPlatform {
    public static HashMap<String, String> getDeviceServiceMap() {
        HashMap<String, String> devicesList = new HashMap();
        devicesList.put("com.connectsdk.service.WebOSTVService", "com.connectsdk.discovery.provider.SSDPDiscoveryProvider");
        return devicesList;
    }
}
