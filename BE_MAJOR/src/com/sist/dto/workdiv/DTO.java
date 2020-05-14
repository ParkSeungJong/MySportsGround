package com.sist.dto.workdiv;

/**
 * Value Object 조상 : 모든 Value Object는 DTO를 상속받아야한다.
 * @author LG
 *
 */
public class DTO {
	/** 글 번호 */
	private String no;
	
	/**검색 구분*/
	private String searchDiv;
	/**검색어*/
	private String searchWord;
	
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	

	/**
	 * @return the searchDiv
	 */
	public String getSearchDiv() {
		return searchDiv;
	}

	/**
	 * @param searchDiv the searchDiv to set
	 */
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	/**
	 * @return the searchWord
	 */
	public String getSearchWord() {
		return searchWord;
	}

	/**
	 * @param searchWord the searchWord to set
	 */
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	@Override
	public String toString() {
		return "DTO [no=" + no + ", searchDiv=" + searchDiv + ", searchWord=" + searchWord + "]";
	}
	
}
