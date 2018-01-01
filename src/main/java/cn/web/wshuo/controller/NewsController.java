package cn.web.wshuo.controller;

import cn.web.wshuo.entity.NewsEntity;
import cn.web.wshuo.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Apex_WS at 11:37 on 2017/12/31.
 */

@RestController
@RequestMapping(value = "/newsController")
@Api(value = "NewsController")

public class NewsController {
    @Autowired
    private NewsService newsService;

    @ApiOperation(value = "获得全部新闻", httpMethod = "GET")
    @RequestMapping(value = "/getAllNews")
    public String getAllNews() {
        List<NewsEntity> news = newsService.getAllNews();
        String info = "";
        for (NewsEntity item : news) {
            info += item.toString() + "*";
        }
        if (info.length() <= 0) return null;
        return info.substring(0, info.length() - 1);
    }

    @ApiOperation(value = "通过id获得新闻", httpMethod = "GET")
    @RequestMapping(value = "/getNewsById")
    public String getNewsById(@RequestBody String newsId) {
        //System.out.println(newsId);
        NewsEntity news = newsService.getNewsById(Integer.valueOf(newsId));
        return news.toString();
    }

    @ApiOperation(value = "通过title获得新闻", httpMethod = "GET")
    @RequestMapping(value = "/getNewsByTitle")
    public String getNewsByTitle(@RequestBody String newsTitle) {
        List<NewsEntity> news = newsService.getNewsByTitle(newsTitle);
        String info = "";
        for (NewsEntity item : news) {
            info += item.toString() + "*";
        }
        if (info.length() == 0) return null;
        return info.substring(0, info.length() - 1);
    }

    @ApiOperation(value = "通过date获得新闻", httpMethod = "GET")
    @RequestMapping(value = "/getNewsByDate")
    public String getNewsByDate(@RequestBody String newsDate) {
        List<NewsEntity> news = newsService.getNewsByDate(newsDate);
        String info = "";
        for (NewsEntity item : news) {
            info += item.toString() + "*";
        }
        return info.substring(0, info.length() - 1);
    }

    @ApiOperation(value = "通过id获得url", httpMethod = "GET")
    @RequestMapping(value = "/getUrlById")
    public String getUrlById(@RequestParam("newsid") int newsId) {
        return newsService.getUrlById(newsId);
    }

    @ApiOperation(value = "添加新闻", httpMethod = "GET")
    @RequestMapping(value = "/insertNews")
    public int insertNews(@RequestBody String newsInfo) {
        //System.out.println(newsInfo);
        String[] info = newsInfo.split("\\*");
        if (info.length != 2) return 0;
        newsService.insertNews(info[0], info[1]);
        return 1;
    }

    @ApiOperation(value = "通过id删除新闻", httpMethod = "POST")
    @RequestMapping(value = "/deleteNews")
    public int deleteNews(@RequestBody String newsId) {
        newsService.deleteNews(Integer.valueOf(newsId));
        return 1;
    }
}









