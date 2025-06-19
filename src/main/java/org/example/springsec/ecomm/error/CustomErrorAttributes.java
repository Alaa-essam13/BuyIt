package org.example.springsec.ecomm.error;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.put("Success", false);
        errorAttributes.put("state", errorAttributes.get("error"));
        errorAttributes.put("exception", errorAttributes.get("message"));
        errorAttributes.put("details", Arrays.asList(errorAttributes.get("message")));
        errorAttributes.remove("error");
        errorAttributes.remove("path");
        return errorAttributes;
    }
}
