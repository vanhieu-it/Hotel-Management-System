package org.example.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import io.jsonwebtoken.io.IOException;

import java.time.LocalDate;
import java.util.Date;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

  private static final long serialVersionUID = 1L;

  public LocalDateDeserializer() {
    this(null);
  }

  public LocalDateDeserializer(final Class<Date> vc) {
    super(vc);
  }

  @Override
  public LocalDate deserialize(JsonParser jsonParser,
      DeserializationContext deserializationContext)
      throws IOException, java.io.IOException {
    if (jsonParser.getText().isEmpty()) {
      return null;
    }

    return DateUtils.stringToZonedDateTime(jsonParser.getText());
  }

}
