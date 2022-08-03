package com.lyh.dao;

import com.lyh.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceMapper {

    /*
        广告位列表查询
     */
    public List<PromotionSpace> findAllPromotionSpace();

    /*
        新增广告位
     */
    public void svaePromotionSpace(PromotionSpace promotionSpace);

    /*
        根据id查询 查询广告位信息
     */
    public PromotionSpace findPromotionSpaceById(int id);

    /*
        修改广告位信息
     */
    public void updatePromotionSpace(PromotionSpace promotionSpace);
}
