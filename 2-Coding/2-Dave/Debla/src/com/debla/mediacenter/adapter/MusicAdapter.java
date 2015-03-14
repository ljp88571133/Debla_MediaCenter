package com.debla.mediacenter.adapter;

import android.graphics.Bitmap;
import android.net.Uri;

import com.debla.mediacenter.data.MediaItem;

/**
 * 音乐数据适配器
 * @author Cocoonshu
 * @date   2014-11-07 14:58:07
 */
public interface MusicAdapter extends MediaAdapter {

	/**
	 * 获取缩略图
	 * @param item 媒体对象
	 * @return
	 */
	public Bitmap getThumbnail(MediaItem item);
	
	/**
	 * 获取全屏缩略图
	 * @param item 媒体对象
	 * @return
	 */
	public Bitmap getScreenNail(MediaItem item);
	
	/**
	 * 获取数据源
	 * @param item 媒体对象
	 * @return
	 */
	public Uri getDataSource(MediaItem item);
}
