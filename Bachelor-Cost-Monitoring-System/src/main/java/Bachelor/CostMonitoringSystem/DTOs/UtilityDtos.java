package Bachelor.CostMonitoringSystem.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class UtilityDtos {
    public record UtilityItemDto(UUID id, String label, BigDecimal amount, Integer sortOrder) {}
    public record UtilityItemRequest(@NotBlank String label, @NotNull BigDecimal amount, Integer sortOrder) {}
}
