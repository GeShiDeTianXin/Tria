package com.tria.service.biz;

import com.tria.dto.model.DietaryRestrictionDTO;

import java.util.List;

/**
 * 忌口食材
 */
public interface DietaryRestrictionService {
    /**
     * 获取饮食限制
     *
     * @param userId 用户ID
     * @return {@link List }<{@link DietaryRestrictionDTO }>
     */
    List<DietaryRestrictionDTO> getDietaryRestriction(Long userId);

    void saveDietaryRestriction(List<DietaryRestrictionDTO> dietaryRestriction);

    void deleteDietaryRestriction(Long dietaryRestrictionId);
}
