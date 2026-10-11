package Bachelor.CostMonitoringSystem.DTOs;

import jakarta.validation.constraints.NotBlank;

public class AuthDtos {
    public record LoginRequest(@NotBlank String username, @NotBlank String password) {}
    public record RefreshRequest(@NotBlank String refreshToken) {}
    public record AuthResponse(String accessToken, String refreshToken, UserDtos user) {}
}
