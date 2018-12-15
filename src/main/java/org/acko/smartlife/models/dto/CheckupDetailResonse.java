package org.acko.smartlife.models.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author prabodh.hend
 */
@Data
public class CheckupDetailResonse {
    private Date date;
    private String parameter;
    private Object value;
}
