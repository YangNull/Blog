package com.yangkangjian.blog.service.impl;

import com.yangkangjian.blog.dao.BlogTypeDao;
import com.yangkangjian.blog.entity.BlogType;
import com.yangkangjian.blog.service.BlogTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 博客类型Service实现类
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

    @Resource
    private BlogTypeDao blogTypeDao;

    public List<BlogType> countList() {
        return blogTypeDao.countList();
    }

    public List<BlogType> list(Map<String, Object> map) {
        return blogTypeDao.list(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return blogTypeDao.getTotal(map);
    }

    public Integer add(BlogType blogType) {
        return blogTypeDao.add(blogType);
    }

    public Integer update(BlogType blogType) {
        return blogTypeDao.update(blogType);
    }

    public Integer delete(Integer id) {
        return blogTypeDao.delete(id);
    }
}
