/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.documentlibrary.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IContainer;
import com.xuggle.xuggler.IPacket;
import com.xuggle.xuggler.IStream;
import com.xuggle.xuggler.IStreamCoder;
import com.xuggle.xuggler.IVideoPicture;

import java.io.File;

/**
 * @author Juan González
 * @author Sergio González
 * @author Brian Wing Shun Chan
 */
public class LiferayVideoThumbnailConverter extends LiferayConverter {

	public LiferayVideoThumbnailConverter(
		String inputURL, File outputFile, String extension, int height,
		int width) {

		_inputURL = inputURL;
		_outputFile = outputFile;
		_extension = extension;
		_height = height;
		_width = width;
	}

	public void convert() throws Exception {
		try {
			doConvert();
		}
		finally {
			if (_inputIContainer.isOpened()) {
				_inputIContainer.close();
			}
		}
	}

	protected void doConvert() throws Exception {
		_inputIContainer = IContainer.make();

		openContainer(_inputIContainer, _inputURL, false);

		int inputStreamsCount = _inputIContainer.getNumStreams();

		if (inputStreamsCount < 0) {
			throw new RuntimeException("Input URL does not have any streams");
		}

		IVideoPicture[] inputIVideoPictures =
			new IVideoPicture[inputStreamsCount];

		IStreamCoder[] inputIStreamCoders = new IStreamCoder[inputStreamsCount];

		for (int i = 0; i < inputStreamsCount; i++) {
			IStream inputIStream = _inputIContainer.getStream(i);

			IStreamCoder inputIStreamCoder = inputIStream.getStreamCoder();

			ICodec.Type inputICodecType = inputIStreamCoder.getCodecType();

			inputIStreamCoders[i] = inputIStreamCoder;

			if (inputICodecType == ICodec.Type.CODEC_TYPE_VIDEO) {
				inputIVideoPictures[i] = IVideoPicture.make(
					inputIStreamCoder.getPixelType(),
					inputIStreamCoder.getWidth(),
					inputIStreamCoder.getHeight());
			}

			if ((inputIStreamCoder != null) &&
				(inputIStreamCoder.open() < 0)) {

				throw new RuntimeException("Unable to open input coder");
			}
		}

		boolean keyPacketFound = false;
		int nonKeyAfterKeyCount = 0;
		boolean onlyDecodeKeyPackets = false;

		IPacket inputIPacket = IPacket.make();

		while (_inputIContainer.readNextPacket(inputIPacket) == 0) {
			if (_log.isDebugEnabled()) {
				_log.debug("Current packet size " + inputIPacket.getSize());
			}

			int streamIndex = inputIPacket.getStreamIndex();

			IStreamCoder inputIStreamCoder = inputIStreamCoders[streamIndex];

			if (inputIStreamCoder.getCodecType() !=
					ICodec.Type.CODEC_TYPE_VIDEO) {

				continue;
			}

			keyPacketFound = isKeyPacketFound(inputIPacket, keyPacketFound);

			nonKeyAfterKeyCount = countNonKeyAfterKey(
				inputIPacket, keyPacketFound, nonKeyAfterKeyCount);

			if (isStartDecoding(
					inputIPacket, inputIStreamCoder, keyPacketFound,
					nonKeyAfterKeyCount, onlyDecodeKeyPackets)) {

				IStream iStream = _inputIContainer.getStream(streamIndex);

				long timeStampOffset = getStreamTimeStampOffset(iStream);

				int value = decodeVideo(
					null, inputIVideoPictures[streamIndex], null, inputIPacket,
					null, inputIStreamCoder, null, null, _outputFile,
					_extension, _height, _width, timeStampOffset);

				if (value <= 0) {
					if (inputIPacket.isKey()) {
						throw new RuntimeException(
							"Unable to decode video stream " + streamIndex);
					}

					onlyDecodeKeyPackets = true;

					continue;
				}
				else if (value == DECODE_VIDEO_THUMBNAIL) {
					break;
				}
			}
			else {
				if (_log.isDebugEnabled()) {
					_log.debug("Do not decode video stream " + streamIndex);
				}
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		LiferayVideoThumbnailConverter.class);

	private String _extension;
	private int _height = 240;
	private IContainer _inputIContainer;
	private String _inputURL;
	private File _outputFile;
	private int _width = 320;

}