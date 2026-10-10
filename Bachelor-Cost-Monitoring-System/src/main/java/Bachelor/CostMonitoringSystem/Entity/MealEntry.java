package Bachelor.CostMonitoringSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "meal_entries",
        uniqueConstraints = @UniqueConstraint(columnNames = {"period_id","member_id","entry_date"}),
        indexes = @Index(name="idx_meal_period_date", columnList = "period_id,entry_date"))
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "period_id")
    private MealPeriod period;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private PeriodMember member;

    @Column(name = "entry_date", nullable = false)
    private LocalDate entryDate;

    @Column(nullable = false)
    private int lunch;

    @Column(nullable = false)
    private int dinner;
}
