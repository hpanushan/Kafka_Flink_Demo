package com.hpanushan.events;

public class Server {
    //public String dateTime;
    //public String timeZone;
    //public String serverId;
    public int temperature;
    public int cpu;
    public int memory;

    public Server() {
    }

    public Server(int temperature, int cpu, int memory)
    {
        //this.dateTime = dateTime;
        //this.timeZone = timeZone;
        //this.serverId = serverId;
        this.temperature = temperature;
        this.cpu = cpu;
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "com.hpanushan.events.Server{" +
                "temperature=" + temperature + '\'' +
                ", cpu='" + cpu + '\'' +
                ", memory=" + memory +
                '}';
    }

//    public String getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(String dateTime) {
//        this.dateTime = dateTime;
//    }
//
//    public String getTimeZone() {
//        return timeZone;
//    }
//
//    public void setTimeZone(String timeZone) {
//        this.timeZone = timeZone;
//    }
//
//    public String getServerId() {
//        return serverId;
//    }
//
//    public void setServerId(String serverId) {
//        this.serverId = serverId;
//    }

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

}


