package org.example.services.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "sendgrid", ignoreUnknownFields = false)
public class SendGridProperties {


  private String apiKey;
  private String fromMail;
  private String name;
  
  @NestedConfigurationProperty
  private Path path;

  @NestedConfigurationProperty
  private DynamicTemplateId dynamicTemplateId;

  @Getter
  @Setter
  public static class Path {

    private String registration;
  }

  @Getter
  @Setter
  public static class DynamicTemplateId {
    private String confirm;
    private String cancel;

  }


}
