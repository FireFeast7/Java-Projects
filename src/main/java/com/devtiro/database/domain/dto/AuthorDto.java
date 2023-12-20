package com.devtiro.database.domain.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {

    private Long id;

    private String name;

    private Integer age;
}
