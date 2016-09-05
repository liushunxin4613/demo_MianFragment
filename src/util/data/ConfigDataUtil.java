package util.data;

import com.leo.mainfragmentdemo.R;

public class ConfigDataUtil {
	
	public static class DataHttpUtil{
		public static String userJsonUri = "http://120.27.190.62:8000/v1/user/login";
	}
	

	/**
	 *MainActivity数据 
	 */
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

	/**
	 * 公共数据
	 */
	public static class DataRootFragmentUtil{
		public static int LayoutId = R.layout.item_fragment;

		public static int TvId = R.id.fm_tv;
	}

	/**
	 * 首页HOME Fragment数据
	 */
	public static class DataHomeFragmentUtil{
		public static int LayoutId = R.layout.fragment_home;
		
		public static int scrollViewId = R.id.fm_home_scrollview;

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

		public static int imgDrawableArrId[] = {
			R.drawable.page_indicator_focused
			,R.drawable.page_indicator_unfocused
		};

		//GridView
		public static int gridViewId = R.id.fm_home_gridView;
		public static int gridViewLayoutId = R.layout.item_home_layout;

		public static int gridViewFromArrId[] = {
			R.id.item_home_image
			,R.id.item_home_text
		};
		public static String gridViewToArrId[] = {
			"img"
			,"text"
		};

		//gridview icon
		public static int gridViewIconArrId[] = {
			R.drawable.icon_home_mall
			,R.drawable.icon_home_part
			,R.drawable.icon_home_second
			,R.drawable.icon_home_more
			,R.drawable.icon_home_more
			,R.drawable.icon_home_more
		};
		
		//gridview icon text
		public static int gridViewTextArrId[] = {
			R.string.fm_home_gridview_0
			,R.string.fm_home_gridview_1
			,R.string.fm_home_gridview_2
			,R.string.fm_home_gridview_3
			,R.string.fm_home_gridview_4
			,R.string.fm_home_gridview_5
		};
		
		public static int numColumns = 2;
		
		public static int iconWidth = 90;
		
		public static int restWidth = 160;
		
		/**
		 *  此值通过img的值计算img*2+40
		 */
		public static int minWidth = 220;
	}
	
	/**
	 * 登录Activity数据
	 */
	public static class DataLoginActivityUtil{
		
		public static int layoutId = R.layout.activity_login;
		
		public static int usernameEtId = R.id.ac_login_username_et;
		public static int pwdEtId = R.id.ac_login_pwd_et;
		
		public static int rememberCbId = R.id.ac_login_remember_cb;
		public static int submitBtId = R.id.ac_login_submit_bt;
		
	}

}
