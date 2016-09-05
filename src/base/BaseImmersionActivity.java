package base;

import util.ui.KitKatUtils;
import util.ui.SystemBarTintManager;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;

import com.leo.mainfragmentdemo.R;

public class BaseImmersionActivity extends BaseActivity {
	/**
	 * ��������������ɫ���Ƿ�Ϊ��ɫ��Ĭ��Ϊ��ɫ
	 */
	private boolean isLight = true;
	/**
	 * ״̬������ɫ
	 */
	private int statusColor;
	
	private SystemBarTintManager systemBarManager;
	
	/**
	 * �Ƿ�ͨ��onOptionsItemSelected��Ӧ
	 */
	protected boolean isHome = true;

	/**
	 * @return ����֪ͨ������ɫ���Ƿ�Ϊ��ɫ
	 */
	public boolean isLight() {
		return isLight;
	}

	/**
	 * @param isLight
	 *            ����֪ͨ����������ɫ�Ƿ�Ϊ��ɫ������miui��Ч��,true ��ɫ; false ��ɫ
	 */
	public void setLight(boolean isLight) {
		this.isLight = isLight;
		KitKatUtils.setStatusBar(this, isLight);
	}

	/**
	 * ����֪ͨ������ɫ
	 * 
	 * @param resid
	 */
	public void setStatusColor(int color) {
		this.statusColor = color;
		systemBarManager = new SystemBarTintManager(this);
		systemBarManager.setStatusBarTintEnabled(true);
		systemBarManager.setStatusBarTintColor(statusColor);
	}

	/**
	 * ����֪ͨ������ɫ
	 * 
	 * @param drawable
	 */
	public void setBackgroundDrawable(Drawable drawable) {
		this.getWindow().setBackgroundDrawable(drawable);
	}

	@Override
	public void initView() {
		KitKatUtils.setStatusBar(this, isLight);
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayShowTitleEnabled(true);
		setStatusColor(getResources().getColor(R.color.immersionColor));
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		if (isHome) {
			int id = item.getItemId();
			switch (id) {
			case android.R.id.home:
				onBackPressed();
				return true;
			}
		}
		return super.onOptionsItemSelected(item);
	}
}
