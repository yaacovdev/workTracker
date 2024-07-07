package com.worktracker.api.utils;

import org.springframework.http.ResponseEntity;

// import com.worktracker.api.model.ApiResponse;

/**
 * Utility class for generating response entities.
 */
public class ResponseUtil {
    
    /**
     * Generates a success response entity with the provided data.
     *
     * @param data the data to be included in the response
     * @param <T> the type of the data
     * @return the success response entity
     */
    public static <T> ResponseEntity<T> successResponse(T data) {
        // ApiResponse<T> apiResponse = new ApiResponse<>(data);
        return ResponseEntity.ok(data);
    }
}
