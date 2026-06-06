package com.spring.abir.module3hospital.dto;

import com.spring.abir.module3hospital.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
