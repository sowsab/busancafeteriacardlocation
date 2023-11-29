package com.example.busancafeteriacardlocation.domain.map.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.busancafeteriacardlocation.domain.map.dto.APIResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MainService {
    
    @Value("${open-api.busan-cafeteria.api-key}")
    private String openApiKey; 

    public APIResponseDTO getLocations() {
        APIResponseDTO apiResponseDTO = null;
        StringBuffer result = new StringBuffer();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://api.odcloud.kr/api/15102055/v1/uddi:122cc22d-cde3-41d0-83c8-db83298b994f");
            urlBuilder.append("?" + URLEncoder.encode("page", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("perPage", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + URLEncoder.encode(openApiKey, "UTF-8"));
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line + "\n");
            }
            rd.close();

            ObjectMapper objectMapper = new ObjectMapper();
            apiResponseDTO = objectMapper.readValue(result.toString(), APIResponseDTO.class);

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return apiResponseDTO;

    }

}
