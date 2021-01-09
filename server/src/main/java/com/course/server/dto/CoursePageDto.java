package com.course.server.dto;

/**
 * Created by luwf on 2021/1/8
 */
public class CoursePageDto extends PageDto{

    private String status;

    private String categoryId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CoursePageDto{");
        sb.append("status='").append(status).append('\'');
        sb.append(", categoryId='").append(categoryId).append('\'');
        sb.append(", page=").append(page);
        sb.append(", size=").append(size);
        sb.append(", total=").append(total);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
