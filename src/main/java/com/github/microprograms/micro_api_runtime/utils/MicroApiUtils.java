package com.github.microprograms.micro_api_runtime.utils;

import org.apache.commons.lang3.StringUtils;

import com.github.microprograms.micro_api_runtime.enums.MicroApiReserveResponseCodeEnum;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.ResponseCode;

public class MicroApiUtils {

    public static void throwExceptionIfBlank(String parameterValue, String parameterName) throws MicroApiExecuteException {
        if (StringUtils.isBlank(parameterValue)) {
            ResponseCode responseCode = MicroApiReserveResponseCodeEnum.missing_required_parameters_exception;
            throw new MicroApiExecuteException(responseCode, responseCode.getMessage() + "：" + parameterName);
        }
    }

    public static void throwExceptionIfBlank(Integer parameterValue, String parameterName) throws MicroApiExecuteException {
        if (parameterValue == null) {
            ResponseCode responseCode = MicroApiReserveResponseCodeEnum.missing_required_parameters_exception;
            throw new MicroApiExecuteException(responseCode, responseCode.getMessage() + "：" + parameterName);
        }
    }

    public static void throwExceptionIfBlank(Long parameterValue, String parameterName) throws MicroApiExecuteException {
        if (parameterValue == null) {
            ResponseCode responseCode = MicroApiReserveResponseCodeEnum.missing_required_parameters_exception;
            throw new MicroApiExecuteException(responseCode, responseCode.getMessage() + "：" + parameterName);
        }
    }
}
