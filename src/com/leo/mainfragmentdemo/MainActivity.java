package com.leo.mainfragmentdemo;

import fragment.BFragment;
import fragment.CFragment;
import fragment.DFragment;
import fragment.HomeFragment;

import util.data.ConfigDataUtil.DataMainActivityUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import base.BaseImmersionFragmentActivity;


public class MainActivity extends BaseImmersionFragmentActivity{

	private FrameLayout frameLayout;
	
	private RadioGroup radioGroup;
	
	private RadioButton radioButtonArr[];
	
	private int location = 0;
	
	private FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
		
		@Override
		public int getCount() {
			return 4;
		}
		
		@Override
		public Fragment getItem(int pos) {
			switch (pos) {
			case 0:
				return new HomeFragment();
			case 1:
				return new BFragment();
			case 2:
				return new CFragment();
			case 3:
				return new DFragment();
			default:
				return null;
			}
		}
		
		public void destroyItem(ViewGroup container, int position, Object object) {
			Fragment fragment = (Fragment) object;
			container.removeView(fragment.getView());
		};
	};
	
	@Override
	public int getRootViewId() {
		return DataMainActivityUtil.LayoutId;
	}
	
	@Override
	public void initView() {
		super.initView();
		
		getActionBar().setDisplayShowHomeEnabled(false);
		isHome = false;
		
		frameLayout = (FrameLayout) findViewById(DataMainActivityUtil.FrameId);
		
		radioGroup = (RadioGroup) findViewById(DataMainActivityUtil.RadioGroupId);
		
		radioButtonArr = new RadioButton[DataMainActivityUtil.RadioButtonArrId.length];
		for (int i = 0; i < DataMainActivityUtil.RadioButtonArrId.length; i++) {
			radioButtonArr[i] = (RadioButton) findViewById(DataMainActivityUtil.RadioButtonArrId[i]);
			radioButtonArr[i].setId(i);
		}
		
		//初始化首键
		radioButtonArr[location].setChecked(true);
		radioButtonArr[location].setTextColor(getResources().getColor(R.color.base_blue));
		
		Fragment fragment = (Fragment) adapter.instantiateItem(frameLayout, location);
		adapter.setPrimaryItem(frameLayout, 0, fragment);
		adapter.finishUpdate(frameLayout);
		
		//点击事件
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				Fragment fragment = (Fragment) adapter.instantiateItem(
						frameLayout, checkedId);
				adapter.setPrimaryItem(frameLayout, 0, fragment);
				adapter.finishUpdate(frameLayout);
				
				radioButtonArr[location].setTextColor(getResources().getColor(R.color.text_gray));
				location = checkedId;
				radioButtonArr[location].setTextColor(getResources().getColor(R.color.base_blue));
			}
		});
		
	}

}
