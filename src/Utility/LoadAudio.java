package Utility;

import java.util.ArrayList;
import java.util.Arrays;

import Exception.EmptyUrlException;
import Exception.UrlErrorException;

import javafx.scene.media.AudioClip;

public class LoadAudio {
	private String fileName;
	private ArrayList<String> audioList = new ArrayList<String>(Arrays.asList("/backgroundSong.mp3"));

	public LoadAudio(String fileName) {
		// TODO Auto-generated constructor stub
		setFileName(fileName);
	}

	public AudioClip LoadAudioFile() throws UrlErrorException, EmptyUrlException {
		String FileName = getFileName();
		try {
			if (FileName.isBlank()) {
				throw new EmptyUrlException();
			} else if (!checkAudioInList(getFileName())) {
				throw new UrlErrorException();
			} else {
				return new AudioClip(getClass().getResource(FileName).toExternalForm());
			}
		} catch (EmptyUrlException e) {
			System.out.println(e);
			return new AudioClip(getClass().getResource("/backgroundSong.mp3").toExternalForm());
		}
		// return null;
		catch (UrlErrorException e) {
			System.out.println(e);
			return new AudioClip(getClass().getResource("/backgroundSong.mp3").toExternalForm());

		}

	}

	private boolean checkAudioInList(String fileName) {
		// TODO Auto-generated method stub
		for (String eachFile:getAudioList()) {
			if (eachFile.equals(fileName)) {
				return true;
			}
		}
		return false;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<String> getAudioList() {
		return audioList;
	}

	public void setAudioList(ArrayList<String> audioList) {
		this.audioList = audioList;
	}
	

}
