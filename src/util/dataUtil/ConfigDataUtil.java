package util.dataUtil;

import com.leo.mainfragmentdemo.R;

public class ConfigDataUtil {
	
	public static class MainActivityData{
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
	
	public static class FragmentData{
		public static int LayoutId = R.layout.item_fragment;
		
		public static int TvId = R.id.fm_tv;
		
	}
	
}
