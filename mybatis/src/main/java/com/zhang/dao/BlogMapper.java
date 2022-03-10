package com.zhang.dao;

import com.zhang.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 插入数据
    void addBlog(Blog blog);

    // 查询博客 (使用动态查询的判断语句)
    // 输出titie名输出对应根据title查询的信息
    List<Blog> queryBlogIF(Map map);

    // 使用choose查询博客
    List<Blog> queryBlogChoose(Map map);

    //使用set更新博客
    void updateBlogSet(Map map);

    // 使用for-each
    // 查询title为"Java" "Spring" 的集合

    List<Blog> queryBlogForeach(Map map);
}
