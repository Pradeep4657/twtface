package com.santosh.bidri.data;

public class BidarBidriArtData {
	
	String bidriArtName;
	String bidriArtImage;
	String bidriArtDescription;
	public BidarBidriArtData(String bidriArtName, String bidriArtImage,
			String bidriArtDescription) {
		super();
		this.bidriArtName = bidriArtName;
		this.bidriArtImage = bidriArtImage;
		this.bidriArtDescription = bidriArtDescription;
	}
	public String getBidriArtName() {
		return bidriArtName;
	}
	public void setBidriArtName(String bidriArtName) {
		this.bidriArtName = bidriArtName;
	}
	public String getBidriArtImage() {
		return bidriArtImage;
	}
	public void setBidriArtImage(String bidriArtImage) {
		this.bidriArtImage = bidriArtImage;
	}
	public String getBidriArtDescription() {
		return bidriArtDescription;
	}
	public void setBidriArtDescription(String bidriArtDescription) {
		this.bidriArtDescription = bidriArtDescription;
	}
    
	
	
}
