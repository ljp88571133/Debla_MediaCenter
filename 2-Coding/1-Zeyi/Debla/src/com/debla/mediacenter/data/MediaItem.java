package com.debla.mediacenter.data;

/**
 * 媒体数据对象
 * 用于存储媒体的基本信息
 * @author Cocoonshu
 * @date   2014-11-01 13:48:02
 */
public class MediaItem {

	private static final String TAG = "MediaItem";

	protected long     mId       = 0;    // 媒体对象的数据库ID
	protected String   mFileName = null; // 媒体对象的文件名
	protected String   mFilePath = null; // 媒体对象的文件路径
	protected MIMEType mMimeType = null; // 媒体对象的媒体类型
	protected long     mFileSize = 0;    // 媒体对象的文件大小
	
	@Override
	public String toString() {
		StringBuilder detail = new StringBuilder();
		detail.append(mId == 0 ? "invalid" : "" + mId);
		detail.append(mFileName == null ? "null" : mFileName);
		detail.append(mMimeType == null ? "null" : mMimeType.toString());
		detail.append(mFilePath == null ? "null" : mFilePath);
		return detail.toString();
	}
}
