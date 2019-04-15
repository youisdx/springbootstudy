package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import com.soft1721.jianyue.api.mapper.ArticleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {

    @Resource
    private ArticleMapper articleMapper;
    @Test
    public void selectAll() {
        List<ArticleVO> list =new ArrayList<>();
        list = articleMapper.selectAll();
        System.out.println(list);

    }

    @Test
    public void getArticleById() {
        ArticleVO articleVO = articleMapper.getArticleById(1);
        List<Img> imgList= new ArrayList<>();
        imgList = articleMapper.selectImgByaId(1);
        articleVO.setImgs(imgList);
        System.out.println(articleVO);

    }
}