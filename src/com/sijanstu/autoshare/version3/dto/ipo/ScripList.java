package com.sijanstu.autoshare.version3.dto.ipo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScripList implements Serializable {
    private Scrip[] object;
    private Integer totalCount;
}
