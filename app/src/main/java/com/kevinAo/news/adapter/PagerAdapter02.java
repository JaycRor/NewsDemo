package com.kevinAo.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.kevinAo.news.R;

import java.util.List;

/**
 * Created by AdminJax on 2017/10/9.
 */

public class PagerAdapter02 extends RecyclerView.Adapter {
    private Context mContext;
    private List<String> img_urls;

    public PagerAdapter02(Context context,List<String> img_url){
        this.mContext=context;
        this.img_urls = img_url;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_secondfragment,
                parent,false);
        viewHolder = new ItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ItemViewHolder){
            ItemViewHolder itemViewHolder= (ItemViewHolder) holder;
//            itemViewHolder.textView.setText(img_urls.get(position));
            itemViewHolder.simpleDraweeView.setImageURI(img_urls.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return img_urls.size();
    }
    //item
    class ItemViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView simpleDraweeView;
        TextView textView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.sim_draweeview02);
            textView= (TextView) itemView.findViewById(R.id.item_title);
        }
    }
}
