package com.debla.mediacenter.adapter;

import com.debla.mediacenter.data.MediaItem;

/**
 * 媒体数据适配器，为界面提供数据操作
 * @author Cocoonshu
 * @date   2014-11-07 23:17:05
 */
public interface MediaAdapter {

	/**
	 * 获取一个媒体对象
	 * @param index
	 */
	public MediaItem getItem(int index);

	/**
	 * 获取媒体数量
	 * @return
	 */
	public int getCount();
	
}
