package activity;

import com.leo.mainfragmentdemo.R;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import base.BaseImmersionActivity;

@SuppressLint("SetJavaScriptEnabled") 
public class MapWebViewActivity extends BaseImmersionActivity {

	private WebView webView;
	private String uriStr = "http://map.onfun.net";
	
	@Override
	public int getRootViewId() {
		return R.layout.activity_map_webview;
	}

	@Override
	public void initView() {
		super.initView();
		
		webView = (WebView) findViewById(R.id.ac_wv);

		WebSettings settings = webView.getSettings();
		
		settings.setJavaScriptEnabled(true);//֧��JavaScript
		
		if (Build.VERSION.SDK_INT >= 19) {
			settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//����ʹ�û���
		}
		
		webView.setWebViewClient(new WebViewClient(){//�Ƿ���õ����������
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {//trueΪʹ��webview,false��ʾ������
				if (uriStr.startsWith("http:") || uriStr.startsWith("https:")) {
					view.loadUrl(url);
				}
				return true;
			}
		});
		
		webView.loadUrl(uriStr);
		
	}
	
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {//���÷��ؼ���webview����
    	if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (webView.canGoBack()) {
				webView.goBack();
				return true;
			} 
		}
    	return super.onKeyDown(keyCode, event);
    }

}
