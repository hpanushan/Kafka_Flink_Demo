package com.hpanushan;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class TestConsumer {

    public static void main(String[] args) throws Exception {

        // Environment
        StreamExecutionEnvironment executionEnvironment
                = StreamExecutionEnvironment.getExecutionEnvironment();

        // Datastream
        DataStream<String> dataStream = executionEnvironment.fromElements(
                "This is a first sentence",
                "This is a second sentence with a one word");

        // Apply transformation
        SingleOutputStreamOperator<String> upperCase = dataStream.map(String::toUpperCase);

        // Print the result of transformation to the standard output
        upperCase.print();

        // Start execution
        executionEnvironment.execute("Example");
    }
}
