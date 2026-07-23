package com.tria.service.base.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.entity.UserDietRestriction;
import com.tria.mapper.UserDietRestrictionMapper;
import com.tria.service.base.UserDietRestrictionIService;
/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class UserDietRestrictionServiceImpl extends ServiceImpl<UserDietRestrictionMapper, UserDietRestriction> implements UserDietRestrictionIService{

}
