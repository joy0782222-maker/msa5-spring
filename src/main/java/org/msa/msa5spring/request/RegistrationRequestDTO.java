package org.msa.msa5spring.request;

import jakarta.validation.constraints.*;

public record RegistrationRequestDTO(
    @NotBlank(message = "이메일 필수")
    @Pattern(regexp = "^[a-z]{4,8}$", message = "이메일 틀림")
    String email,

    @NotBlank(message = "비밀번호 필수")
    @Size(min = 2, max = 10, message = "비밀번호 2~10자")
    String password,

    String name,

    @Min(value = 0, message = "나이는 최소 0")
    @Max(value = 999, message = "나이는 최대 999")
    Integer age
    ) {}
