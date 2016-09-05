package activity;

import com.leo.mainfragmentdemo.MainActivity;
import com.leo.mainfragmentdemo.R;

import entity.User;
import util.data.ConfigDataUtil.DataLoginActivityUtil;
import util.data.DataUtil;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import base.BaseActivity;

public class LoginActivity extends BaseActivity implements OnClickListener{

	private EditText usernameEt,pwdEt;
	private CheckBox rememberCb;
	private Button submitBt;

	private User user;

	@Override
	public int getRootViewId() {
		return DataLoginActivityUtil.layoutId;
	}

	@Override
	public void initView() {

		usernameEt = (EditText) findViewById(DataLoginActivityUtil.usernameEtId);
		pwdEt = (EditText) findViewById(DataLoginActivityUtil.pwdEtId);

		rememberCb = (CheckBox) findViewById(DataLoginActivityUtil.rememberCbId);

		submitBt = (Button) findViewById(DataLoginActivityUtil.submitBtId);
		submitBt.setOnClickListener(this);

	}

	@Override
	public void initData() {
		user = DataUtil.getUserLoginInfo(this);
		usernameEt.setHint(user.getUsername());
		pwdEt.setHint(user.getPwd());
		rememberCb.setChecked(user.isRemember());
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == DataLoginActivityUtil.submitBtId){//登录
			if (usernameEt.getText() != null) {
				if (usernameEt.getText().toString().trim().length() != 0) {
					user.setUsername(usernameEt.getText().toString());
				}
			}
			if (pwdEt.getText() != null) {
				if (pwdEt.getText().toString().trim().length() != 0) {
					user.setPwd(pwdEt.getText().toString());
				}
			}
			if (checkData(user)) {
				login();
			}else {
				String s = new String(getResources().getString(R.string.login_input_error_info));
				Toast.makeText(this, s, Toast.LENGTH_LONG).show();
			}
		}
	}

	//模拟数据
	private boolean isSuccess = true;

	//提交数据登录
	private void login() {
		String text = "";
		if (isSuccess) {
			text = new String(getResources().getString(R.string.login_success));
			loginSuccess();
		}else {
			text = new String(getResources().getString(R.string.login_error));
			loginError();
		}
		Toast.makeText(this, text, Toast.LENGTH_LONG).show();
	}

	//登录失败
	private void loginError() {
		user.setPwd(null);
		DataUtil.saveUserLoginInfo(this, user, rememberCb.isChecked());
	}

	//登录成功
	private void loginSuccess() {
		DataUtil.saveUserLoginInfo(this, user, rememberCb.isChecked());
		startActivity(new Intent(this, MainActivity.class));
	}

	/**
	 * 检查数据合法性
	 * @param user
	 * @return
	 */
	public boolean checkData(User user){
		if (user == null) {
			return false;
		}else {
			if (user.getUsername() == null) {
				return false;
			}else {
				if (user.getUsername().trim().length() == 0) {
					return false;
				}
			}
			if (user.getPwd() == null) {
				return false;
			}else {
				if (user.getPwd().trim().length() == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
