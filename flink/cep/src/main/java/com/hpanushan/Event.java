package com.hpanushan;

import java.io.Serializable;

public class Event implements Serializable {

    private int temperature;
    private int cpu;
    private int memory;

    public Event(int temperature, int cpu, int memory)
    {
        this.temperature = temperature;
        this.cpu = cpu;
        this.memory = memory;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public long getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "temperature: " + this.temperature + ", cpu: " + this.cpu + ", memory: " + this.memory;
    }
}