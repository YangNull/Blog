package com.yangkangjian.blog.service.impl;

import com.yangkangjian.blog.dao.CommentDao;
import com.yangkangjian.blog.entity.Comment;
import com.yangkangjian.blog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 评论Service实现类
 *
 * @author Administrator
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    public int add(Comment comment) {
        return commentDao.add(comment);
    }

    public List<Comment> list(Map<String, Object> map) {
        return commentDao.list(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return commentDao.getTotal(map);
    }

    public Integer delete(Integer id) {
        return commentDao.delete(id);
    }

    public int update(Comment comment) {
        return commentDao.update(comment);
    }

}
