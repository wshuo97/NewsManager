package cn.web.wshuo.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.io.Serializable;

/**
 * Created by Apex_WS at 11:38 on 2017/12/31.
 */

public class NewsEntity implements Serializable {
    private static final long serialVersionUID = 4294967297L;

    private int newsId;
    private String newsTitle;
    private String newsDate;
    private String newsUrl;

    public NewsEntity() {
    }

    public NewsEntity(int newsId, String newTitle, String newsDate, String newsUrl) {
        this.newsId = newsId;
        this.newsTitle = newTitle;
        this.newsDate = newsDate;
        this.newsUrl = newsUrl;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    @Override
    public String toString() {
        return String.valueOf(getNewsId()) + "+" + getNewsTitle() + "+" + getNewsDate() + "+" + getNewsUrl();
    }
}
