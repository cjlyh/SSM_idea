package com.lyh.dao;

import com.lyh.domain.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {

    /*
        分页查询广告信息
     */

    public List<PromotionAd> findAllPromotionAdByPage();

    /*
        广告动态上下线
     */
    public void updatePromotionAdStatus(PromotionAd promotionAd);

    /*
        新增广告信息
     */
    public void  savePromotionAd(PromotionAd promotionAd);

    /*
        修改广告信息
     */
    public void updatePromotionAd(PromotionAd promotionAd);

    /*
        根据ID回显广告信息
     */
    public PromotionAd findPromotionAdById(int id);
}
