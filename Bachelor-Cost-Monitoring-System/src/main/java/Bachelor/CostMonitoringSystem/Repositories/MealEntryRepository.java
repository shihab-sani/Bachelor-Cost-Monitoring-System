package Bachelor.CostMonitoringSystem.Repositories;

import Bachelor.CostMonitoringSystem.Entity.MealEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MealEntryRepository extends JpaRepository<MealEntry, UUID> {
    List<MealEntry> findByPeriodId(UUID periodId);
    Optional<MealEntry> findByMemberIdAndEntryDate(UUID memberId, LocalDate date);

    @Query("select coalesce(sum(m.lunch + m.dinner),0) from MealEntry m where m.member.id = :memberId")
    int sumMealsByMember(@Param("memberId") UUID memberId);

    @Query("select coalesce(sum(m.lunch + m.dinner),0) from MealEntry m where m.period.id = :periodId")
    int sumMealsByPeriod(@Param("periodId") UUID periodId);
}
