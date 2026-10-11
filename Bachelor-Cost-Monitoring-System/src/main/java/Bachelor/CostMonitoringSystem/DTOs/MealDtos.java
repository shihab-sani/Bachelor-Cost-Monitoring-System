package Bachelor.CostMonitoringSystem.DTOs;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class MealDtos {
    public record MealCell(UUID memberId, LocalDate date, int lunch, int dinner) {}
    public record BulkMealRequest(List<MealCell> cells) {}
}
