package Bachelor.CostMonitoringSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "period_members",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"period_id","user_id"}),
                @UniqueConstraint(columnNames = {"period_id","column_order"})
        })
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeriodMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "period_id")
    private MealPeriod period;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 120)
    private String displayName;

    @Column(nullable = false)
    private int columnOrder;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MealEntry> meals = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("sortOrder ASC, id ASC")
    private List<BazarItem> bazarItems = new ArrayList<>();
}
