package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.Like;
import com.soft1721.jianyue.api.entity.vo.LikeVO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LikeService {
    Like getLike(int fromlikeUId, int tolikeUId);

    List<LikeVO> getlikeByUId(int fromlikeUId);

    void insertLike(Like like);

    void deletelike(int fromlikeUId, int tolikeUId);
}
