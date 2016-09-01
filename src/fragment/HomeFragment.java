package fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customLib.ExpandGridView;

import util.dataUtil.ConfigDataUtil.DataHomeFragmentUtil;
import adapter.GridViewAdapter;
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
	
	private int imgDrawableArrId[];
	
	//GridView
	private ExpandGridView gridView;
	private GridViewAdapter gridViewAdapter;
	
	private String to[];
	
	private int iconArr[];
	private int textArr[];
	
	private int numColumns;

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

		//初始化imgDrawableArrId
		imgDrawableArrId = DataHomeFragmentUtil.imgDrawableArrId;
		
		for (int i = 0; i < imgArr.length; i++) {
			imgArr[i] = getView(imgDrawableArrId[1]);
			group.addView(imgArr[i],params);
		}
		
		imgArr[location].setBackgroundResource(imgDrawableArrId[0]);

		adapter = new ImgPagerAdapter(list);

		viewPager.setAdapter(adapter);

		viewPager.setCurrentItem(size * ImgPagerAdapter.MAX);

		viewPager.setOnPageChangeListener(this);
		
		//GridView
		gridView = (ExpandGridView) rootView.findViewById(DataHomeFragmentUtil.gridViewId);
		
		to = DataHomeFragmentUtil.gridViewToArrId;
		
		iconArr = DataHomeFragmentUtil.gridViewIconArrId;
		textArr = DataHomeFragmentUtil.gridViewTextArrId;
		
		List<Map<String, Integer>> mList = new ArrayList<Map<String,Integer>>();
		
		for (int i = 0; i < iconArr.length; i++) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put(to[0], iconArr[i]);
			map.put(to[1], textArr[i]);
			mList.add(map);
		}
		
		gridViewAdapter = new GridViewAdapter(getActivity(), mList, DataHomeFragmentUtil.gridViewLayoutId,
				DataHomeFragmentUtil.gridViewFromArrId, to);
		gridView.setAdapter(gridViewAdapter);
		
		numColumns = DataHomeFragmentUtil.numColumns;
		
		gridView.setNumColumns(numColumns);
		
		gridView.setColumnWidth(getWindowsWidth()/numColumns);
		
		gridViewAdapter.setParameter(numColumns, numColumns * DataHomeFragmentUtil.iconWidth + DataHomeFragmentUtil.restWidth);
		
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
