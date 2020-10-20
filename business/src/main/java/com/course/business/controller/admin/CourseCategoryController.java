package com.course.business.controller.admin;

import com.course.server.dto.CourseCategoryDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.CourseCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/courseCategory")
public class CourseCategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseCategoryController.class);
    public static final String BUSINESS_NAME = "课程分类";

    @Resource
    private CourseCategoryService courseCategoryService;

    /**
     * 列表查询
     */
    @RequestMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        //前端传入PageDto，后台服务给pageDto设置value，然后返回pageDto
        ResponseDto responseDto = new ResponseDto();
        courseCategoryService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    @RequestMapping("/save")
    public ResponseDto save(@RequestBody CourseCategoryDto courseCategoryDto) {
        //保存校检

        ResponseDto responseDto = new ResponseDto();
        courseCategoryService.save(courseCategoryDto);
        responseDto.setContent(courseCategoryDto);
        return responseDto;
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {//截取路径对应id
        LOG.info("id:{}", id);
        ResponseDto responseDto = new ResponseDto();
        courseCategoryService.delete(id);
        return responseDto;
    }

}
