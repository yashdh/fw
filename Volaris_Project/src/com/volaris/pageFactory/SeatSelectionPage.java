package com.volaris.pageFactory;

public interface SeatSelectionPage {
	
	//*************Created by Amarnath**************//	
	String seatPopupEle = ".//*[@id='modal-initialseat']/div[2]/button";
	String seatSelectionPageEle = ".//*[@id='seatMapForm']";
	String nextBtnOnSeatPageEle = ".//button[@id='js-next-seatmap-button' and contains(text(),'Next')]";
	String continueBtnOnSeatPageEle = ".//button[@id='js-next-seatmap-button' and contains(text(),'Continue')]";
}
