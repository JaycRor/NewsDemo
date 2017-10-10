package com.kevinAo.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevinAo.news.R;
import com.kevinAo.news.adapter.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AdminJax on 2017/10/9.
 */

public class FirstpagerFragment extends Fragment {

    private RecyclerView recyclerView;
    private PagerAdapter adapter;
    private List<String> img_url;
    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_layout,
                (ViewGroup) getActivity().findViewById(R.id.view_pager), false);


        img_url = new ArrayList<>();
        img_url.add("http://img.ivsky.com/img/tupian/co/201708/18/zhuangguanmeilidetitiantupian-005.jpg");
        img_url.add("http://img.ivsky.com/img/tupian/co/201708/14/jingqiaodefangdajingtupian-009.jpg");
        img_url.add("http://img.ivsky.com/img/tupian/co/201708/15/huopokeai_de_xiaoxiongmao-008.jpg");
        img_url.add("http://img.ivsky.com/img/tupian/co/201708/14/jingqiaodefangdajingtupian-009.jpg");
        img_url.add("http://img.ivsky.com/img/tupian/co/201708/17/banma-003.jpg");
        img_url.add("http://img.ivsky.com/img/tupian/co/201708/17/chongwumao-001.jpg");
        img_url.add("http://img4.imgtn.bdimg.com/it/u=2266315078,3967665466&fm=200&gp=0.jpg");
        img_url.add("http://img.ivsky.com/img/tupian/co/201708/14/jingqiaodefangdajingtupian-009.jpg");

        recyclerView = (RecyclerView) v.findViewById(R.id.rcview);
        toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        adapter = new PagerAdapter(getActivity(), img_url);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


        return v;
    }

}
