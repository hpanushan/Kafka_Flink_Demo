package com.hpanushan.sink;

import com.hpanushan.Event;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SinkToMySQL extends RichSinkFunction<Event> {
    PreparedStatement ps;
    private Connection connection;

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        connection = getConnection();

        String sql = "insert into events(temperature, cpu, memo) values(?, ?, ?);";
        ps = this.connection.prepareStatement(sql);
    }

    @Override
    public void close() throws Exception {
        super.close();
        //Close connections and release resources
        if (connection != null) {
            connection.close();
        }
        if (ps != null) {
            ps.close();
        }
    }

    @Override
    public void invoke(Event value, Context context) throws Exception {
        //Assemble data and perform insert operations
        ps.setInt(1, value.getTemperature());
        ps.setDouble(2, value.getCpu());
        ps.setDouble(3, value.getMemory());
        ps.executeUpdate();
    }

    private static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.168.8.105:3306/flink?useUnicode=true&characterEncoding=UTF-8", "anushan", "Omnibis.1234");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}