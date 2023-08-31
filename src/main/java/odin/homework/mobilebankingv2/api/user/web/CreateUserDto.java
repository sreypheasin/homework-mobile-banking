package odin.homework.mobilebankingv2.api.user.web;

public record CreateUserDto(
        String name,
        String gender,
        String password,
        String email,
        Boolean isStudent
        //        List<UserAccount> userAccounts,
//        List<UserRole> userRoles
) {
}
