package com.soft1721.jianyue.api.controller;

import com.soft1721.jianyue.api.entity.Like;
import com.soft1721.jianyue.api.service.LikeService;
import com.soft1721.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/like")
public class LikeController {
    @Resource
    private LikeService likeService;

    @PostMapping("/add")
    public ResponseResult likeUser(@RequestParam("fromlikeUId") int fromlikeUId, @RequestParam("tolikeUId") int tolikeUId) {
        Like like = new Like();
        like.setFromlikeUId(fromlikeUId);
        like.setTolikeUId(tolikeUId);
        likeService.insertLike(like);
        return ResponseResult.success();
    }

    @PostMapping("/cancel")
    public ResponseResult cancelLike(@RequestParam("fromlikeUId") int fromlikeUId, @RequestParam("tolikeUId") int tolikeUId) {
        likeService.deletelike(fromlikeUId, tolikeUId);
        return ResponseResult.success();
    }
}
