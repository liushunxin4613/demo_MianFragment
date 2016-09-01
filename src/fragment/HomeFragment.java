package fragment;

import java.util.ArrayList;
import java.util.List;

import com.leo.mainfragmentdemo.R;

import util.dataUtil.ConfigDataUtil.DataHomeFragmentUtil;
import adapter.ImgPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import base.BaseMainFragment;

public class HomeFragment extends BaseMainFragment implements OnPageChangeListener{

	private ViewPager viewPager;

	private ImgPagerAdapter adapter;

	private List<ImageView> list;

	private ImageView imgArr[];

	private int size;
	
	private int location = 0;

	private int imgDrawableArrId[] = {
			R.drawable.page_indicator_focused
			,R.drawable.page_indicator_unfocused
	};

	@Override
	public int getRootViewId() {
		return DataHomeFragmentUtil.LayoutId;
	}

	@Override
	public void initView() {
		
		viewPager = (ViewPager) rootView.findViewById(DataHomeFragmentUtil.ViewPagerId);

		LayoutParams lp = (LayoutParams) viewPager.getLayoutParams();
		lp.height = getWindowsWidth()/8*5;
		viewPager.setLayoutParams(lp);

		list = new ArrayList<ImageView>();

		size = DataHomeFragmentUtil.imgArrId.length;

		for (int i = 0; i < size; i++) {
			ImageView img = new ImageView(getActivity());
			img.setBackgroundResource(DataHomeFragmentUtil.imgArrId[i]);
			list.add(img);
		}

		//初始化小点
		ViewGroup group = (ViewGroup) rootView.findViewById(DataHomeFragmentUtil.DotId);

		imgArr = new ImageView[size];

		//设置小圆点间距
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		int margin = 20;
		params.setMargins(margin, margin, margin, margin);

		for (int i = 0; i < imgArr.length; i++) {
			imgArr[i] = getView(imgDrawableArrId[1]);
			group.addView(imgArr[i],params);
		}
		
		imgArr[location].setBackgroundResource(imgDrawableArrId[0]);

		adapter = new ImgPagerAdapter(list);

		viewPager.setAdapter(adapter);

		viewPager.setCurrentItem(size * ImgPagerAdapter.MAX);

		viewPager.setOnPageChangeListener(this);

	}

	public ImageView getView(int resid){
		ImageView imageView = new ImageView(getActivity());
		LayoutParams params = new LayoutParams(DataHomeFragmentUtil.dotWidth, DataHomeFragmentUtil.dotHight);
		imageView.setLayoutParams(params);
		imageView.setBackgroundResource(resid);
		return imageView;
	}

	@Override
	public void onPageScrollStateChanged(int postion) {
	}

	@Override
	public void onPageScrolled(int postion, float f, int i) {
	}

	@Override
	public void onPageSelected(int postion) {

		postion %= size;

		for (int i = 0; i < imgArr.length; i++) {
			if (i == postion) {
				imgArr[i].setBackgroundResource(imgDrawableArrId[0]);
			}else {
				imgArr[i].setBackgroundResource(imgDrawableArrId[1]);
			}
		}
		
		//储存标记
		location = postion;

	}

}
