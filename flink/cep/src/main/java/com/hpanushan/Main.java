package com.hpanushan;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {

        // Create the environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Setting properties
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "node2:9092,node3:9092,node4:9092");
        properties.setProperty("group.id", "demo");

        DataStream<Event> stream = env
                .addSource(new FlinkKafkaConsumer<>("demo1", new EventDeserializationSchema(), properties));

        stream.print();
        env.execute("Flink CEP");

    }
}
