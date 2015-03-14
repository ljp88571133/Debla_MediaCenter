package com.debla.mediacenter.data;

import java.util.List;

/**
 * 媒体库
 * 用于存放和管理所有媒体对象
 * @author Cocoonshu
 * @date   2014-11-01 14:33:49
 */
public abstract class MediaPool {

	/**
	 * 排序方式
	 * @author Cocoonshu
	 * @date   2014-11-01 14:38:29
	 */
	public enum SortOrder {
		ASC,
		DESC
	}
	
	/**
	 * 排序条件
	 * @author Cocoonshu
	 * @date   2014-11-01 14:38:29
	 */
	public enum SortCondition {
		FileName,
		FileSize,
		Duration,
		Artist,
		Album
	}
	
	/**
	 * 获取媒体对象
	 * @param index
	 */
	public abstract void getMediaItem(int index);
	
	/**
	 * 获取已排序的媒体对象列表
	 * @param condition 排序条件
	 * @param order 排序方式
	 * @return
	 */
	public abstract List<MediaItem> getSortedList(SortCondition condition, SortOrder order);
}
