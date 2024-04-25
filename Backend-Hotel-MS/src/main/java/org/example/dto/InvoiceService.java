package org.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.example.entity.UsageReport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class InvoiceService {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date date;
    private String roomCode;
    private String service;
    private int quantity;
    private long price;
    private List<RoomUsage> roomUsages = new ArrayList<>();

    public static InvoiceService toDTO(UsageReport usage){
        if (usage == null)
            return null;
        InvoiceService service = new InvoiceService();
        service.setService(usage.getService());
        service.setDate(usage.getDate());
        service.setPrice(usage.getPrice());
        service.setRoomCode(usage.getRoomCode());
        service.setQuantity(usage.getQuantity());
        return service;
    }
}
