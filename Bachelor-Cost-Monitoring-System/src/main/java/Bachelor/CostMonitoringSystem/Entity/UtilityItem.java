package Bachelor.CostMonitoringSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "utility_items", indexes = @Index(name="idx_util_period", columnList="period_id"))
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilityItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "period_id")
    private MealPeriod period;

    @Column(nullable = false, length = 80)
    private String label;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    private Integer sortOrder;
}
