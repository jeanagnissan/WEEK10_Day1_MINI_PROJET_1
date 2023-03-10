package com.adaci.userproject.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Help {
    public static Map<String, String> buildHttpBodyRequest(List<BodyContent> bodyContents) {
        Map<String, String> map = new HashMap<>();
        bodyContents.forEach(bodyContent -> {
            map.put(bodyContent.getKey(), bodyContent.getValue());
        });
        return map;
    }
}
