package org.example.entity.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ServicePriceID implements Serializable {
    @Column(name = "ID_DICHVU", nullable = false)
    private int serviceID;
    @Column(name = "NGAY", nullable = false)
    private Date date = new Date();
}
