package Bachelor.CostMonitoringSystem.DTOs;

import java.util.UUID;

public class AuditLogDtos {
    public record AuditLogDto(UUID id, java.time.Instant occurredAt, String actorUsername,
                              String action, String entityType, String entityId, UUID periodId,
                              String description, String oldValue, String newValue,
                              String ipAddress, String userAgent) {}
}
