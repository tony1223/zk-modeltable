function (out) {
	var item = this._items,
		header = this._headers ,
		ref = {
			child: this.firstChild
		};	

	out.push('<table ',this.domAttrs_(),'>');
	
	if (header) 
		this.drawJSONTag(out, header, ref);
	

	for(var i = 0 ,len = item.length ; i < len ;++i){
		if(item[i])
			this.drawJSONTag(out,item[i],ref)	
	}
	out.push('</table>');

}