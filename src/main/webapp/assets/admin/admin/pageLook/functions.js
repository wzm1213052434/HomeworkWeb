/**
 *  admin/look*** 系列函数
 *  在管理员界面 look开头的所有页面中引用
 */

function GetPar(name) {  /* 获取参数函数 */
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return decodeURIComponent(r[2]);
	return null;
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
	var obj = document.getElementById("pageURL");
	var url = obj.innerHTML;
	var name = obj.getAttribute("name");
    var page = dest;
    location.href = encodeURI(url + "?page=" + page + "&"+name+"=" + TheName);
}

function jumpPrevPage(){  /* 跳转到上一页  */
	var obj = document.getElementById("pageURL");
	var url = obj.innerHTML;
	var name = obj.getAttribute("name");
	if(now > 1){
	    var page = now-1;
		location.href = encodeURI(url + "?page=" + page + "&"+name+"=" + TheName);
	}	
}

function jumpNextPage(){  /* 跳转到下一页  */
	var obj = document.getElementById("pageURL");
	var url = obj.innerHTML;
	var name = obj.getAttribute("name");
	if(now < total){
	    var page = now+1;
		location.href = encodeURI(url + "?page=" + page + "&"+name+"=" + TheName);
	}	
}

function findCourse(message){   /* 按输入模糊查询课程信息  */
	var obj = document.getElementById("pageURL");
	var url = obj.innerHTML;
	var name = obj.getAttribute("name");
	var input = document.getElementById("contentInput");
	var inputThing = input.value;
	if(inputThing == ""){
		alert(message);
	}else{
	    var cn = inputThing;
		location.href = encodeURI(url + "?"+name+"=" + cn);
	}
}

function changeIcon(i){     /* 展示与隐藏内容过程后更改小图标  */
	var name = "listIcon" + i;
	var icon = document.getElementsByName(name);
	if(icon[0].getAttribute("class") == "fa fa-angle-left"){
		icon[0].setAttribute("class","fa fa-angle-down");
	}else{
		icon[0].setAttribute("class","fa fa-angle-left");
	}
}

var openAndClose = function (i){  /* 点击标题，展示与隐藏内容  */
	var name = ".listContent" + i;
	$(name).slideToggle(500,changeIcon(i));
}