package Bachelor.CostMonitoringSystem.Repositories;

import Bachelor.CostMonitoringSystem.Entity.MealPeriod;
import Bachelor.CostMonitoringSystem.Entity.PeriodMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PeriodMemberRepository extends JpaRepository<PeriodMember, UUID> {
    List<PeriodMember> findByPeriodOrderByColumnOrderAsc(MealPeriod period);
}
