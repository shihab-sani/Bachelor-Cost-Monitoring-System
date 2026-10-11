package Bachelor.CostMonitoringSystem.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public class UserDtos {
    public record UserDto(UUID id, String username, String email, String fullName,
                          boolean enabled, List<String> roles,
                          List<PermissionOverride> permissions) {}

    public record PermissionOverride(String permission, boolean granted) {}

    public record CreateUserRequest(
            @NotBlank @Size(min=3,max=60) String username,
            @NotBlank @Email String email,
            @NotBlank @Size(min=8) String password,
            @NotBlank String fullName,
            List<String> roles,
            List<PermissionOverride> permissions) {}
    public record UpdateUserRequest(String email, String fullName, Boolean enabled) {}
    public record ChangePasswordRequest(@NotBlank String currentPassword, @NotBlank @Size(min=8) String newPassword) {}
}
