package dev.rudchenko.testassignment.service;

import dev.rudchenko.testassignment.service.dto.ResultDTO;
import dev.rudchenko.testassignment.service.dto.TicketsDTO;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class CalculationServiceImp implements CalculationService {

    @Override
    public Map<String, LocalTime> calculateMinFlightTimes(TicketsDTO ticketsDTO) {
        Map<String, LocalTime> minFlightTimes;
        minFlightTimes = new HashMap<>();
        ticketsDTO.getTickets().forEach(it -> {
            String carrier = it.getCarrier();
            LocalTime departureTime = it.getDepartureTime();
            LocalTime arrivalTime = it.getArrivalTime();

            long flightDurationSeconds = arrivalTime.toSecondOfDay() - departureTime.toSecondOfDay();

            if (minFlightTimes.containsKey(carrier)) {
                LocalTime currentMinTime = minFlightTimes.get(carrier);
                if (flightDurationSeconds < currentMinTime.toSecondOfDay()) {
                    minFlightTimes.put(carrier, LocalTime.ofSecondOfDay(flightDurationSeconds));
                }
            } else {
                minFlightTimes.put(carrier, LocalTime.ofSecondOfDay(flightDurationSeconds));
            }
        });
        return minFlightTimes;
    }

    @Override
    public double calculatePriceDifference(TicketsDTO ticketsDTO) {

        List<Double> prices = new ArrayList<>();

        final String targetOrigin = "VVO";
        final String targetDestination = "TLV";

        ticketsDTO.getTickets().forEach(it -> {
            String origin = it.getOrigin();
            String destination = it.getDestination();

            if (targetOrigin.equals(origin) && targetDestination.equals(destination)) {
                prices.add(it.getPrice());
            }
        });

        return calculateAverage(prices) - calculateMedian(prices);
    }

    @Override
    public ResultDTO calculateResultDTO(double difference, Map<String, LocalTime> minFlyTime) {
        var resultDTO = new ResultDTO();
        resultDTO.setMinFlightTimes(minFlyTime);
        resultDTO.setDifference(difference);
        return resultDTO;
    }

    private static double calculateAverage(List<Double> data) {
        if (data.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double price : data) {
            sum += price;
        }
        return sum / data.size();
    }

    private static double calculateMedian(List<Double> data) {
        if (data.isEmpty()) {
            return 0;
        }
        Collections.sort(data);
        int middle = data.size() / 2;
        return data.size() % 2 == 0 ? (data.get(middle - 1) + data.get(middle)) / 2.0 : data.get(middle);
    }

}
