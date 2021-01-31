package com.hpanushan;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

class EventDeserializationSchema implements DeserializationSchema<Event> {

    private static final long serialVersionUID = 1L;

    @Override
    public Event deserialize(byte[] message) throws IOException {
        String line = new String(message, StandardCharsets.UTF_8);
        String[] parts = line.split(" ");

        Event event = new Event(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));

        return event;
    }

    @Override
    public boolean isEndOfStream(Event nextElement) {
        return false;
    }

    @Override
    public TypeInformation<Event> getProducedType() {
        return TypeInformation.of(Event.class);
    }
}