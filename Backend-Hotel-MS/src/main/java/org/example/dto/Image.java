package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Image {
    @NotBlank(message = "cannot be empty")
    private String base64String;
}
