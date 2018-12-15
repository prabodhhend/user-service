package org.acko.smartlife.service.mapper;

import org.acko.smartlife.models.dao.jpa.Checkup;
import org.acko.smartlife.models.dao.jpa.CheckupDetails;
import org.acko.smartlife.models.dto.CheckupDetailResonse;
import org.acko.smartlife.models.dto.CheckupResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author prabodh.hend
 */
public class CheckupMapper {

    public static List<CheckupResponse> map(List<Checkup> checkupList) {
        List<CheckupResponse> checkupResponses = new ArrayList<>();
        if (!checkupList.isEmpty()) {
            checkupResponses = checkupList.stream()
                    .map(checkup -> {
                        CheckupResponse checkupResponse = new CheckupResponse();
                        checkupResponse.setUserId(checkup.getUserId());

                        List<CheckupDetailResonse> details = checkup.getCheckupDetailsList().stream()
                                .map(checkupDetails -> {
                                    CheckupDetailResonse detailResonse = new CheckupDetailResonse();

                                    detailResonse.setParameter(checkupDetails.getParameter());
                                    setValue(checkupDetails, detailResonse);

                                    return detailResonse;
                                }).collect(Collectors.toList());

                        checkupResponse.setDetails(details);
                        return checkupResponse;

                    }).collect(Collectors.toList());
        }
        return checkupResponses;
    }

    private static void setValue(CheckupDetails checkupDetails, CheckupDetailResonse detailResonse) {
        String value = checkupDetails.getValue();
        switch (checkupDetails.getDataType()) {
            case BOOLEAN:
                detailResonse.setValue(Boolean.valueOf(value));
                break;
            case STRING:
                detailResonse.setValue(value.toString());
                break;
            case DOUBLE:
                detailResonse.setValue(Double.parseDouble(value));
                break;
        }
    }

}
