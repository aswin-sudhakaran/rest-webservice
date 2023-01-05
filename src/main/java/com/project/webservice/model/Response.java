package com.project.webservice.model;

import com.project.webservice.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Map<String,Object> response;
    public ResponseEntity<?> successResponse(Object data){
        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("data",data);
        responseMap.put("status",Constants.SUCCESS);
        return new ResponseEntity<>(new Response(responseMap), HttpStatus.OK);
    }

    public ResponseEntity<?> failureResponse(Object data){
        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("error",data);
        responseMap.put("status",Constants.FAILURE);
        return new ResponseEntity<>(new Response(responseMap), HttpStatus.BAD_REQUEST);
    }

}
