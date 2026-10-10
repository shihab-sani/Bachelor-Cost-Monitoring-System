package Bachelor.CostMonitoringSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "audit_logs",
        indexes = {
                @Index(name="idx_audit_actor", columnList="actorUserId"),
                @Index(name="idx_audit_entity", columnList="entityType,entityId"),
                @Index(name="idx_audit_period", columnList="periodId"),
                @Index(name="idx_audit_time", columnList="occurredAt")
        })
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private Instant occurredAt;

    private UUID actorUserId;

    @Column(length = 60)
    private String actorUsername;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private AuditAction action;

    @Column(nullable = false, length = 80)
    private String entityType;

    @Column(length = 80)
    private String entityId;

    private UUID periodId;

    @Column(length = 500)
    private String description;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String oldValue;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String newValue;

    @Column(length = 45)
    private String ipAddress;

    @Column(length = 300)
    private String userAgent;
}
