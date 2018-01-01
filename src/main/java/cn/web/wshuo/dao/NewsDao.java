package cn.web.wshuo.dao;

import cn.web.wshuo.entity.NewsEntity;
import org.apache.ibatis.annotations.*;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

/**
 * Created by Apex_WS at 11:37 on 2017/12/31.
 */

public interface NewsDao {
    //mysql -- show all news
    @Select("SELECT * FROM news")
    @Results({
            @Result(property = "newsId", column = "news_id"),
            @Result(property = "newsTitle", column = "news_title"),
            @Result(property = "newsDate", column = "news_date"),
            @Result(property = "newsUrl", column = "news_url")
    })
    public List<NewsEntity> getAllNews();

    //mysql -- show one news by id
    @Select("SELECT * FROM news WHERE news_id = #{newsid}")
    @Results({
            @Result(property = "newsId", column = "news_id"),
            @Result(property = "newsTitle", column = "news_title"),
            @Result(property = "newsDate", column = "news_date"),
            @Result(property = "newsUrl", column = "news_url")
    })
    public NewsEntity getOneNewsById(@Param("newsid") int newsId);


    //mysql -- show one news by title
    @Select("SELECT * FROM news WHERE news_title LIKE CONCAT('%',#{newstitle},'%')")
    @Results({
            @Result(property = "newsId", column = "news_id"),
            @Result(property = "newsTitle", column = "news_title"),
            @Result(property = "newsDate", column = "news_date"),
            @Result(property = "newsUrl", column = "news_url")
    })
    public List<NewsEntity> getOneNewsByTitle(@Param("newstitle") String newsTitle);

    //mysql -- show one news by date
    @Select("SELECT * FROM news WHERE news_date LIKE CONCAT('%',#{newsdate},'%')")
    @Results({
            @Result(property = "newsId", column = "news_id"),
            @Result(property = "newsTitle", column = "news_title"),
            @Result(property = "newsDate", column = "news_date"),
            @Result(property = "newsUrl", column = "news_url")
    })
    public List<NewsEntity> getOneNewsByDate(@Param("newsdate") String newsDate);

    //mysql -- get url by id
    @Select("SELECT news_url FROM news WHERE news_id = #{newsid}")
    public String getUrlById(@Param("newsid") int newsId);

    //mysql -- add one news
    @Insert("INSERT INTO news(news_title, news_date, news_url) VALUES(#{newstitle}, #{newsdate}, #{newsurl})")
    public void insertNews(@Param("newstitle") String newsTietle, @Param("newsdate") String newsDate, @Param("newsurl") String newsUrl);

    //mysql -- remove one news
    @Delete("DELETE FROM news WHERE news_id = #{newsid}")
    public void deleteNews(@Param("newsid") int newsId);
}

