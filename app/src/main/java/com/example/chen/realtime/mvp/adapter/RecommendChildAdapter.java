package com.example.chen.realtime.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.chen.realtime.R;
import com.example.chen.realtime.bean.Recommend;
import com.king.base.adapter.ViewHolderRecyclerAdapter;
import com.king.base.adapter.holder.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 */

public class RecommendChildAdapter extends ViewHolderRecyclerAdapter<Recommend.RoomBean.ListBean> {

    public RecommendChildAdapter(Context context, List<Recommend.RoomBean.ListBean> listData) {
        super(context, listData);
    }

    @Override
    public View buildConvertView(LayoutInflater layoutInflater, int viewType) {
        return inflate(R.layout.list_live_item);
    }

    @Override
    public void bindViewDatas(ViewHolder holder, Recommend.RoomBean.ListBean data, int position) {

        ImageView iv = holder.getView(R.id.iv);

        Glide.with(context).load(data.getThumb())
                .placeholder(R.mipmap.live_default).error(R.mipmap.live_default)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
        holder.setText(R.id.tvTitle,data.getTitle());
        holder.setText(R.id.tvName,data.getNick());
        holder.setText(R.id.tvViewer,data.getViews());

    }
}
