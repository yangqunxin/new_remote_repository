package com.example.tabdemo;

import java.util.ArrayList;
import java.util.List;

import com.ab.view.sliding.AbBottomTabView;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class TabActivity extends FragmentActivity {

	private AbBottomTabView mBottomTabView;
	private List<Drawable> tabDrawables = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);

		mBottomTabView = (AbBottomTabView) findViewById(R.id.mBottomTabView);

		mBottomTabView.getViewPager().setOffscreenPageLimit(5);

		FragmentLoad page1 = new FragmentLoad();
		FragmentLoad2 page2 = new FragmentLoad2();
		FragmentRefresh page3 = new FragmentRefresh();
		FragmentLoad2 page4 = new FragmentLoad2();

		List<Fragment> mFragments = new ArrayList<Fragment>();
		mFragments.add(page1);
		mFragments.add(page2);
		mFragments.add(page3);
		mFragments.add(page4);

		List<String> tabTexts = new ArrayList<String>();
		tabTexts.add("精选");
		tabTexts.add("发现");
		tabTexts.add("广场");
		tabTexts.add("我的");

		// 设置样式
		mBottomTabView.setTabTextColor(Color.BLACK);
		// 选中后的字体的颜色
		mBottomTabView.setTabSelectColor(Color.rgb(155, 190, 79));
//		mBottomTabView.setTabBackgroundResource(R.drawable.tab_bg2);
		mBottomTabView.setTabBackgroundColor(Color.WHITE);
//		mBottomTabView.setTabLayoutBackgroundResource(R.drawable.tablayout_bg2);

		// 注意图片的顺序
		tabDrawables = new ArrayList<Drawable>();
		tabDrawables.add(this.getResources().getDrawable(
				R.drawable.collect_normal));
		tabDrawables.add(this.getResources().getDrawable(
				R.drawable.collect_pressed));
		tabDrawables.add(this.getResources()
				.getDrawable(R.drawable.find_normal));
		tabDrawables.add(this.getResources().getDrawable(
				R.drawable.find_pressed));
		tabDrawables.add(this.getResources().getDrawable(
				R.drawable.group_normal));
		tabDrawables.add(this.getResources().getDrawable(
				R.drawable.group_pressed));
		tabDrawables.add(this.getResources()
				.getDrawable(R.drawable.mine_normal));
		tabDrawables.add(this.getResources().getDrawable(
				R.drawable.mine_pressed));

		// 演示增加一组
		mBottomTabView.addItemViews(tabTexts, mFragments, tabDrawables);

		 mBottomTabView.setTabPadding(2,2, 2, 2);

	}

}
