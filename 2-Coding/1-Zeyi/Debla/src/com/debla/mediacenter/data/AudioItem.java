package com.debla.mediacenter.data;

/**
 * 音频媒体类型
 * @author Cocoonshu
 * @date   2014-11-01 14:24:33
 */
public class AudioItem extends MediaItem{

	private String mArtist   = null; // 歌手
	private String mSongName = null; // 歌曲名
	private String mAlbum    = null; // 专辑
	private long   mDuration = 0;
	
	@Override
	public String toString() {
		// TODO
		return super.toString();
	}
	
}
