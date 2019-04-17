package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Like;
import com.soft1721.jianyue.api.entity.vo.LikeVO;
import com.soft1721.jianyue.api.mapper.LikeMapper;
import com.soft1721.jianyue.api.service.LikeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    @Resource
    private LikeMapper likeMapper;

    @Override
    public Like getLike(int fromlikeUId, int tolikeUId) {
        return likeMapper.getLike(fromlikeUId, tolikeUId);
    }

    @Override
    public List<LikeVO> getlikeByUId(int fromlikeUId) {
        return likeMapper.getLikeByUId(fromlikeUId);
    }

    @Override
    public void insertLike(Like like) {
        likeMapper.insertLike((like));

    }

    @Override
    public void deletelike(int fromlikeUId, int tolikeUId) {
        likeMapper.deleteLike(fromlikeUId, tolikeUId);
    }
}
