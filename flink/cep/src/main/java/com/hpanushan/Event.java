package com.hpanushan;

import java.io.Serializable;

public class Event implements Serializable {

    private String timestamp;
    private String timezone;
    private String server;
    private int temperature;
    private int cpu;
    private int memory;

    public Event(String timestamp, String timezone, String server, int temperature, int cpu, int memory)
    {
        this.timestamp = timestamp;
        this.timezone = timezone;
        this.server = server;
        this.temperature = temperature;
        this.cpu = cpu;
        this.memory = memory;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "timestamp: " + this.timestamp + ", timezone: " + this.timezone + ", server: " + this.server + ", temperature: " + this.temperature + ", cpu: " + this.cpu + ", memory: " + this.memory;
    }
}