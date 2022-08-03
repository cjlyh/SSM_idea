package com.lyh.service;

import com.lyh.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {
    /*
        获取所有广告位
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
