package org.acko.smartlife.service;

import org.acko.smartlife.models.dto.CheckupResponse;

/**
 * @author prabodh.hend
 */
public interface CheckupService {

    public CheckupResponse getDetails(String userId);
}
