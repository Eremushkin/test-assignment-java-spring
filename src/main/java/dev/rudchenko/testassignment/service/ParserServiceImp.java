package dev.rudchenko.testassignment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.rudchenko.testassignment.service.dto.TicketsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


@Service
public class ParserServiceImp implements ParserService {

    private final ObjectMapper objectMapper;

    @Autowired
    public ParserServiceImp(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public TicketsDTO parseFromJson(String filePath)  {//проверяемый эксепшн

        try {

            return objectMapper.readValue(new File(filePath),TicketsDTO.class);

        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Incorrect format file:" + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("IOException",e);
        }
    }

}
