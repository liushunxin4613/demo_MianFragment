package com.leo.mainfragmentdemo;

import fragment.AFragment;
import fragment.BFragment;
import fragment.CFragment;
import fragment.DFragment;

import util.dataUtil.ConfigDataUtil.MainActivityData;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import base.BaseFragmentActivity;


public class MainActivity extends BaseFragmentActivity implements OnClickListener{

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
				return new AFragment();
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
		return MainActivityData.LayoutId;
	}
	
	@Override
	public void initView() {
		
		frameLayout = (FrameLayout) findViewById(MainActivityData.FrameId);
		
		radioGroup = (RadioGroup) findViewById(MainActivityData.RadioGroupId);
		
		radioButtonArr = new RadioButton[MainActivityData.RadioButtonArrId.length];
		for (int i = 0; i < MainActivityData.RadioButtonArrId.length; i++) {
			radioButtonArr[i] = (RadioButton) findViewById(MainActivityData.RadioButtonArrId[i]);
			radioButtonArr[i].setId(i);
			radioButtonArr[i].setOnClickListener(this);
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

	@Override
	public void onClick(View v) {
		
		
		
	}

}
