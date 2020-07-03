package com.mufeng.blog.controller.blog;


import com.mufeng.blog.controller.vo.BlogDetailVO;
import com.mufeng.blog.dto.ReqComment;
import com.mufeng.blog.dto.RspLinkDto;
import com.mufeng.blog.entity.BlogComment;
import com.mufeng.blog.entity.BlogLink;
import com.mufeng.blog.service.BlogService;
import com.mufeng.blog.service.CategoryService;
import com.mufeng.blog.service.CommentService;
import com.mufeng.blog.service.ConfigService;
import com.mufeng.blog.service.LinkService;
import com.mufeng.blog.service.TagService;
import com.mufeng.blog.util.MyBlogUtils;
import com.mufeng.blog.util.PageResult;
import com.mufeng.blog.util.PatternUtil;
import com.mufeng.blog.util.Result;
import com.mufeng.blog.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
@RestController
@RequestMapping("/page")
public class MyBlogController {


    public static String theme = "amaze";
    @Resource
    private BlogService blogService;
    @Resource
    private TagService tagService;
    @Resource
    private LinkService linkService;
    @Resource
    private CommentService commentService;
    @Resource
    private ConfigService configService;
    @Resource
    private CategoryService categoryService;


    /**
     * 首页 分页数据
     *
     * @return
     */
    @GetMapping({"/index/{pageNum}"})
    public PageResult page( @PathVariable("pageNum") int pageNum) {
        return blogService.getBlogsForIndexPage(pageNum);
    }
    @GetMapping({"/getBlogListForIndexPage/{type}"})
    public Result getBlogListForIndexPage(@PathVariable("type") int type){
        return Result.rspSucc(blogService.getBlogListForIndexPage(type));
    }
    @GetMapping({"/hotTags"})
    public Result hotTags(){
        return Result.rspSucc(tagService.getBlogTagCountForIndex());
    }
    @GetMapping({"/configurations"})
    public Result configurations(){
        return Result.rspSucc(configService.getAllConfigs());
    }

    /**
     * Categories页面(包括分类数据和标签数据)
     *
     * @return
     */
    @GetMapping({"/categories"})
    public Result categories() {
        return Result.rspSucc(categoryService.getAllCategories());
    }

    /**
     * 详情页
     *
     * @return
     */
    @GetMapping({"/blog/{blogId}", "/article/{blogId}"})
    public Result<BlogDetailVO> detail(HttpServletRequest request, @PathVariable("blogId") Long blogId, @RequestParam(value = "commentPage", required = false, defaultValue = "1") Integer commentPage) {
        return Result.rspSucc(blogService.getBlogDetail(blogId));
    }
    @GetMapping({"/getCommentPage/{blogId}"})
    public PageResult getCommentPage(@PathVariable("blogId") Long blogId, @RequestParam(value = "commentPage", required = false, defaultValue = "1") Integer commentPage){
        return commentService.getCommentPageByBlogIdAndPageNum(blogId, commentPage);
    }


    /**
     * 标签列表页
     *
     * @return
     */
    @GetMapping({"/tag/{tagName}/{page}"})
    public PageResult tag(@PathVariable("tagName") String tagName, @PathVariable("page") Integer page) {
        return blogService.getBlogsPageByTag(tagName, page);
    }

    /**
     * 分类列表页
     *
     * @return
     */
    @GetMapping({"/category/{categoryName}/{page}"})
    public PageResult category(@PathVariable("categoryName") String categoryName, @PathVariable("page") Integer page) {
        return blogService.getBlogsPageByCategory(categoryName, page);
    }


    /**
     * 搜索列表页
     *
     * @return
     */
    @GetMapping({"/search/{keyword}/{page}"})
    public PageResult search(@PathVariable("keyword") String keyword, @PathVariable("page") Integer page) {
        return blogService.getBlogsPageBySearch(keyword, page);
    }


    /**
     * 友情链接页
     *
     * @return
     */
    @GetMapping({"/link"})
    public Result<RspLinkDto> link() {
        Map<Byte, List<BlogLink>> linkMap = linkService.getLinksForLinkPage();
        if (linkMap != null) {
            RspLinkDto rspLinkDto=new RspLinkDto();
            //判断友链类别并封装数据 0-友链 1-推荐 2-个人网站
            if (linkMap.containsKey((byte) 0)) {
                rspLinkDto.setFavoriteLinks(linkMap.get((byte) 0));
            }
            if (linkMap.containsKey((byte) 1)) {
                rspLinkDto.setRecommendLinks(linkMap.get((byte) 1));
            }
            if (linkMap.containsKey((byte) 2)) {
                rspLinkDto.setPersonalLinks(linkMap.get((byte) 2));
            }
            return Result.rspSucc(rspLinkDto);
        }
        return Result.rspSucc();
    }

    /**
     * 评论操作
     */
    @PostMapping(value = "/blog/comment")
    public Result comment(@RequestBody ReqComment req) {
        BlogComment comment = new BlogComment();
        comment.setBlogId(req.getBlogId());
        comment.setCommentator(MyBlogUtils.cleanString(req.getCommentator()));
        comment.setEmail(req.getEmail());
        if (PatternUtil.isURL(req.getWebsiteUrl())) {
            comment.setWebsiteUrl(req.getWebsiteUrl());
        }
        comment.setCommentBody(MyBlogUtils.cleanString(req.getCommentBody()));
        return ResultGenerator.genSuccessResult(commentService.addComment(comment));
    }

    /**
     * 关于页面 以及其他配置了subUrl的文章页
     *
     * @return
     */
    @GetMapping({"/{subUrl}"})
    public Result<BlogDetailVO> detail(@PathVariable("subUrl") String subUrl) {
        return Result.rspSucc(blogService.getBlogDetailBySubUrl(subUrl));
    }
}
