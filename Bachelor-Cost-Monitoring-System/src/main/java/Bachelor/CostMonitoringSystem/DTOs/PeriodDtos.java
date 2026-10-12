package Bachelor.CostMonitoringSystem.DTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class PeriodDtos {
    public record CreatePeriodRequest(
            @Min(2000) int year, @Min(1) @Max(12) int month,
            String label, BigDecimal buaPerPerson,
            List<UUID> memberUserIds) {}
    public record PeriodSummaryRow(
            UUID memberId, String displayName, int meals,
            BigDecimal bazarPaid, BigDecimal mealCost, BigDecimal remaining,
            BigDecimal checkTotal, BigDecimal netPayable) {}
    public record PeriodSummary(
            UUID periodId, int year, int month, String status,
            int totalMeals, BigDecimal totalBazar, BigDecimal perMealRate,
            BigDecimal utilityTotal, BigDecimal utilityPerPerson, BigDecimal buaPerPerson,
            List<PeriodSummaryRow> rows) {}
}
