package com.example.Criteria_Builder.dto_classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonDto {
    private Long id;
    private String name;
    private String emailID;
    private String password;
    private Long age;
}
