/**
 * 
 */
//绑定字典内容到指定的Select控件
		function BindSelect(ctrlName, url) {

			var control = $('#' + ctrlName);
			//绑定Ajax的内容

			$.getJSON(url, function(data) {
				control.empty();//清空下拉框
				//	alert(ctrlName);
				if (ctrlName == "CH_DeptName") {
					control.append("<option value='0' selected='selected'>请选择部门</option>");
				}
				$.each(data, function(i, item) {
					control.append("<option value='" + item.id + "'>" + item.deptName + "</option>");
				});

			});
		}