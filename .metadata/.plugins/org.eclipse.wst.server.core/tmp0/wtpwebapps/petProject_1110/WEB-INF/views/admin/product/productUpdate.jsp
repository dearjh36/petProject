<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>

<article>
<h1>상품수정</h1>  
<form name="frm" method="post" enctype="multipart/form-data">
<input type="hidden" name="pNum" value="${productVO.pNum}">
<input type="hidden" name="code" >
<input type="hidden" name="nonmakeImg" value="${productVO.pImg}">
<table id="list">
  <tr>
    <th>상품분류</th>
    <td colspan="5">
    <select name="kind">
      <c:forEach items="${kindList}" var="kind" varStatus="status">
        <c:choose>
          <c:when test="${productVO.kind==kind}">
            <option value="${kind}" selected="selected">${kind}</option>
          </c:when>
          <c:otherwise>
            <option value="${kind}">${kind}</option>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </select> 
    </td>
  
  </tr>
  <tr>
    <th>카테고리</th>
    <td colspan="5">
    <select name="cateCode">
      <c:forEach items="${cateCodeList}" var="cateCode" varStatus="status1">
        <c:choose>
          <c:when test="${productVO.cateCode==status1.count}">
            <option value="${status1.count}" selected="selected">${cateCode}</option>
          </c:when>
          <c:otherwise>
            <option value="${status1.count}">${cateCode}</option>
          </c:otherwise>
         </c:choose>
      </c:forEach>
    </select> 
    </td>
  </tr>

  <tr>
    <th>상품명</th>
    <td width="343" colspan="5">
      <input type="text" name="pName" size="47" maxlength="100" value="${productVO.pName}">
    </td>
  </tr>
  <tr>
    <th>가 격</th>
    <td width="70">        
      <input type="text" name="pPrice" size="11" value="${productVO.pPrice}">
    </td>
      </tr>
  <tr>
      <th>제조사</th>
    <td width="70">        
      <input type="text" name="CP" size="11" value="${productVO.CP}">
    </td>
      </tr>
    
  
  <tr>
    <th>상세설명</th>
    <td colspan="5">
      <textarea name="pInfo" rows="8" cols="70" >${productVO.pInfo}</textarea>
    </td>
  </tr>
  <tr>
    <th>상품이미지</th>
    <td colspan="5">
      <img src="images/product_img/${productVO.pImg}"  width="200pt">     
      
     	<script>
     	$("input[type='file']").on("change", function(e){
    		
    		/* 이미지 존재시 삭제 */
    		if($(".imgDeleteBtn").length > 0){
    			deleteFile();
    		}
    		
    		let formData = new FormData();
    		let fileInput = $('input[name="uploadFile"]');
    		let fileList = fileInput[0].files;
    		let fileObj = fileList[0];
    		
    		if(!fileCheck(fileObj.name, fileObj.size)){
    			return false;
    		}
    		
    		formData.append("uploadFile", fileObj);
    		
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
      <br>
      <input type="file" name="pImg">
    </td> 
  </tr>    
</table>
<input class="btn" type="button" value="수정" onClick="go_mod_save('${tpage}','${productVO.pNum}')">           
<input class="btn" type="button" value="취소" onClick="go_mov()">
</form> 
</article>
<%@ include file="../footer.jsp"%>
