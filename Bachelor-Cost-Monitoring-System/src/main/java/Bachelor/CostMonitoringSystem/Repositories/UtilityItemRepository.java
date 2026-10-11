package Bachelor.CostMonitoringSystem.Repositories;

import Bachelor.CostMonitoringSystem.Entity.UtilityItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface UtilityItemRepository extends JpaRepository<UtilityItem, UUID> {
    List<UtilityItem> findByPeriodIdOrderBySortOrderAscIdAsc(UUID periodId);

    @Query("select coalesce(sum(u.amount),0) from UtilityItem u where u.period.id = :periodId")
    BigDecimal sumAmountByPeriod(@Param("periodId") UUID periodId);
}
