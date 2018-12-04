package com.ljz.network;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ljz.network.adapter.BannerAdapter;
import com.ljz.network.entity.Banner;
import com.ljz.network.api.BaseApi;
import com.ljz.network.api.ApiService;
import com.ljz.network.module.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BannerAdapter bannerAdapter;

    private List<Banner.DataBean> list =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRecyclerView();

        BaseApi.request(BaseApi.createApi(ApiService.class).getBanner(),
                new BaseApi.iResponseListener<Banner>() {
                    @Override
                    public void onSuccess(Banner data) {
                     if(list.size()>0){
                         list.clear();
                     }
                     list.addAll(data.getData());
                     bannerAdapter.addData(list);
                     bannerAdapter.notifyDataSetChanged();
                     dealData(list);
                    }

                    @Override
                    public void onFail() {

                    }
                });
    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        bannerAdapter=new BannerAdapter(R.layout.item_banner,this);
        recyclerView.setAdapter(bannerAdapter);
    }

    private void dealData(final List<Banner.DataBean> list) {
        bannerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra(Constant.KEY_FROM_MAIN_ACTIVITY,list.get(position).getUrl());
                startActivity(intent);
            }
        });
    }
}
