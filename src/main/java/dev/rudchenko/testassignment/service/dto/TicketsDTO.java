package dev.rudchenko.testassignment.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
public class TicketsDTO {
    @JsonProperty
    private List<FlyDataDTO> tickets;
    @Getter
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class FlyDataDTO {
        @JsonProperty
        private String origin;
        @JsonProperty
        private String originName;
        @JsonProperty
        private String destination;
        @JsonProperty
        private String destinationName;
        @JsonProperty
        @JsonFormat(pattern = "dd.MM.yy")
        private LocalDate departureDate;
        @JsonProperty()
        @JsonFormat(pattern = "k:mm")
        private LocalTime departureTime;
        @JsonProperty
        @JsonFormat(pattern = "dd.MM.yy")
        private LocalDate arrivalDate;
        @JsonProperty
        @JsonFormat(pattern = "k:mm")
        private LocalTime arrivalTime;
        @JsonProperty
        private String carrier;
        @JsonProperty
        private Integer stops;
        @JsonProperty
        private Double price;
    }
}
