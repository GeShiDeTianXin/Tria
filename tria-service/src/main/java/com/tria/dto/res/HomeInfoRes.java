package com.tria.dto.res;

import com.tria.dto.model.HomeInfoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xc
 * @since 2024-01-05
 */
@Setter
@Getter
public class HomeInfoRes {
    private List<HomeInfoDTO> homeInfoDTOList;
}
