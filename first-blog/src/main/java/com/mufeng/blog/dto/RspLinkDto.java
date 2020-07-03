package com.mufeng.blog.dto;

import com.mufeng.blog.entity.BlogLink;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/29 17:04
 */
public class RspLinkDto implements Serializable {
    private List<BlogLink> favoriteLinks;
    private List<BlogLink> recommendLinks;
    private List<BlogLink> personalLinks;

    public List<BlogLink> getFavoriteLinks() {
        return favoriteLinks;
    }

    public void setFavoriteLinks(List<BlogLink> favoriteLinks) {
        this.favoriteLinks = favoriteLinks;
    }

    public List<BlogLink> getRecommendLinks() {
        return recommendLinks;
    }

    public void setRecommendLinks(List<BlogLink> recommendLinks) {
        this.recommendLinks = recommendLinks;
    }

    public List<BlogLink> getPersonalLinks() {
        return personalLinks;
    }

    public void setPersonalLinks(List<BlogLink> personalLinks) {
        this.personalLinks = personalLinks;
    }
}
