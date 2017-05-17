package com.yangkangjian.blog.web.controller.admin;

import com.yangkangjian.blog.entity.Blog;
import com.yangkangjian.blog.entity.BlogType;
import com.yangkangjian.blog.entity.Blogger;
import com.yangkangjian.blog.entity.Link;
import com.yangkangjian.blog.service.BlogService;
import com.yangkangjian.blog.service.BlogTypeService;
import com.yangkangjian.blog.service.BloggerService;
import com.yangkangjian.blog.service.LinkService;
import com.yangkangjian.blog.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 管理员系统Controller层
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {

    @Resource
    private BloggerService bloggerService;

    @Resource
    private BlogTypeService blogTypeService;

    @Resource
    private BlogService blogService;

    @Resource
    private LinkService linkService;

    /**
     * 刷新系统缓存
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/refreshSystem")
    public String refreshSystem(HttpServletResponse response, HttpServletRequest request) throws Exception {
        ServletContext application = RequestContextUtils.getWebApplicationContext(request).getServletContext();
        Blogger blogger = bloggerService.find(); // 查询博主信息
        blogger.setPassword(null);
        application.setAttribute("blogger", blogger);

        List<BlogType> blogTypeCountList = blogTypeService.countList(); // 查询博客类别以及博客的数量
        application.setAttribute("blogTypeCountList", blogTypeCountList);

        List<Blog> blogCountList = blogService.countList(); // 根据日期分组查询博客
        application.setAttribute("blogCountList", blogCountList);

        List<Link> linkList = linkService.list(null); // 获取所有友情链接
        application.setAttribute("linkList", linkList);

        JSONObject result = new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }
}
