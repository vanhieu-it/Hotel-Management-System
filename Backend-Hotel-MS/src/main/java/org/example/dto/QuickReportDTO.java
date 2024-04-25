package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.QuickReport;

@Getter
@Setter
public class QuickReportDTO {
    private String roomClassName;
    private int quantity;
    private int availableQuantity;

    public static QuickReportDTO toDTO(QuickReport quickReport){
        if (quickReport == null)
            return null;
        QuickReportDTO dto = new QuickReportDTO();
        dto.setQuantity(quickReport.getQuantity());
        dto.setRoomClassName(quickReport.getRoomClassName());
        dto.setAvailableQuantity(quickReport.getAvailable());
        return dto;
    }
}
