package com.pollServiceProject.userServiceFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "UserService",
        url = "${userService.url}"
)
public interface UserService {
    @GetMapping("/{userId}")
    UserServiceResponse getUserById(@PathVariable Long userId);
    @GetMapping("/check-registration/{userId}")
    Boolean isUserRegistered(@PathVariable Long userId);

}
