package com.tria.convert;

import com.tria.dto.res.UserInfoRes;
import com.tria.entity.SysUser;
import com.tria.entity.UserDietRestriction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author xc
 * @since 2024-01-05
 */
@Mapper(componentModel = "spring")
public interface UserInfoConvert {
    @Mapping(source = "sysUser.id",target = "userId")
    @Mapping(source = "sysUser.avatar",target = "avatar")
    @Mapping(source = "sysUser.nickname",target = "nickname")
    @Mapping(source = "sysUser.gender",target = "gender")
    @Mapping(source = "sysUser.birthday",target = "birthday")
    @Mapping(source = "list",target = "list")
    UserInfoRes convertUserInfo(SysUser sysUser,List<UserDietRestriction> list);
}