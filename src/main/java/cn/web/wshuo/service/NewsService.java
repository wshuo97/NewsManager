package cn.web.wshuo.service;

import cn.web.wshuo.dao.NewsDao;
import cn.web.wshuo.entity.NewsEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Apex_WS at 11:38 on 2017/12/31.
 */

@Service

public class NewsService {
    @Autowired
    private NewsDao newsDao;

    // get all news
    public List<NewsEntity> getAllNews() {
        return newsDao.getAllNews();
    }

    //get news by id
    public NewsEntity getNewsById(int newsId) {
        return newsDao.getOneNewsById(newsId);
    }

    //get news by title
    public List<NewsEntity> getNewsByTitle(String newsTitle) {
        return newsDao.getOneNewsByTitle(newsTitle);
    }

    // get news by date
    public List<NewsEntity> getNewsByDate(String newsDate) {
        return newsDao.getOneNewsByDate(newsDate);
    }

    // get url by id
    public String getUrlById(int newsId) {
        return newsDao.getUrlById(newsId);
    }

    //add one news & news_id inc 1 & get now date
    public void insertNews(String newsTitle, String newsUrl) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newsDate = sdf.format(date).toString();
        newsDao.insertNews(newsTitle, newsDate, newsUrl);
    }

    //remove one news by id
    public void deleteNews(int newsId) {
        newsDao.deleteNews(newsId);
    }
}














