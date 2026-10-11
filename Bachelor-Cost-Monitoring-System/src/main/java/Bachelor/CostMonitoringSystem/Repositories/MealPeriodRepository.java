package Bachelor.CostMonitoringSystem.Repositories;

import Bachelor.CostMonitoringSystem.Entity.MealPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MealPeriodRepository extends JpaRepository<MealPeriod, UUID> {
    Optional<MealPeriod> findByYearAndMonth(int year, int month);
    List<MealPeriod> findAllByOrderByYearDescMonthDesc();
}
