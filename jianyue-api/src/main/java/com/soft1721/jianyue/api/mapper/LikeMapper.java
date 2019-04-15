package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.Like;
import com.soft1721.jianyue.api.entity.vo.LikeVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LikeMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "fromlikeUId", column = "fromlike_uid"),
            @Result(property = "tolikeUId", column = "tolike_uid")
    })
    @Select("SELECT * FROM t_like WHERE fromlike_uid = #{fromlikeUId} AND tolike_uid = #{tolikeUId} ")
    Like getLike(@Param("fromlikeUId") int fromlikeUId, @Param("tolikeUId") int tolikeUId);

    @Results({
            @Result(property = "tolikeUId", column = "tolike_uid"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select("SELECT a.tolike_uid,b.nickname,b.avatar FROM t_like a LEFT JOIN t_user b ON a.tolike_uid = b.id WHERE a.fromlike_uid = #{fromlikeUId}  ")
    List<LikeVO> getLikeByUId(int fromlikeUId);

    @Insert("INSERT INTO t_like (fromlike_uid,tolike_uid) VALUES (#{fromlikeUId},#{tolikeUId}) ")
    void insertLike(Like like);

    @Delete("DELETE  FROM t_like WHERE fromlike_uid = #{fromlikeUId} AND tolike_uid = #{tolikeUId} ")
    void deleteLike(@Param("fromlikeUId") int fromlikeUId, @Param("tolikeUId") int tolikeUId);
}
