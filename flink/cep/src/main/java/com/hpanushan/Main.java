package com.hpanushan;

import com.hpanushan.sink.SinkToMySQL;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.control.Alert;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternSelectFunction;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.cep.pattern.conditions.SimpleCondition;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {

        // Create the environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Setting properties
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "node2:9092,node3:9092,node4:9092");
        properties.setProperty("group.id", "demo");

        DataStream<Event> input = env
                .addSource(new FlinkKafkaConsumer<>("demo1", new EventDeserializationSchema(), properties));


        // Filter
        DataStream<Event> filterd = input.filter(new FilterFunction<Event>() {
            @Override
            public boolean filter(Event event) throws Exception {
                return (event.getTemperature() > 90) || (event.getCpu() > 95) || (event.getMemory() > 95);
            }
        });

        // filterd.print();

        filterd.addSink(new SinkToMySQL()).name("MySQL"); //Data sink to mysql

        env.execute("Flink CEP");

    }
}
