package com.tria.service.base.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.entity.SysDictType;
import com.tria.mapper.SysDictTypeMapper;
import com.tria.service.base.SysDictTypeIService;
/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeIService{

}
