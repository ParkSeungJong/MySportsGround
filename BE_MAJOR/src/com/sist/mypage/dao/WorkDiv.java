/**
 *<pre>
 * com.sist.hr.cmn
 * Class Name : WorkDiv.java
 * Description : 
 * Modification Information
 * 
 *   ������      ������              ��������
 *  ---------   ---------   -------------------------------
 *  2019-11-22           ���ʻ���
 *
 * @author ���������ӿ�ũ ����ȯ�� ������
 * @since 2019-11-22 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
 
package com.sist.mypage.dao;

import java.util.List;

/**
 * @author sist
 *
 */
public interface WorkDiv {
	
	   /**
	    * 등록기능을 구현 하세요.
	    * @param dto
	    * @return 등록성공 : 1, 실패: 0.
	    */
	public abstract int do_save(DTO dto);
	
	
	
	   /**
	    * 수정기능을 구현 하세요.
	    * @param dto
	    * @return 등록성공 : 1, 실패: 0.
	    */

	public abstract int do_update(DTO dto);
	
	
	
	  /**
	    * 삭제기능을 구현 하세요.
	    * @param dto
	    * @return 등록성공 : 1, 실패: 0.
	    */   
	public abstract int do_delete(DTO dto);
	
	
	   /**
	    * 단건조회 기능을 구현 하세요.
	    * @param dto
	    * @return DTO
	    */   
	public abstract UserVO DTO_selectOne(DTO dto);
	
	
	
	 /**
	    * 목록조회 기능을 구현 하세요.
	    * @param dto
	    * @return List<DTO>
	    */   
	public abstract List<?> do_retrieve(DTO dto);
	DTO do_selectOne(DTO dto);


}
