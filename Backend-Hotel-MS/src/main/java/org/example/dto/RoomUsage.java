package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RoomUsage {
    private String roomCode;
    private List<ServiceDetail> serviceDetails = new ArrayList<>();
}
