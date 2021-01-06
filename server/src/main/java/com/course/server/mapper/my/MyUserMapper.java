package com.course.server.mapper.my;

import com.course.server.dto.ResourceDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by luwf on 2021/1/6
 */
public interface MyUserMapper {
    List<ResourceDto> findResources(@Param("userId") String userId);
}
