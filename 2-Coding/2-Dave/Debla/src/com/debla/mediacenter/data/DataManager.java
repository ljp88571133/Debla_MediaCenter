package com.debla.mediacenter.data;

import java.util.List;

import android.content.Context;

/**
 * 对数据进行统一管理
 * @author Cocoonshu
 * @date   2014-11-01 13:45:59
 */
public class DataManager {

	private static DataManager me       = null;
	private        Context     mContext = null;
	
	public static DataManager getInstance(Context context) {
		if (me == null) {
			me = new DataManager(context);
		}
		return me;
	}
	
	private DataManager(Context context) {
		mContext = context;
	}
	
	/**
	 * 获取视频数据集
	 * @return
	 */
	public List<MediaItem> getVideoMediaSet() {
		// TODO
		return null;
	}
	
	/**
	 * 获取音乐数据集
	 * @return
	 */
	public List<MediaItem> getAudioMediaSet() {
		// TODO
		return null;
	}
	
	/**
	 * 获取图片数据集
	 * @return
	 */
	public List<MediaItem> getImageMediaSet() {
		// TODO
		return null;
	}
}
