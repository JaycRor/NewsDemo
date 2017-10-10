package com.kevinAo.news.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.kevinAo.news.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * Created by AdminJax on 2017/10/9.
 */

public class PagerAdapter extends RecyclerView.Adapter {

    private final int TYPE_HEAD = 0;//首位轮播item
    private final int TYPE_NORMAL = 1;//正常item
    private Context mContext;
    private List<String> img_urls;

    public PagerAdapter(Context context, List<String> img_url) {
        this.mContext = context;
        this.img_urls = img_url;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        if (viewType == TYPE_HEAD) {
            viewHolder = new BannerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.banner_layout,
                    parent, false));
        } else {
            viewHolder = new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_firstfragment,
                    parent, false));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;

            //设置banner样式
            bannerViewHolder.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            //设置标题
            bannerViewHolder.banner.setBannerTitles(img_urls);
            //设置图片加载器
            bannerViewHolder.banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            bannerViewHolder.banner.setImages(img_urls);
            //banner设置方法全部调用完毕最后调用
            bannerViewHolder.banner.start();

        } else if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.textView.setText(img_urls.get(position - 1));
            itemViewHolder.simpleDraweeView.setImageURI(img_urls.get(position - 1));
        }

    }

    @Override
    public int getItemCount() {
        return img_urls.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEAD;
        } else {
            return TYPE_NORMAL;
        }
    }

    //正常显示item
    class ItemViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView simpleDraweeView;
        TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.simple_draweeview);
            textView = (TextView) itemView.findViewById(R.id.news_text);
        }
    }

    //banner显示
    class BannerViewHolder extends RecyclerView.ViewHolder {

        Banner banner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
        }
    }


    //chongxie图片加载器
    class GlideImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            //用fresco加载图片简单用法，记得要写下面的createImageView方法
            Uri uri = Uri.parse((String) path);
            imageView.setImageURI(uri);
        }

        //提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
        @Override
        public ImageView createImageView(Context context) {
            //使用fresco，需要创建它提供的ImageView，当然你也可以用自己自定义的具有图片加载功能的ImageView
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
            return simpleDraweeView;
        }
    }
}
