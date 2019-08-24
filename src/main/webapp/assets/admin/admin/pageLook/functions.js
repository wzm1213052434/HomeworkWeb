/**
 * 
 */

function GetPar(name) {  /* 获取参数函数 */
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return decodeURIComponent(r[2]);
	return null;
}

function changePar(){  /* 更改页面原始参数函数  */
	var id1 = GetPar("page");
	var id2 = GetPar("cname");
	if(id1 != null){
		var nowpage = parseInt(id1);
		Page = nowpage;
		now = Page;
	}
	if(id2 != null){
		Cname = id2;
	}
}

function dataFirstToLast(message,p,r){  /* 更改页码显示  */
	var num = parseInt(message);
	if (isNaN(num)){
		var obj = document.getElementById("displayMessage");
		obj.style.display = "table-row";
		obj = document.getElementById("displayContent");
		obj.style.display = "none";
		obj = document.getElementById("pages");
		obj.style.display = "none";
		obj = document.getElementById("emptyMessage");
		obj.innerHTML = message;
	}else{
		num = num/r;
		total = num;
		var pageList = $('#pageList');
		if(num < 5){
			for(var j=0;j<num;j++){
				if(j+1 == p)
					var newNode=$('<a href="javascript:;" style="font-size:14px;font-weight:bold;">'+(j+1)+'</a>');
				else
					var newNode=$('<a href="javascript:;" style="font-size:10px;" onclick="jumpPage(this.innerHTML);">'+(j+1)+'</a>');
                pageList.append(newNode);
            }
		}else{
			if(num-p > 3){
				for(var j=0;j<4;j++){
					if(j == 0)
						var newNode=$('<a href="javascript:;" style="font-size:14px;font-weight:bold;">'+p+'</a>');
					else
						var newNode=$('<a href="javascript:;" style="font-size:10px;" onclick="jumpPage(this.innerHTML);">'+(j+p)+'</a>');
	                pageList.append(newNode);
	            }
			}else{
				for(var j=3;j>=0;j--){
					if(num-j == p)
						var newNode=$('<a href="javascript:;" style="font-size:14px;font-weight:bold;">'+p+'</a>');
					else
						var newNode=$('<a href="javascript:;" style="font-size:10px;" onclick="jumpPage(this.innerHTML);">'+(num-j)+'</a>');
	                pageList.append(newNode);
	            }
			}
		}
	}
}

function jumpPage(dest){  /* 跳转分页  */
	var url = document.getElementById("pageURL").innerHTML;
    var page = dest;
    location.href = encodeURI(url + "?page=" + page + "&cname=" + Cname);
}

function jumpPrevPage(){  /* 跳转到上一页  */
	var url = document.getElementById("pageURL").innerHTML;
	if(now > 1){
	    var page = now-1;
		location.href = encodeURI(url + "?page=" + page + "&cname=" + Cname);
	}	
}

function jumpNextPage(){  /* 跳转到下一页  */
	var url = document.getElementById("pageURL").innerHTML;
	if(now < total){
	    var page = now+1;
		location.href = encodeURI(url + "?page=" + page + "&cname=" + Cname);
	}	
}

function findCourse(message){   /* 按输入模糊查询课程信息  */
	var url = document.getElementById("pageURL").innerHTML;
	var input = document.getElementById("contentInput");
	var inputThing = input.value;
	if(inputThing == ""){
		alert(message);
	}else{
	    var cn = inputThing;
		location.href = encodeURI(url + "?cname=" + cn);
	}
}