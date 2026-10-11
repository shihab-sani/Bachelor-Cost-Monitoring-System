package Bachelor.CostMonitoringSystem.Repositories;

import Bachelor.CostMonitoringSystem.Entity.BazarItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface BazarItemRepository extends JpaRepository<BazarItem, UUID> {
    List<BazarItem> findByPeriodId(UUID periodId);
    List<BazarItem> findByMemberIdOrderBySortOrderAscIdAsc(UUID memberId);

    @Query("select coalesce(sum(b.price),0) from BazarItem b where b.member.id = :memberId")
    BigDecimal sumPriceByMember(@Param("memberId") UUID memberId);

    @Query("select coalesce(sum(b.price),0) from BazarItem b where b.period.id = :periodId")
    BigDecimal sumPriceByPeriod(@Param("periodId") UUID periodId);
}
