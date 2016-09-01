package util.dataUtil;

import com.leo.mainfragmentdemo.R;

public class ConfigDataUtil {
	
	public static class DataMainActivityUtil{
		public static int LayoutId = R.layout.activity_main;
		
		public static int FrameId = R.id.ac_main_container;
		public static int RadioGroupId = R.id.ac_main_bottomgroup;
		public static int RadioButtonArrId[] = {
			R.id.ac_main_radio_home
			,R.id.ac_main_radio_collection
			,R.id.ac_main_radio_find
			,R.id.ac_main_radio_me
		};
		
	}
	
	public static class DataRootFragmentUtil{
		public static int LayoutId = R.layout.item_fragment;
		
		public static int TvId = R.id.fm_tv;
	}
	
	public static class DataHomeFragmentUtil{
		public static int LayoutId = R.layout.fragment_home;
		
		public static int ViewPagerId = R.id.fm_home_viewPager;
		public static int DotId = R.id.fm_home_dot;
//		public static int GridViewId = R.id.fm_home_gridView;
		
		public static int imgArrId[] = {
			R.drawable.item_01
			,R.drawable.item_02
			,R.drawable.item_03
		};
		
		public static int dotWidth = 10;
		public static int dotHight = 10;
		
	}
	
}
