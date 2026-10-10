package Bachelor.CostMonitoringSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "bazar_items", indexes = @Index(name="idx_bazar_period", columnList="period_id"))
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BazarItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "period_id")
    private MealPeriod period;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private PeriodMember member;

    @Column(nullable = false, length = 160)
    private String itemName;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    private LocalDate purchaseDate;
    private Integer sortOrder;
}
