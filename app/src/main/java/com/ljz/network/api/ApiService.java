package com.ljz.network.api;

import com.ljz.network.entity.Banner;
import com.ljz.network.entity.PublicAddress;

import io.reactivex.Observable;
import retrofit2.http.GET;

//接口
public interface ApiService {

   //获取公众号列表
    @GET("wxarticle/chapters/json")
    Observable<PublicAddress> getPublicAddressList();

    //获取Banner
    @GET("banner/json")
    Observable<Banner> getBanner();
}
