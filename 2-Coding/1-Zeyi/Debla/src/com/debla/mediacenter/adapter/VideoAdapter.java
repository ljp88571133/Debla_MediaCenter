package com.debla.mediacenter.adapter;

import android.graphics.Bitmap;
import android.net.Uri;

import com.debla.mediacenter.data.MediaItem;

/**
 * 视频数据适配器
 * @author Cocoonshu
 * @date   2014-11-07 15:06:18
 */
public interface VideoAdapter {

	/**
	 * 获取缩略图
	 * @param item 媒体对象
	 * @return
	 */
	public Bitmap getThumbnail(MediaItem item);
	
	/**
	 * 获取数据源
	 * @param item 媒体对象
	 * @return
	 */
	public Uri getDataSource(MediaItem item);
	
}
