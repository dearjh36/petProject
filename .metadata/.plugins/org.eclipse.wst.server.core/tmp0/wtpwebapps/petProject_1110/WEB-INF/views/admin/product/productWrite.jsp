<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script>
	/* 이미지 업로드 */

	function go_save() 
	{
		 var theForm = document.frm;		
			theForm.action = "/admin/product/Write";
			theForm.submit();
	}
	
</script>

<article>

<h1>상품등록</h1>  
<form name="frm" method="post" enctype="multipart/form-data" >
<table id="list">
<tr>
  <th>상품분류</th>
  <td colspan="5">
  <select name="kind" required>
    <c:forEach items="${kindList}" var="kind" varStatus="status">
      <option value="${kind}">${kind}</option>
   </c:forEach>
  </select>  
 </td>
 <th>카테고리</th>
  <td colspan="5">
  <select name="cateCode" required>
    <c:forEach items="${cateCodeList}" var="cateCode" varStatus="status1">
      <option value="${status1.count}">${cateCode}</option>
   </c:forEach>
   </select>
     
 </td>
 </tr>
 
 <tr>
 <th> 제조사</th>
 <td width="70">   
 	<input type="text" name="CP" size="11" required>
 </tr>
      
<tr>
  <th>상품명</th>
  <td width="343" colspan="5">
       <input type="text" name="pName" size="47" maxlength="100" required>
  </td>
</tr>
<tr>
  <th>판매가격</th>
  <td width="70">
    <input type="text" name="pPrice" size="11" required>
  </td>
  
  </tr>
    
  <tr>
    <th>상세설명</th>
    <td colspan="5">
      <textarea name="pInfo" rows="8" cols="70" required></textarea>
    </td>
  </tr>
  <tr>
    <th>상품이미지</th>
    <td width="343" colspan="5">
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->
      <input type="file" name="fileImg" required></td>

  	
  </tr>    
</table>
<input type="submit" value="등록" class="btn" >           
<input class="btn" type="button" value="취소" onClick="go_mov()">
</form> 
</article>
<script>
     	$("input[type='file']").on("change", function(e){
    		
    		/* 이미지 존재시 삭제 */
    		if($(".imgDeleteBtn").length > 0){
    			deleteFile();
    		}
    		
    		let formData = new FormData();
    		let fileInput = $('input[name="fileImg"]');
    		let fileList = fileInput[0].files;
    		let fileObj = fileList[0];
    		
    		if(!fileCheck(fileObj.name, fileObj.size)){
    			return false;
    		}
    		
    		formData.append("fileImg", fileObj);
    		
    		$.ajax({
    			url: '/admin/uploadAjaxAction',
    	    	processData : false,
    	    	contentType : false,
    	    	data : formData,
    	    	type : 'POST',
    	    	dataType : 'json',
    	    	success : function(result){
    	    		console.log(result);
    	    		showUploadImage(result);
    	    	},
    	    	error : function(result){
    	    		alert("이미지 파일이 아닙니다.");
    	    	}
    		});		

    		
    	});
	</script>
<%@ include file="../footer.jsp"%>
