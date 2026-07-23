package com.tria.service.base.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.entity.IngredientMatch;
import com.tria.mapper.IngredientMatchMapper;
import com.tria.service.base.IngredientMatchIService;
/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class IngredientMatchServiceImpl extends ServiceImpl<IngredientMatchMapper, IngredientMatch> implements IngredientMatchIService{

}
