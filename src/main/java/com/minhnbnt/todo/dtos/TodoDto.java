package com.minhnbnt.todo.dtos;

import jakarta.validation.constraints.NotEmpty;


public record TodoDto(

        @NotEmpty
        String description

) {}
