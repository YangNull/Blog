package com.yangkangjian.blog.service.impl;

import com.yangkangjian.blog.dao.BloggerDao;
import com.yangkangjian.blog.entity.Blogger;
import com.yangkangjian.blog.service.BloggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 博主Service实现类
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {

    @Resource
    private BloggerDao bloggerDao;

    public Blogger find() {
        return bloggerDao.find();
    }

    public Blogger getByUserName(String userName) {
        return bloggerDao.getByUserName(userName);
    }

    public Integer update(Blogger blogger) {
        return bloggerDao.update(blogger);
    }


}