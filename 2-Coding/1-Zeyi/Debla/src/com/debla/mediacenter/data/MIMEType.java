package com.debla.mediacenter.data;

import android.media.AudioManager;

/**
 * 媒体对象类型
 * @author Cocoonshu
 * @date   2014-11-01 13:51:07
 */
public class MIMEType {

//	audio/basic	             au
//	audio/basic	             snd
//	audio/mid	             mid
//	audio/mid	             rmi
//	audio/mpeg	             mp3
//	audio/x-aiff	         aif
//	audio/x-aiff	         aifc
//	audio/x-aiff	         aiff
//	audio/x-mpegurl	         m3u
//	audio/x-pn-realaudio	 ra
//	audio/x-pn-realaudio	 ram
//	audio/x-wav	             wav
	
//	video/mpeg	             mp2
//	video/mpeg	             mpa
//	video/mpeg	             mpe
//	video/mpeg	             mpeg
//	video/mpeg         	     mpg
//	video/mpeg	             mpv2
//	video/quicktime	         mov
//	video/quicktime	         qt
//	video/x-la-asf	         lsf
//	video/x-la-asf	         lsx
//	video/x-ms-asf	         asf
//	video/x-ms-asf	         asr
//	video/x-ms-asf	         asx
//	video/x-msvideo	         avi
//	video/x-sgi-movie	     movie
	
//	image/bmp	             bmp
//	image/cis-cod	         cod
//	image/gif	             gif
//	image/ief	             ief
//	image/jpeg 	             jpe
//	image/jpeg	             jpeg
//	image/jpeg	             jpg
//	image/pipeg	             jfif
//	image/svg+xml	         svg
//	image/tiff	             tif
//	image/tiff	             tiff
//	image/x-cmu-raster	     ras
//	image/x-cmx	             cmx
//	image/x-icon	         ico
//	image/x-portable-anymap	 pnm
//	image/x-portable-bitmap	 pbm
//	image/x-portable-graymap pgm
//	image/x-portable-pixmap	 ppm
//	image/x-rgb         	 rgb
//	image/x-xbitmap	         xbm
//	image/x-xpixmap	         xpm
//	image/x-xwindowdump	     xwd
	
	public static final String AUDIO_TYPE = "audio/*";
	public static final String VIDEO_TYPE = "video/*";
	public static final String IMAGE_TYPE = "image/*";
	
	public static final String AUDIO      = "audio";
	public static final String VIDEO      = "video";
	public static final String IMAGE      = "image";

	private String mMainType = null;
	private String mSubType  = null;
	private String mMimeType = null;
	
	/**
	 * 通过String类型的mimeType来创建MIMEType对象
	 * @param mimeType String类型的MimeType
	 * @return
	 */
	public MIMEType(String mimeType) {
		String[] splitedTypes = null;
		
		if (mimeType != null && !mimeType.isEmpty()) {
			splitedTypes = mimeType.split("[/]");
			if (splitedTypes != null && splitedTypes.length >= 2) {
				mMainType = splitedTypes[0];
				mSubType  = splitedTypes[1];
				mMimeType = mimeType;
			} 
		}

		if (mMimeType == null || mMainType == null || mSubType == null) {
			throw new IllegalArgumentException(
					String.format("Argument \"%s\" is illegal", mimeType == null ? "null" : mimeType)
					);
		}
	}
	
	/**
	 * 获取主类型
	 * @return
	 */
	public String getMainType() {
		return mMainType;
	}
	
	/**
	 * 获取子类型
	 * @return
	 */
	public String getSubType() {
		return mSubType;
	}
	
	/**
	 * 是否为音频类型
	 * @return
	 */
	public boolean isAudio() {
		// TODO
		return false;
	}
	
	/**
	 * 是否为视频类型
	 * @return
	 */
	public boolean isVideo() {
		// TODO
		return false;
	}
	
	/**
	 * 是否为图像类型
	 * @return
	 */
	public boolean isImage() {
		// TODO
		return false;
	}
	
	@Override
	public String toString() {
		return mMimeType;
	}
}
