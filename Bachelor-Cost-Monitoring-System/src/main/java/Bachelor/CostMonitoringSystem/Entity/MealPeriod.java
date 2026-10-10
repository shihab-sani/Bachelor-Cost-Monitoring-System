package Bachelor.CostMonitoringSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "meal_periods",
        uniqueConstraints = @UniqueConstraint(columnNames = {"year","month"}))
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false) private int year;
    @Column(nullable = false) private int month;   // 1..12
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PeriodStatus status = PeriodStatus.DRAFT;

    @Column(precision = 12, scale = 4)
    private BigDecimal perMealRate;

    @Column(precision = 14, scale = 2)
    private BigDecimal utilityTotal;

    @Column(precision = 14, scale = 2)
    private BigDecimal utilityPerPerson;

    @Column(precision = 14, scale = 2)
    private BigDecimal buaPerPerson;

    private Instant finalizedAt;
    private UUID finalizedBy;

    @Column(nullable = false, updatable = false) private Instant createdAt;
    private UUID createdBy;

    private Instant updatedAt;
    private UUID updatedBy;

    @Version
    private Long version;

    @OneToMany(mappedBy = "period", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("columnOrder ASC")
    private List<PeriodMember> members = new ArrayList<>();

    @OneToMany(mappedBy = "period", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("sortOrder ASC, id ASC")
    private List<UtilityItem> utilityItems = new ArrayList<>();

    @PrePersist
    void p() {
        createdAt = Instant.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    void u() {
        updatedAt = Instant.now();
    }
}
