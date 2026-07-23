package com.tria.dto.res;

import com.tria.dto.model.DietaryRestrictionDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class UserInfoRes {
    private String userId;
    private String avatar;
    private String nickname;
    private Integer gender;
    private LocalDate birthday;
    private List<DietaryRestrictionDTO> list;
}
