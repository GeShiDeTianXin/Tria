package com.tria.service.base.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.mapper.NutrientDictMapper;
import com.tria.entity.NutrientDict;
import com.tria.service.base.NutrientDictIService;
/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class NutrientDictServiceImpl extends ServiceImpl<NutrientDictMapper, NutrientDict> implements NutrientDictIService{

}
