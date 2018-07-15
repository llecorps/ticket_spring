package org.example.demo.ticket.batch.impl;

/**
 * Created by esspressoh on 15.07.18.
 */
public class SystemSettings {

    private String myrep;

    public SystemSettings() {

    }



    public void setMyrep(String Myrep) {
        myrep = Myrep;
    }

    public String getMyrep() {
        return myrep;
    }

    public SystemSettings(String appDisplayName) {
        this.appDisplayName = appDisplayName;
    }

    public String appDisplayName;

    @Override
    public String toString() {
        return "SystemSettings{" +
                "myrep='" + myrep + '\'' +
                ", appDisplayName='" + appDisplayName + '\'' +
                '}';
    }
}
