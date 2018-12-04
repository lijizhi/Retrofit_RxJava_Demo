package com.ljz.network.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ljz.network.entity.Banner;
import com.ljz.network.R;

/**
 * Created by Welive on 2018/12/4.
 * Banner的item
 */

public class BannerAdapter  extends BaseQuickAdapter<Banner.DataBean, BaseViewHolder> {

    private Context context;

    public BannerAdapter(int layoutResId,Context context) {
        super(layoutResId);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Banner.DataBean item) {
      helper.setText(R.id.tv_title,item.getTitle());
        Glide.with(mContext).load(item.getImagePath()).into((ImageView) helper.getView(R.id.iv_banner));
    }
}
