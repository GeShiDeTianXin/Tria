package com.tria.service.biz.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tria.dto.model.DietaryRestrictionDTO;
import com.tria.entity.UserDietRestriction;
import com.tria.service.base.UserDietRestrictionIService;
import com.tria.service.biz.DietaryRestrictionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author xc
 * @since 2024-01-05
 */
@Slf4j
@Service
@AllArgsConstructor
public class DietaryRestrictionServiceImpl implements DietaryRestrictionService {

    private final UserDietRestrictionIService userDietRestrictionIService;

    @Override
    public List<DietaryRestrictionDTO> getDietaryRestriction(Long userId) {
        List<UserDietRestriction> list = userDietRestrictionIService.list(Wrappers.<UserDietRestriction>lambdaQuery().eq(UserDietRestriction::getUserId, userId));
        if (CollUtil.isEmpty(list)) {
            return List.of();
        }
        return list.stream().map(item->{
            DietaryRestrictionDTO dto = new DietaryRestrictionDTO();
            dto.setId(item.getId());
            dto.setUserId(item.getUserId());
            dto.setIngredientId(item.getIngredientId());
            dto.setIngredientName(item.getIngredientName());
            dto.setRestrictionType(dto.getRestrictionType());
            dto.setIsLongTerm(dto.getIsLongTerm());
            dto.setStartDate(dto.getStartDate());
            dto.setEndDate(dto.getEndDate());
            return dto;
        }).toList();
    }

    @Override
    public void saveDietaryRestriction(List<DietaryRestrictionDTO> dietaryRestriction) {
        if (CollUtil.isEmpty(dietaryRestriction)) {
            return;
        }
        List<UserDietRestriction> list = dietaryRestriction.stream().map(item -> {
            UserDietRestriction userDietRestriction = new UserDietRestriction();
            userDietRestriction.setId(item.getId());
            userDietRestriction.setUserId(item.getUserId());
            userDietRestriction.setIngredientId(item.getIngredientId());
            userDietRestriction.setIngredientName(item.getIngredientName());
            userDietRestriction.setRestrictionType(item.getRestrictionType());
            userDietRestriction.setIsLongTerm(item.getIsLongTerm());
            userDietRestriction.setStartDate(item.getStartDate());
            userDietRestriction.setEndDate(item.getEndDate());
            if (Integer.valueOf(0).equals(item.getIsLongTerm()) && LocalDate.now().isAfter(userDietRestriction.getStartDate())
                    && LocalDate.now().isBefore(userDietRestriction.getEndDate())) {
                userDietRestriction.setStatus(1);
            } else {
                userDietRestriction.setStatus(0);
            }
            return userDietRestriction;
        }).toList();
        userDietRestrictionIService.saveOrUpdateBatch(list);
    }

    @Override
    public void deleteDietaryRestriction(Long dietaryRestrictionId) {
        userDietRestrictionIService.removeById(dietaryRestrictionId);
    }
}
