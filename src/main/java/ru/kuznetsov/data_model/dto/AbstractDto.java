package ru.kuznetsov.data_model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractDto {
    private Long id;
    private LocalDateTime created;
    private LocalDateTime updated;
}
