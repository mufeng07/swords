package com.mufeng.blog.dto;

import java.io.Serializable;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/29 17:54
 */
public class ReqComment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long blogId;
    private String verifyCode;
    private String commentator;
    private String email;
    private String websiteUrl;
    private String commentBody;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
}
