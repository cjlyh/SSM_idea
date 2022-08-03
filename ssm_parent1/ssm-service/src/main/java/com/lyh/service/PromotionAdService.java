package com.lyh.service;

import com.github.pagehelper.PageInfo;
import com.lyh.domain.PromotionAd;
import com.lyh.domain.PromotionAdVo;

import java.util.List;

public interface PromotionAdService {

    /*
        分页查询广告信息
     */

    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVo promotionAdVo);

    /*
        广告动态上下线
     */
    public void updatePromotionAdStatus(int id,int status);

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
