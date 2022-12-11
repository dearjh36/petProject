function go_cart() {
	  if (document.formm.cnt.value == "") {
	    alert("수량을 입력하여 주세요.");
	    document.formm.cnt.focus();
	  } else {
	    document.formm.action = "/cart/add";
	    document.formm.submit();
	  }
	}

function goOrder1() {
	document.formm.action = "MypetServlet?command=order_direct_insert";
	document.formm.submit();
}

function goOrder2(pNum) {
	var p = pNum;
	document.formm.action = "MypetServlet?command=order_direct_form&pNum="+p;
	document.formm.submit();
}



function inputNumberWithComma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, "$1,");
}