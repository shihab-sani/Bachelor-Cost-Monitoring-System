package Bachelor.CostMonitoringSystem.Repositories;

import Bachelor.CostMonitoringSystem.Entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {
    Optional<RefreshToken> findByTokenAndRevokedFalse(String token);

    @Modifying
    @Query("update RefreshToken r set r.revoked = true where r.userId = :uid")
    void revokeAllForUser(@Param("uid") UUID userId);
}
