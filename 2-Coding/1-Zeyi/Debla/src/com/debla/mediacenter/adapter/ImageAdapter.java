package com.debla.mediacenter.adapter;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.debla.mediacenter.data.MediaItem;

/**
 * 图片数据适配器
 * @author Cocoonshu
 * @date   2014-11-07 14:57:36
 */
public interface ImageAdapter {

	/**
	 * 获取缩略图
	 * @param item 媒体对象
	 * @return
	 */
	public Bitmap getThumbnail(MediaItem item);
	
	/**
	 * 获取全屏图
	 * @param item 媒体对象
	 * @return
	 */
	public Bitmap getScreenNail(MediaItem item);
	
	/**
	 * 获取区域解码图
	 * @param item 媒体对象
	 * @param rect 解码区域
	 * @return
	 */
	public Bitmap getImageTile(MediaItem item, Rect rect);
}
