package util.ui;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

public class KitKatUtils {
	/**
	 * ����״̬��͸��
	 * @param activity Ŀ��Activity
	 * @param isLight �Ƿ�����״̬��ͼ��Ϊ��ɫ������MIUI��Ч
	 */
	@TargetApi(Build.VERSION_CODES.KITKAT)
	public static boolean setStatusBar(Activity activity, boolean isLight) {
		Window window = activity.getWindow();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			if ("xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {
				Class<?> clazz = window.getClass();
				try {
					int tranceFlag = 0;
					int darkModeFlag = 0;
					Class<?> layoutParams = Class
							.forName("android.view.MiuiWindowManager$LayoutParams");

					Field field = layoutParams
							.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT");
					tranceFlag = field.getInt(layoutParams);

					field = layoutParams
							.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
					darkModeFlag = field.getInt(layoutParams);

					Method extraFlagField = clazz.getMethod("setExtraFlags",
							int.class, int.class);

					if (isLight)
						// ֻ��Ҫ״̬��͸��
						extraFlagField.invoke(window, tranceFlag, tranceFlag);
					else
						// ״̬��͸���Һ�ɫ����
						extraFlagField.invoke(window,
								tranceFlag | darkModeFlag, tranceFlag
								| darkModeFlag);
					// �����ɫ����
					// extraFlagField.invoke(window, 0, darkModeFlag);
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				return true;
			}
			window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			return true;
		}
		return false;
	}

	/**
	 * ���õ�����͸��
	 * @param activity Ŀ��Activity
	 */
	@TargetApi(Build.VERSION_CODES.KITKAT)
	public static void setNavigationBar(Activity activity) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			Window window = activity.getWindow();
			window.setFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		}
	}
}
