package dev.rudchenko.testassignment.service;

import dev.rudchenko.testassignment.service.dto.ResultDTO;
import org.springframework.stereotype.Service;

@Service
public class ConsoleOutputService implements OutputService {
    @Override
    public void print(ResultDTO resultDTO) {
        System.out.println("Minimal Flight Times:" + resultDTO.getMinFlightTimes().toString() + "\n"
                +"Difference between average price and median:"+ resultDTO.getDifference());
    }
}
