package com.pollServiceProject.userServiceFeignClient;

public class UserServiceResponse {
        private Long id;
        public UserServiceResponse(){};

    public UserServiceResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}



