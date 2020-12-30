package com.course.system.controller.admin;

import com.course.server.domain.Role;
import com.course.server.dto.RoleDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.exception.ValidatorException;
import com.course.server.service.RoleService;
import com.course.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/role")
public class RoleController {

    private static final Logger LOG = LoggerFactory.getLogger(RoleController.class);
    public static final String BUSINESS_NAME = "角色";

    @Resource
    private RoleService roleService;

    /**
     * 列表查询
     */
    @RequestMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        //前端传入PageDto，后台服务给pageDto设置value，然后返回pageDto
        ResponseDto responseDto = new ResponseDto();
        roleService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    @RequestMapping("/save")
    public ResponseDto save(@RequestBody RoleDto roleDto) {
        //保存校检
        ValidatorUtil.require(roleDto.getName(), "角色");
        ValidatorUtil.length(roleDto.getName(), "角色", 1, 50);
        ValidatorUtil.require(roleDto.getDesc(), "描述");
        ValidatorUtil.length(roleDto.getDesc(), "描述", 1, 100);

        ResponseDto responseDto = new ResponseDto();
        roleService.save(roleDto);
        responseDto.setContent(roleDto);
        return responseDto;
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {//截取路径对应id
        LOG.info("id:{}", id);
        ResponseDto responseDto = new ResponseDto();
        roleService.delete(id);
        return responseDto;
    }

}