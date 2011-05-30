/**
* Here's the mold file , a mold means a HTML struct that the widget really presented.
* yep, we build html in Javascript , that make it more clear and powerful.
*/
function (out) {

	//Here you call the "this" means the widget instance. (@see Modeltable.js)

	var zcls = this.getZclass(),
		uuid = this.uuid;


	out.push('<div class="',zcls,'-header" ', this.domAttrs_(), '>',
		'<table cellspacing="0" cellpadding="0" border="0"  style="table-layout:fixed;">');
	
	
	var item = this._items || [] ,
		header = this._headers || [];
	
	if(header && header.length){
		out.push('<tr class="',zcls,'-columns">');
		
		for (var j = 0 , len = header.length; j < len; ++j) {
			out.push('<th width="50px" class="',zcls,'-column ',zcls,'-column-sort">',
				'<div class="',zcls,'-column-cnt">', header[j], "</div></th>");
		}	
		
		out.push("</tr>");		
	}
	
	var child = this.firstChild;
	for(var i = 0 ,len = item.length ; i < len ;++i){
		out.push('<tr class="',zcls,'-row ', i % 2 == 0 ? zcls + '-odd' : '','">');
		
		for (var j = 0; j < item[i].length; ++j) {
			if( item[i][j] == "$#_wgt_#$" ){
				out.push('<td class="',zcls,'-row-inner">');
				if(child){
					child.redraw(out);
					child = child.nextSibling ;
				}
				out.push('</td>');
			}else{
				out.push('<td class="',zcls,'-row-inner">', item[i][j]  , '</td>');
			}
		}	
		
		out.push("</tr>");
	}
	out.push('</table></div>');

}