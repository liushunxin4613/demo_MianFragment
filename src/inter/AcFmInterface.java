package inter;

public interface AcFmInterface {

	/**
	 * ��ʼ������������ĸ��ͼ֮ǰ
	 */
	void initRootView();
	
	/**
	 * ����ĸ��ͼid
	 * @return
	 */
	int getRootViewId();
	
	/**
	 * ��ȡĸ��ͼ���ʼ������
	 */
	void initView();
	
	/**
	 * ��ȡ�������ʼ�����ݼ�UI
	 */
	void initData();
	
}
