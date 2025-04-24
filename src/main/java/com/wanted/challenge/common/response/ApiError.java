package com.wanted.challenge.common.response;

import lombok.Builder;

import java.util.Map;

@Builder
public record ApiError(
        String code,
        String message,
        Map<String, String> details
) {
}
