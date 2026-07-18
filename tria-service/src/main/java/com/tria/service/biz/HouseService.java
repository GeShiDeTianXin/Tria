package com.tria.service.biz;

import com.tria.dto.res.HomeInfoRes;

public interface HouseService {
    HomeInfoRes getHomeInfoByUserId(Long userId);
}
