package com.santosh.bidri.data;

public class BidarMonumentsData {
	
	String bidarMonumentName;
	String bidarMonumentImage;
	String bidarMonumentDescription;
	public BidarMonumentsData(String bidarMonumentName,
			String bidarMonumentImage, String bidarMonumentDescription) {
		super();
		this.bidarMonumentName = bidarMonumentName;
		this.bidarMonumentImage = bidarMonumentImage;
		this.bidarMonumentDescription = bidarMonumentDescription;
	}
	public String getBidarMonumentName() {
		return bidarMonumentName;
	}
	public void setBidarMonumentName(String bidarMonumentName) {
		this.bidarMonumentName = bidarMonumentName;
	}
	public String getBidarMonumentImage() {
		return bidarMonumentImage;
	}
	public void setBidarMonumentImage(String bidarMonumentImage) {
		this.bidarMonumentImage = bidarMonumentImage;
	}
	public String getBidarMonumentDescription() {
		return bidarMonumentDescription;
	}
	public void setBidarMonumentDescription(String bidarMonumentDescription) {
		this.bidarMonumentDescription = bidarMonumentDescription;
	}
	
	

}
