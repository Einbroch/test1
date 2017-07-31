/**
 * bbs-list 관련 처리 함수
 */
function pageFunc(s, e){
	var v;
	console.log(s+":"+e);
	$(".listrow").hide();
	for (var i = s; i <= e; i++) {
		var v = "#con"+i;
		console.log(i);
		$(v).show();
	}
}
function eachFunc(data, block){
	block = Number(block);
	var num = 0;
	$("#contents").empty();
	$("#page").empty();
	{
		/*var label = "";
		label += '<label class="btn btn-default">';
		label +='<input type="button" name="leftblock" id="leftblock" ';
		label +=' moveblock="'+(block-1)+'" ';
		if(block==0){
			label +='class="btn disabled"> &lt; </label>';
		}else{
			label +='class="btn"> &lt; </label>';
		}*/
		var label = "";
		label +='<button type="button" name="leftblock" id="leftblock" ';
		label +=' moveblock="'+(block-1)+'" ';
		if(block==0){
			label +='class="btn disabled">left</button>';
		}else{
			label +='class="btn">left</button>';
		}
		$("#page").append(label);
	}
	$.each(data,function(i,d){
		num = i;
		//console.log(d);
		$("#contents").append(
			"<tr id='con"+i+"' class='listrow'>"
				+"<td>"+d["num"]+"</td>"
				+"<td>"+d["title"]+"</td>"
				+"<td>"+d["ownerName"]+"</td>"
				+"<td>"+d["registData"]+"</td>"
			+"</tr>");
		if((i%10)==0){
			var label = "";
			if(i==0){
				label += '<label class="btn btn-primary active">';
			}else{
				label += '<label class="btn btn-primary">';
			}
			label +='<input type="radio" name="options" class="page"';
			label += 'startrow="'+i+'" endrow="'+(i+9)+'" ';
			label +='id="page'+((i/10)+1)+'">';
			label += ((i/10)+1)+'</label>';
			$("#page").append(label);
		}
	});
	{
		/*var label = "";
		label += '<label class="btn btn-default">';
		label +='<input type="btn" name="rightblock" id="rightblock" ';
		label +=' moveblock="'+(block+1)+'" ';
		if(num!=99){
			label +='class="btn disabled"> &gt; </label>';
		}else{
			label +='class="btn"> &gt; </label>';
		}*/
		var label = "";
		label +='<button type="button" name="rightblock" '
		label +='id="rightblock" ';
		label +=' moveblock="'+(block+1)+'" ';
		if(num!=99){
			label +='class="btn disabled">right</button>';
		}else{
			label +='class="btn">right</button>';
		}
		$("#page").append(label);
	}
}

function callAjax(block){
	var u = "/bbs/list/data/"+block;
	$.ajax({
		url:u,
		type:"post",
		dataType:"json",
		success:function(data){
			eachFunc(data, block);
		},
		complete:function(){
			pageFunc(0,9);
		}
	});
}