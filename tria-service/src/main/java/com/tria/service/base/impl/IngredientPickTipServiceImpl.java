package com.tria.service.base.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.mapper.IngredientPickTipMapper;
import com.tria.entity.IngredientPickTip;
import com.tria.service.base.IngredientPickTipIService;
/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class IngredientPickTipServiceImpl extends ServiceImpl<IngredientPickTipMapper, IngredientPickTip> implements IngredientPickTipIService{

}
