package org.acko.smartlife.service.mapper;

import org.acko.smartlife.constants.DataType;
import org.acko.smartlife.models.dao.jpa.Checkup;
import org.acko.smartlife.models.dto.CheckupDetailResonse;
import org.acko.smartlife.models.dto.CheckupResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author prabodh.hend
 */
public class CheckupMapper {

    public static CheckupResponse map(String userId, List<Checkup> checkup) {
        CheckupResponse response = new CheckupResponse();
        response.setUserId(userId);
        if (!checkup.isEmpty()) {


            List<CheckupDetailResonse> details = checkup.stream()
                    .map(checkupResponse -> {
                        CheckupDetailResonse checkupDetail = new CheckupDetailResonse();
                        checkupDetail.setDate(checkupResponse.getCheckupDate());

//                        checkupResponse.getCheckupDetailsList()




//                        checkupDetail.setParameter(detail.get());
//                        setValue(checkupDetail, detail.getValue(), detail.getDataType());
                        return checkupDetail;
                    }).collect(Collectors.toList());
            response.setDetails(details);
        }
        return response;
    }

    private static void setValue(CheckupDetailResonse checkupDetail, String value, DataType dataType) {
        switch (dataType) {
            case BOOLEAN:
                checkupDetail.setValue(Boolean.valueOf(value));
                break;
            case STRING:
                checkupDetail.setValue(value.toString());
                break;
            case DOUBLE:
                checkupDetail.setValue(Double.parseDouble(value));
                break;
        }
    }

}
