package dev.rudchenko.testassignment.service;

import dev.rudchenko.testassignment.service.dto.ResultDTO;
import dev.rudchenko.testassignment.service.dto.TicketsDTO;

import java.time.LocalTime;
import java.util.Map;

public interface CalculationService {
    Map<String, LocalTime> calculateMinFlightTimes(TicketsDTO ticketsDTO);
    double calculatePriceDifference(TicketsDTO ticketsDTO);
    ResultDTO calculateResultDTO(double difference, Map<String, LocalTime> minFlyTime);
}
