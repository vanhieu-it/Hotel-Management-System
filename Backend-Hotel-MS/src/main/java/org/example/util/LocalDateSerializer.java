package org.example.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateSerializer extends StdSerializer<LocalDate> {

  private static final long serialVersionUID = 1L;

  public LocalDateSerializer() {
    this(null);
  }



  public LocalDateSerializer(final Class<LocalDate> vc) {
    super(vc);
  }

  @Override
  public void serialize(LocalDate dateTime, JsonGenerator jsonGenerator,
      SerializerProvider provider)
      throws IOException {
    jsonGenerator.writeObject(DateUtils.zonedDateTimeToString(dateTime));
  }

}
