package dev.rudchenko.testassignment.service;

import dev.rudchenko.testassignment.service.dto.TicketsDTO;

public interface ParserService {
    TicketsDTO parseFromJson(String filePath);
}
