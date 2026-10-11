package Bachelor.CostMonitoringSystem.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class BazarDtos {
    public record BazarItemDto(UUID id, UUID memberId, String itemName, BigDecimal price, LocalDate purchaseDate, Integer sortOrder) {}
    public record BazarItemRequest(UUID memberId, @NotBlank String itemName, @NotNull BigDecimal price, LocalDate purchaseDate, Integer sortOrder) {}
}
